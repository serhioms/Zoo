package ca.mss.pojotrans.impl.fields;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.function.Consumer;

import com.fasterxml.jackson.databind.JsonNode;

import ca.mss.pojotrans.PojoTransformer;
import ca.mss.pojotrans.TransformerException;
import ca.mss.pojotrans.impl.AbstractTargetField;
import ca.mss.pojotrans.impl.LazyRef;
import ca.mss.streval.EvalUtil;

public class DateFieldHandler extends AbstractTargetField {

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
			target = valueNodeFindValueFromExpression("${"+schemaNode.asText()+"}", valueNode, cache, maps, exceptionHandler);
			if( target == null ){
				target = valueNode.findValue(schemaNode.asText());
			}
		}
		field.setAccessible(true);
		try {
			if (target != null && !target.asText().isEmpty()) {
				if( target.asText().contains("T") ){
					field.set(result.get(), Date.from(LocalDateTime.parse(target.asText()).atZone(ZoneId.of("America/New_York")).toInstant()));
				} else {
					field.set(result.get(), Date.from(LocalDateTime.parse(target.asText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n")).toInstant(ZoneOffset.UTC)));
				}
			} else if( schemaNode.asText() != null && !schemaNode.asText().isEmpty()) {
				if( schemaNode.asText().contains("T") ){
					field.set(result.get(), Date.from(LocalDateTime.parse(schemaNode.asText()).atZone(ZoneId.of("America/New_York")).toInstant()));
				} else {
					field.set(result.get(), Date.from(LocalDateTime.parse(schemaNode.asText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n")).toInstant(ZoneOffset.UTC)));
				}
			}
		} catch (IllegalArgumentException | InstantiationException e) {
			exceptionHandler.accept(new TransformerException("Fail to createObject: "+e.getClass().getSimpleName(), e));
		} catch( RuntimeException e){
			exceptionHandler.accept(new TransformerException("Bad data: "+e.getClass().getSimpleName(), e));
		}
		
	}
	
}
