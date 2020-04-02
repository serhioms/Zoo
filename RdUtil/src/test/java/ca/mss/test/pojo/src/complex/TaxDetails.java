
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
    "alerts",
    "canadaTaxJurisdictionInd",
    "compliant",
    "connectId",
    "crsInfo",
    "foreignTaxJurisdictionCd",
    "key",
    "socialSecurityNum",
    "socialSecurityNumberNotProvidedInd",
    "usCitizenInd",
    "userType",
    "actionCd"
})
public class TaxDetails implements Serializable, Cloneable
{

    @JsonProperty("additionalApplicant")
    private Boolean additionalApplicant;
    @JsonProperty("alerts")
    private Boolean alerts;
    @JsonProperty("canadaTaxJurisdictionInd")
    private Boolean canadaTaxJurisdictionInd;
    @JsonProperty("compliant")
    private Boolean compliant;
    @JsonProperty("connectId")
    private String connectId;
    @JsonProperty("crsInfo")
    private CrsInfo crsInfo;
    @JsonProperty("foreignTaxJurisdictionCd")
    private String foreignTaxJurisdictionCd;
    @JsonProperty("key")
    private String key;
    @JsonProperty("socialSecurityNum")
    private String socialSecurityNum;
    @JsonProperty("socialSecurityNumberNotProvidedInd")
    private Boolean socialSecurityNumberNotProvidedInd;
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
    private final static long serialVersionUID = -8163575684395972629L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TaxDetails() {
    }

    /**
     * 
     * @param usCitizenInd
     * @param foreignTaxJurisdictionCd
     * @param alerts
     * @param canadaTaxJurisdictionInd
     * @param socialSecurityNumberNotProvidedInd
     * @param compliant
     * @param crsInfo
     * @param userType
     * @param connectId
     * @param socialSecurityNum
     * @param additionalApplicant
     * @param key
     * @param actionCd
     */
    public TaxDetails(Boolean additionalApplicant, Boolean alerts, Boolean canadaTaxJurisdictionInd, Boolean compliant, String connectId, CrsInfo crsInfo, String foreignTaxJurisdictionCd, String key, String socialSecurityNum, Boolean socialSecurityNumberNotProvidedInd, Boolean usCitizenInd, String userType, String actionCd) {
        super();
        this.additionalApplicant = additionalApplicant;
        this.alerts = alerts;
        this.canadaTaxJurisdictionInd = canadaTaxJurisdictionInd;
        this.compliant = compliant;
        this.connectId = connectId;
        this.crsInfo = crsInfo;
        this.foreignTaxJurisdictionCd = foreignTaxJurisdictionCd;
        this.key = key;
        this.socialSecurityNum = socialSecurityNum;
        this.socialSecurityNumberNotProvidedInd = socialSecurityNumberNotProvidedInd;
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

    @JsonProperty("crsInfo")
    public CrsInfo getCrsInfo() {
        return crsInfo;
    }

    @JsonProperty("crsInfo")
    public void setCrsInfo(CrsInfo crsInfo) {
        this.crsInfo = crsInfo;
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

    @JsonProperty("socialSecurityNum")
    public String getSocialSecurityNum() {
        return socialSecurityNum;
    }

    @JsonProperty("socialSecurityNum")
    public void setSocialSecurityNum(String socialSecurityNum) {
        this.socialSecurityNum = socialSecurityNum;
    }

    @JsonProperty("socialSecurityNumberNotProvidedInd")
    public Boolean getSocialSecurityNumberNotProvidedInd() {
        return socialSecurityNumberNotProvidedInd;
    }

    @JsonProperty("socialSecurityNumberNotProvidedInd")
    public void setSocialSecurityNumberNotProvidedInd(Boolean socialSecurityNumberNotProvidedInd) {
        this.socialSecurityNumberNotProvidedInd = socialSecurityNumberNotProvidedInd;
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
        return new ToStringBuilder(this).append("additionalApplicant", additionalApplicant).append("alerts", alerts).append("canadaTaxJurisdictionInd", canadaTaxJurisdictionInd).append("compliant", compliant).append("connectId", connectId).append("crsInfo", crsInfo).append("foreignTaxJurisdictionCd", foreignTaxJurisdictionCd).append("key", key).append("socialSecurityNum", socialSecurityNum).append("socialSecurityNumberNotProvidedInd", socialSecurityNumberNotProvidedInd).append("usCitizenInd", usCitizenInd).append("userType", userType).append("actionCd", actionCd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(usCitizenInd).append(foreignTaxJurisdictionCd).append(alerts).append(canadaTaxJurisdictionInd).append(socialSecurityNumberNotProvidedInd).append(compliant).append(crsInfo).append(userType).append(additionalProperties).append(connectId).append(socialSecurityNum).append(additionalApplicant).append(key).append(actionCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TaxDetails) == false) {
            return false;
        }
        TaxDetails rhs = ((TaxDetails) other);
        return new EqualsBuilder().append(usCitizenInd, rhs.usCitizenInd).append(foreignTaxJurisdictionCd, rhs.foreignTaxJurisdictionCd).append(alerts, rhs.alerts).append(canadaTaxJurisdictionInd, rhs.canadaTaxJurisdictionInd).append(socialSecurityNumberNotProvidedInd, rhs.socialSecurityNumberNotProvidedInd).append(compliant, rhs.compliant).append(crsInfo, rhs.crsInfo).append(userType, rhs.userType).append(additionalProperties, rhs.additionalProperties).append(connectId, rhs.connectId).append(socialSecurityNum, rhs.socialSecurityNum).append(additionalApplicant, rhs.additionalApplicant).append(key, rhs.key).append(actionCd, rhs.actionCd).isEquals();
    }

}
