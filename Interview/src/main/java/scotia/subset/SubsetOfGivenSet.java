package scotia.subset;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class SubsetOfGivenSet {

	@Test
	public void test() {
		String result = "";
		
		List<String> set = Arrays.asList("A", "B", "C", "D");
		
		SubSets subset = new SubSets(set.size());
		while( subset.hasNext()) {
			result += "["+(subset.next()
					.map(i->set.get(i))
					.collect(Collectors.joining(", "))) + "];";
		}
		assertEquals("[A, B, C, D];[A, B, C];[A, B, D];[A, B];[A, C];[A, D];[A];[B, C, D];[B, C];[B, D];[B];[C, D];[C];[D];", result);
	}
}
