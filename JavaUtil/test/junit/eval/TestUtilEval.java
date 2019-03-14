package junit.eval;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static rd.mss.util.UtilEval.toMap;

import org.junit.Test;

import rd.mss.util.UtilEval;

public class TestUtilEval {

	@Test
	public void string1() {
		try {
			assertEquals("String", UtilEval.eval("String"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void string2() {
		try {
			assertEquals("USD|2018-05-09|Contract (CFD)|METL|NPRM", UtilEval.eval("USD|2018-05-09|Contract (CFD)|METL|NPRM"));
		}catch(Exception e) {
			assertEquals("USD|2018-05-09|Contract (CFD)|METL|NPRM", e.getMessage());
		}
	}

	@Test
	public void nullif6() {
		try {
			assertEquals("USD|2018-05-09|Contract (CFD)|METL|NPRM", UtilEval.eval("nullif(${a};Data Not Available)", toMap("a","USD|2018-05-09|Contract (CFD)|METL|NPRM")));
		}catch(Exception e) {
			assertEquals("nullif(USD|2018-05-09|Contract (CFD)|METL|NPRM;Data Not Available)", e.getMessage());
		}
	}
	
	@Test
	public void dollarExpr() {
		try {
			assertEquals("BlaBlaBla", UtilEval.eval("${label}", toMap("label", "BlaBlaBla")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void format() {
		try {
			assertEquals("50.56%", UtilEval.eval("format(${quantity};%3.2f)%", toMap("quantity","50.555555555")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void upper() {
		try {
			assertEquals("BLABLABLA", UtilEval.eval("upper(blablabla)"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void lower() {
		try {
			assertEquals("blablabla", UtilEval.eval("lower(BLABLABLA)"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void lower_wrong1() {
		try {
			assertEquals("", UtilEval.eval("lower()"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void lower_wrong2() {
		try {
			assertEquals("blablabla", UtilEval.eval("lower(BLABLABLA;BLA...)"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc1() {
		try {
			assertEquals("3", UtilEval.eval("?(true;3;4)"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}


	@Test
	public void questionFunc11() {
		try {
			assertEquals("4", UtilEval.eval("?(1==2;3;4)"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc12() {
		try {
			assertEquals("3", UtilEval.eval("?(1!=2;3;4)"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc13() {
		try {
			assertEquals("?(1!=;3;4)", UtilEval.eval("?(1!=;3;4)"));
		}catch(Exception e) {
			assertEquals("?(1!=;3;4)", e.getMessage());
		}
	}

	@Test
	public void questionFunc14() {
		try {
			assertEquals("?(;3;4)", UtilEval.eval("?(;3;4)"));
		}catch(Exception e) {
			assertEquals("?(;3;4)", e.getMessage());
		}
	}

	@Test
	public void questionFunc3() {
		try {
			assertEquals("4", UtilEval.eval("?(${a}==${b};${c};${d})", toMap("a","1","b","2","c","3","d","4")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc4() {
		try {
			assertEquals("3", UtilEval.eval("?(${a}==${b};${c};${d})", toMap("a","1","b","1","c","3","d","4")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc5() {
		try {
			assertEquals("", UtilEval.eval("?(${a}==${b};;${d})", toMap("a","1","b","1","c","3","d","4")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc6() {
		try {
			assertEquals("4", UtilEval.eval("?(${a}==${b};;${d})", toMap("a","1","b","2","c","3","d","4")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void replace1() {
		try {
			assertEquals("12-01-71", UtilEval.eval("replace(12.01.71;.;-)"));
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void replace2() {
		try {
			assertEquals("12-01-71", UtilEval.eval("replace(${a};${b};${c})", toMap("a","12.01.71","b",".","c","-")));
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void nullif1() {
		try {
			assertEquals("N/A", UtilEval.eval("nullif(null;N/A)"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void nullif2() {
		try {
			assertEquals("1", UtilEval.eval("nullif(${a};N/A)", toMap("a","1")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void nullif3() {
		try {
			assertEquals("${a}", UtilEval.eval("nullif(${a};N/A)", toMap()));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void nullif4() {
		try {
			assertEquals("N/A", UtilEval.eval("nullif(${a};N/A)", toMap("a", "null")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void nullif5() {
		try {
			assertEquals("N/A", UtilEval.eval("nullif(;N/A)"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
