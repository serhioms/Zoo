package ca.interview.rbc.rearrange;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

public class RearrangeString {

	@Test
	public void test() {
		assertEquals("ababaca", rearrangeString("aaabcab"));
		assertEquals("abac", rearrangeString("aabc"));
		assertEquals(null, rearrangeString("aaa"));
	}

	private String rearrangeString(String str) {

		LinkedList<Character> list = new LinkedList<>();
		LinkedList<Character> buffer = new LinkedList<>();
		
		str.chars().sorted().mapToObj(c -> (char) c).forEach(list::add);
		
		String result = "";
		Character last = null;
		
		for(int max=list.size(); !(list.isEmpty() && buffer.isEmpty()) && max-- > 0;) {
			if( last == null ) {
				last = list.removeFirst();
				result = last.toString();
				max=list.size();
			} else {
				Character next = buffer.isEmpty()? null: buffer.getFirst();
				if( next != null && !last.equals(next)) {
					last = next;
					result += buffer.removeFirst().toString();
					max=list.size()+buffer.size();
					continue;
				}
				next = list.isEmpty()? null: list.removeFirst();
				if( next == null ) {
					break;
				} else if( last.equals(next) ) {
						buffer.add(next);
				} else {
					last = next;
					result += next.toString();
					max=list.size()+buffer.size();
				}
			}
		}
		
		return result.length() != str.length()? null: result;
	}

	
	
}
