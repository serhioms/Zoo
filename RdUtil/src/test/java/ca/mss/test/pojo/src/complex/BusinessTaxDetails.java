
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
    "additionalApplicant",
    "canadianBN",
    "entityCountry",
    "personCountry",
    "alerts",
    "canadaTaxJurisdictionInd",
    "compliant",
    "connectId",
    "BusinessCrsInfo",
    "foreignTaxJurisdictionCd",
    "key",
    "taxIdNum",
    "taxIdNumNotProvidedInd",
    "usCitizenInd",
    "userType",
    "actionCd"
})
public class BusinessTaxDetails implements Serializable, Cloneable
{

    @JsonProperty("additionalApplicant")
    private Boolean additionalApplicant;
    /**
     * Canadian Business Number; also known as CRA Number
     * 
     */
    @JsonProperty("canadianBN")
    @JsonPropertyDescription("Canadian Business Number; also known as CRA Number")
    private String canadianBN;
    /**
     * Business Country - Business Banking will pass three characters country code
     * 
     */
    @JsonProperty("entityCountry")
    @JsonPropertyDescription("Business Country - Business Banking will pass three characters country code")
    private String entityCountry;
    /**
     * Person's Country - Business Banking will pass three characters country code
     * 
     */
    @JsonProperty("personCountry")
    @JsonPropertyDescription("Person's Country - Business Banking will pass three characters country code")
    private String personCountry;
    @JsonProperty("alerts")
    private Boolean alerts;
    @JsonProperty("canadaTaxJurisdictionInd")
    private Boolean canadaTaxJurisdictionInd;
    @JsonProperty("compliant")
    private Boolean compliant;
    @JsonProperty("connectId")
    private String connectId;
    @JsonProperty("BusinessCrsInfo")
    private BusinessCrsInfo businessCrsInfo;
    @JsonProperty("foreignTaxJurisdictionCd")
    private String foreignTaxJurisdictionCd;
    @JsonProperty("key")
    private String key;
    @JsonProperty("taxIdNum")
    private String taxIdNum;
    @JsonProperty("taxIdNumNotProvidedInd")
    private Boolean taxIdNumNotProvidedInd;
    @JsonProperty("usCitizenInd")
    private Boolean usCitizenInd;
    @JsonProperty("userType")
    private String userType;
    /**
     * Action Details :: 0 -Do nothing :: 1 -Create :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.
     * 
     */
    @JsonProperty("actionCd")
    @JsonPropertyDescription("Action Details :: 0 -Do nothing :: 1 -Create :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.")
    private String actionCd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1196651018897808781L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BusinessTaxDetails() {
    }

    /**
     * 
     * @param canadianBN
     * @param taxIdNumNotProvidedInd
     * @param usCitizenInd
     * @param businessCrsInfo
     * @param foreignTaxJurisdictionCd
     * @param alerts
     * @param canadaTaxJurisdictionInd
     * @param entityCountry
     * @param compliant
     * @param personCountry
     * @param userType
     * @param connectId
     * @param taxIdNum
     * @param additionalApplicant
     * @param key
     * @param actionCd
     */
    public BusinessTaxDetails(Boolean additionalApplicant, String canadianBN, String entityCountry, String personCountry, Boolean alerts, Boolean canadaTaxJurisdictionInd, Boolean compliant, String connectId, BusinessCrsInfo businessCrsInfo, String foreignTaxJurisdictionCd, String key, String taxIdNum, Boolean taxIdNumNotProvidedInd, Boolean usCitizenInd, String userType, String actionCd) {
        super();
        this.additionalApplicant = additionalApplicant;
        this.canadianBN = canadianBN;
        this.entityCountry = entityCountry;
        this.personCountry = personCountry;
        this.alerts = alerts;
        this.canadaTaxJurisdictionInd = canadaTaxJurisdictionInd;
        this.compliant = compliant;
        this.connectId = connectId;
        this.businessCrsInfo = businessCrsInfo;
        this.foreignTaxJurisdictionCd = foreignTaxJurisdictionCd;
        this.key = key;
        this.taxIdNum = taxIdNum;
        this.taxIdNumNotProvidedInd = taxIdNumNotProvidedInd;
        this.usCitizenInd = usCitizenInd;
        this.userType = userType;
        this.actionCd = actionCd;
    }

    @JsonProperty("additionalApplicant")
    public Boolean getAdditionalApplicant() {
        return additionalApplicant;
    }

    @JsonProperty("additionalApplicant")
    public void setAdditionalApplicant(Boolean additionalApplicant) {
        this.additionalApplicant = additionalApplicant;
    }

    /**
     * Canadian Business Number; also known as CRA Number
     * 
     */
    @JsonProperty("canadianBN")
    public String getCanadianBN() {
        return canadianBN;
    }

    /**
     * Canadian Business Number; also known as CRA Number
     * 
     */
    @JsonProperty("canadianBN")
    public void setCanadianBN(String canadianBN) {
        this.canadianBN = canadianBN;
    }

    /**
     * Business Country - Business Banking will pass three characters country code
     * 
     */
    @JsonProperty("entityCountry")
    public String getEntityCountry() {
        return entityCountry;
    }

    /**
     * Business Country - Business Banking will pass three characters country code
     * 
     */
    @JsonProperty("entityCountry")
    public void setEntityCountry(String entityCountry) {
        this.entityCountry = entityCountry;
    }

    /**
     * Person's Country - Business Banking will pass three characters country code
     * 
     */
    @JsonProperty("personCountry")
    public String getPersonCountry() {
        return personCountry;
    }

    /**
     * Person's Country - Business Banking will pass three characters country code
     * 
     */
    @JsonProperty("personCountry")
    public void setPersonCountry(String personCountry) {
        this.personCountry = personCountry;
    }

    @JsonProperty("alerts")
    public Boolean getAlerts() {
        return alerts;
    }

    @JsonProperty("alerts")
    public void setAlerts(Boolean alerts) {
        this.alerts = alerts;
    }

    @JsonProperty("canadaTaxJurisdictionInd")
    public Boolean getCanadaTaxJurisdictionInd() {
        return canadaTaxJurisdictionInd;
    }

    @JsonProperty("canadaTaxJurisdictionInd")
    public void setCanadaTaxJurisdictionInd(Boolean canadaTaxJurisdictionInd) {
        this.canadaTaxJurisdictionInd = canadaTaxJurisdictionInd;
    }

    @JsonProperty("compliant")
    public Boolean getCompliant() {
        return compliant;
    }

    @JsonProperty("compliant")
    public void setCompliant(Boolean compliant) {
        this.compliant = compliant;
    }

    @JsonProperty("connectId")
    public String getConnectId() {
        return connectId;
    }

    @JsonProperty("connectId")
    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    @JsonProperty("BusinessCrsInfo")
    public BusinessCrsInfo getBusinessCrsInfo() {
        return businessCrsInfo;
    }

    @JsonProperty("BusinessCrsInfo")
    public void setBusinessCrsInfo(BusinessCrsInfo businessCrsInfo) {
        this.businessCrsInfo = businessCrsInfo;
    }

    @JsonProperty("foreignTaxJurisdictionCd")
    public String getForeignTaxJurisdictionCd() {
        return foreignTaxJurisdictionCd;
    }

    @JsonProperty("foreignTaxJurisdictionCd")
    public void setForeignTaxJurisdictionCd(String foreignTaxJurisdictionCd) {
        this.foreignTaxJurisdictionCd = foreignTaxJurisdictionCd;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("taxIdNum")
    public String getTaxIdNum() {
        return taxIdNum;
    }

    @JsonProperty("taxIdNum")
    public void setTaxIdNum(String taxIdNum) {
        this.taxIdNum = taxIdNum;
    }

    @JsonProperty("taxIdNumNotProvidedInd")
    public Boolean getTaxIdNumNotProvidedInd() {
        return taxIdNumNotProvidedInd;
    }

    @JsonProperty("taxIdNumNotProvidedInd")
    public void setTaxIdNumNotProvidedInd(Boolean taxIdNumNotProvidedInd) {
        this.taxIdNumNotProvidedInd = taxIdNumNotProvidedInd;
    }

    @JsonProperty("usCitizenInd")
    public Boolean getUsCitizenInd() {
        return usCitizenInd;
    }

    @JsonProperty("usCitizenInd")
    public void setUsCitizenInd(Boolean usCitizenInd) {
        this.usCitizenInd = usCitizenInd;
    }

    @JsonProperty("userType")
    public String getUserType() {
        return userType;
    }

    @JsonProperty("userType")
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Action Details :: 0 -Do nothing :: 1 -Create :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.
     * 
     */
    @JsonProperty("actionCd")
    public String getActionCd() {
        return actionCd;
    }

    /**
     * Action Details :: 0 -Do nothing :: 1 -Create :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.
     * 
     */
    @JsonProperty("actionCd")
    public void setActionCd(String actionCd) {
        this.actionCd = actionCd;
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
        return new ToStringBuilder(this).append("additionalApplicant", additionalApplicant).append("canadianBN", canadianBN).append("entityCountry", entityCountry).append("personCountry", personCountry).append("alerts", alerts).append("canadaTaxJurisdictionInd", canadaTaxJurisdictionInd).append("compliant", compliant).append("connectId", connectId).append("businessCrsInfo", businessCrsInfo).append("foreignTaxJurisdictionCd", foreignTaxJurisdictionCd).append("key", key).append("taxIdNum", taxIdNum).append("taxIdNumNotProvidedInd", taxIdNumNotProvidedInd).append("usCitizenInd", usCitizenInd).append("userType", userType).append("actionCd", actionCd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(canadianBN).append(taxIdNumNotProvidedInd).append(usCitizenInd).append(businessCrsInfo).append(foreignTaxJurisdictionCd).append(alerts).append(canadaTaxJurisdictionInd).append(entityCountry).append(compliant).append(personCountry).append(userType).append(additionalProperties).append(connectId).append(taxIdNum).append(additionalApplicant).append(key).append(actionCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BusinessTaxDetails) == false) {
            return false;
        }
        BusinessTaxDetails rhs = ((BusinessTaxDetails) other);
        return new EqualsBuilder().append(canadianBN, rhs.canadianBN).append(taxIdNumNotProvidedInd, rhs.taxIdNumNotProvidedInd).append(usCitizenInd, rhs.usCitizenInd).append(businessCrsInfo, rhs.businessCrsInfo).append(foreignTaxJurisdictionCd, rhs.foreignTaxJurisdictionCd).append(alerts, rhs.alerts).append(canadaTaxJurisdictionInd, rhs.canadaTaxJurisdictionInd).append(entityCountry, rhs.entityCountry).append(compliant, rhs.compliant).append(personCountry, rhs.personCountry).append(userType, rhs.userType).append(additionalProperties, rhs.additionalProperties).append(connectId, rhs.connectId).append(taxIdNum, rhs.taxIdNum).append(additionalApplicant, rhs.additionalApplicant).append(key, rhs.key).append(actionCd, rhs.actionCd).isEquals();
    }

}
