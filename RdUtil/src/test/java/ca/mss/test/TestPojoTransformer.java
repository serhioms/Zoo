package ca.mss.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import ca.mss.pojotrans.PojoTransformer;
import ca.mss.test.impl.TestBase;
import ca.mss.test.pojo.dest.Event;
import ca.mss.test.pojo.dest.complex.ComplexTarget;
import ca.mss.test.pojo.dest.simple.SimpleTarget;
import ca.mss.test.pojo.src.complex.Account;
import ca.mss.test.pojo.src.complex.ComplexSource;
import ca.mss.test.pojo.src.complex.Data;
import ca.mss.test.pojo.src.complex.OptionAmt;
import ca.mss.test.pojo.src.simple.SimpleSource;
import ca.mss.utilms.FileNioUtil;
import ca.mss.utilms.JacksonUtil;
import ca.mss.utilms.MapUtil;
import ca.mss.utilms.StrUtil;

/*
 * Performance test
 * 
 * 1) Original logic
 * 
 * simpleTransform #1: 40/120 mls
 * simpleTransform #100,000: 160-180 mks
 * simpleTransform done in 17.3 s
 * 
 * complexTransform #1: 171/233 mls
 * complexTransform #100,000: 3.5-4.0 mls
 * complexTransform done in 398-399 s
 * 
 * 2) Substitute handlers chain to handlers map
 * 
 * simpleTransform #1: 46.000 mls
 * simpleTransform #100,000: 160-161 mks
 * simpleTransform done in 16.17 s
 * 
 * complexTransform #1: 177.000 mls
 * complexTransform #100,000: 3.925 mls
 * complexTransform done in 392.70 s
 * 
 * 3) Add extensive ${data.prop} without proper order and cache  
 * simpleTransform #1: 44.000 mls
 * simpleTransform #100,000: 228 mks
 * simpleTransform done in 22.89 s
 * 
 * complexTransform #1: 210.000 mls
 * complexTransform #100,000: 7.233/9.170 mls
 * complexTransform done in 723.49 s
 * 
 * complexTransform #1: 183.000 mls
 * complexTransform #100,000: 5.570 mls
 * complexTransform done in 557.14 s
 */

public class TestPojoTransformer extends TestBase {

	@Test
	public void simpleTransform() {
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		long start=0, finish=0;
		try {
			
			SimpleSource source = JacksonUtil.readValue(FileNioUtil.getClassLoaderPath("transform/source-simple.json"), SimpleSource.class); 
			assertNotNull(source);
	
			PojoTransformer transformer = new PojoTransformer(FileNioUtil.read2String(FileNioUtil.getClassLoaderPath("transform/MapperSimpleTarget.json")));
			
			AtomicReference<SimpleTarget> target = new AtomicReference<SimpleTarget>();

			Map<String, Object> map = MapUtil.toMap(
					 "parentEventId", "12345"
					,"eventTypeCD", "ASS_PARTY_CMPLNC"
					,"businessOutcomeCD", "-1"
					,"eventStatus", "SUCCESS"
				);

			start = System.currentTimeMillis();
			test(method, ()->{
				try {
					target.set(transformer.transform(source, SimpleTarget.class, map));
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			finish = System.currentTimeMillis();
			
			assertNotNull(target.get());
	
			String expected = FileNioUtil.read2String(FileNioUtil.getClassLoaderPath("transform/target-simple-expected.json"));
			String actual = JacksonUtil.serialize(target.get());

			if( max == 1 ){
				System.out.printf("Expected: %s\n", expected);
				System.out.printf("  Actual: %s\n", actual);
			}

			assertEquals("Fail transform", expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		System.out.printf("%s done in %.2f s\n\n", method, (finish - start)/1000.0);
	}

	@Test
	public void complexTransform() {
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		long start=0, finish=0;
		try {
			
			ComplexSource source = JacksonUtil.readValue(FileNioUtil.getClassLoaderPath("transform/source-complex.json"), ComplexSource.class); 
			assertNotNull(source);
	
			PojoTransformer transformer = new PojoTransformer(FileNioUtil.read2String(FileNioUtil.getClassLoaderPath("transform/MapperComplexTarget.json")));
			
			AtomicReference<ComplexTarget> target = new AtomicReference<ComplexTarget>();

			Event event = new Event();
			event.setEventTmstmp("2018-07-17 18:59:25.441176"); 
			event.setEventStatusCd("SUCCESS");
			event.setEventTypeCd("SUBMIT_ORIGINATION");
			@SuppressWarnings("unchecked")
			Map<String, Object> eventMap = MapUtil.toMap(JacksonUtil.convertValue(event, Map.class));

			Map<String, Object> metadataMap = MapUtil.toMap(
					"reasonCodes","[CB3:CB3 Check, 02:Customer not within risk tolerance]",
					"correlationId", "IPR-80771",
					"identityVerificationStatus", "Pass",
					"identityVerification", "[{serviceProviderNM=ThreatMetrix, verificationNO=644b3f63cd6c4ce2a06357dfb9431686}, {serviceProviderNM=TransUnion, verificationNO=20100831-0406819}, {serviceProviderNM=EBVS, verificationNO=20180629-287160}]"
			);
			
			Optional<Account> account = Optional.of(source)
					.map(ComplexSource::getData)
					.map(Data::getAccounts)
					.map(accountList->accountList.get(0));
			
			Map<String, Object> complexMap = MapUtil.toMap(
					"metaData", source.getMetaData(),
					"accessCard", !account.isPresent()? null: account.get().getAccessCard(),
					"branch", !account.isPresent()? null: account.get().getBranch(),
					"Requested_Amount", extractAmount(account, "requestedAmount"),
					"Approved_Amount", extractAmount(account, "approvedAmt")
					);
			
			Map<String, Object> idpMap = MapUtil.toMap(
					"Threat_Metrix_Verification_No", extractThreatMetrixVerificationNo("identityVerification", metadataMap, metadataMap),
					"IPR_Reason_Codes", extractIPRReasonCodes("reasonCodes", metadataMap, metadataMap),
					"correlationId", extractCorrelationId("errorMessage", metadataMap, metadataMap)
					);
			
			start = System.currentTimeMillis();
			test(method, ()->{
				try {
					target.set(transformer.transform(source, ComplexTarget.class, 
							eventMap,
							metadataMap,
							complexMap,
							idpMap
						)
					);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			finish = System.currentTimeMillis();

			assertNotNull(target.get());
	
			String expected = FileNioUtil.read2String(FileNioUtil.getClassLoaderPath("transform/target-complex-expected.json"));
			String actual = JacksonUtil.serialize(target.get());
			
			if( max == 1 ){
				System.out.printf("Expected:  %s\n", expected);
				System.out.printf("  Actual:  %s\n", actual);
			}
			
			assertEquals("Fail transform", expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		System.out.printf("%s done in %.2f s\n\n", method, (finish - start)/1000.0);
	}
	
	
	
	
	/*
	 * Complex parameter extracting
	 */
	
	private String extractAmount(Optional<Account> account, String amountType) {
		try {
			return account.map(Account::getAmounts)
					.map(amountList->amountList.stream().filter(amount->amountType.equals(amount.getType()))
									.findFirst()
									.map(OptionAmt::getAmount))
					.map(d->d.get()==null? "": d.get().toString())
					.map(String::toString).orElse("");
		} catch(Exception e){
			return null;
		}
	}

	@SafeVarargs
	final private String extractThreatMetrixVerificationNo(String key, Map<String,Object>...maps) {
		try {
			if( maps == null ){
				return "";
			}
	
			Object list = null;
			
			for(int i=0; i<maps.length; i++){
				if( maps[i] != null && maps[i].containsKey(key)){
					list = maps[i].get(key);
					if( list != null && !list.toString().isEmpty() && ! "[]".equals(list)){
						break;
					}
				}
			}
			
			if( list == null ){
				return "";
			}
			
			/* [{serviceProviderNM=ThreatMetrix, verificationNO=644b3f63cd6c4ce2a06357dfb9263944}, 
			 *  {serviceProviderNM=TransUnion, verificationNO=20100831-0629620}, 
			 *  {serviceProviderNM=EBVS, verificationNO=20180629-497298}]
			 */
			return StrUtil.extract(list.toString(), 
					"\\{serviceProviderNM=ThreatMetrix", "1", 
					"\\, verificationNO=", "1", 
					"\\}", "0");
		} catch(RuntimeException e){
			return "";
		}
	}

	@SafeVarargs
	final private String extractIPRReasonCodes(String key, Map<String,Object>...maps) {
		try {
			if( maps == null ){
				return "";
			}
			
			Object list = null;
			
			for(int i=0; i<maps.length; i++){
				if( maps[i] != null && maps[i].containsKey(key)){
					list = maps[i].get(key);
					if( list != null && !list.toString().isEmpty() && ! "[]".equals(list)){
						break;
					}
				}
			}
			
			if( list == null ){
				return "";
			}
			
			/* 
			 * [CB3:CB3 Check, 02:Customer not within risk tolerance] => CB3*02
			 */
			String result = "";
			String[] doSplit = list.toString().split("\\[|:|, |\\]");
			
			for(int i=1, max=doSplit.length; i<max; i+=2){
				result += (result.isEmpty()?"":"*")+doSplit[i];
			}
			
			return result;
		} catch(RuntimeException e){
			return "";
		}
	}

	@SafeVarargs
	final private String extractCorrelationId(String key, Map<String,Object>...maps) {
		try {
			if( maps == null ){
				return "";
			}
			
			Object list = null;
			
			for(int i=0; i<maps.length; i++){
				if( maps[i] != null && maps[i].containsKey(key)){
					list = maps[i].get(key);
					if( list != null && !list.toString().isEmpty() && ! "[]".equals(list)){
						break;
					}
				}
			}
			
			if( list == null ){
				return "";
			}
			
			/* 
			 * Retrieve IP service call failed. Status: Fail
			 * | Correlation Id: IPR-675937
			 * | Reason code : 08 Description: Multiple Attempts Detected
			 * | Reason code : 10 Description: Customer not within credit history
			 * | Reason code : 02 Description: Customer not within risk tolerance => IPR-675937
			 */
			return StrUtil.extract(list.toString(), 
					"\\| Correlation Id\\: ", "1", 
					"\\|", "0");
		} catch(RuntimeException e){
			return "";
		}
	}

	/*
	 * External functions for the complex transformation test
	 */
	
	private static final String APPROVED = "Approved";
	private static final String DECLINED = "Declined";

	public static int adjudicationSelector(ArrayNode anode){
		switch( anode.size() ){
		case 0:
			return -1;	// Skip adjudication
		case 1:
			return 0;	// 1. if only one adjudication then that is primary/current
		default: 		// 2. if >1 adjudication then sort by adjudicationDate to find current (null < valid date)
			List<JsonNode> list = new ArrayList<>();
			for(int i=0,max=anode.size(); i<max; i++){
				list.add(anode.get(i));
			}
			JsonNode latestNode = list.stream().sorted((a,b)->b.get("adjudicationDate").intValue()-a.get("adjudicationDate").intValue()).findFirst().get();
			for(int i=0,max=anode.size(); i<max; i++){
				if( anode.get(i) == latestNode ){
					return i;
				}
			}
			return -1;
		}
	}
	
	public static int employmentSelector(ArrayNode anode){
		switch( anode.size() ){
		case 0:
			return -1;	// Skip employment
		case 1:
			return 0;	// 1.	if only one instance then that one is primary/current
		default: 		// 2.	if >1 instances use isPrimary = true and isActive = true to find primary/current (if none primary/active select none)
						// 3.	if multiple isPrimary = true and isActive = true then select where actionInd = 1 (if multiple actionInd = 1 select none)
			int index = -1;
			int index1 = -1;
			for(int i=0,max=anode.size(); i<max; i++){
				JsonNode el = anode.get(i);
				JsonNode isPrimary = el.get("isPrimary");
				JsonNode isActive = el.get("isActive");
				JsonNode actionInd = el.get("actionInd");
				if( isPrimary != null && isActive != null ){
					if( isPrimary.booleanValue() && isActive.booleanValue() ){
						if( "1".equals(actionInd.textValue()) ){
							if( index1 == -1 ){
								index1 = i;
							} else {
								return -1; // if multiple actionInd = 1 select none
							}
						} else if( index == -1 ){
							index = i;
						} else {
							return Integer.MAX_VALUE; // if none actionInd = 1 select none
						}
					} 
				} 
			}
			return index1>0? index1: index;
		}
	}

	public static String activityTypeCd(){
		return "";
	}

	public static String activityTypeCd(String fraudEventTypeCd ){
		if( fraudEventTypeCd == null || fraudEventTypeCd.isEmpty() ){
			return "";
		}
		switch( fraudEventTypeCd.toUpperCase() ){
		case "START_IDENTITY_PROOF": 	return "EAIP";
		case "SUBMIT_ORIGINATION": 		return "EASU";
		case "REC_ADJ_NOTIFICATION": 	return "EAAJ";
		case "RECIEVE_ADJUDICATION": 	return "EAAJ";
		case "UPDATE_ACCOUNT": 			return "EAFN";
		case "FUND_ACCOUNT": 			return "EAFN";
		case "CANCEL_APPLICATION": 		return "EACN";
		case "EXECUTE_IDNTITY_PRF": 	return "EAIS";
		case "CHECK_PARTY_ALERTS": 		return "EAAS";
		case "CHECK_ELIGIBILITY": 		return "EAAS";
		default:
			throw new RuntimeException("Unmapped activity type code for [fraudEventTypeCd="+fraudEventTypeCd+"]");
		}
	}
	
	public static String businessOutcomeCd(String fraudEventTypeCd, String fraudBusinessOutcomeCd ){
		if( fraudEventTypeCd == null || fraudEventTypeCd.isEmpty() ){
			return "";
		}
		if( fraudBusinessOutcomeCd == null || fraudBusinessOutcomeCd.isEmpty() ){
			return "";
		}
		switch( fraudEventTypeCd.toUpperCase() ){
		case "START_IDENTITY_PROOF": 	return "IPR_START";
		case "SUBMIT_ORIGINATION": 		return "SUBMIT";
		case "REC_ADJ_NOTIFICATION": 	return "ADJUDICATE";
		case "RECIEVE_ADJUDICATION": 	return "ADJUDICATE";
		case "UPDATE_ACCOUNT": 			return "FUND";
		case "FUND_ACCOUNT": 			return "FUND";
		case "CANCEL_APPLICATION": 		return "CANCEL";
		case "EXECUTE_IDNTITY_PRF": 	return "-1".equals(fraudBusinessOutcomeCd)?"-1":"IPR_FAIL";
		case "CHECK_PARTY_ALERTS": 		return "-1".equals(fraudBusinessOutcomeCd)?"-1":"ALERT_HARDSTOP";
		case "CHECK_ELIGIBILITY ": 		return "-1".equals(fraudBusinessOutcomeCd)?"-1":"ALERT_HARDSTOP";
		default:
			throw new RuntimeException("Unmapped business outcome code for [fraudEventTypeCd="+fraudEventTypeCd+"][fraudBusinessOutcomeCd="+fraudBusinessOutcomeCd+"]");
		}
	}

	public static String phoneType(){
		return "";
	}
	
	public static String phoneType(String phoneType){
		if( phoneType == null || phoneType.isEmpty() ){
			return "";
		}
		switch( phoneType.toUpperCase() ){
		case "LANDLINE": 	return "P"; // Landline
		case "P": 			return "P"; // Landline
		case "C": 			return "C";	// Mobile
		case "MOBILE": 		return "C";	// Mobile
		case "W": 			return "W";	// Fax
		case "F": 			return "F";	// Work
		default:
			throw new RuntimeException("Unmapped adress phone type for [phoneType="+phoneType+"]");
		}
	}

	public static String unitType(){
		return "";
	}

	public static String unitType(String unitType){
		if( unitType == null || unitType.isEmpty() ){
			return "";
		}
		switch( unitType.toUpperCase() ){
		case "APARTMENT": 	return "APT";	// Apartment
		case "APT": 		return "APT";	// Apartment
		case "SUITE": 		return "SUITE"; // Suite
		case "PENTHOUSE": 	return "PH";	// Penthouse
		case "UNIT": 		return "UNIT";	// Unit
		//case "": 			return "ROOM";	// Room
		case "FLOOR": 		return "FLOOR";	// Floor
		default:
			throw new RuntimeException("Unmapped adress unit type for [unitType="+unitType+"]");
		}
	}
	
	public static String adjudicationTable(String adjudicationResponseCd, String lobName){
		if( adjudicationResponseCd == null || adjudicationResponseCd.isEmpty() ){
			return "";
		}
		if( lobName == null || lobName.isEmpty() ){
			return "";
		}
		switch((lobName+"-"+adjudicationResponseCd).toUpperCase()){
		case "PL-AP":	 return APPROVED; //	Approved
		case "PL-DL":	 return DECLINED; //	Declined
		case "PL-AM":	 return APPROVED; //	Amended Approval (Downsell)
		case "PL-CA":	 return APPROVED; //	Conditional Approval
		case "PL-FW":	 return ""; 		//	Forwarded (no Fraud notification)
		case "PL-PD":	 return ""; 		//	Pending (no Fraud notification)
		case "PL-SU":	 return ""; 		//	Submitted
		case "PL-AE":	 return ""; 		//	Approval Expired (no Fraud notification)
		case "PL-WD":	 return ""; 		//	Waiver Declined (no Fraud notification)
		case "PL-PF":	 return ""; 		//	Pending Funding (no Fraud notification)
		case "PL-RM": 	 return ""; 		//	Reversed Mortgage (no Fraud notification)
		case "CARDS-AP": return APPROVED; //	Approved
		case "CARDS-DL": return DECLINED; //	Declined
		case "CARDS-AM": return APPROVED; //	Amended Approval (Downsell)
		case "CARDS-CA": return DECLINED; //	Conditional Approval
		case "CARDS-FW": return ""; 		//	Forwarded (no Fraud notification)
		case "CARDS-PD": return ""; 		//	Pending (no Fraud notification)
		case "CARDS-SU": return ""; 		//	Submitted
		case "CARDS-AE": return ""; 		//	Approval Expired (no Fraud notification)
		case "CARDS-WD": return ""; 		//	Waiver Declined (no Fraud notification)
		case "CARDS-PF": return ""; 		//	Pending Funding (no Fraud notification)
		case "CARDS-RM": return ""; 		//	Reversed Mortgage (no Fraud notification)
		default:
			throw new RuntimeException("Unmapped Adjudication Approve/Decline for [LOB="+lobName+"][adjudicationResponseCd="+adjudicationResponseCd+"]");
		}
	}
}
