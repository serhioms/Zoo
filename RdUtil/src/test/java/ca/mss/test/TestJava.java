package ca.mss.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestJava {

	@Test
	public void nullInMap() {
		try {
			Map<String,Object> map = new HashMap<String,Object>();

			map.put("key", null);
			
			assertEquals(true, map.containsKey("key"));

			assertEquals(null, map.get("key"));

			assertEquals(null, map.get("abrakadabra"));
			
			assertEquals(false, map.containsKey("abrakadabra"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	public static class A {}
	
	public static class B extends A{}
	
	@Test
	public void castingNull() {
		try {
			B b = null;
			A a = (A )b;
			System.out.println(a);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
