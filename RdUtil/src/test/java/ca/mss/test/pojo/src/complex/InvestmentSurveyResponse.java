
package ca.mss.test.pojo.src.complex;

import java.io.Serializable;
import java.util.HashMap;
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
    "investmentKnowledgeLevelVal",
    "totalInvestmentAssetAmountVal",
    "personalAnnualIncomeVal",
    "age",
    "investmentTypeOwnershipVal",
    "liquidAssetValueAmt",
    "fixedAssetValueAmt",
    "totalAssetValueAmt",
    "totalLiabilityBalanceAmt",
    "totalNetWorthAmt"
})
public class InvestmentSurveyResponse implements Serializable, Cloneable
{

    /**
     * Answer value for investment understanding.
     * 
     */
    @JsonProperty("investmentKnowledgeLevelVal")
    @JsonPropertyDescription("Answer value for investment understanding.")
    private String investmentKnowledgeLevelVal;
    /**
     * This represents the answere to the question 'What's the estimated value of all your investments, including those held at other institutions?' Answer is for value of all investment accounts. Must be answered by POA as well. Potential answer values are 'a', 'b', 'c', 'd', 'e' or 'f' --- a) Under $25,000 , b) $25,000 - $49,999 , c) $50,000 - $99,999, d) $100,000 - $499,999 , e) $500,000 - $999,999 , f) Over $1,000,000
     * 
     */
    @JsonProperty("totalInvestmentAssetAmountVal")
    @JsonPropertyDescription("This represents the answere to the question 'What's the estimated value of all your investments, including those held at other institutions?' Answer is for value of all investment accounts. Must be answered by POA as well. Potential answer values are 'a', 'b', 'c', 'd', 'e' or 'f' --- a) Under $25,000 , b) $25,000 - $49,999 , c) $50,000 - $99,999, d) $100,000 - $499,999 , e) $500,000 - $999,999 , f) Over $1,000,000")
    private String totalInvestmentAssetAmountVal;
    /**
     * This represents the answere to the question 'What's your yearly income?' . Answer is for personal annual income. Potential answer value is 'a', 'b', 'c', 'd' or 'e'  ---- a) Under $25,000 , b) $25,000 - $49,999 ,  c) $50,000 - $74,999 , d) $75,000 - $125,000 , e) Over $125,000 
     * 
     */
    @JsonProperty("personalAnnualIncomeVal")
    @JsonPropertyDescription("This represents the answere to the question 'What's your yearly income?' . Answer is for personal annual income.\u00a0Potential answer value is 'a', 'b', 'c', 'd' or 'e'  ---- a) Under $25,000 , b) $25,000 - $49,999 ,  c) $50,000 - $74,999 , d) $75,000 - $125,000 , e) Over $125,000 ")
    private String personalAnnualIncomeVal;
    /**
     * Answer value for Age.
     * 
     */
    @JsonProperty("age")
    @JsonPropertyDescription("Answer value for Age.")
    private Integer age;
    /**
     * Answer value for current investment description. It is optional only if POA indicator set.
     * 
     */
    @JsonProperty("investmentTypeOwnershipVal")
    @JsonPropertyDescription("Answer value for current investment description. It is optional only if POA indicator set.")
    private String investmentTypeOwnershipVal;
    @JsonProperty("liquidAssetValueAmt")
    private OptionAmt liquidAssetValueAmt;
    @JsonProperty("fixedAssetValueAmt")
    private OptionAmt fixedAssetValueAmt;
    @JsonProperty("totalAssetValueAmt")
    private OptionAmt totalAssetValueAmt;
    @JsonProperty("totalLiabilityBalanceAmt")
    private OptionAmt totalLiabilityBalanceAmt;
    @JsonProperty("totalNetWorthAmt")
    private OptionAmt totalNetWorthAmt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7164484613814370882L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public InvestmentSurveyResponse() {
    }

    /**
     * 
     * @param totalNetWorthAmt
     * @param fixedAssetValueAmt
     * @param totalInvestmentAssetAmountVal
     * @param investmentTypeOwnershipVal
     * @param totalAssetValueAmt
     * @param totalLiabilityBalanceAmt
     * @param investmentKnowledgeLevelVal
     * @param personalAnnualIncomeVal
     * @param age
     * @param liquidAssetValueAmt
     */
    public InvestmentSurveyResponse(String investmentKnowledgeLevelVal, String totalInvestmentAssetAmountVal, String personalAnnualIncomeVal, Integer age, String investmentTypeOwnershipVal, OptionAmt liquidAssetValueAmt, OptionAmt fixedAssetValueAmt, OptionAmt totalAssetValueAmt, OptionAmt totalLiabilityBalanceAmt, OptionAmt totalNetWorthAmt) {
        super();
        this.investmentKnowledgeLevelVal = investmentKnowledgeLevelVal;
        this.totalInvestmentAssetAmountVal = totalInvestmentAssetAmountVal;
        this.personalAnnualIncomeVal = personalAnnualIncomeVal;
        this.age = age;
        this.investmentTypeOwnershipVal = investmentTypeOwnershipVal;
        this.liquidAssetValueAmt = liquidAssetValueAmt;
        this.fixedAssetValueAmt = fixedAssetValueAmt;
        this.totalAssetValueAmt = totalAssetValueAmt;
        this.totalLiabilityBalanceAmt = totalLiabilityBalanceAmt;
        this.totalNetWorthAmt = totalNetWorthAmt;
    }

    /**
     * Answer value for investment understanding.
     * 
     */
    @JsonProperty("investmentKnowledgeLevelVal")
    public String getInvestmentKnowledgeLevelVal() {
        return investmentKnowledgeLevelVal;
    }

    /**
     * Answer value for investment understanding.
     * 
     */
    @JsonProperty("investmentKnowledgeLevelVal")
    public void setInvestmentKnowledgeLevelVal(String investmentKnowledgeLevelVal) {
        this.investmentKnowledgeLevelVal = investmentKnowledgeLevelVal;
    }

    /**
     * This represents the answere to the question 'What's the estimated value of all your investments, including those held at other institutions?' Answer is for value of all investment accounts. Must be answered by POA as well. Potential answer values are 'a', 'b', 'c', 'd', 'e' or 'f' --- a) Under $25,000 , b) $25,000 - $49,999 , c) $50,000 - $99,999, d) $100,000 - $499,999 , e) $500,000 - $999,999 , f) Over $1,000,000
     * 
     */
    @JsonProperty("totalInvestmentAssetAmountVal")
    public String getTotalInvestmentAssetAmountVal() {
        return totalInvestmentAssetAmountVal;
    }

    /**
     * This represents the answere to the question 'What's the estimated value of all your investments, including those held at other institutions?' Answer is for value of all investment accounts. Must be answered by POA as well. Potential answer values are 'a', 'b', 'c', 'd', 'e' or 'f' --- a) Under $25,000 , b) $25,000 - $49,999 , c) $50,000 - $99,999, d) $100,000 - $499,999 , e) $500,000 - $999,999 , f) Over $1,000,000
     * 
     */
    @JsonProperty("totalInvestmentAssetAmountVal")
    public void setTotalInvestmentAssetAmountVal(String totalInvestmentAssetAmountVal) {
        this.totalInvestmentAssetAmountVal = totalInvestmentAssetAmountVal;
    }

    /**
     * This represents the answere to the question 'What's your yearly income?' . Answer is for personal annual income. Potential answer value is 'a', 'b', 'c', 'd' or 'e'  ---- a) Under $25,000 , b) $25,000 - $49,999 ,  c) $50,000 - $74,999 , d) $75,000 - $125,000 , e) Over $125,000 
     * 
     */
    @JsonProperty("personalAnnualIncomeVal")
    public String getPersonalAnnualIncomeVal() {
        return personalAnnualIncomeVal;
    }

    /**
     * This represents the answere to the question 'What's your yearly income?' . Answer is for personal annual income. Potential answer value is 'a', 'b', 'c', 'd' or 'e'  ---- a) Under $25,000 , b) $25,000 - $49,999 ,  c) $50,000 - $74,999 , d) $75,000 - $125,000 , e) Over $125,000 
     * 
     */
    @JsonProperty("personalAnnualIncomeVal")
    public void setPersonalAnnualIncomeVal(String personalAnnualIncomeVal) {
        this.personalAnnualIncomeVal = personalAnnualIncomeVal;
    }

    /**
     * Answer value for Age.
     * 
     */
    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    /**
     * Answer value for Age.
     * 
     */
    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Answer value for current investment description. It is optional only if POA indicator set.
     * 
     */
    @JsonProperty("investmentTypeOwnershipVal")
    public String getInvestmentTypeOwnershipVal() {
        return investmentTypeOwnershipVal;
    }

    /**
     * Answer value for current investment description. It is optional only if POA indicator set.
     * 
     */
    @JsonProperty("investmentTypeOwnershipVal")
    public void setInvestmentTypeOwnershipVal(String investmentTypeOwnershipVal) {
        this.investmentTypeOwnershipVal = investmentTypeOwnershipVal;
    }

    @JsonProperty("liquidAssetValueAmt")
    public OptionAmt getLiquidAssetValueAmt() {
        return liquidAssetValueAmt;
    }

    @JsonProperty("liquidAssetValueAmt")
    public void setLiquidAssetValueAmt(OptionAmt liquidAssetValueAmt) {
        this.liquidAssetValueAmt = liquidAssetValueAmt;
    }

    @JsonProperty("fixedAssetValueAmt")
    public OptionAmt getFixedAssetValueAmt() {
        return fixedAssetValueAmt;
    }

    @JsonProperty("fixedAssetValueAmt")
    public void setFixedAssetValueAmt(OptionAmt fixedAssetValueAmt) {
        this.fixedAssetValueAmt = fixedAssetValueAmt;
    }

    @JsonProperty("totalAssetValueAmt")
    public OptionAmt getTotalAssetValueAmt() {
        return totalAssetValueAmt;
    }

    @JsonProperty("totalAssetValueAmt")
    public void setTotalAssetValueAmt(OptionAmt totalAssetValueAmt) {
        this.totalAssetValueAmt = totalAssetValueAmt;
    }

    @JsonProperty("totalLiabilityBalanceAmt")
    public OptionAmt getTotalLiabilityBalanceAmt() {
        return totalLiabilityBalanceAmt;
    }

    @JsonProperty("totalLiabilityBalanceAmt")
    public void setTotalLiabilityBalanceAmt(OptionAmt totalLiabilityBalanceAmt) {
        this.totalLiabilityBalanceAmt = totalLiabilityBalanceAmt;
    }

    @JsonProperty("totalNetWorthAmt")
    public OptionAmt getTotalNetWorthAmt() {
        return totalNetWorthAmt;
    }

    @JsonProperty("totalNetWorthAmt")
    public void setTotalNetWorthAmt(OptionAmt totalNetWorthAmt) {
        this.totalNetWorthAmt = totalNetWorthAmt;
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
        return new ToStringBuilder(this).append("investmentKnowledgeLevelVal", investmentKnowledgeLevelVal).append("totalInvestmentAssetAmountVal", totalInvestmentAssetAmountVal).append("personalAnnualIncomeVal", personalAnnualIncomeVal).append("age", age).append("investmentTypeOwnershipVal", investmentTypeOwnershipVal).append("liquidAssetValueAmt", liquidAssetValueAmt).append("fixedAssetValueAmt", fixedAssetValueAmt).append("totalAssetValueAmt", totalAssetValueAmt).append("totalLiabilityBalanceAmt", totalLiabilityBalanceAmt).append("totalNetWorthAmt", totalNetWorthAmt).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(totalNetWorthAmt).append(fixedAssetValueAmt).append(totalInvestmentAssetAmountVal).append(investmentTypeOwnershipVal).append(totalAssetValueAmt).append(totalLiabilityBalanceAmt).append(additionalProperties).append(investmentKnowledgeLevelVal).append(personalAnnualIncomeVal).append(age).append(liquidAssetValueAmt).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InvestmentSurveyResponse) == false) {
            return false;
        }
        InvestmentSurveyResponse rhs = ((InvestmentSurveyResponse) other);
        return new EqualsBuilder().append(totalNetWorthAmt, rhs.totalNetWorthAmt).append(fixedAssetValueAmt, rhs.fixedAssetValueAmt).append(totalInvestmentAssetAmountVal, rhs.totalInvestmentAssetAmountVal).append(investmentTypeOwnershipVal, rhs.investmentTypeOwnershipVal).append(totalAssetValueAmt, rhs.totalAssetValueAmt).append(totalLiabilityBalanceAmt, rhs.totalLiabilityBalanceAmt).append(additionalProperties, rhs.additionalProperties).append(investmentKnowledgeLevelVal, rhs.investmentKnowledgeLevelVal).append(personalAnnualIncomeVal, rhs.personalAnnualIncomeVal).append(age, rhs.age).append(liquidAssetValueAmt, rhs.liquidAssetValueAmt).isEquals();
    }

}
