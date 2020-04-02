
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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Customer FinancialInfo.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "grossAnnualPersonalIncome",
    "heatingCost",
    "monthlyMortgage",
    "otherIncome",
    "propertyTax",
    "residentialStatus",
    "incomeType",
    "condoFees",
    "monthlyRent",
    "totalLiquidAssets",
    "residenceValue",
    "otherFixedAsset",
    "totalLiabilities",
    "totalAssetValue",
    "estimatedNetWorth",
    "currency",
    "bankingInfo"
})
public class FinancialInfo implements Serializable, Cloneable
{

    @JsonProperty("grossAnnualPersonalIncome")
    private Double grossAnnualPersonalIncome;
    @JsonProperty("heatingCost")
    private Double heatingCost;
    @JsonProperty("monthlyMortgage")
    private Double monthlyMortgage;
    @JsonProperty("otherIncome")
    private Double otherIncome;
    @JsonProperty("propertyTax")
    private Double propertyTax;
    @JsonProperty("residentialStatus")
    private String residentialStatus;
    @JsonProperty("incomeType")
    private String incomeType;
    @JsonProperty("condoFees")
    private Double condoFees;
    @JsonProperty("monthlyRent")
    private Double monthlyRent;
    @JsonProperty("totalLiquidAssets")
    private Double totalLiquidAssets;
    @JsonProperty("residenceValue")
    private Double residenceValue;
    @JsonProperty("otherFixedAsset")
    private Double otherFixedAsset;
    @JsonProperty("totalLiabilities")
    private Double totalLiabilities;
    @JsonProperty("totalAssetValue")
    private Double totalAssetValue;
    @JsonProperty("estimatedNetWorth")
    private Double estimatedNetWorth;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("bankingInfo")
    private List<Account> bankingInfo = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7979960107904191940L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FinancialInfo() {
    }

    /**
     * 
     * @param monthlyMortgage
     * @param bankingInfo
     * @param incomeType
     * @param residenceValue
     * @param totalLiabilities
     * @param monthlyRent
     * @param otherFixedAsset
     * @param otherIncome
     * @param estimatedNetWorth
     * @param condoFees
     * @param totalLiquidAssets
     * @param grossAnnualPersonalIncome
     * @param residentialStatus
     * @param heatingCost
     * @param totalAssetValue
     * @param currency
     * @param propertyTax
     */
    public FinancialInfo(Double grossAnnualPersonalIncome, Double heatingCost, Double monthlyMortgage, Double otherIncome, Double propertyTax, String residentialStatus, String incomeType, Double condoFees, Double monthlyRent, Double totalLiquidAssets, Double residenceValue, Double otherFixedAsset, Double totalLiabilities, Double totalAssetValue, Double estimatedNetWorth, String currency, List<Account> bankingInfo) {
        super();
        this.grossAnnualPersonalIncome = grossAnnualPersonalIncome;
        this.heatingCost = heatingCost;
        this.monthlyMortgage = monthlyMortgage;
        this.otherIncome = otherIncome;
        this.propertyTax = propertyTax;
        this.residentialStatus = residentialStatus;
        this.incomeType = incomeType;
        this.condoFees = condoFees;
        this.monthlyRent = monthlyRent;
        this.totalLiquidAssets = totalLiquidAssets;
        this.residenceValue = residenceValue;
        this.otherFixedAsset = otherFixedAsset;
        this.totalLiabilities = totalLiabilities;
        this.totalAssetValue = totalAssetValue;
        this.estimatedNetWorth = estimatedNetWorth;
        this.currency = currency;
        this.bankingInfo = bankingInfo;
    }

    @JsonProperty("grossAnnualPersonalIncome")
    public Double getGrossAnnualPersonalIncome() {
        return grossAnnualPersonalIncome;
    }

    @JsonProperty("grossAnnualPersonalIncome")
    public void setGrossAnnualPersonalIncome(Double grossAnnualPersonalIncome) {
        this.grossAnnualPersonalIncome = grossAnnualPersonalIncome;
    }

    @JsonProperty("heatingCost")
    public Double getHeatingCost() {
        return heatingCost;
    }

    @JsonProperty("heatingCost")
    public void setHeatingCost(Double heatingCost) {
        this.heatingCost = heatingCost;
    }

    @JsonProperty("monthlyMortgage")
    public Double getMonthlyMortgage() {
        return monthlyMortgage;
    }

    @JsonProperty("monthlyMortgage")
    public void setMonthlyMortgage(Double monthlyMortgage) {
        this.monthlyMortgage = monthlyMortgage;
    }

    @JsonProperty("otherIncome")
    public Double getOtherIncome() {
        return otherIncome;
    }

    @JsonProperty("otherIncome")
    public void setOtherIncome(Double otherIncome) {
        this.otherIncome = otherIncome;
    }

    @JsonProperty("propertyTax")
    public Double getPropertyTax() {
        return propertyTax;
    }

    @JsonProperty("propertyTax")
    public void setPropertyTax(Double propertyTax) {
        this.propertyTax = propertyTax;
    }

    @JsonProperty("residentialStatus")
    public String getResidentialStatus() {
        return residentialStatus;
    }

    @JsonProperty("residentialStatus")
    public void setResidentialStatus(String residentialStatus) {
        this.residentialStatus = residentialStatus;
    }

    @JsonProperty("incomeType")
    public String getIncomeType() {
        return incomeType;
    }

    @JsonProperty("incomeType")
    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    @JsonProperty("condoFees")
    public Double getCondoFees() {
        return condoFees;
    }

    @JsonProperty("condoFees")
    public void setCondoFees(Double condoFees) {
        this.condoFees = condoFees;
    }

    @JsonProperty("monthlyRent")
    public Double getMonthlyRent() {
        return monthlyRent;
    }

    @JsonProperty("monthlyRent")
    public void setMonthlyRent(Double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    @JsonProperty("totalLiquidAssets")
    public Double getTotalLiquidAssets() {
        return totalLiquidAssets;
    }

    @JsonProperty("totalLiquidAssets")
    public void setTotalLiquidAssets(Double totalLiquidAssets) {
        this.totalLiquidAssets = totalLiquidAssets;
    }

    @JsonProperty("residenceValue")
    public Double getResidenceValue() {
        return residenceValue;
    }

    @JsonProperty("residenceValue")
    public void setResidenceValue(Double residenceValue) {
        this.residenceValue = residenceValue;
    }

    @JsonProperty("otherFixedAsset")
    public Double getOtherFixedAsset() {
        return otherFixedAsset;
    }

    @JsonProperty("otherFixedAsset")
    public void setOtherFixedAsset(Double otherFixedAsset) {
        this.otherFixedAsset = otherFixedAsset;
    }

    @JsonProperty("totalLiabilities")
    public Double getTotalLiabilities() {
        return totalLiabilities;
    }

    @JsonProperty("totalLiabilities")
    public void setTotalLiabilities(Double totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    @JsonProperty("totalAssetValue")
    public Double getTotalAssetValue() {
        return totalAssetValue;
    }

    @JsonProperty("totalAssetValue")
    public void setTotalAssetValue(Double totalAssetValue) {
        this.totalAssetValue = totalAssetValue;
    }

    @JsonProperty("estimatedNetWorth")
    public Double getEstimatedNetWorth() {
        return estimatedNetWorth;
    }

    @JsonProperty("estimatedNetWorth")
    public void setEstimatedNetWorth(Double estimatedNetWorth) {
        this.estimatedNetWorth = estimatedNetWorth;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("bankingInfo")
    public List<Account> getBankingInfo() {
        return bankingInfo;
    }

    @JsonProperty("bankingInfo")
    public void setBankingInfo(List<Account> bankingInfo) {
        this.bankingInfo = bankingInfo;
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
        return new ToStringBuilder(this).append("grossAnnualPersonalIncome", grossAnnualPersonalIncome).append("heatingCost", heatingCost).append("monthlyMortgage", monthlyMortgage).append("otherIncome", otherIncome).append("propertyTax", propertyTax).append("residentialStatus", residentialStatus).append("incomeType", incomeType).append("condoFees", condoFees).append("monthlyRent", monthlyRent).append("totalLiquidAssets", totalLiquidAssets).append("residenceValue", residenceValue).append("otherFixedAsset", otherFixedAsset).append("totalLiabilities", totalLiabilities).append("totalAssetValue", totalAssetValue).append("estimatedNetWorth", estimatedNetWorth).append("currency", currency).append("bankingInfo", bankingInfo).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(monthlyMortgage).append(bankingInfo).append(incomeType).append(residenceValue).append(totalLiabilities).append(monthlyRent).append(otherFixedAsset).append(otherIncome).append(estimatedNetWorth).append(condoFees).append(totalLiquidAssets).append(grossAnnualPersonalIncome).append(residentialStatus).append(heatingCost).append(totalAssetValue).append(currency).append(additionalProperties).append(propertyTax).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FinancialInfo) == false) {
            return false;
        }
        FinancialInfo rhs = ((FinancialInfo) other);
        return new EqualsBuilder().append(monthlyMortgage, rhs.monthlyMortgage).append(bankingInfo, rhs.bankingInfo).append(incomeType, rhs.incomeType).append(residenceValue, rhs.residenceValue).append(totalLiabilities, rhs.totalLiabilities).append(monthlyRent, rhs.monthlyRent).append(otherFixedAsset, rhs.otherFixedAsset).append(otherIncome, rhs.otherIncome).append(estimatedNetWorth, rhs.estimatedNetWorth).append(condoFees, rhs.condoFees).append(totalLiquidAssets, rhs.totalLiquidAssets).append(grossAnnualPersonalIncome, rhs.grossAnnualPersonalIncome).append(residentialStatus, rhs.residentialStatus).append(heatingCost, rhs.heatingCost).append(totalAssetValue, rhs.totalAssetValue).append(currency, rhs.currency).append(additionalProperties, rhs.additionalProperties).append(propertyTax, rhs.propertyTax).isEquals();
    }

}
