
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
    "number",
    "name",
    "type",
    "status",
    "deliveryDetails",
    "purpose",
    "issueDate",
    "expiryDate"
})
public class AccessCard implements Serializable, Cloneable
{

    @JsonProperty("number")
    private String number;
    /**
     * This is a card name which is printed on card.
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("This is a card name which is printed on card.")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("status")
    private String status;
    @JsonProperty("deliveryDetails")
    private String deliveryDetails;
    @JsonProperty("purpose")
    private String purpose;
    /**
     * IssueDate of the card.
     * 
     */
    @JsonProperty("issueDate")
    @JsonPropertyDescription("IssueDate of the card.")
    private Long issueDate;
    /**
     * ExpiryDate of the card.
     * 
     */
    @JsonProperty("expiryDate")
    @JsonPropertyDescription("ExpiryDate of the card.")
    private Long expiryDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8501461037077075641L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AccessCard() {
    }

    /**
     * 
     * @param expiryDate
     * @param number
     * @param purpose
     * @param name
     * @param deliveryDetails
     * @param type
     * @param issueDate
     * @param status
     */
    public AccessCard(String number, String name, String type, String status, String deliveryDetails, String purpose, Long issueDate, Long expiryDate) {
        super();
        this.number = number;
        this.name = name;
        this.type = type;
        this.status = status;
        this.deliveryDetails = deliveryDetails;
        this.purpose = purpose;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * This is a card name which is printed on card.
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * This is a card name which is printed on card.
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("deliveryDetails")
    public String getDeliveryDetails() {
        return deliveryDetails;
    }

    @JsonProperty("deliveryDetails")
    public void setDeliveryDetails(String deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
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
     * IssueDate of the card.
     * 
     */
    @JsonProperty("issueDate")
    public Long getIssueDate() {
        return issueDate;
    }

    /**
     * IssueDate of the card.
     * 
     */
    @JsonProperty("issueDate")
    public void setIssueDate(Long issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * ExpiryDate of the card.
     * 
     */
    @JsonProperty("expiryDate")
    public Long getExpiryDate() {
        return expiryDate;
    }

    /**
     * ExpiryDate of the card.
     * 
     */
    @JsonProperty("expiryDate")
    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
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
        return new ToStringBuilder(this).append("number", number).append("name", name).append("type", type).append("status", status).append("deliveryDetails", deliveryDetails).append("purpose", purpose).append("issueDate", issueDate).append("expiryDate", expiryDate).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(expiryDate).append(number).append(purpose).append(name).append(deliveryDetails).append(additionalProperties).append(type).append(issueDate).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AccessCard) == false) {
            return false;
        }
        AccessCard rhs = ((AccessCard) other);
        return new EqualsBuilder().append(expiryDate, rhs.expiryDate).append(number, rhs.number).append(purpose, rhs.purpose).append(name, rhs.name).append(deliveryDetails, rhs.deliveryDetails).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(issueDate, rhs.issueDate).append(status, rhs.status).isEquals();
    }

}
