
package ca.mss.test.pojo.src.complex;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "subApplicationId",
    "adjudicationRefList",
    "type",
    "productId",
    "iban",
    "name",
    "number",
    "currency",
    "businessDetails",
    "branch",
    "institutionNumber",
    "institutionName",
    "status",
    "feature",
    "purpose",
    "thirdPartyIndicator",
    "activateApplicationIndicator",
    "acceptIndicator",
    "accessCard",
    "dates",
    "overdraftEligibleFlg",
    "rate",
    "transactionIdList",
    "amounts",
    "fees",
    "acctStatementDelivery",
    "holders"
})
public class Account implements Serializable, Cloneable
{

    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * 
     */
    @JsonProperty("subApplicationId")
    @JsonPropertyDescription("corresponding to EVENT. SUBAPPLICATION_ID")
    private String subApplicationId;
    /**
     * This is an adjudication referenceNumber List in this format: adjudicationReferenceNo + ' - ' + adjudicationResultList.adjudicationDate. For an account open, we may get more than one adjudication results.
     * 
     */
    @JsonProperty("adjudicationRefList")
    @JsonPropertyDescription("This is an adjudication referenceNumber List in this format: adjudicationReferenceNo + ' - ' + adjudicationResultList.adjudicationDate. For an account open, we may get more than one adjudication results.")
    private List<String> adjudicationRefList = null;
    /**
     * This will hold whether account is saving / CC / loan / chequing / allInclusiveChecquing.
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("This will hold whether account is saving / CC / loan / chequing / allInclusiveChecquing.")
    private String type;
    /**
     * This will hold whether account is open for product for which application is made.
     * 
     */
    @JsonProperty("productId")
    @JsonPropertyDescription("This will hold whether account is open for product for which application is made.")
    private String productId;
    /**
     * This will hold IBAN number of an account.
     * 
     */
    @JsonProperty("iban")
    @JsonPropertyDescription("This will hold IBAN number of an account.")
    private String iban;
    /**
     * This is an account name 
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("This is an account name ")
    private String name;
    /**
     * This is an account number.
     * 
     */
    @JsonProperty("number")
    @JsonPropertyDescription("This is an account number.")
    private String number;
    /**
     * This is an account currency.
     * 
     */
    @JsonProperty("currency")
    @JsonPropertyDescription("This is an account currency.")
    private String currency;
    /**
     * Version v1, Date; 20180529. BusinessDetails Definition
     * 
     */
    @JsonProperty("businessDetails")
    @JsonPropertyDescription("Version v1, Date; 20180529. BusinessDetails Definition")
    private BusinessDetails businessDetails;
    @JsonProperty("branch")
    private Branch branch;
    /**
     * This is a bank code e.g. 004 for TD.
     * 
     */
    @JsonProperty("institutionNumber")
    @JsonPropertyDescription("This is a bank code e.g. 004 for TD.")
    private String institutionNumber;
    /**
     * This is a bank or financial institution Name corresponding to institutionNumber, e.g. TD,  MBNA, RBC 
     * 
     */
    @JsonProperty("institutionName")
    @JsonPropertyDescription("This is a bank or financial institution Name corresponding to institutionNumber, e.g. TD,  MBNA, RBC ")
    private String institutionName;
    /**
     * This is an account status such as closed, open, activated, frozen etc.
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("This is an account status such as closed, open, activated, frozen etc.")
    private String status;
    /**
     * For DI, features would have value such as Options &/Or Shortselling. This needs discussion.
     * 
     */
    @JsonProperty("feature")
    @JsonPropertyDescription("For DI, features would have value such as Options &/Or Shortselling. This needs discussion.")
    private String feature;
    @JsonProperty("purpose")
    private String purpose;
    /**
     * Used to determine if the application is for individual or third party (false for individual, true for third party)
     * 
     */
    @JsonProperty("thirdPartyIndicator")
    @JsonPropertyDescription("Used to determine if the application is for individual or third party (false for individual, true for third party)")
    private Boolean thirdPartyIndicator;
    /**
     * Used to determine if the application account was sent for activation
     * 
     */
    @JsonProperty("activateApplicationIndicator")
    @JsonPropertyDescription("Used to determine if the application account was sent for activation")
    private Boolean activateApplicationIndicator;
    /**
     * Used to determine if applicant accepted the amended amount, e.g. downsell or upSell.
     * 
     */
    @JsonProperty("acceptIndicator")
    @JsonPropertyDescription("Used to determine if applicant accepted the amended amount, e.g. downsell or upSell.")
    private String acceptIndicator;
    @JsonProperty("accessCard")
    private AccessCard accessCard;
    @JsonProperty("dates")
    private List<Date> dates = null;
    @JsonProperty("overdraftEligibleFlg")
    private String overdraftEligibleFlg;
    @JsonProperty("rate")
    private List<Rate> rate = null;
    /**
     * This is a txnIdList which determins which txn occured for which newly opened account.
     * 
     */
    @JsonProperty("transactionIdList")
    @JsonPropertyDescription("This is a txnIdList which determins which txn occured for which newly opened account.")
    private List<String> transactionIdList = null;
    /**
     * This list  contains all the different amounts linked to account.
     * 
     */
    @JsonProperty("amounts")
    @JsonPropertyDescription("This list  contains all the different amounts linked to account.")
    private List<OptionAmt> amounts = null;
    @JsonProperty("fees")
    private List<Fee> fees = null;
    @JsonProperty("acctStatementDelivery")
    private List<AcctStatementDelivery> acctStatementDelivery = null;
    /**
     * This contains all the account holders list.
     * 
     */
    @JsonProperty("holders")
    @JsonPropertyDescription("This contains all the account holders list.")
    private List<Holder> holders = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6460015503086302356L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Account() {
    }

    /**
     * 
     * @param fees
     * @param purpose
     * @param type
     * @param branch
     * @param transactionIdList
     * @param number
     * @param feature
     * @param overdraftEligibleFlg
     * @param amounts
     * @param rate
     * @param holders
     * @param adjudicationRefList
     * @param acctStatementDelivery
     * @param currency
     * @param productId
     * @param activateApplicationIndicator
     * @param acceptIndicator
     * @param subApplicationId
     * @param thirdPartyIndicator
     * @param dates
     * @param businessDetails
     * @param accessCard
     * @param institutionNumber
     * @param iban
     * @param institutionName
     * @param name
     * @param status
     */
    public Account(String subApplicationId, List<String> adjudicationRefList, String type, String productId, String iban, String name, String number, String currency, BusinessDetails businessDetails, Branch branch, String institutionNumber, String institutionName, String status, String feature, String purpose, Boolean thirdPartyIndicator, Boolean activateApplicationIndicator, String acceptIndicator, AccessCard accessCard, List<Date> dates, String overdraftEligibleFlg, List<Rate> rate, List<String> transactionIdList, List<OptionAmt> amounts, List<Fee> fees, List<AcctStatementDelivery> acctStatementDelivery, List<Holder> holders) {
        super();
        this.subApplicationId = subApplicationId;
        this.adjudicationRefList = adjudicationRefList;
        this.type = type;
        this.productId = productId;
        this.iban = iban;
        this.name = name;
        this.number = number;
        this.currency = currency;
        this.businessDetails = businessDetails;
        this.branch = branch;
        this.institutionNumber = institutionNumber;
        this.institutionName = institutionName;
        this.status = status;
        this.feature = feature;
        this.purpose = purpose;
        this.thirdPartyIndicator = thirdPartyIndicator;
        this.activateApplicationIndicator = activateApplicationIndicator;
        this.acceptIndicator = acceptIndicator;
        this.accessCard = accessCard;
        this.dates = dates;
        this.overdraftEligibleFlg = overdraftEligibleFlg;
        this.rate = rate;
        this.transactionIdList = transactionIdList;
        this.amounts = amounts;
        this.fees = fees;
        this.acctStatementDelivery = acctStatementDelivery;
        this.holders = holders;
    }

    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * 
     */
    @JsonProperty("subApplicationId")
    public String getSubApplicationId() {
        return subApplicationId;
    }

    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * 
     */
    @JsonProperty("subApplicationId")
    public void setSubApplicationId(String subApplicationId) {
        this.subApplicationId = subApplicationId;
    }

    /**
     * This is an adjudication referenceNumber List in this format: adjudicationReferenceNo + ' - ' + adjudicationResultList.adjudicationDate. For an account open, we may get more than one adjudication results.
     * 
     */
    @JsonProperty("adjudicationRefList")
    public List<String> getAdjudicationRefList() {
        return adjudicationRefList;
    }

    /**
     * This is an adjudication referenceNumber List in this format: adjudicationReferenceNo + ' - ' + adjudicationResultList.adjudicationDate. For an account open, we may get more than one adjudication results.
     * 
     */
    @JsonProperty("adjudicationRefList")
    public void setAdjudicationRefList(List<String> adjudicationRefList) {
        this.adjudicationRefList = adjudicationRefList;
    }

    /**
     * This will hold whether account is saving / CC / loan / chequing / allInclusiveChecquing.
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * This will hold whether account is saving / CC / loan / chequing / allInclusiveChecquing.
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This will hold whether account is open for product for which application is made.
     * 
     */
    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    /**
     * This will hold whether account is open for product for which application is made.
     * 
     */
    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * This will hold IBAN number of an account.
     * 
     */
    @JsonProperty("iban")
    public String getIban() {
        return iban;
    }

    /**
     * This will hold IBAN number of an account.
     * 
     */
    @JsonProperty("iban")
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * This is an account name 
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * This is an account name 
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is an account number.
     * 
     */
    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    /**
     * This is an account number.
     * 
     */
    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * This is an account currency.
     * 
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * This is an account currency.
     * 
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Version v1, Date; 20180529. BusinessDetails Definition
     * 
     */
    @JsonProperty("businessDetails")
    public BusinessDetails getBusinessDetails() {
        return businessDetails;
    }

    /**
     * Version v1, Date; 20180529. BusinessDetails Definition
     * 
     */
    @JsonProperty("businessDetails")
    public void setBusinessDetails(BusinessDetails businessDetails) {
        this.businessDetails = businessDetails;
    }

    @JsonProperty("branch")
    public Branch getBranch() {
        return branch;
    }

    @JsonProperty("branch")
    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    /**
     * This is a bank code e.g. 004 for TD.
     * 
     */
    @JsonProperty("institutionNumber")
    public String getInstitutionNumber() {
        return institutionNumber;
    }

    /**
     * This is a bank code e.g. 004 for TD.
     * 
     */
    @JsonProperty("institutionNumber")
    public void setInstitutionNumber(String institutionNumber) {
        this.institutionNumber = institutionNumber;
    }

    /**
     * This is a bank or financial institution Name corresponding to institutionNumber, e.g. TD,  MBNA, RBC 
     * 
     */
    @JsonProperty("institutionName")
    public String getInstitutionName() {
        return institutionName;
    }

    /**
     * This is a bank or financial institution Name corresponding to institutionNumber, e.g. TD,  MBNA, RBC 
     * 
     */
    @JsonProperty("institutionName")
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    /**
     * This is an account status such as closed, open, activated, frozen etc.
     * 
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * This is an account status such as closed, open, activated, frozen etc.
     * 
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * For DI, features would have value such as Options &/Or Shortselling. This needs discussion.
     * 
     */
    @JsonProperty("feature")
    public String getFeature() {
        return feature;
    }

    /**
     * For DI, features would have value such as Options &/Or Shortselling. This needs discussion.
     * 
     */
    @JsonProperty("feature")
    public void setFeature(String feature) {
        this.feature = feature;
    }

    @JsonProperty("purpose")
    public String getPurpose() {
        return purpose;
    }

    @JsonProperty("purpose")
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * Used to determine if the application is for individual or third party (false for individual, true for third party)
     * 
     */
    @JsonProperty("thirdPartyIndicator")
    public Boolean getThirdPartyIndicator() {
        return thirdPartyIndicator;
    }

    /**
     * Used to determine if the application is for individual or third party (false for individual, true for third party)
     * 
     */
    @JsonProperty("thirdPartyIndicator")
    public void setThirdPartyIndicator(Boolean thirdPartyIndicator) {
        this.thirdPartyIndicator = thirdPartyIndicator;
    }

    /**
     * Used to determine if the application account was sent for activation
     * 
     */
    @JsonProperty("activateApplicationIndicator")
    public Boolean getActivateApplicationIndicator() {
        return activateApplicationIndicator;
    }

    /**
     * Used to determine if the application account was sent for activation
     * 
     */
    @JsonProperty("activateApplicationIndicator")
    public void setActivateApplicationIndicator(Boolean activateApplicationIndicator) {
        this.activateApplicationIndicator = activateApplicationIndicator;
    }

    /**
     * Used to determine if applicant accepted the amended amount, e.g. downsell or upSell.
     * 
     */
    @JsonProperty("acceptIndicator")
    public String getAcceptIndicator() {
        return acceptIndicator;
    }

    /**
     * Used to determine if applicant accepted the amended amount, e.g. downsell or upSell.
     * 
     */
    @JsonProperty("acceptIndicator")
    public void setAcceptIndicator(String acceptIndicator) {
        this.acceptIndicator = acceptIndicator;
    }

    @JsonProperty("accessCard")
    public AccessCard getAccessCard() {
        return accessCard;
    }

    @JsonProperty("accessCard")
    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    @JsonProperty("dates")
    public List<Date> getDates() {
        return dates;
    }

    @JsonProperty("dates")
    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    @JsonProperty("overdraftEligibleFlg")
    public String getOverdraftEligibleFlg() {
        return overdraftEligibleFlg;
    }

    @JsonProperty("overdraftEligibleFlg")
    public void setOverdraftEligibleFlg(String overdraftEligibleFlg) {
        this.overdraftEligibleFlg = overdraftEligibleFlg;
    }

    @JsonProperty("rate")
    public List<Rate> getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(List<Rate> rate) {
        this.rate = rate;
    }

    /**
     * This is a txnIdList which determins which txn occured for which newly opened account.
     * 
     */
    @JsonProperty("transactionIdList")
    public List<String> getTransactionIdList() {
        return transactionIdList;
    }

    /**
     * This is a txnIdList which determins which txn occured for which newly opened account.
     * 
     */
    @JsonProperty("transactionIdList")
    public void setTransactionIdList(List<String> transactionIdList) {
        this.transactionIdList = transactionIdList;
    }

    /**
     * This list  contains all the different amounts linked to account.
     * 
     */
    @JsonProperty("amounts")
    public List<OptionAmt> getAmounts() {
        return amounts;
    }

    /**
     * This list  contains all the different amounts linked to account.
     * 
     */
    @JsonProperty("amounts")
    public void setAmounts(List<OptionAmt> amounts) {
        this.amounts = amounts;
    }

    @JsonProperty("fees")
    public List<Fee> getFees() {
        return fees;
    }

    @JsonProperty("fees")
    public void setFees(List<Fee> fees) {
        this.fees = fees;
    }

    @JsonProperty("acctStatementDelivery")
    public List<AcctStatementDelivery> getAcctStatementDelivery() {
        return acctStatementDelivery;
    }

    @JsonProperty("acctStatementDelivery")
    public void setAcctStatementDelivery(List<AcctStatementDelivery> acctStatementDelivery) {
        this.acctStatementDelivery = acctStatementDelivery;
    }

    /**
     * This contains all the account holders list.
     * 
     */
    @JsonProperty("holders")
    public List<Holder> getHolders() {
        return holders;
    }

    /**
     * This contains all the account holders list.
     * 
     */
    @JsonProperty("holders")
    public void setHolders(List<Holder> holders) {
        this.holders = holders;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("subApplicationId", subApplicationId).append("adjudicationRefList", adjudicationRefList).append("type", type).append("productId", productId).append("iban", iban).append("name", name).append("number", number).append("currency", currency).append("businessDetails", businessDetails).append("branch", branch).append("institutionNumber", institutionNumber).append("institutionName", institutionName).append("status", status).append("feature", feature).append("purpose", purpose).append("thirdPartyIndicator", thirdPartyIndicator).append("activateApplicationIndicator", activateApplicationIndicator).append("acceptIndicator", acceptIndicator).append("accessCard", accessCard).append("dates", dates).append("overdraftEligibleFlg", overdraftEligibleFlg).append("rate", rate).append("transactionIdList", transactionIdList).append("amounts", amounts).append("fees", fees).append("acctStatementDelivery", acctStatementDelivery).append("holders", holders).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fees).append(purpose).append(type).append(branch).append(transactionIdList).append(number).append(feature).append(overdraftEligibleFlg).append(amounts).append(rate).append(holders).append(adjudicationRefList).append(acctStatementDelivery).append(currency).append(productId).append(activateApplicationIndicator).append(acceptIndicator).append(subApplicationId).append(thirdPartyIndicator).append(dates).append(businessDetails).append(accessCard).append(institutionNumber).append(iban).append(institutionName).append(name).append(additionalProperties).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Account) == false) {
            return false;
        }
        Account rhs = ((Account) other);
        return new EqualsBuilder().append(fees, rhs.fees).append(purpose, rhs.purpose).append(type, rhs.type).append(branch, rhs.branch).append(transactionIdList, rhs.transactionIdList).append(number, rhs.number).append(feature, rhs.feature).append(overdraftEligibleFlg, rhs.overdraftEligibleFlg).append(amounts, rhs.amounts).append(rate, rhs.rate).append(holders, rhs.holders).append(adjudicationRefList, rhs.adjudicationRefList).append(acctStatementDelivery, rhs.acctStatementDelivery).append(currency, rhs.currency).append(productId, rhs.productId).append(activateApplicationIndicator, rhs.activateApplicationIndicator).append(acceptIndicator, rhs.acceptIndicator).append(subApplicationId, rhs.subApplicationId).append(thirdPartyIndicator, rhs.thirdPartyIndicator).append(dates, rhs.dates).append(businessDetails, rhs.businessDetails).append(accessCard, rhs.accessCard).append(institutionNumber, rhs.institutionNumber).append(iban, rhs.iban).append(institutionName, rhs.institutionName).append(name, rhs.name).append(additionalProperties, rhs.additionalProperties).append(status, rhs.status).isEquals();
    }

}
