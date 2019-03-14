package junit.match;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestMatch {

	private String match(String str, Pattern pattern) {
		Matcher matcher = pattern.matcher(str);
	    while( matcher.find() ) {
	    	int groupCount = matcher.groupCount();
	    	String result = "["+groupCount+"]";
	    	for(int i=1; i<=groupCount; i++){
	    		result += "["+matcher.group(i)+"]";
	    	}
   			return result;
	    }
		return null;
	}
	
	@Test
	public void test1() {
		try {
			assertEquals("[1][96.05999999999996]", match("format(${96.05999999999996},%3.2f)%", Pattern.compile("\\$\\{(.*?)\\}")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}


	@Test
	public void test2() {
		try {
			assertEquals("[3][format][96.05999999999996][%3.2f]", match("format(96.05999999999996;%3.2f)%", Pattern.compile("(.*?)\\((.*?)\\;(.*?)\\)")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test3() {
		try {
			assertEquals("[1][3.2]", match("%3.2f", Pattern.compile("%(.*?)f")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test4() {
		try {
			assertEquals(true, Pattern.compile("\\{5,(.*?)\\}").matcher("{5,123}").matches());
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
