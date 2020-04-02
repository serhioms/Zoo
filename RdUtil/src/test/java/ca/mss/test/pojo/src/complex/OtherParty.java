
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
    "personalParty",
    "businessParty"
})
public class OtherParty implements Serializable, Cloneable
{

    @JsonProperty("personalParty")
    private PersonalParty personalParty;
    @JsonProperty("businessParty")
    private BusinessParty businessParty;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5701029886106570552L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OtherParty() {
    }

    /**
     * 
     * @param businessParty
     * @param personalParty
     */
    public OtherParty(PersonalParty personalParty, BusinessParty businessParty) {
        super();
        this.personalParty = personalParty;
        this.businessParty = businessParty;
    }

    @JsonProperty("personalParty")
    public PersonalParty getPersonalParty() {
        return personalParty;
    }

    @JsonProperty("personalParty")
    public void setPersonalParty(PersonalParty personalParty) {
        this.personalParty = personalParty;
    }

    @JsonProperty("businessParty")
    public BusinessParty getBusinessParty() {
        return businessParty;
    }

    @JsonProperty("businessParty")
    public void setBusinessParty(BusinessParty businessParty) {
        this.businessParty = businessParty;
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
        return new ToStringBuilder(this).append("personalParty", personalParty).append("businessParty", businessParty).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(businessParty).append(personalParty).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OtherParty) == false) {
            return false;
        }
        OtherParty rhs = ((OtherParty) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(businessParty, rhs.businessParty).append(personalParty, rhs.personalParty).isEquals();
    }

}
