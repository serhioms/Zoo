package rd.mss.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilEval {

	static private Pattern[] expressPattern = new Pattern[] {
			Pattern.compile("\\$\\{(.*?)\\}"),					// ${abc}
			Pattern.compile("(.*?)\\([(.*?)\\]]*(.*?)\\)"),	// ?(a,b,c) upper(blablabla) format(95.87613;%3.2f) replace(2018.01.19;.;-) nullif_replace(2018.01.19;.;-;Not Applicable)
	};

	@SafeVarargs
	static public String eval(String expr, Map<String, String>... data) {
		for (Pattern pattern : expressPattern) {
			Matcher matcher = pattern.matcher(expr);
		    while( matcher.find() ) {
		    	int signature = matcher.groupCount();
		    	if( signature == 0 ) {
		    		continue;
		    	} else if( signature == 1 ) { // ${percentageQty}
		    		String fragment = matcher.group(0);
		    		String var = matcher.group(1);
		    		if( var.isEmpty() ) {
	    				expr = expr.replace(fragment, "");
		    		} else {
			    		if( removeAll(fragment, var).equals("${}") ) {
			    			boolean isResolved = false;
				    		for (Map<String, String> val : data) {
				    			if( val.containsKey(var)) {
				    				expr = expr.replace(fragment, val.get(var));
				    				isResolved = true;
				    				break;
				    			}
							}
				    		if( !isResolved ) {
				    			continue; // skip new matcher
				    		}
			    		} else {
		    				throwException(expr);
			    		}
		    		}
		    	} else { 
		    		String fragment = matcher.group(0);
		    		String func = matcher.group(1);
	    			String argl = matcher.group(2);
	    			if( !func.isEmpty() && removeAll(fragment, func, argl).equals("()") && !argl.contains("(") && !argl.contains(")")) {
		    			String[] args = argl.split("\\;");

		    			switch( func.toLowerCase() ) {
			    		case "upper":
		    				expr = expr.replace(fragment, args[0].toUpperCase());
			    			break;
			    		case "lower":
		    				expr = expr.replace(fragment, args[0].toLowerCase());
			    			break;
			    		case "nullif":
		    				if( args[0].equals("null") || args[0].trim().isEmpty()) {
			    				expr = expr.replace(fragment, args[1]);
			    			} else {
			    				expr = expr.replace(fragment, args[0]);
			    			}
			    			break;
			    		case "format":
			    			if( args[1].contains("%") && args[1].contains("f")) {
			    				expr = expr.replace(fragment, String.format(args[1], new Double(args[0])));
			    			} else if( args[1].contains("%") && args[1].contains("d")) {
			    				expr = expr.replace(fragment, String.format(args[1], new Integer(args[0])));
			    			} else if( args[1].contains("%") && args[0].contains("s")) {
			    				expr = expr.replace(fragment, String.format(args[1], args[0]));
			    			} else {
			    				throwException(expr);
			    			}
			    			break;
			    		case "replace":
			    			expr = expr.replace(fragment, args[0].replace(args[1], args[2]));
			    			break;
			    		case "nullif_replace":
			    			if( args[0].equals("null") || args[0].isEmpty()) {
			    				expr = expr.replace(fragment, args[3]);
			    			} else {
			    				expr = expr.replace(fragment, args[0].replace(args[1], args[2]));
			    			}
			    		case "?":
			    			Boolean bool = boolEval(args[0].toLowerCase());
				    		if( bool == null ) {
				    			throwException(expr);
				    		} else if( bool.booleanValue()) {
			    				expr = expr.replace(fragment, args[1]);
				    		} else {
			    				expr = expr.replace(fragment, args[2]);
				    		}
			    			break;
			    		default:
			    			throwException(expr);
			    		}
		    		} else {
		    			throwException(expr);
		    		}
		    	}
				matcher = pattern.matcher(expr);
		    }
		}
		return expr;
	}
	
	public static Boolean boolEval(String expr) {
		switch( expr) {
		case "true":
		case "false":
			return Boolean.parseBoolean(expr);
		default:
			String[] args = expr.split("==");
			if( args.length == 2 ) {
				return args[0].equals(args[1]);
			}
			args = expr.split("!=");
			if( args.length == 2 ) {
				return !args[0].equals(args[1]);
			}
		}
		return null;
	}


	public static String removeAll(String orig, String... substrs) {
		String str = orig;
		for(String substr: substrs){
			if( !substr.isEmpty() ) {
				int index = str.indexOf(substr);
				if( index != -1 ) {
					int sublen = substr.length();
					if( index == 0 ) {
						str = str.substring(sublen);
					} else {
						str = str.substring(0, index)+str.substring(index+sublen);
					}
				}
			}
		}
		return str;
	}
	
	public static Map<String,String> toMap(String... args){
		Map<String,String> result = new HashMap<String,String>();
		for(int i=0,max=args.length; i<max; i+=2) {
			result.put(args[i], args[i+1]);
		}
		return result;
	}

	private static void throwException(String expr) {
		throw new CantParseExpression(expr);	
	}

	public static class CantParseExpression extends RuntimeException {
		private static final long serialVersionUID = 6566659013028653449L;

		public CantParseExpression(String message) {
			super(message);
		}
	}
}
