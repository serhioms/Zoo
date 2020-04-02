package ca.mss.pojotrans.impl.fields;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Consumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

import ca.mss.pojotrans.PojoTransformer;
import ca.mss.pojotrans.TransformerException;
import ca.mss.pojotrans.impl.AbstractTargetField;
import ca.mss.pojotrans.impl.LazyRef;
import ca.mss.streval.EvalUtil;

public class StringFieldHandler extends AbstractTargetField {

	@Override
	public void assignFields(Field field, LazyRef<?> result, 
			JsonNode schemaNode, JsonNode valueNode, PojoTransformer transformer, 
			Map<String,Object> mapo, Map<String,Object>[] maps,
			Consumer<Exception> exceptionHandler)
			throws IllegalAccessException {
		JsonNode target = null;
		if (schemaNode.isObject()) {
			target = findObject(schemaNode, valueNode, mapo, maps, exceptionHandler);
		} else if( schemaNode.asText().isEmpty() ) {
			return;
		} else if( EvalUtil.isExpression(schemaNode.asText()) ){
			target = valueNodeFindValueFromExpression(schemaNode.asText(), valueNode, mapo, maps, exceptionHandler);
		} else {
			target = valueNode.findValue(schemaNode.asText());
			if( target == null ){
				target = new TextNode(schemaNode.asText());
			}
		}
		field.setAccessible(true);
		try {
			if (target != null) {
				if (target.isArray()) {
					field.set(result.get(), target.toString());
				} else if( !target.asText().isEmpty() ) {
					field.set(result.get(), target.asText());
				}
			}
		} catch (IllegalArgumentException | InstantiationException e) {
			exceptionHandler.accept(new TransformerException("Fail to createObject: "+e.getClass().getSimpleName(), e));
		} catch( RuntimeException e){
			exceptionHandler.accept(new TransformerException("Bad data: "+e.getClass().getSimpleName(), e));
		}
	}
}
