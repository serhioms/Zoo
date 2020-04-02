
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


/**
 * Phone/contact Number information is stored in this object.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "number",
    "areaCode",
    "type",
    "countryCd",
    "isPrimary",
    "extension",
    "isSecondary",
    "corelationId",
    "actionInd"
})
public class Phone implements Serializable
{

    @JsonProperty("number")
    private String number;
    @JsonProperty("areaCode")
    private String areaCode;
    /**
     * Valid enumeration for all LOB's is;
     * P: Landline
     * C: Mobile
     * F: Fax
     * W: Employment
     * Other enumerations have been sunset & should be phased out in future LOB releases
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Valid enumeration for all LOB's is;\r\nP: Landline\r\nC: Mobile\r\nF: Fax\r\nW: Employment\r\nOther enumerations have been sunset & should be phased out in future LOB releases")
    private String type;
    /**
     * This is used in case landline number from anyother country is given by customer.
     * 
     */
    @JsonProperty("countryCd")
    @JsonPropertyDescription("This is used in case landline number from anyother country is given by customer.")
    private String countryCd;
    @JsonProperty("isPrimary")
    private Boolean isPrimary;
    @JsonProperty("extension")
    private String extension;
    @JsonProperty("isSecondary")
    private Boolean isSecondary;
    @JsonProperty("corelationId")
    private String corelationId;
    /**
     * Action Details :: 0 -Do nothing :: 1 -Create = Ignore Corelationid and Generate Corelationid :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.For Employment, we need to ignore corelationId from Employment Address always.
     * 
     */
    @JsonProperty("actionInd")
    @JsonPropertyDescription("Action Details :: 0 -Do nothing :: 1 -Create = Ignore Corelationid and Generate Corelationid :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.For Employment, we need to ignore corelationId from Employment Address always.")
    private String actionInd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6480292861823308433L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Phone() {
    }

    /**
     * 
     * @param number
     * @param areaCode
     * @param extension
     * @param isPrimary
     * @param countryCd
     * @param actionInd
     * @param corelationId
     * @param isSecondary
     * @param type
     */
    public Phone(String number, String areaCode, String type, String countryCd, Boolean isPrimary, String extension, Boolean isSecondary, String corelationId, String actionInd) {
        super();
        this.number = number;
        this.areaCode = areaCode;
        this.type = type;
        this.countryCd = countryCd;
        this.isPrimary = isPrimary;
        this.extension = extension;
        this.isSecondary = isSecondary;
        this.corelationId = corelationId;
        this.actionInd = actionInd;
    }

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("areaCode")
    public String getAreaCode() {
        return areaCode;
    }

    @JsonProperty("areaCode")
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * Valid enumeration for all LOB's is;
     * P: Landline
     * C: Mobile
     * F: Fax
     * W: Employment
     * Other enumerations have been sunset & should be phased out in future LOB releases
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Valid enumeration for all LOB's is;
     * P: Landline
     * C: Mobile
     * F: Fax
     * W: Employment
     * Other enumerations have been sunset & should be phased out in future LOB releases
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This is used in case landline number from anyother country is given by customer.
     * 
     */
    @JsonProperty("countryCd")
    public String getCountryCd() {
        return countryCd;
    }

    /**
     * This is used in case landline number from anyother country is given by customer.
     * 
     */
    @JsonProperty("countryCd")
    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    @JsonProperty("isPrimary")
    public Boolean getIsPrimary() {
        return isPrimary;
    }

    @JsonProperty("isPrimary")
    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    @JsonProperty("extension")
    public String getExtension() {
        return extension;
    }

    @JsonProperty("extension")
    public void setExtension(String extension) {
        this.extension = extension;
    }

    @JsonProperty("isSecondary")
    public Boolean getIsSecondary() {
        return isSecondary;
    }

    @JsonProperty("isSecondary")
    public void setIsSecondary(Boolean isSecondary) {
        this.isSecondary = isSecondary;
    }

    @JsonProperty("corelationId")
    public String getCorelationId() {
        return corelationId;
    }

    @JsonProperty("corelationId")
    public void setCorelationId(String corelationId) {
        this.corelationId = corelationId;
    }

    /**
     * Action Details :: 0 -Do nothing :: 1 -Create = Ignore Corelationid and Generate Corelationid :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.For Employment, we need to ignore corelationId from Employment Address always.
     * 
     */
    @JsonProperty("actionInd")
    public String getActionInd() {
        return actionInd;
    }

    /**
     * Action Details :: 0 -Do nothing :: 1 -Create = Ignore Corelationid and Generate Corelationid :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.For Employment, we need to ignore corelationId from Employment Address always.
     * 
     */
    @JsonProperty("actionInd")
    public void setActionInd(String actionInd) {
        this.actionInd = actionInd;
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
        return new ToStringBuilder(this).append("number", number).append("areaCode", areaCode).append("type", type).append("countryCd", countryCd).append("isPrimary", isPrimary).append("extension", extension).append("isSecondary", isSecondary).append("corelationId", corelationId).append("actionInd", actionInd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(number).append(areaCode).append(extension).append(isPrimary).append(countryCd).append(actionInd).append(corelationId).append(isSecondary).append(additionalProperties).append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Phone) == false) {
            return false;
        }
        Phone rhs = ((Phone) other);
        return new EqualsBuilder().append(number, rhs.number).append(areaCode, rhs.areaCode).append(extension, rhs.extension).append(isPrimary, rhs.isPrimary).append(countryCd, rhs.countryCd).append(actionInd, rhs.actionInd).append(corelationId, rhs.corelationId).append(isSecondary, rhs.isSecondary).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).isEquals();
    }

}
