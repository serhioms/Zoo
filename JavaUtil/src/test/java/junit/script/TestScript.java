package junit.script;

import static org.junit.Assert.fail;

import javax.script.ScriptException;

import org.junit.Test;

import rd.mss.util.script.ScriptUtil;

public class TestScript {

	@Test
	public void EvalScript() {
		try {
			ScriptUtil.nashorn("print('Hello, World!');");
			ScriptUtil.nashorn("print('Hello, World!');");
			ScriptUtil.nashorn("a = 2+2;");
			ScriptUtil.nashorn("b = a*a;");

			ScriptUtil.javascript("2+2");

			ScriptUtil.ecmascript("2+2");

		} catch (final ScriptException se) {
			se.printStackTrace();
			fail(se.getMessage());
		}
	}

}
