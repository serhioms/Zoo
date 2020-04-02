package ca.mss.streval;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import ca.mss.streval.impl.FunctionalMap;
import ca.mss.utilms.MapUtil;
import ca.mss.utilms.StrUtil;

/*
 * Evaluate 3 types of expression: ${variable}, function and ?-operator.
 * 
 * Returns evaluation result as string. 
 * 
 */
public class EvalUtil {

	private static final boolean CONTINUE_PROCESSIONG = true;
	private static final boolean STOP_PROCESSIONG = false;

	private EvalUtil() {
	}

	public static boolean isExpression(String text) {
		return text.startsWith("$") || text.contains("$"+"{");
	}

	public static String eval(String expr) throws EvalException {
		return evaluate(MapUtil.toMap(), expr, null, null);
	}
	
	@SafeVarargs
	public static String eval(String expr, Map<String, Object>... maps) throws EvalException {
		return evaluate(MapUtil.toMap(), expr, null, maps);
	}
	
	@SafeVarargs
	public static String eval(Map<String, Object> cache, String expr, Map<String, Object>... maps) throws EvalException {
		return evaluate(cache, expr, null, maps);
	}
	
	public static String eval(String expr, FunctionalMap<String,Object> lambda) throws EvalException {
		return evaluate(MapUtil.toMap(), expr, lambda, null);
	}
	
	@SafeVarargs
	public static String eval(String expr, FunctionalMap<String,Object> lambda, Map<String, Object>... maps) throws EvalException {
		return evaluate(MapUtil.toMap(), expr, lambda, maps);
	}
	
	@SafeVarargs
	public static String eval(Map<String, Object> cache, String expr, FunctionalMap<String,Object> lambda, Map<String, Object>... maps)
			 throws EvalException {
		return evaluate(cache, expr, lambda, maps);
	}
	
	private static final Pattern[] expressPattern = new Pattern[] {
			Pattern.compile("\\$\\{(.*?)\\}"),		// ${property.field}
			Pattern.compile("(.*?)\\?\\?(.*?):(.*)"),	// like a?b;c but evaluated before functions
			Pattern.compile("\\$(.*?)\\((.*?)\\)"),	// $function(a;b;c)
			Pattern.compile("(.*?)\\?(.*?):(.*)"),	// a?b;c
	};

	private static String evaluate(Map<String, Object> cache, String expr, FunctionalMap<String,Object> lambda, Map<String, Object>[] maps)
			 throws EvalException {
		try {
			AtomicReference<String> exprref = new AtomicReference<>(expr); 
			for (Pattern pattern : expressPattern) {
				processPattern(pattern, exprref, lambda, cache, maps);
			}
			return exprref.get();
		} catch( RuntimeException e){
			throw new EvalException("Unexpected exception: "+e.getClass().getSimpleName(), e); 
		}
	}
	
	private static void  processPattern(Pattern pattern, AtomicReference<String> expr, FunctionalMap<String,Object> lambda, Map<String, Object> cache, Map<String, Object>[] maps) 
			throws EvalException {
		Matcher matcher = pattern.matcher(expr.get());
	    while( matcher.find() ) {
	    	if( processMatcher(matcher, expr, lambda, cache, maps) ){
	    		continue;
	    	}
			matcher = pattern.matcher(expr.get());
	    }
	}

	private static boolean processMatcher(Matcher matcher, AtomicReference<String> expr, 
			FunctionalMap<String,Object> lambda, Map<String, Object> cache, Map<String, Object>[] maps)
			 throws EvalException {
    	switch( matcher.groupCount() ) {
    	case 0: // no match
    		return CONTINUE_PROCESSIONG;
    		
    	case 1: // $ expression
    		String fragment = matcher.group(0);
    		String var = matcher.group(1);
    		return processDollarExpression(var, fragment, expr, lambda, cache, maps);
    		
    	case 2: // function
    		fragment = matcher.group(0);
    		String func = matcher.group(1);
			String argl = matcher.group(2);
			return processFunctionExpression(func, argl, fragment, expr, cache);
			
    	case 3: // ? expression
    		fragment = matcher.group(0);
    		String boolexp = matcher.group(1);
			String arg1 = matcher.group(2);
			String arg2 = matcher.group(3);
			return processQuestionExpression(boolexp, arg1, arg2, fragment, expr, lambda, cache, maps);

    	default: // not match
    		return CONTINUE_PROCESSIONG;
    	}
	}

	private static boolean processQuestionExpression(String boolexp, String arg1, String arg2, String fragment, AtomicReference<String> expr, 
			FunctionalMap<String,Object> lambda, Map<String, Object> cache, Map<String, Object>[] maps)
			 throws EvalException {
		String removeAll = StrUtil.removeAll(fragment, boolexp, arg1, arg2);
		if( "?:".equals(removeAll) || "??:".equals(removeAll) ) {
			Boolean bool = evaluateBooleanExpression(eval(cache, boolexp, lambda, maps));
    		if( bool == null ) {
    			throw new EvalException(expr.get(), "["+fragment+"] syntax error - missing expression!");
    		} if( bool.booleanValue()) {
    			expr.set(expr.get().replace(fragment, arg1));
    		} else {
    			expr.set(expr.get().replace(fragment, arg2));
    		}
		} else {
			throw new EvalException(expr.get(), "["+fragment+"] syntax error ["+StrUtil.removeAll(fragment, boolexp, arg1, arg2)+"]");
		}
		return STOP_PROCESSIONG;
	}

	private static Pattern funcPattern = Pattern.compile("(.*?)\\$(.*)");
	
	private static boolean processFunctionExpression(String func, String argl, String fragment, AtomicReference<String> expr, Map<String, Object> cache)
			 throws EvalException {
		if( !func.isEmpty() && "$()".equals(StrUtil.removeAll(fragment, func, argl)) ) {

			// "abc;;;" gives String[1]=["abc"] but String[4]=["abc",,,] expected
			String[] args = null;
			if( argl.isEmpty() ){
				// no args!
			} else if( argl.endsWith(";")){
				args = (argl+" ").split("\\;"); // add extra space
				args[args.length-1] = "";		// remove extra space
			} else {
				args = argl.split("\\;");
			}

			// bla*bla*bla*$function => function
			Matcher fmatcher = funcPattern.matcher(func);
		    if( fmatcher.find() && fmatcher.groupCount() == 2 ){
	    		String prefix = fmatcher.group(1);
	    		func = fmatcher.group(2);
	    		fragment = fragment.substring(prefix.length()); // with $
		    }
			
		    expr.set(evaluateFunction(expr.get(), func, fragment, args, cache));
		    
		} else {
			throw new EvalException(expr.get(), func.isEmpty()?"Function name is empty": "["+fragment+"] syntax error ["+StrUtil.removeAll(fragment, func, argl)+"]");
		}
		return STOP_PROCESSIONG;
	}

	private static boolean processDollarExpression(String var, String fragment, AtomicReference<String> expr,  
			FunctionalMap<String,Object> lambda, Map<String, Object> cache, Map<String, Object>[] maps)
			 throws EvalException {
		
		if( var == null || var.isEmpty() ) {
			expr.set(expr.get().replace(fragment, ""));
			return STOP_PROCESSIONG;
		} 
		
		if( !"${}".equals(StrUtil.removeAll(fragment, var)) ) {
			throw new EvalException(expr.get(), "Syntax error ["+StrUtil.removeAll(fragment, var)+"]" );
		}
		
		Object value = null;
		
		// check cache first
		if( cache != null ){ 
			value = cache.get(var);
		}
		
		// check lambda then
		if( lambda != null && value == null ){ 
			if( var.contains(".") ){ 
				String[] dvar = var.split("\\.");
				Object result = evalObjectDotExpr(dvar, lambda.get(dvar[0]));
				if( result != null ){
					expr.set(expr.get().replace(fragment, result.toString()));
					return STOP_PROCESSIONG;
				}
			} else {
				Object val = lambda.get(var);
				if( val instanceof JsonNode ){
					JsonNode node = (JsonNode )val;
					if( node.isTextual() ){
						value = node.asText();
					} else {
						value = node.toString();
					}
				} else {
					value = (val == null)? null: val.toString();
				}
			}			
		}

		// resolve data.prop1.prop2.prop3 from maps then
		if( maps != null && value == null && var.contains(".") ){ 
			String[] dvar = var.split("\\.");
			Object result = evalObjectDotExpr(dvar, getValFromMaps(dvar[0], maps));
			if( result != null ){
				expr.set(expr.get().replace(fragment, result.toString()));
				return STOP_PROCESSIONG;
			}
		}
		
		// resolve as key from the maps
		if( maps != null && value == null ){ 
			value = getValFromMaps(var, maps);
		}
		
		if( value != null ){
			expr.set(expr.get().replace(fragment, value.toString()));
			return STOP_PROCESSIONG;
		} else {
			expr.set(expr.get().replace(fragment, "")); // substitute null by empty value
			return CONTINUE_PROCESSIONG;
		}
	}

	public static Object evalObjectDotExpr(String[] anobj, Object result) throws EvalException {
		for(int i=1, max=anobj.length; result!=null && i<max; i++ ){
			try {
				if( result instanceof String ){
					return null;
				} else if( result instanceof ObjectNode ){
					result = ((ObjectNode) result).get(anobj[i]);
					continue;
				} else {
					Class<? extends Object> clazz = result.getClass();
					
					try {
						Method method = clazz.getMethod("get"+Character.toUpperCase(anobj[i].charAt(0))+anobj[i].substring(1));
						result = method.invoke(result);
						continue;
					} catch(NoSuchMethodException e){
						// vie get method
					}
	
					try {
						Field field = clazz.getField(anobj[i]);
						result = field.get(result);
						continue;
					} catch(NoSuchFieldException e){
						// vie public property
					}
				}
			} catch (Exception e) {
				throw new EvalException("Exception on dot property ["+anobj[i]+"]", e);
			}
			
			throw new EvalException("Dot property ["+anobj[i]+"] not exists");
		}

		if( result instanceof TextNode ){
			result = ((TextNode) result).asText();
		} else if( result instanceof ObjectNode ){
			result = ((ObjectNode) result).asText();
		}
		
		return result;
	}

	public static Object getValFromMaps(String var, Map<String, Object>[] maps) {
		if( maps != null ){
			for(Map<String,?> map: maps){
				if( map != null && map.containsKey(var)){
					Object val = map.get(var);
					if( val != null && !val.toString().isEmpty() ){
						return val;
					}
				}
			}
		}
		return null;
	}

	public static Object getValFromMap(String var, Map<String, Object> map) {
		if( map != null && map.containsKey(var)){
			Object val = map.get(var);
			if( val != null ){
				return val;
			}
		}
		return null;
	}

	private static String evaluateFunction(String expr, String func, String fragment, String[] args, Map<String, Object> cache) throws EvalException {
		try {
			switch( func.toLowerCase() ) {
			
			case "datetimeformat":
				if( args.length == 0 ){
					return expr.replace(fragment, "");
				}
				
				LocalDateTime fromDateTime = "UTC".equalsIgnoreCase(args[0])? 
						 (new Date(Long.parseLong(args[1]))).toInstant().atZone(ZoneOffset.UTC).toLocalDateTime() 
						: LocalDateTime.parse(args[1], DateTimeFormatter.ofPattern(args[0]));
						 
				String toDateTime = fromDateTime.format(DateTimeFormatter.ofPattern(args[2]));
				
				return expr.replace(fragment, toDateTime);
				
			case "todatetime":
				if( args.length == 0 ){
					return expr.replace(fragment, "");
				}
				
				fromDateTime = "UTC".equalsIgnoreCase(args[0])? 
						 (new Date(Long.parseLong(args[1]))).toInstant().atZone(ZoneOffset.UTC).toLocalDateTime() 
						: LocalDateTime.parse(args[1], DateTimeFormatter.ofPattern(args[0]));
						 
				
						 
				toDateTime = fromDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
				
				return expr.replace(fragment, toDateTime);
				
			case "dateformat":
				if( args.length == 0 ){
					return expr.replace(fragment, "");
				}
			
				LocalDate fromDate = LocalDate.parse(args[1], DateTimeFormatter.ofPattern(args[0]));
						 
				String toDate = fromDate.format(DateTimeFormatter.ofPattern(args[2]));
				
				return expr.replace(fragment, toDate);

    		case "upper":
				return expr.replace(fragment, args[0].toUpperCase());
    			
    		case "lower":
				return expr.replace(fragment, args[0].toLowerCase());
    			
			case "nullif":
				if( args.length == 0 ){
					return expr.replace(fragment, "");
				} 
				
				if( "null".equals(args[0]) || args[0].trim().isEmpty()) {
					return expr.replace(fragment, args[1]);
				} else {
					return expr.replace(fragment, args[0]);
				}
				
    		case "format":
    			if( args[1].contains("%") && args[1].contains("f")) {
    				return expr.replace(fragment, String.format(args[1], new Double(args[0])));
    			} else if( args[1].contains("%") && args[1].contains("d")) {
    				return expr.replace(fragment, String.format(args[1], new Integer(args[0])));
    			} else if( args[1].contains("%") && args[0].contains("s")) {
    				return expr.replace(fragment, String.format(args[1], args[0]));
    			} else {
	    			return expr;
    			}
    			
    		case "replace":
    			return expr.replace(fragment, args[0].replace(args[1], args[2]));
    			
    		case "nullif_replace":
    			if( args[0].equals("null") || args[0].isEmpty()) {
    				return expr.replace(fragment, args[3]);
    			} else {
    				return expr.replace(fragment, args[0].replace(args[1], args[2]));
    			}
				
			case "const":
				if( args.length == 0 ){
					return expr.replace(fragment, "");
				}

				return expr.replace(fragment, args[0]);
				
			case "cache":
				if( args.length == 0 ){
					return expr.replace(fragment, "");
				}
				if( args[1].length() > 0 ){
					cache.put(args[0], args[1]);
				}
				return expr.replace(fragment, args[1]);

			case "?":
				if( args.length == 0 ){
					return expr.replace(fragment, "");
				} 

				Boolean bool = evaluateBooleanExpression(args[0]);
				if( bool == null ) {
	    			throw new EvalException(expr, "["+fragment+"] syntax error - missing expression!");
	    		} 
				
				if( bool.booleanValue()) {
	    			return expr.replace(fragment, args[1]);
	    		} else {
	    			return expr.replace(fragment, args[2]);
	    		}

			default: // external function

				// cached one?
				if( cache != null && cache.containsKey(fragment) ){
					return expr.replace(fragment, cache.get(fragment).toString());
				}

				Object result = evalMethodOrStatic(func, args, cache);
				if( result == null ){ 
	    			return expr.replace(fragment, "");
				} 

				// Cache it!
				if( cache != null ){ 
					cache.put(fragment, result);
				}

				return expr.replace(fragment, result.toString());
			}
		} catch(ArrayIndexOutOfBoundsException | NullPointerException e){
			throw new EvalException(e.getMessage()+" ["+fragment+"]", e);
		}
	}

	public static Object evalMethodOrStatic(String func, Object[] args, Map<String, Object> cache) throws EvalException {
		try {
			String[] afunc = func.split("\\.");
			
			String methodName = afunc[afunc.length-1];
			
			// Resolve class or object
			String className = null;
			Object obj = null;
			
			String classNameOrObject = null;
			if( func.contains(".") ){
				classNameOrObject = func.substring(0, func.lastIndexOf("."+methodName));
			} else {
				throw new EvalException("Can't find class or object for external function ["+func+"]");
			}
			
			if( classNameOrObject.contains(".") ){
				className = classNameOrObject;
			} else {
				if( Character.isUpperCase(classNameOrObject.charAt(0))){
					className = classNameOrObject;
				} else {
					obj = getValFromMap(classNameOrObject, cache);
					if( obj == null ){
						throw new EvalException("Can't find object ["+classNameOrObject+"] in the cache for external function ["+func+"]");
					} else if( obj instanceof String ){
						className = obj.toString();
					} else {
						className = obj.getClass().getName();
					}
				}
			}

			// Resolve args
			Class<?>[] parameters = null;
			if( args != null ){
				boolean isArgsConverted2obj = false;
				parameters = new Class<?>[args.length];
				for(int i=0,max=args.length; i<max; i++){
					if( cache == null ){
						parameters[i] = args[i].getClass();
					} else if( cache.containsKey(args[i])){
						if( isArgsConverted2obj ){
							args[i] = cache.get(args[i]);
						} else {
							// Originally args is String[] - have to be converted to Object[] in case of object args
							isArgsConverted2obj = true;
							Object[] objs = new Object[args.length];
							for(int j=0,maxj=args.length; j<maxj; j++){
								objs[j] = args[j];
							}
							args = objs;
							args[i] = cache.get(args[i]);
						}
						parameters[i] = args[i].getClass();
					} else {
						parameters[i] = args[i].getClass();
					}
				}
			}
			
			// get result
			Class<?> clazz = Class.forName(className);
			Method method = null;
			if( parameters == null ){
				method = clazz.getMethod(methodName);
			} else {
				method = clazz.getMethod(methodName, parameters);
			}
			
			return method.invoke(obj, args);
		} catch (Exception e) {
			throw new EvalException("External function ["+func+"] exception" , e);
		}  
	}

	public static Boolean evaluateBooleanExpression(String expr) throws EvalException {
		if( expr == null || expr.trim().isEmpty() ){
			return STOP_PROCESSIONG; 
		}
		String expr2 = expr.trim().toLowerCase();
		switch( expr2 ) {
		case "true":
		case "false":
			return Boolean.parseBoolean(expr2);
		default:
			expr = " "+expr+" "; // == or !=
			String[] args = expr.split("==");
			if( args.length == 2 ) {
				return args[0].trim().equals(args[1].trim());
			}
			args = expr.split("!=");
			if( args.length == 2 ) {
				return !args[0].trim().equals(args[1].trim());
			}
			throw new EvalException(expr, args.length==2? "Expected [==,!=] operands only": "Expected 2 arguments around [==,!=] not "+args.length);
		}
	}

}