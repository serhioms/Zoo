package ca.mss.pojotrans.impl.fields;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.fasterxml.jackson.databind.JsonNode;

import ca.mss.pojotrans.PojoTransformer;
import ca.mss.pojotrans.TransformerException;
import ca.mss.pojotrans.impl.AbstractTargetField;
import ca.mss.pojotrans.impl.LazyRef;

public class ListFieldHandler extends AbstractTargetField {

	@Override
	public void assignFields(Field field, LazyRef<?> result,JsonNode schemaNode, JsonNode valueNode, 
			PojoTransformer transformer, Map<String,Object> cache, Map<String,Object>[] maps,
			Consumer<Exception> exceptionHandler)
			throws IllegalAccessException {
		Type type = field.getGenericType();
		List<Object> list = new ArrayList<>();
		if (type instanceof ParameterizedType){
			ParameterizedType ptype = (ParameterizedType)type;
			Type t= (ptype.getActualTypeArguments())[0];
			if (t == java.lang.String.class){
				list.addAll(stringSetList(schemaNode, valueNode, cache, maps, exceptionHandler));
			} else {
				list.addAll(objectSetList(schemaNode, valueNode, t, transformer, cache, maps, exceptionHandler));
			}
			
		}
		if( !list.isEmpty() ){
			field.setAccessible(true);
			try {
				field.set(result.get(), list);
			} catch (IllegalArgumentException | InstantiationException | IllegalAccessException e) {
				exceptionHandler.accept(new TransformerException("Fail to createObject: "+e.getClass().getSimpleName(), e));
			}
		}
	}

	private List<String> stringSetList(JsonNode schemaNode, JsonNode valueNode, 
			Map<String,Object> cache, Map<String,Object>[] maps,
			Consumer<Exception> exceptionHandler) {
		List<String> list = new ArrayList<>();
		for (Iterator<JsonNode> iterator = schemaNode.elements();iterator.hasNext();){
			JsonNode itNode = iterator.next();
			JsonNode strNode = findObject(itNode, valueNode, cache, maps, exceptionHandler);
			if (strNode != null && !strNode.isObject()) {
					list.add(strNode.asText());
			} else {
				list.add(itNode.asText());
			}

		}
		return list;
	}
	
	private List<Object> objectSetList(JsonNode schemaNode, JsonNode valueNode, Type t, 
			PojoTransformer transformer, Map<String,Object> cache, 
			Map<String,Object>[] maps, Consumer<Exception> exceptionHandler){
		List<Object> list = new ArrayList<>();
		for (Iterator<JsonNode> iterator = schemaNode.elements();iterator.hasNext();){
			JsonNode itNode = iterator.next();
				try {
					Object createObject = transformer.createObject((Class<?>)t, itNode, valueNode, cache, maps);
					if( createObject != null) {
						list.add(createObject);
					}
				} catch (TransformerException e) {
					exceptionHandler.accept(e);
				}
		}
		return list;
	}
}
