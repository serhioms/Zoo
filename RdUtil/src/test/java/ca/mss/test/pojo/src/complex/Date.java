
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
    "dateType",
    "date"
})
public class Date implements Serializable, Cloneable
{

    /**
     * Account Date Type enum: open / close / freeze / approved / activation 
     * 
     */
    @JsonProperty("dateType")
    @JsonPropertyDescription("Account Date Type enum: open / close / freeze / approved / activation ")
    private String dateType;
    @JsonProperty("date")
    private Long date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8803684672214421537L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Date() {
    }

    /**
     * 
     * @param date
     * @param dateType
     */
    public Date(String dateType, Long date) {
        super();
        this.dateType = dateType;
        this.date = date;
    }

    /**
     * Account Date Type enum: open / close / freeze / approved / activation 
     * 
     */
    @JsonProperty("dateType")
    public String getDateType() {
        return dateType;
    }

    /**
     * Account Date Type enum: open / close / freeze / approved / activation 
     * 
     */
    @JsonProperty("dateType")
    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    @JsonProperty("date")
    public Long getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(Long date) {
        this.date = date;
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
        return new ToStringBuilder(this).append("dateType", dateType).append("date", date).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(date).append(dateType).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Date) == false) {
            return false;
        }
        Date rhs = ((Date) other);
        return new EqualsBuilder().append(date, rhs.date).append(dateType, rhs.dateType).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
