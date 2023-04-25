package interview.question;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class TestStringBuilder {

	@Test
	public void test01(){
		
		String string = "hello";
		StringBuilder builder = new StringBuilder("hello");
		StringBuilder builder2 = new StringBuilder("hello");

		// fail(string == builder);
		assertFalse(string.equals(builder) );
		assertFalse(builder2.equals(builder) );
	}
}
