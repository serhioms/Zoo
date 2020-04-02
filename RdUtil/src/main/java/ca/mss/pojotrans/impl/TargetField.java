package ca.mss.pojotrans.impl;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Consumer;

import com.fasterxml.jackson.databind.JsonNode;

import ca.mss.pojotrans.PojoTransformer;

public interface TargetField {
	
	void assignFields(
			Field field,  LazyRef<?> result, 
			JsonNode schemaNode, JsonNode valueNode, 
			PojoTransformer transformer, 
			Map<String,Object> cache, Map<String,Object>[] maps,
			Consumer<Exception> exceptionHandler)
			throws IllegalAccessException;
}
