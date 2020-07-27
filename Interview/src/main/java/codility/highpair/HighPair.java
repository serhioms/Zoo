package codility.highpair;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

import org.junit.Test;

public class HighPair {

	public String findHighCharPairTooSlow(String S) {
		Set<Character> set = new HashSet<>(64);

		Optional<Character> max = S.chars()
			.mapToObj(c -> (char) c)
			.filter(c->{
				if( set.contains(c) ) {
					return false;
				}
				set.add(c);
				return set.contains(Character.toUpperCase(c)) &&  set.contains(Character.toLowerCase(c));
			})
			.map(c->Character.toLowerCase(c))
			.max((a, b) -> Character.compare(a, b));

		return max.isPresent()?max.get().toString().toUpperCase(): "NO";
	}

	public String findHighCharPairBitSlow(String S) {
		Set<Character> set = new HashSet<>(64);

		Optional<Character> max = S.chars()
			.parallel()
			.mapToObj(c -> (char) c)
			.filter(c->{
				if( set.contains(c) ) {
					return false;
				}
				set.add(c);
				return set.contains(Character.toUpperCase(c)) &&  set.contains(Character.toLowerCase(c));
			})
			.map(c->Character.toLowerCase(c))
			.max((a, b) -> Character.compare(a, b));

		return max.isPresent()?max.get().toString().toUpperCase(): "NO";
	}

	public String findHighCharPairFast(String S) {
		boolean[] charset = new boolean[1024];
		
		OptionalInt max = S.chars()
			.parallel()
			.filter(c->charset[c]?false:(charset[c]=true)?charset[Character.toLowerCase(c)]&&charset[Character.toUpperCase(c)]:false)
			.map(c->Character.toLowerCase(c))
			.max();
		
		return max.isPresent()?String.valueOf(Character.toUpperCase((char)max.getAsInt())): "NO";
	}

	@Test
	public void findHighCharPair() {
		assertEquals("D",findHighCharPairTooSlow("aaBabcDad"));
		assertEquals("D",findHighCharPairBitSlow("aaBabcDad"));
		assertEquals("D",findHighCharPairFast("aaBabcDad"));
		assertEquals("B",findHighCharPairTooSlow("aaBabcDaA"));
		assertEquals("B",findHighCharPairBitSlow("aaBabcDaA"));
		assertEquals("B",findHighCharPairFast("aaBabcDaA"));
		assertEquals("NO",findHighCharPairTooSlow(""));
		assertEquals("NO",findHighCharPairBitSlow(""));
		assertEquals("NO",findHighCharPairFast(""));
		assertEquals("NO",findHighCharPairTooSlow("Codility"));
		assertEquals("NO",findHighCharPairBitSlow("Codility"));
		assertEquals("NO",findHighCharPairFast("Codility"));
		assertEquals("T",findHighCharPairTooSlow("WeTestCodErs"));
		assertEquals("T",findHighCharPairBitSlow("WeTestCodErs"));
		assertEquals("T",findHighCharPairFast("WeTestCodErs"));
		assertEquals("Z",findHighCharPairTooSlow("WeTestCodErszZ"));
		assertEquals("Z",findHighCharPairBitSlow("WeTestCodErszZ"));
		assertEquals("Z",findHighCharPairFast("WeTestCodErszZ"));
	}

}
