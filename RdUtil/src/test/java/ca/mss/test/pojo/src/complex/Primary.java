
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
    "businessParty",
    "kyc"
})
public class Primary implements Serializable, Cloneable
{

    @JsonProperty("personalParty")
    private PersonalParty personalParty;
    @JsonProperty("businessParty")
    private BusinessParty businessParty;
    @JsonProperty("kyc")
    private Kyc kyc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2224392280560759058L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Primary() {
    }

    /**
     * 
     * @param businessParty
     * @param kyc
     * @param personalParty
     */
    public Primary(PersonalParty personalParty, BusinessParty businessParty, Kyc kyc) {
        super();
        this.personalParty = personalParty;
        this.businessParty = businessParty;
        this.kyc = kyc;
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

    @JsonProperty("kyc")
    public Kyc getKyc() {
        return kyc;
    }

    @JsonProperty("kyc")
    public void setKyc(Kyc kyc) {
        this.kyc = kyc;
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
        return new ToStringBuilder(this).append("personalParty", personalParty).append("businessParty", businessParty).append("kyc", kyc).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(businessParty).append(kyc).append(personalParty).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Primary) == false) {
            return false;
        }
        Primary rhs = ((Primary) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(businessParty, rhs.businessParty).append(kyc, rhs.kyc).append(personalParty, rhs.personalParty).isEquals();
    }

}
