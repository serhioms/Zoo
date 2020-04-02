
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
    "investmentObjectiveVal",
    "safeInvestmentCriticalityVal",
    "yearsOfSavingTowardsInvestmentGoalVal",
    "yearsOfWithdrawalAfterInvestmentGoalVal",
    "investmentRiskToleranceLevelVal",
    "investmentComfortLevelVal"
})
public class InvestmentAgreementSurvey implements Serializable, Cloneable
{

    /**
     * Answer value for investment objective.
     * 
     */
    @JsonProperty("investmentObjectiveVal")
    @JsonPropertyDescription("Answer value for investment objective.")
    private String investmentObjectiveVal;
    /**
     * Answer value for minimal fluctuation importance.
     * 
     */
    @JsonProperty("safeInvestmentCriticalityVal")
    @JsonPropertyDescription("Answer value for minimal fluctuation importance.")
    private String safeInvestmentCriticalityVal;
    /**
     * Answer value for investment time horizon.
     * 
     */
    @JsonProperty("yearsOfSavingTowardsInvestmentGoalVal")
    @JsonPropertyDescription("Answer value for investment time horizon.")
    private String yearsOfSavingTowardsInvestmentGoalVal;
    /**
     * Answer value for withdrawal years.
     * 
     */
    @JsonProperty("yearsOfWithdrawalAfterInvestmentGoalVal")
    @JsonPropertyDescription("Answer value for withdrawal years.")
    private String yearsOfWithdrawalAfterInvestmentGoalVal;
    /**
     * Answer value for portfolio comfort.
     * 
     */
    @JsonProperty("investmentRiskToleranceLevelVal")
    @JsonPropertyDescription("Answer value for portfolio comfort.")
    private String investmentRiskToleranceLevelVal;
    /**
     * Answer value for portfolio risk comfort.
     * 
     */
    @JsonProperty("investmentComfortLevelVal")
    @JsonPropertyDescription("Answer value for portfolio risk comfort.")
    private String investmentComfortLevelVal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3878289689977334065L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public InvestmentAgreementSurvey() {
    }

    /**
     * 
     * @param yearsOfSavingTowardsInvestmentGoalVal
     * @param safeInvestmentCriticalityVal
     * @param investmentRiskToleranceLevelVal
     * @param investmentComfortLevelVal
     * @param investmentObjectiveVal
     * @param yearsOfWithdrawalAfterInvestmentGoalVal
     */
    public InvestmentAgreementSurvey(String investmentObjectiveVal, String safeInvestmentCriticalityVal, String yearsOfSavingTowardsInvestmentGoalVal, String yearsOfWithdrawalAfterInvestmentGoalVal, String investmentRiskToleranceLevelVal, String investmentComfortLevelVal) {
        super();
        this.investmentObjectiveVal = investmentObjectiveVal;
        this.safeInvestmentCriticalityVal = safeInvestmentCriticalityVal;
        this.yearsOfSavingTowardsInvestmentGoalVal = yearsOfSavingTowardsInvestmentGoalVal;
        this.yearsOfWithdrawalAfterInvestmentGoalVal = yearsOfWithdrawalAfterInvestmentGoalVal;
        this.investmentRiskToleranceLevelVal = investmentRiskToleranceLevelVal;
        this.investmentComfortLevelVal = investmentComfortLevelVal;
    }

    /**
     * Answer value for investment objective.
     * 
     */
    @JsonProperty("investmentObjectiveVal")
    public String getInvestmentObjectiveVal() {
        return investmentObjectiveVal;
    }

    /**
     * Answer value for investment objective.
     * 
     */
    @JsonProperty("investmentObjectiveVal")
    public void setInvestmentObjectiveVal(String investmentObjectiveVal) {
        this.investmentObjectiveVal = investmentObjectiveVal;
    }

    /**
     * Answer value for minimal fluctuation importance.
     * 
     */
    @JsonProperty("safeInvestmentCriticalityVal")
    public String getSafeInvestmentCriticalityVal() {
        return safeInvestmentCriticalityVal;
    }

    /**
     * Answer value for minimal fluctuation importance.
     * 
     */
    @JsonProperty("safeInvestmentCriticalityVal")
    public void setSafeInvestmentCriticalityVal(String safeInvestmentCriticalityVal) {
        this.safeInvestmentCriticalityVal = safeInvestmentCriticalityVal;
    }

    /**
     * Answer value for investment time horizon.
     * 
     */
    @JsonProperty("yearsOfSavingTowardsInvestmentGoalVal")
    public String getYearsOfSavingTowardsInvestmentGoalVal() {
        return yearsOfSavingTowardsInvestmentGoalVal;
    }

    /**
     * Answer value for investment time horizon.
     * 
     */
    @JsonProperty("yearsOfSavingTowardsInvestmentGoalVal")
    public void setYearsOfSavingTowardsInvestmentGoalVal(String yearsOfSavingTowardsInvestmentGoalVal) {
        this.yearsOfSavingTowardsInvestmentGoalVal = yearsOfSavingTowardsInvestmentGoalVal;
    }

    /**
     * Answer value for withdrawal years.
     * 
     */
    @JsonProperty("yearsOfWithdrawalAfterInvestmentGoalVal")
    public String getYearsOfWithdrawalAfterInvestmentGoalVal() {
        return yearsOfWithdrawalAfterInvestmentGoalVal;
    }

    /**
     * Answer value for withdrawal years.
     * 
     */
    @JsonProperty("yearsOfWithdrawalAfterInvestmentGoalVal")
    public void setYearsOfWithdrawalAfterInvestmentGoalVal(String yearsOfWithdrawalAfterInvestmentGoalVal) {
        this.yearsOfWithdrawalAfterInvestmentGoalVal = yearsOfWithdrawalAfterInvestmentGoalVal;
    }

    /**
     * Answer value for portfolio comfort.
     * 
     */
    @JsonProperty("investmentRiskToleranceLevelVal")
    public String getInvestmentRiskToleranceLevelVal() {
        return investmentRiskToleranceLevelVal;
    }

    /**
     * Answer value for portfolio comfort.
     * 
     */
    @JsonProperty("investmentRiskToleranceLevelVal")
    public void setInvestmentRiskToleranceLevelVal(String investmentRiskToleranceLevelVal) {
        this.investmentRiskToleranceLevelVal = investmentRiskToleranceLevelVal;
    }

    /**
     * Answer value for portfolio risk comfort.
     * 
     */
    @JsonProperty("investmentComfortLevelVal")
    public String getInvestmentComfortLevelVal() {
        return investmentComfortLevelVal;
    }

    /**
     * Answer value for portfolio risk comfort.
     * 
     */
    @JsonProperty("investmentComfortLevelVal")
    public void setInvestmentComfortLevelVal(String investmentComfortLevelVal) {
        this.investmentComfortLevelVal = investmentComfortLevelVal;
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
        return new ToStringBuilder(this).append("investmentObjectiveVal", investmentObjectiveVal).append("safeInvestmentCriticalityVal", safeInvestmentCriticalityVal).append("yearsOfSavingTowardsInvestmentGoalVal", yearsOfSavingTowardsInvestmentGoalVal).append("yearsOfWithdrawalAfterInvestmentGoalVal", yearsOfWithdrawalAfterInvestmentGoalVal).append("investmentRiskToleranceLevelVal", investmentRiskToleranceLevelVal).append("investmentComfortLevelVal", investmentComfortLevelVal).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(yearsOfSavingTowardsInvestmentGoalVal).append(safeInvestmentCriticalityVal).append(investmentRiskToleranceLevelVal).append(additionalProperties).append(investmentComfortLevelVal).append(investmentObjectiveVal).append(yearsOfWithdrawalAfterInvestmentGoalVal).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InvestmentAgreementSurvey) == false) {
            return false;
        }
        InvestmentAgreementSurvey rhs = ((InvestmentAgreementSurvey) other);
        return new EqualsBuilder().append(yearsOfSavingTowardsInvestmentGoalVal, rhs.yearsOfSavingTowardsInvestmentGoalVal).append(safeInvestmentCriticalityVal, rhs.safeInvestmentCriticalityVal).append(investmentRiskToleranceLevelVal, rhs.investmentRiskToleranceLevelVal).append(additionalProperties, rhs.additionalProperties).append(investmentComfortLevelVal, rhs.investmentComfortLevelVal).append(investmentObjectiveVal, rhs.investmentObjectiveVal).append(yearsOfWithdrawalAfterInvestmentGoalVal, rhs.yearsOfWithdrawalAfterInvestmentGoalVal).isEquals();
    }

}
