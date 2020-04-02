package ca.mss.pojotrans.impl.fields;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Consumer;

import com.fasterxml.jackson.databind.JsonNode;

import ca.mss.pojotrans.PojoTransformer;
import ca.mss.pojotrans.TransformerException;
import ca.mss.pojotrans.impl.AbstractTargetField;
import ca.mss.pojotrans.impl.LazyRef;

public class ObjectFieldHandler extends AbstractTargetField {

	@Override
	public void assignFields(Field field, LazyRef<?> result,
			JsonNode schemaNode, JsonNode valueNode, PojoTransformer transformer, 
			Map<String,Object> cache, Map<String,Object>[] maps,
			Consumer<Exception> exceptionHandler)
			throws IllegalAccessException {

		field.setAccessible(true);
		try {
			Object createObject = transformer.createObject(field.getType(), schemaNode, valueNode, cache, maps);
			if( createObject != null ){
				try {
					field.set(result.get(), createObject);
				} catch (IllegalArgumentException | InstantiationException | IllegalAccessException e) {
					exceptionHandler.accept(new TransformerException("Fail to createObject: "+e.getClass().getSimpleName(), e));
				}
			}
		} catch (TransformerException e) {
			exceptionHandler.accept(e);
		}
	}
}
