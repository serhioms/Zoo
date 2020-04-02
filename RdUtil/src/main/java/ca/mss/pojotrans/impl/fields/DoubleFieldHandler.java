package ca.mss.pojotrans.impl.fields;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Consumer;

import com.fasterxml.jackson.databind.JsonNode;

import ca.mss.pojotrans.PojoTransformer;
import ca.mss.pojotrans.TransformerException;
import ca.mss.pojotrans.impl.AbstractTargetField;
import ca.mss.pojotrans.impl.LazyRef;
import ca.mss.streval.EvalUtil;

public class DoubleFieldHandler extends AbstractTargetField{

	@Override
	public void assignFields(Field field, LazyRef<?> result,
			JsonNode schemaNode, JsonNode valueNode, PojoTransformer transformer, 
			Map<String,Object> cache, Map<String,Object>[] maps,
			Consumer<Exception> exceptionHandler)
			throws IllegalAccessException {

		JsonNode target = null;
		if (schemaNode.isObject()) {
			target = findObject(schemaNode, valueNode, cache, maps, exceptionHandler);
		} else if( schemaNode.asText().isEmpty() ) {
			return;
		} else if( EvalUtil.isExpression(schemaNode.asText()) ){
			target = valueNodeFindValueFromExpression(schemaNode.asText(), valueNode, cache, maps, exceptionHandler);
		} else {
			target = valueNode.findValue(schemaNode.asText());
		}
		field.setAccessible(true);
		try {
			if (target != null && !target.asText().isEmpty()) {
				field.set(result.get(), target.asDouble());
			} else if( schemaNode.asText() != null && !schemaNode.asText().isEmpty()) {
				String val = evaluateExpr(schemaNode.asText(), cache, maps, exceptionHandler);
				if( val != null && !val.isEmpty()) {
					field.set(result.get(), Double.parseDouble(val));
				}
			}
		} catch (IllegalArgumentException | InstantiationException e) {
			exceptionHandler.accept(new TransformerException("Fail to createObject: "+e.getClass().getSimpleName(), e));
		} catch( RuntimeException e){
			exceptionHandler.accept(new TransformerException("Bad data: "+e.getClass().getSimpleName(), e));
		}
	}
}
