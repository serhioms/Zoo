package rd.mss.util.script;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptUtil {

	// create a script engine manager
	static ScriptEngineManager factory = new ScriptEngineManager();
	
	// create an engine
	static ScriptEngine nashorn = factory.getEngineByName("nashorn");
	static ScriptEngine javascript = factory.getEngineByName("javascript");
	static ScriptEngine ecmascript = factory.getEngineByName("ecmascript");
	
	static ScriptContext context = nashorn.getContext();

	public static void nashorn(String script) throws ScriptException {
		Object result = null;
		
		long durationMls = System.currentTimeMillis();
		result = nashorn.eval(script, context);
		durationMls = System.currentTimeMillis() - durationMls;
		
		if (result != null) {
			System.out.println("nashorn: "+result + " = " + script + " duration "+durationMls+" mls");
		} else {
			System.out.println("nashorn: "+script + " duration "+durationMls+" mls");
		}
	}

	public static void javascript(String script) throws ScriptException {
		Object result = null;
		
		long durationMls = System.currentTimeMillis();
		result = javascript.eval(script);
		durationMls = System.currentTimeMillis() - durationMls;
		
		if (result != null) {
			System.out.println("javascript: "+result + " = " + script + " duration "+durationMls+" mls");
		} else {
			System.out.println("javascript: "+script + " duration "+durationMls+" mls");
		}
	}

	public static void ecmascript(String script) throws ScriptException {
		Object result = null;
		
		long durationMls = System.currentTimeMillis();
		result = ecmascript.eval(script);
		durationMls = System.currentTimeMillis() - durationMls;
		
		if (result != null) {
			System.out.println("ecmascript: "+result + " = " + script + " duration "+durationMls+" mls");
		} else {
			System.out.println("ecmascript: "+script + " duration "+durationMls+" mls");
		}
	}

}
