
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


/**
 * This contains the existing alerts details which are present on customer profile
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alertCheck",
    "idReascertainment",
    "partyID",
    "idCompliantFlag",
    "frozenFlag",
    "compliantFlag",
    "hasTDCTProducts",
    "existingAlertList",
    "complianceReasonCds"
})
public class AlertCheckResponse implements Serializable, Cloneable
{

    @JsonProperty("alertCheck")
    private Boolean alertCheck;
    /**
     * whether ID proofing is required when IDs' dates are too old
     * 
     */
    @JsonProperty("idReascertainment")
    @JsonPropertyDescription("whether ID proofing is required when IDs' dates are too old")
    private Boolean idReascertainment;
    @JsonProperty("partyID")
    private String partyID;
    @JsonProperty("idCompliantFlag")
    private Boolean idCompliantFlag;
    @JsonProperty("frozenFlag")
    private Boolean frozenFlag;
    @JsonProperty("compliantFlag")
    private Boolean compliantFlag;
    @JsonProperty("hasTDCTProducts")
    private Boolean hasTDCTProducts;
    /**
     * Existing AlertList present in TD CIF System.
     * 
     */
    @JsonProperty("existingAlertList")
    @JsonPropertyDescription("Existing AlertList present in TD CIF System.")
    private List<String> existingAlertList = null;
    /**
     * Existing compliance reason code present in TD compliance System.
     * 
     */
    @JsonProperty("complianceReasonCds")
    @JsonPropertyDescription("Existing compliance reason code present in TD compliance System.")
    private List<ComplianceReasonCd> complianceReasonCds = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1755602439343579243L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertCheckResponse() {
    }

    /**
     * 
     * @param complianceReasonCds
     * @param compliantFlag
     * @param idCompliantFlag
     * @param idReascertainment
     * @param hasTDCTProducts
     * @param existingAlertList
     * @param partyID
     * @param frozenFlag
     * @param alertCheck
     */
    public AlertCheckResponse(Boolean alertCheck, Boolean idReascertainment, String partyID, Boolean idCompliantFlag, Boolean frozenFlag, Boolean compliantFlag, Boolean hasTDCTProducts, List<String> existingAlertList, List<ComplianceReasonCd> complianceReasonCds) {
        super();
        this.alertCheck = alertCheck;
        this.idReascertainment = idReascertainment;
        this.partyID = partyID;
        this.idCompliantFlag = idCompliantFlag;
        this.frozenFlag = frozenFlag;
        this.compliantFlag = compliantFlag;
        this.hasTDCTProducts = hasTDCTProducts;
        this.existingAlertList = existingAlertList;
        this.complianceReasonCds = complianceReasonCds;
    }

    @JsonProperty("alertCheck")
    public Boolean getAlertCheck() {
        return alertCheck;
    }

    @JsonProperty("alertCheck")
    public void setAlertCheck(Boolean alertCheck) {
        this.alertCheck = alertCheck;
    }

    /**
     * whether ID proofing is required when IDs' dates are too old
     * 
     */
    @JsonProperty("idReascertainment")
    public Boolean getIdReascertainment() {
        return idReascertainment;
    }

    /**
     * whether ID proofing is required when IDs' dates are too old
     * 
     */
    @JsonProperty("idReascertainment")
    public void setIdReascertainment(Boolean idReascertainment) {
        this.idReascertainment = idReascertainment;
    }

    @JsonProperty("partyID")
    public String getPartyID() {
        return partyID;
    }

    @JsonProperty("partyID")
    public void setPartyID(String partyID) {
        this.partyID = partyID;
    }

    @JsonProperty("idCompliantFlag")
    public Boolean getIdCompliantFlag() {
        return idCompliantFlag;
    }

    @JsonProperty("idCompliantFlag")
    public void setIdCompliantFlag(Boolean idCompliantFlag) {
        this.idCompliantFlag = idCompliantFlag;
    }

    @JsonProperty("frozenFlag")
    public Boolean getFrozenFlag() {
        return frozenFlag;
    }

    @JsonProperty("frozenFlag")
    public void setFrozenFlag(Boolean frozenFlag) {
        this.frozenFlag = frozenFlag;
    }

    @JsonProperty("compliantFlag")
    public Boolean getCompliantFlag() {
        return compliantFlag;
    }

    @JsonProperty("compliantFlag")
    public void setCompliantFlag(Boolean compliantFlag) {
        this.compliantFlag = compliantFlag;
    }

    @JsonProperty("hasTDCTProducts")
    public Boolean getHasTDCTProducts() {
        return hasTDCTProducts;
    }

    @JsonProperty("hasTDCTProducts")
    public void setHasTDCTProducts(Boolean hasTDCTProducts) {
        this.hasTDCTProducts = hasTDCTProducts;
    }

    /**
     * Existing AlertList present in TD CIF System.
     * 
     */
    @JsonProperty("existingAlertList")
    public List<String> getExistingAlertList() {
        return existingAlertList;
    }

    /**
     * Existing AlertList present in TD CIF System.
     * 
     */
    @JsonProperty("existingAlertList")
    public void setExistingAlertList(List<String> existingAlertList) {
        this.existingAlertList = existingAlertList;
    }

    /**
     * Existing compliance reason code present in TD compliance System.
     * 
     */
    @JsonProperty("complianceReasonCds")
    public List<ComplianceReasonCd> getComplianceReasonCds() {
        return complianceReasonCds;
    }

    /**
     * Existing compliance reason code present in TD compliance System.
     * 
     */
    @JsonProperty("complianceReasonCds")
    public void setComplianceReasonCds(List<ComplianceReasonCd> complianceReasonCds) {
        this.complianceReasonCds = complianceReasonCds;
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
        return new ToStringBuilder(this).append("alertCheck", alertCheck).append("idReascertainment", idReascertainment).append("partyID", partyID).append("idCompliantFlag", idCompliantFlag).append("frozenFlag", frozenFlag).append("compliantFlag", compliantFlag).append("hasTDCTProducts", hasTDCTProducts).append("existingAlertList", existingAlertList).append("complianceReasonCds", complianceReasonCds).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(complianceReasonCds).append(compliantFlag).append(idCompliantFlag).append(idReascertainment).append(hasTDCTProducts).append(existingAlertList).append(additionalProperties).append(partyID).append(frozenFlag).append(alertCheck).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AlertCheckResponse) == false) {
            return false;
        }
        AlertCheckResponse rhs = ((AlertCheckResponse) other);
        return new EqualsBuilder().append(complianceReasonCds, rhs.complianceReasonCds).append(compliantFlag, rhs.compliantFlag).append(idCompliantFlag, rhs.idCompliantFlag).append(idReascertainment, rhs.idReascertainment).append(hasTDCTProducts, rhs.hasTDCTProducts).append(existingAlertList, rhs.existingAlertList).append(additionalProperties, rhs.additionalProperties).append(partyID, rhs.partyID).append(frozenFlag, rhs.frozenFlag).append(alertCheck, rhs.alertCheck).isEquals();
    }

}
