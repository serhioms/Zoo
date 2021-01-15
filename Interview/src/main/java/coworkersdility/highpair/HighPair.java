package coworkersdility.highpair;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

import org.junit.Test;

public class HighPair {

	public String findHighCharPairCharStream(String S) {
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

	public String findHighCharPairCharStreamParallel(String S) {
		Set<Character> set = new HashSet<>(128);

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

	public String findHighCharPairCharStreamParallelOptimize(String S) {
		Set<Character> set = new HashSet<>(128);

		Optional<Character> max = S.chars()
			.parallel()
			.mapToObj(c -> (char) c)
			.filter(c->set.contains(c)?false: set.add(c)?
						set.contains(Character.toUpperCase(c)) &&  set.contains(Character.toLowerCase(c)):
						false)
			.map(c->Character.toLowerCase(c))
			.max((a, b) -> Character.compare(a, b));

		return max.isPresent()?max.get().toString().toUpperCase(): "NO";
	}

	// 100%
	public String findHighCharPairIntStream(String S) {
		boolean[] barr = new boolean[128];
		
		OptionalInt max = S.chars()
			.parallel()
			.filter(c->barr[c]?false:(barr[c]=true)?barr[Character.toLowerCase(c)]&&barr[Character.toUpperCase(c)]:false)
			.map(c->Character.toLowerCase(c))
			.max();
		
		return max.isPresent()?String.valueOf(Character.toUpperCase((char)max.getAsInt())): "NO";
	}

	public Set<Character> findCharPairSet(String S) {
		boolean[] barr = new boolean[128];
		Set<Character> set = new HashSet<>(32);
		
		S.chars()
			.parallel()
			.filter(c->barr[c]?false:(barr[c]=true)?barr[Character.toLowerCase(c)]&&barr[Character.toUpperCase(c)]:false)
			.forEach(c->set.add((char) Character.toLowerCase(c)));
		
		return set;
	}

	@Test
	public void testFindHighCharPair() {
		System.out.println(findCharPairSet("aaBabcDad"));
		System.out.println(findCharPairSet("aaBabcDaA"));
		System.out.println(findCharPairSet("Codility"));
		System.out.println(findCharPairSet("WeTestCodErs"));
		System.out.println(findCharPairSet("WeTestCodErszZ"));

		assertEquals("D",findHighCharPairCharStream("aaBabcDad"));
		assertEquals("D",findHighCharPairCharStreamParallel("aaBabcDad"));
		assertEquals("D",findHighCharPairCharStreamParallelOptimize("aaBabcDad"));
		assertEquals("D",findHighCharPairIntStream("aaBabcDad")); // 100%
		
		assertEquals("B",findHighCharPairCharStream("aaBabcDaA"));
		assertEquals("B",findHighCharPairCharStreamParallel("aaBabcDaA"));
		assertEquals("B",findHighCharPairCharStreamParallelOptimize("aaBabcDaA"));
		assertEquals("B",findHighCharPairIntStream("aaBabcDaA"));
		
		assertEquals("NO",findHighCharPairCharStream(""));
		assertEquals("NO",findHighCharPairCharStreamParallel(""));
		assertEquals("NO",findHighCharPairCharStreamParallelOptimize(""));
		assertEquals("NO",findHighCharPairIntStream(""));
		
		assertEquals("NO",findHighCharPairCharStream("Codility"));
		assertEquals("NO",findHighCharPairCharStreamParallel("Codility"));
		assertEquals("NO",findHighCharPairCharStreamParallelOptimize("Codility"));
		assertEquals("NO",findHighCharPairIntStream("Codility"));
		
		assertEquals("T",findHighCharPairCharStream("WeTestCodErs"));
		assertEquals("T",findHighCharPairCharStreamParallel("WeTestCodErs"));
		assertEquals("T",findHighCharPairCharStreamParallelOptimize("WeTestCodErs"));
		assertEquals("T",findHighCharPairIntStream("WeTestCodErs"));
		
		assertEquals("Z",findHighCharPairCharStream("WeTestCodErszZ"));
		assertEquals("Z",findHighCharPairCharStreamParallel("WeTestCodErszZ"));
		assertEquals("Z",findHighCharPairCharStreamParallelOptimize("WeTestCodErszZ"));
		assertEquals("Z",findHighCharPairIntStream("WeTestCodErszZ"));
	}

}
