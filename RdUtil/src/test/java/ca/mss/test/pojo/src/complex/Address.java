
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
    "usageCd",
    "attention",
    "streetAddress",
    "unitNumber",
    "unitType",
    "city",
    "postBoxNumber",
    "postalCode",
    "zipCode",
    "specialAddress",
    "province",
    "state",
    "countryCd",
    "startYm",
    "corelationId",
    "isActive",
    "isPrimary",
    "actionInd"
})
public class Address implements Serializable, Cloneable
{

    /**
     * This is a address type/usageCd. Values can be Mailing/Billing/Legal Address
     * 
     */
    @JsonProperty("usageCd")
    @JsonPropertyDescription("This is a address type/usageCd. Values can be Mailing/Billing/Legal Address")
    private String usageCd;
    /**
     * Address line 1 - Additional recipient information
     * 
     */
    @JsonProperty("attention")
    @JsonPropertyDescription("Address line 1 - Additional recipient information")
    private String attention;
    /**
     * This is a street address or streetNumber
     * 
     */
    @JsonProperty("streetAddress")
    @JsonPropertyDescription("This is a street address or streetNumber")
    private String streetAddress;
    @JsonProperty("unitNumber")
    private String unitNumber;
    /**
     * Valid enumeration for all LOB's is;
     * APT: Apartment
     * SUITE: Suite
     * PH: Penthouse
     * UNIT: Unit
     * ROOM: Room
     * FLOOR: Floor 
     * Other enumerations have been sunset & should be phased out in future LOB releases
     * 
     */
    @JsonProperty("unitType")
    @JsonPropertyDescription("Valid enumeration for all LOB's is;\r\nAPT: Apartment\r\nSUITE: Suite\r\nPH: Penthouse\r\nUNIT: Unit\r\nROOM: Room\r\nFLOOR: Floor \r\nOther enumerations have been sunset & should be phased out in future LOB releases")
    private String unitType;
    @JsonProperty("city")
    private String city;
    @JsonProperty("postBoxNumber")
    private String postBoxNumber;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("specialAddress")
    private String specialAddress;
    @JsonProperty("province")
    private String province;
    @JsonProperty("state")
    private String state;
    @JsonProperty("countryCd")
    private String countryCd;
    @JsonProperty("startYm")
    private String startYm;
    /**
     * In case of employment, Ignore this corelationId as we need to use from Employment level. For ResidentAddress, we need to use this   corelationId.
     * 
     */
    @JsonProperty("corelationId")
    @JsonPropertyDescription("In case of employment, Ignore this corelationId as we need to use from Employment level. For ResidentAddress, we need to use this   corelationId.")
    private String corelationId;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("isPrimary")
    private Boolean isPrimary;
    /**
     * Action Details :: 0 -Do nothing :: 1 -Create = Ignore Corelationid and Generate Corelationid :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.For Resident Address, App Engine should consider the corelationId from Address always.
     * 
     */
    @JsonProperty("actionInd")
    @JsonPropertyDescription("Action Details :: 0 -Do nothing :: 1 -Create = Ignore Corelationid and Generate Corelationid :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.For Resident Address, App Engine should consider the corelationId from Address always.")
    private String actionInd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4052971508045666252L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Address() {
    }

    /**
     * 
     * @param zipCode
     * @param specialAddress
     * @param city
     * @param postalCode
     * @param countryCd
     * @param unitNumber
     * @param isActive
     * @param unitType
     * @param province
     * @param streetAddress
     * @param isPrimary
     * @param actionInd
     * @param attention
     * @param postBoxNumber
     * @param corelationId
     * @param state
     * @param startYm
     * @param usageCd
     */
    public Address(String usageCd, String attention, String streetAddress, String unitNumber, String unitType, String city, String postBoxNumber, String postalCode, String zipCode, String specialAddress, String province, String state, String countryCd, String startYm, String corelationId, Boolean isActive, Boolean isPrimary, String actionInd) {
        super();
        this.usageCd = usageCd;
        this.attention = attention;
        this.streetAddress = streetAddress;
        this.unitNumber = unitNumber;
        this.unitType = unitType;
        this.city = city;
        this.postBoxNumber = postBoxNumber;
        this.postalCode = postalCode;
        this.zipCode = zipCode;
        this.specialAddress = specialAddress;
        this.province = province;
        this.state = state;
        this.countryCd = countryCd;
        this.startYm = startYm;
        this.corelationId = corelationId;
        this.isActive = isActive;
        this.isPrimary = isPrimary;
        this.actionInd = actionInd;
    }

    /**
     * This is a address type/usageCd. Values can be Mailing/Billing/Legal Address
     * 
     */
    @JsonProperty("usageCd")
    public String getUsageCd() {
        return usageCd;
    }

    /**
     * This is a address type/usageCd. Values can be Mailing/Billing/Legal Address
     * 
     */
    @JsonProperty("usageCd")
    public void setUsageCd(String usageCd) {
        this.usageCd = usageCd;
    }

    /**
     * Address line 1 - Additional recipient information
     * 
     */
    @JsonProperty("attention")
    public String getAttention() {
        return attention;
    }

    /**
     * Address line 1 - Additional recipient information
     * 
     */
    @JsonProperty("attention")
    public void setAttention(String attention) {
        this.attention = attention;
    }

    /**
     * This is a street address or streetNumber
     * 
     */
    @JsonProperty("streetAddress")
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * This is a street address or streetNumber
     * 
     */
    @JsonProperty("streetAddress")
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @JsonProperty("unitNumber")
    public String getUnitNumber() {
        return unitNumber;
    }

    @JsonProperty("unitNumber")
    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    /**
     * Valid enumeration for all LOB's is;
     * APT: Apartment
     * SUITE: Suite
     * PH: Penthouse
     * UNIT: Unit
     * ROOM: Room
     * FLOOR: Floor 
     * Other enumerations have been sunset & should be phased out in future LOB releases
     * 
     */
    @JsonProperty("unitType")
    public String getUnitType() {
        return unitType;
    }

    /**
     * Valid enumeration for all LOB's is;
     * APT: Apartment
     * SUITE: Suite
     * PH: Penthouse
     * UNIT: Unit
     * ROOM: Room
     * FLOOR: Floor 
     * Other enumerations have been sunset & should be phased out in future LOB releases
     * 
     */
    @JsonProperty("unitType")
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("postBoxNumber")
    public String getPostBoxNumber() {
        return postBoxNumber;
    }

    @JsonProperty("postBoxNumber")
    public void setPostBoxNumber(String postBoxNumber) {
        this.postBoxNumber = postBoxNumber;
    }

    @JsonProperty("postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @JsonProperty("specialAddress")
    public String getSpecialAddress() {
        return specialAddress;
    }

    @JsonProperty("specialAddress")
    public void setSpecialAddress(String specialAddress) {
        this.specialAddress = specialAddress;
    }

    @JsonProperty("province")
    public String getProvince() {
        return province;
    }

    @JsonProperty("province")
    public void setProvince(String province) {
        this.province = province;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("countryCd")
    public String getCountryCd() {
        return countryCd;
    }

    @JsonProperty("countryCd")
    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    @JsonProperty("startYm")
    public String getStartYm() {
        return startYm;
    }

    @JsonProperty("startYm")
    public void setStartYm(String startYm) {
        this.startYm = startYm;
    }

    /**
     * In case of employment, Ignore this corelationId as we need to use from Employment level. For ResidentAddress, we need to use this   corelationId.
     * 
     */
    @JsonProperty("corelationId")
    public String getCorelationId() {
        return corelationId;
    }

    /**
     * In case of employment, Ignore this corelationId as we need to use from Employment level. For ResidentAddress, we need to use this   corelationId.
     * 
     */
    @JsonProperty("corelationId")
    public void setCorelationId(String corelationId) {
        this.corelationId = corelationId;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("isPrimary")
    public Boolean getIsPrimary() {
        return isPrimary;
    }

    @JsonProperty("isPrimary")
    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    /**
     * Action Details :: 0 -Do nothing :: 1 -Create = Ignore Corelationid and Generate Corelationid :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.For Resident Address, App Engine should consider the corelationId from Address always.
     * 
     */
    @JsonProperty("actionInd")
    public String getActionInd() {
        return actionInd;
    }

    /**
     * Action Details :: 0 -Do nothing :: 1 -Create = Ignore Corelationid and Generate Corelationid :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.For Resident Address, App Engine should consider the corelationId from Address always.
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
        return new ToStringBuilder(this).append("usageCd", usageCd).append("attention", attention).append("streetAddress", streetAddress).append("unitNumber", unitNumber).append("unitType", unitType).append("city", city).append("postBoxNumber", postBoxNumber).append("postalCode", postalCode).append("zipCode", zipCode).append("specialAddress", specialAddress).append("province", province).append("state", state).append("countryCd", countryCd).append("startYm", startYm).append("corelationId", corelationId).append("isActive", isActive).append("isPrimary", isPrimary).append("actionInd", actionInd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(zipCode).append(specialAddress).append(city).append(postalCode).append(countryCd).append(unitNumber).append(isActive).append(unitType).append(province).append(streetAddress).append(isPrimary).append(actionInd).append(attention).append(postBoxNumber).append(corelationId).append(state).append(additionalProperties).append(startYm).append(usageCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Address) == false) {
            return false;
        }
        Address rhs = ((Address) other);
        return new EqualsBuilder().append(zipCode, rhs.zipCode).append(specialAddress, rhs.specialAddress).append(city, rhs.city).append(postalCode, rhs.postalCode).append(countryCd, rhs.countryCd).append(unitNumber, rhs.unitNumber).append(isActive, rhs.isActive).append(unitType, rhs.unitType).append(province, rhs.province).append(streetAddress, rhs.streetAddress).append(isPrimary, rhs.isPrimary).append(actionInd, rhs.actionInd).append(attention, rhs.attention).append(postBoxNumber, rhs.postBoxNumber).append(corelationId, rhs.corelationId).append(state, rhs.state).append(additionalProperties, rhs.additionalProperties).append(startYm, rhs.startYm).append(usageCd, rhs.usageCd).isEquals();
    }

}
