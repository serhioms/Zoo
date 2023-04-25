package java7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ImmutableExamples {

	@Test
	public void list() {
		List<String> unmodifiableList = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
		try {
			unmodifiableList.add("d");
			fail();
		} catch(UnsupportedOperationException e){
			assertEquals("java.lang.UnsupportedOperationException", e.getClass().getName());
		}
	}

}
