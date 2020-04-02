package ca.mss.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.mss.utilms.StrUtil;

public class TestStrUtil {

	@Test
	public void parseErrorMessage() {
		assertEquals("IPR-675937", 
			StrUtil.extract(
				"Retrieve IP service call failed." 
					+"Status: Fail"
					+"| Correlation Id: IPR-675937"
					+"| Reason code : 08 Description: Multiple Attempts Detected"
					+"| Reason code : 10 Description: Customer not within credit history"
					+"| Reason code : 02 Description: Customer not within risk tolerance => IPR-675937"
				,"\\| Correlation Id\\: ", "1", 
				 "\\|", "0"));
	}

	@Test
	public void parseList() {
		assertEquals("644b3f63cd6c4ce2a06357dfb9263944", 
			StrUtil.extract(
				"[{serviceProviderNM=ThreatMetrix, verificationNO=644b3f63cd6c4ce2a06357dfb9263944}," 
						+"{serviceProviderNM=TransUnion, verificationNO=20100831-0629620}, "
						+"{serviceProviderNM=EBVS, verificationNO=20180629-497298}]"
				,"\\{serviceProviderNM=ThreatMetrix", "1", 
				 "\\, verificationNO=", "1", 
				 "\\}", "0"));
	}
}