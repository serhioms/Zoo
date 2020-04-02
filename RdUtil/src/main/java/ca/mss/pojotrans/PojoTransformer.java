package ca.mss.pojotrans;

import java.io.File;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import com.fasterxml.jackson.databind.JsonNode;

import ca.mss.pojotrans.impl.LazyRef;
import ca.mss.pojotrans.impl.TargetField;
import ca.mss.pojotrans.impl.fields.BigIntegerFieldHandler;
import ca.mss.pojotrans.impl.fields.BooleanFieldHandler;
import ca.mss.pojotrans.impl.fields.DateFieldHandler;
import ca.mss.pojotrans.impl.fields.DoubleFieldHandler;
import ca.mss.pojotrans.impl.fields.IntFieldHandler;
import ca.mss.pojotrans.impl.fields.ListFieldHandler;
import ca.mss.pojotrans.impl.fields.LongFieldHandler;
import ca.mss.pojotrans.impl.fields.ObjectFieldHandler;
import ca.mss.pojotrans.impl.fields.StringFieldHandler;
import ca.mss.utilms.JacksonUtil;
import ca.mss.utilms.MapUtil;

public class PojoTransformer {

	public static final Map<Class<?>,TargetField>  fieldHandler = new HashMap<>();
	private static final TargetField defaultHandler = new ObjectFieldHandler();
 	
	private JsonNode mapper;
	
	private Consumer<Exception> exceptionHandler = e->{
		System.err.println(getCauseReason(e));
		e.printStackTrace(System.err);
	};
	
	public void setExceptionHandler(Consumer<Exception> exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}

	public static String getCauseReason(Throwable cause) {
		String reason = "";
		for(int i=0; i<7 && cause != null && !reason.contains("["+cause.getMessage()+"]"); i++ ){
			reason += "["+cause.getClass().getName()+"]";
			reason += "["+cause.getMessage()+"]";
			cause = cause.getCause();
		}
		return reason;
	}
	
	public PojoTransformer(JsonNode mapper) throws PojoTransformerException {
		if (mapper == null) {
			throw new PojoTransformerException("Cant instantiate transformer from null JsonNode");
		}
		this.mapper = mapper;
	}
	
	public PojoTransformer(File mapperFile) throws PojoTransformerException {
		try {
			this.mapper = JacksonUtil.readTree(mapperFile);
		} catch (Exception e) {
			throw new PojoTransformerException("Cant instantiate transformer from File", e);
		}
	}
	public PojoTransformer(String mapperJson) throws PojoTransformerException {
		try {
			this.mapper = JacksonUtil.readTree(mapperJson);
		} catch (Exception e) {
			throw new PojoTransformerException("Cant instantiate transformer from json String", e);
		}
	}

	@SafeVarargs
	public final <T> T transform(Object o, Class<T> clazz, Map<String,Object>... maps) throws TransformerException {
		return transform(MapUtil.toMap(), o, clazz, maps);
	}

	@SafeVarargs
	public final <T> T transform(Map<String,Object> cache, Object o, Class<T> clazz, Map<String,Object>... maps) throws TransformerException {
		T t = null;
		try {
			JsonNode valueNode = JacksonUtil.convertValue(o, JsonNode.class);
			t = createObject(clazz, mapper.get(clazz.getSimpleName()), valueNode, cache, maps);
		} catch (Exception e){
			throw new TransformerException("Cant transform object "+o.getClass().getSimpleName()+" to "+clazz.getSimpleName(), e);
		}
		return t;
	}

	public <C> C createObject(Class<C> c, JsonNode schemaNode, JsonNode valueNode, 
			Map<String,Object> cache, Map<String,Object>[] maps) throws TransformerException {
		LazyRef<C> refc = new LazyRef<>(c);
		
		for(Iterator<Entry<String, JsonNode>> fields = schemaNode.fields(); fields.hasNext(); ){
			Entry<String, JsonNode> next = fields.next();
			JsonNode subSchemaNode = next.getValue();
			try {
				Field field = c.getDeclaredField(next.getKey());
				TargetField targetField = fieldHandler.get(field.getType());
				if( targetField != null ){
					targetField.assignFields(field,  refc, subSchemaNode, valueNode, this, cache, maps, exceptionHandler);
				} else {
					defaultHandler.assignFields(field,  refc, subSchemaNode, valueNode, this, cache, maps, exceptionHandler);
				}
			} catch (NoSuchFieldException e) {
				exceptionHandler.accept(new TransformerException("Can't find field "+subSchemaNode, e));
			} catch (SecurityException e) {
				exceptionHandler.accept(new TransformerException("Can't access field "+subSchemaNode, e));
			} catch (IllegalAccessException e) {
				exceptionHandler.accept(new TransformerException("Illegal access to field "+subSchemaNode, e));
			}
		}
		
		try {
			return refc.isNull()? null: refc.get();
		} catch (IllegalArgumentException | InstantiationException | IllegalAccessException e) {
			throw new TransformerException("Fail create object: "+e.getClass().getSimpleName(), e);
		}
	}	

	static {
		fieldHandler.put(java.util.List.class, new ListFieldHandler());
		fieldHandler.put(Date.class, new DateFieldHandler());
		fieldHandler.put(String.class, new StringFieldHandler());
		fieldHandler.put(BigInteger.class, new BigIntegerFieldHandler());
		fieldHandler.put(double.class, new DoubleFieldHandler());
		fieldHandler.put(Double.class, new DoubleFieldHandler());
		fieldHandler.put(Integer.class, new IntFieldHandler());
		fieldHandler.put(int.class, new IntFieldHandler());
		fieldHandler.put(Boolean.class, new BooleanFieldHandler());
		fieldHandler.put(boolean.class, new BooleanFieldHandler());
		fieldHandler.put(long.class, new LongFieldHandler());
		fieldHandler.put(Long.class, new LongFieldHandler());
		fieldHandler.put(Object.class, new ObjectFieldHandler());
	}
}
