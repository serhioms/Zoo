
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
    "id",
    "type",
    "description",
    "expiryDate",
    "issueDate",
    "verifyDate"
})
public class Id implements Serializable, Cloneable
{

    /**
     * Actual ID value
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Actual ID value")
    private String id;
    /**
     * Actual ID Type e.g, ACF or PRN etc
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Actual ID Type e.g, ACF or PRN etc")
    private String type;
    /**
     * Actual ID Description
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Actual ID Description")
    private String description;
    /**
     * Actual ID Expiry Date if any
     * 
     */
    @JsonProperty("expiryDate")
    @JsonPropertyDescription("Actual ID Expiry Date if any")
    private String expiryDate;
    /**
     * Actual ID Issue Date if any
     * 
     */
    @JsonProperty("issueDate")
    @JsonPropertyDescription("Actual ID Issue Date if any")
    private String issueDate;
    /**
     * Actual ID Verification Date if any
     * 
     */
    @JsonProperty("verifyDate")
    @JsonPropertyDescription("Actual ID Verification Date if any")
    private String verifyDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3579929704041901730L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Id() {
    }

    /**
     * 
     * @param expiryDate
     * @param verifyDate
     * @param description
     * @param id
     * @param type
     * @param issueDate
     */
    public Id(String id, String type, String description, String expiryDate, String issueDate, String verifyDate) {
        super();
        this.id = id;
        this.type = type;
        this.description = description;
        this.expiryDate = expiryDate;
        this.issueDate = issueDate;
        this.verifyDate = verifyDate;
    }

    /**
     * Actual ID value
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Actual ID value
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Actual ID Type e.g, ACF or PRN etc
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Actual ID Type e.g, ACF or PRN etc
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Actual ID Description
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Actual ID Description
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Actual ID Expiry Date if any
     * 
     */
    @JsonProperty("expiryDate")
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Actual ID Expiry Date if any
     * 
     */
    @JsonProperty("expiryDate")
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Actual ID Issue Date if any
     * 
     */
    @JsonProperty("issueDate")
    public String getIssueDate() {
        return issueDate;
    }

    /**
     * Actual ID Issue Date if any
     * 
     */
    @JsonProperty("issueDate")
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * Actual ID Verification Date if any
     * 
     */
    @JsonProperty("verifyDate")
    public String getVerifyDate() {
        return verifyDate;
    }

    /**
     * Actual ID Verification Date if any
     * 
     */
    @JsonProperty("verifyDate")
    public void setVerifyDate(String verifyDate) {
        this.verifyDate = verifyDate;
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
        return new ToStringBuilder(this).append("id", id).append("type", type).append("description", description).append("expiryDate", expiryDate).append("issueDate", issueDate).append("verifyDate", verifyDate).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(expiryDate).append(verifyDate).append(description).append(id).append(additionalProperties).append(type).append(issueDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Id) == false) {
            return false;
        }
        Id rhs = ((Id) other);
        return new EqualsBuilder().append(expiryDate, rhs.expiryDate).append(verifyDate, rhs.verifyDate).append(description, rhs.description).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(issueDate, rhs.issueDate).isEquals();
    }

}
