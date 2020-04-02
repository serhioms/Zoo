package ca.mss.test;

import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestJS {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/*
	 * 15sec  for 2000000 times: 7.59 mks/1
	 */
	@Test
	public void test() throws ScriptException, InterruptedException {
		
		String lob = "PERSONAL_LOAN";
		String eventTypeCd = "SUBMIT_ORIGINATION";
		String adjResult = "AM";
		
		Map<String,String> p = new HashMap<>();
		p.put("lob", lob);
		p.put("eventTypeCd", eventTypeCd);
		p.put("adjResult", adjResult);
		
		Object result = null;

		int max = 10000;

		long start = System.currentTimeMillis();
		for(int i=0; i<max; i++){
			result = (lob.equalsIgnoreCase("EDB") || lob.equalsIgnoreCase("PERSONAL_LOAN")) && (eventTypeCd.equalsIgnoreCase("SUBMIT_ORIGINATION")) && (adjResult.equalsIgnoreCase("AP") || adjResult.equalsIgnoreCase("DL") || adjResult.equalsIgnoreCase("AM") || adjResult.equalsIgnoreCase("CA"));
			result = (lob.equalsIgnoreCase("EDB") || lob.equalsIgnoreCase("PERSONAL_LOAN")) && (eventTypeCd.equalsIgnoreCase("SUBMIT_ORIGINATION")) && !(adjResult.equalsIgnoreCase("AP") || adjResult.equalsIgnoreCase("DL") || adjResult.equalsIgnoreCase("AM") || adjResult.equalsIgnoreCase("CA"));
//			result = (p.get("lob").equalsIgnoreCase("EDB") || p.get("lob").equalsIgnoreCase("PERSONAL_LOAN")) && (p.get("eventTypeCd").equalsIgnoreCase("SUBMIT_ORIGINATION")) && (p.get("adjResult").equalsIgnoreCase("AP") || p.get("adjResult").equalsIgnoreCase("DL") || p.get("adjResult").equalsIgnoreCase("AM") || p.get("adjResult").equalsIgnoreCase("CA"));
//			result = (p.get("lob").equalsIgnoreCase("EDB") || p.get("lob").equalsIgnoreCase("PERSONAL_LOAN")) && (p.get("eventTypeCd").equalsIgnoreCase("SUBMIT_ORIGINATION")) && !(p.get("adjResult").equalsIgnoreCase("AP") || p.get("adjResult").equalsIgnoreCase("DL") || p.get("adjResult").equalsIgnoreCase("AM") || p.get("adjResult").equalsIgnoreCase("CA"));
		}
		long finish = System.currentTimeMillis();
		double duration = (finish-start)*1.0;
		System.out.println("Java: "+(duration/1000)+"sec "+" for "+(max*2)+" times: "+(duration/max*1000/2)+" mks/1");

		
		
		
		
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");

		ScriptContext ctx = new SimpleScriptContext();
		ctx.setAttribute("lob", lob, ScriptContext.ENGINE_SCOPE);
		ctx.setAttribute("eventTypeCd", eventTypeCd, ScriptContext.ENGINE_SCOPE);
		ctx.setAttribute("adjResult", adjResult, ScriptContext.ENGINE_SCOPE);

		System.currentTimeMillis();
		
		start = System.currentTimeMillis();
		for(int i=0; i<max; i++){
			result = engine.eval("(lob == 'EDB' || lob == 'PERSONAL_LOAN') && (eventTypeCd == 'SUBMIT_ORIGINATION') && (adjResult == 'AP' || adjResult == 'DL' || adjResult == 'AM' || adjResult == 'CA')", ctx);
			result = engine.eval("(lob == 'EDB' || lob == 'PERSONAL_LOAN') && (eventTypeCd == 'SUBMIT_ORIGINATION') && !(adjResult == 'AP' || adjResult == 'DL' || adjResult == 'AM' || adjResult == 'CA')", ctx);
		}
		finish = System.currentTimeMillis();
		duration = (finish-start)*1.0;
		
		System.out.println("JS: "+(duration/1000)+"sec "+" for "+(max*2)+" times: "+(duration*1000/2/max)+" mks/1");

	}

}
