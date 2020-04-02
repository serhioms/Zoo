package ca.mss.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;

import ca.mss.streval.EvalUtil;
import ca.mss.streval.EvalException;
import ca.mss.utilms.MapUtil;
import ca.mss.utilms.StrUtil;

public class TestEvalUtil {

	@Test
	public void dateParsingEST() {
		try {
			assertEquals("Tue Jul 17 18:59:25 EDT 2018", Date.from(LocalDateTime.parse("2018-07-17T18:59:25.000441176").atZone(ZoneId.of("America/New_York")).toInstant()).toString());
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void removeAll_1() {
		try {
			assertEquals(null, StrUtil.removeAll(null));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void removeAll_2() {
		try {
			assertEquals("Hey you", StrUtil.removeAll("Hey you"));
		}catch(Exception e) {
			fail(e.getClass().getSimpleName());
		}
	}

	@Test
	public void removeAll_3() {
		try {
			assertEquals("Hey ", StrUtil.removeAll("Hey you", "you"));
		}catch(Exception e) {
			fail(e.getClass().getSimpleName());
		}
	}

	@Test
	public void evaluateBooleanExpression_1() {
		try {
			assertEquals(true, EvalUtil.evaluateBooleanExpression(" tRue "));
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getClass().getSimpleName());
		}
	}

	@Test
	public void evaluateBooleanExpression_2() {
		try {
			assertEquals(false, EvalUtil.evaluateBooleanExpression(" faLse "));
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getClass().getSimpleName());
		}
	}


	@Test
	public void evaluateBooleanExpression_3() {
		try {
			assertEquals(true, EvalUtil.evaluateBooleanExpression(" 1 == 1 "));
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getClass().getSimpleName());
		}
	}

	@Test
	public void evaluateBooleanExpression_4() {
		try {
			assertEquals(false, EvalUtil.evaluateBooleanExpression(" 1 != 1 "));
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getClass().getSimpleName());
		}
	}

	@Test
	public void string() {
		try {
			assertEquals("String", EvalUtil.eval("String"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void nullif() {
		try {
			assertEquals("String", EvalUtil.eval("$nullif(${a};Data Not Available)", MapUtil.toMap("a","String")));
		}catch(Exception e) {
			assertEquals("nullif(String;Data Not Available)", e.getMessage());
		}
	}
	
	@Test
	public void dollarExpr() {
		try {
			assertEquals("BlaBlaBla", EvalUtil.eval("${label}", MapUtil.toMap("label", "BlaBlaBla")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void concatenation1() {
		try {
			assertEquals("1*2*3", EvalUtil.eval("${label1}*${label2}*${label3}", 
					MapUtil.toMap("label1", "1", "label2", "2", "label3", "3")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void concatenation2() {
		try {
			assertEquals("**", EvalUtil.eval("${label1}*${label2}*${label3}"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void concatenation3() {
		try {
			assertEquals("A*B*C", EvalUtil.eval("${label1}*${label2}*${label3}",
					MapUtil.toMap("label1","A"),
					MapUtil.toMap("label2","B"),
					MapUtil.toMap("label3","C")
					));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void concatenation4() {
		try {
			assertEquals("IPR-43260*Pass*<reasoncode1>*<reasoncode2>", EvalUtil.eval("${IPR Correlation ID}*${IPR Pass/Fail}*${IPR Reason Codes}",
					MapUtil.toMap(
							"IPR Correlation ID", "IPR-43260",
							"IPR Pass/Fail", "Pass",
							"IPR Reason Codes", "<reasoncode1>*<reasoncode2>",
							"ThreatMetrix VerificationNo", "63F39BAB-308D-4E47-95A6-FA6508A52E5A"
							)
					));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void questionFunc1() {
		try {
			assertEquals("3", EvalUtil.eval("true?3:4"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}


	@Test
	public void questionFunc11() {
		try {
			assertEquals("4", EvalUtil.eval("1==2?3:4"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc12() {
		try {
			assertEquals("3", EvalUtil.eval("1!=2?3:4"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc13() {
		try {
			assertEquals("3", EvalUtil.eval("1!=?3:4"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc15() {
		try {
			assertEquals("A*B*C*1979-07*True", EvalUtil.eval("${firstName}*${middleName}*${lastName}*$dateTimeFormat(UTC;${birthDt};yyyy-MM)*$?(${socialInsuranceNum}==;False;True)",
					MapUtil.toMap(
							"firstName", "A",
							"middleName", "B",
							"lastName", "C",
							"birthDt","300513600000",
							"socialInsuranceNum", "1234567"
							)));
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void questionFunc16() {
		try {
			assertEquals("A*B*C*1979-07*False", EvalUtil.eval("${firstName}*${middleName}*${lastName}*$dateTimeFormat(UTC;${birthDt};yyyy-MM)*$?(${socialInsuranceNum}==;False;True)",
					MapUtil.toMap(
							"firstName", "A",
							"middleName", "B",
							"lastName", "C",
							"birthDt","300513600000",
							"socialInsuranceNum", ""
							)));
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void questionFunc17() {
		try {
			assertEquals("A*B*C*1979-07*False", EvalUtil.eval("${firstName}*${middleName}*${lastName}*$dateTimeFormat(UTC;${birthDt};yyyy-MM)*$?(${socialInsuranceNum}==;False;True)",
					MapUtil.toMap(
							"firstName", "A",
							"middleName", "B",
							"lastName", "C",
							"birthDt","300513600000"
							)));
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void questionFunc14() {
		try {
			assertEquals("4", EvalUtil.eval("?3:4"));
		}catch(Exception e) {
			assertEquals("Fragment [?3:4] syntax error - missing expression!:\n?3;4", e.getMessage());
		}
	}

	@Test
	public void questionFunc3() {
		try {
			assertEquals("4", EvalUtil.eval("${a}==${b}?${c}:${d}", MapUtil.toMap("a","1","b","2","c","3","d","4")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc4() {
		try {
			assertEquals("3", EvalUtil.eval("${a}==${b}?${c}:${d}", 
					MapUtil.toMap(
							"a","1",
							"b","1",
							"c","3",
							"d","4")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc5() {
		try {
			assertEquals("", EvalUtil.eval("${a}==${b}?:${d}", MapUtil.toMap("a","1","b","1","c","3","d","4")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc6() {
		try {
			assertEquals("4", EvalUtil.eval("${a}==${b}?:${d}", MapUtil.toMap("a","1","b","2","c","3","d","4")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc18() {
		try {
			assertEquals("", EvalUtil.eval("${a}==?:${b}", MapUtil.toMap("a","","b","2")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc19() {
		try {
			assertEquals("", EvalUtil.eval("${a}==?:${b}", MapUtil.toMap("a",null,"b","2")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc20() {
		try {
			assertEquals("", EvalUtil.eval("${a}==?:${b}", MapUtil.toMap("b","2")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc21() {
		try {
			assertEquals("IprId", EvalUtil.eval("${correlationId}${identityVerificationStatus}${IPR Reason Codes}==?:$const(IprId)", 
					MapUtil.toMap(
							"correlationId","1",
							"identityVerificationStatus","2",
							"IPR Reason Codes","3"
							)));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void questionFunc22() {
		try {
			assertEquals("1*2*3", EvalUtil.eval("${correlationId}${identityVerificationStatus}${IPR Reason Codes}==?:${correlationId}*${identityVerificationStatus}*${IPR Reason Codes}", 
					MapUtil.toMap(
							"correlationId","1",
							"identityVerificationStatus","2",
							"IPR Reason Codes","3"
							)));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void nullif1() {
		try {
			assertEquals("N/A", EvalUtil.eval("$nullif(null;N/A)"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void nullif2() {
		try {
			assertEquals("1", EvalUtil.eval("$nullif(${a};N/A)", MapUtil.toMap("a","1")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void nullif3() {
		try {
			assertEquals("N/A", EvalUtil.eval("$nullif(${a};N/A)", MapUtil.toMap()));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void nullif4() {
		try {
			assertEquals("N/A", EvalUtil.eval("$nullif(${a};N/A)", MapUtil.toMap("a", "null")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void nullif5() {
		try {
			assertEquals("N/A", EvalUtil.eval("$nullif(;N/A)"));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void nullif6() {
		try {
			assertEquals("M5V 3A4", EvalUtil.eval("$nullif(${postalCode};${zipCode})", MapUtil.toMap("postalCode", "M5V 3A4")));
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void dateFormat1() {
		try {
			assertEquals("201001", EvalUtil.eval("$dateFormat(dd/MM/yyyy;01/${startDateVal};yyyyMM)", MapUtil.toMap("startDateVal", "01/2010")));
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void dateFormat2() {
		try {
			assertEquals("John*D*Smith*1979-07-11", EvalUtil.eval("${firstName}*${middleName}*${lastName}*$dateTimeFormat(UTC;${birthDt};yyyy-MM-dd)", 
					MapUtil.toMap(
							"firstName", "John",
							"middleName","D",
							"lastName","Smith",
							"birthDt","300513600000"
							)));
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void nodeSelector() {
		try {
			String result = null;
			assertEquals("false", 
					result=EvalUtil.eval("$ca.mss.test.ExternalObjClaz.external1(${type})==C?true:false", 
					MapUtil.toMap(
							"type", "M"
							)));
			System.out.println("nodeSelector: "+result);
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void externalFunction3() {
		try {
			String result = null;
			assertEquals("12345*1979-07-11*xexe*true", 
					result=EvalUtil.eval(
							MapUtil.toMap("externalObject", new ExternalObjClaz()),
							"${refNo}$dateTimeFormat(UTC;${date};yyyy-MM-dd)$externalObject.external3(${param1};${param2})${flag}==?:${refNo}*$dateTimeFormat(UTC;${date};yyyy-MM-dd)*$externalObject.external3(${param1};${param2})*${flag}", 
							MapUtil.toMap(
							"refNo", "12345",
							"param1","a",
							"param2","b",
							"flag","true",
							"date","300513600000"
							)));
			System.out.println("externalFunction: "+result);
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void externalFunction2() {
		try {
			String result = null;
			assertEquals("12345*1979-07-11*xexe*true", 
					result=EvalUtil.eval("${refNo}$dateTimeFormat(UTC;${date};yyyy-MM-dd)$ca.mss.test.ExternalObjClaz.external2(${param1};${param2})${flag}==?:${refNo}*$dateTimeFormat(UTC;${date};yyyy-MM-dd)*$ca.mss.test.ExternalObjClaz.external2(${param1};${param2})*${flag}", 
							MapUtil.toMap(
							"refNo", "12345",
							"param1","a",
							"param2","b",
							"flag","true",
							"date","300513600000"
							)));
			System.out.println("externalFunction: "+result);
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void externalFunction1() {
		try {
			String result = null;
			assertEquals("25 Cherry*xe*", 
					result=EvalUtil.eval("${streetAddress}$ca.mss.test.ExternalObjClaz.external1(${param1})${unitNumber}==?:${streetAddress}*$ca.mss.test.ExternalObjClaz.external1(${param1})*${unitNumber}", 
							MapUtil.toMap(
							"streetAddress", "25 Cherry",
							"param1", "a"
							)));
			System.out.println("externalFunction: "+result);
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void objectDotObject1() {
		try {
			assertEquals("A", EvalUtil.eval(
					"${externalObject.label1}",
					MapUtil.toMap("externalObject", new ExternalObjClaz())
				));
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void objectDotObject2() {
		try {
			assertEquals("B", EvalUtil.eval(
					"${externalObject.label2}",
					MapUtil.toMap("externalObject", new ExternalObjClaz())
				));
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void objectDotObject3() {
		try {
			assertEquals("C", EvalUtil.eval(
					"${externalObject.label3}",
					MapUtil.toMap("externalObject", new ExternalObjClaz())
				));
			fail("Exception - property not exist expected!");
		}catch(EvalException e) {
			// All right
		}
	}
	
	@Test
	public void objectDotObject4() {
		try {
			assertEquals("C", EvalUtil.eval(
					"${externalObject.label4}",
					MapUtil.toMap("externalObject", new ExternalObjClaz())
					));
			fail("Exception - property not exist expected!");
		}catch(EvalException e) {
			// All right
		}
	}
	
	@Test
	public void objectDotObject10() {
		try {
			assertEquals("A*B*C", EvalUtil.eval(
					"${externalObject.label1}*${externalObject.obj2.label}*${externalObject.obj3.obj2.label}",
					MapUtil.toMap("externalObject", new ExternalObjClaz())
				));
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
