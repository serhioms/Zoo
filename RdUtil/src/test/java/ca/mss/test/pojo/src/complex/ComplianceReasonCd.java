
package ca.mss.test.pojo.src.complex;

import java.io.Serializable;
import java.util.HashMap;
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "reasonCd",
    "description"
})
public class ComplianceReasonCd implements Serializable, Cloneable
{

    @JsonProperty("reasonCd")
    private String reasonCd;
    @JsonProperty("description")
    private String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2651232280240979283L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ComplianceReasonCd() {
    }

    /**
     * 
     * @param description
     * @param reasonCd
     */
    public ComplianceReasonCd(String reasonCd, String description) {
        super();
        this.reasonCd = reasonCd;
        this.description = description;
    }

    @JsonProperty("reasonCd")
    public String getReasonCd() {
        return reasonCd;
    }

    @JsonProperty("reasonCd")
    public void setReasonCd(String reasonCd) {
        this.reasonCd = reasonCd;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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
        return new ToStringBuilder(this).append("reasonCd", reasonCd).append("description", description).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(description).append(additionalProperties).append(reasonCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ComplianceReasonCd) == false) {
            return false;
        }
        ComplianceReasonCd rhs = ((ComplianceReasonCd) other);
        return new EqualsBuilder().append(description, rhs.description).append(additionalProperties, rhs.additionalProperties).append(reasonCd, rhs.reasonCd).isEquals();
    }

}
