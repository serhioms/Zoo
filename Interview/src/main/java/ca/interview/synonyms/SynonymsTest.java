package ca.interview.synonyms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SynonymsTest {

	public interface ISynonyms {
		public void addSynonyms(String w1, String w2);
		public boolean isSynonyms(String w1, String w2);
	}
	
	
	ISynonyms syn;

	@Before
	public void setUp() throws Exception {
		syn = new Synonyms();
		syn.addSynonyms("Amazing", "Astonishing");
		syn.addSynonyms("Astonishing", "Thrilling");
	}

	@Test
	public void test1() {
		assertTrue(syn.isSynonyms("Amazing", "Thrilling"));
	}

	@Test
	public void test2() {
		assertTrue(syn.isSynonyms("ThrillinG", "AmazinG"));
	}

	@Test
	public void test3() {
		assertFalse(syn.isSynonyms("Apple", "AmazinG"));
	}

	@Test
	public void test4() {
		assertTrue(syn.isSynonyms("Astonishing", "Astonishing"));
	}

	@Test
	public void test5() {
		assertTrue(syn.isSynonyms("Astonishing", "AstonishinG"));
	}

	@Test
	public void test6() {
		assertTrue(syn.isSynonyms("Apple", "ApplE"));
	}

	@Test
	public void test7() {
		assertFalse(syn.isSynonyms("Apple", "Mellon"));
	}

	@Test
	public void test8() {
		try {
			syn.isSynonyms("Apple", null);
			assertTrue(false);
		}catch(RuntimeException e){
			assertTrue(true);
		}
	}


}
