
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
    "fee",
    "schedule",
    "description",
    "type"
})
public class Fee implements Serializable, Cloneable
{

    /**
     * various account fees, e.g. setup or maintenance fee.
     * 
     */
    @JsonProperty("fee")
    @JsonPropertyDescription("various account fees, e.g. setup or maintenance fee.")
    private Double fee;
    /**
     * This is an account maintenance fee schedule such as monthly/quarterly/daily.
     * 
     */
    @JsonProperty("schedule")
    @JsonPropertyDescription("This is an account maintenance fee schedule such as monthly/quarterly/daily.")
    private String schedule;
    /**
     * This is contains the fee description.
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("This is contains the fee description.")
    private String description;
    /**
     * setupFee/nonSufficientFundsFee
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("setupFee/nonSufficientFundsFee")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7369554724640527347L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fee() {
    }

    /**
     * 
     * @param schedule
     * @param fee
     * @param description
     * @param type
     */
    public Fee(Double fee, String schedule, String description, String type) {
        super();
        this.fee = fee;
        this.schedule = schedule;
        this.description = description;
        this.type = type;
    }

    /**
     * various account fees, e.g. setup or maintenance fee.
     * 
     */
    @JsonProperty("fee")
    public Double getFee() {
        return fee;
    }

    /**
     * various account fees, e.g. setup or maintenance fee.
     * 
     */
    @JsonProperty("fee")
    public void setFee(Double fee) {
        this.fee = fee;
    }

    /**
     * This is an account maintenance fee schedule such as monthly/quarterly/daily.
     * 
     */
    @JsonProperty("schedule")
    public String getSchedule() {
        return schedule;
    }

    /**
     * This is an account maintenance fee schedule such as monthly/quarterly/daily.
     * 
     */
    @JsonProperty("schedule")
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * This is contains the fee description.
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * This is contains the fee description.
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * setupFee/nonSufficientFundsFee
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * setupFee/nonSufficientFundsFee
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
        return new ToStringBuilder(this).append("fee", fee).append("schedule", schedule).append("description", description).append("type", type).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(schedule).append(description).append(additionalProperties).append(type).append(fee).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Fee) == false) {
            return false;
        }
        Fee rhs = ((Fee) other);
        return new EqualsBuilder().append(schedule, rhs.schedule).append(description, rhs.description).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(fee, rhs.fee).isEquals();
    }

}
