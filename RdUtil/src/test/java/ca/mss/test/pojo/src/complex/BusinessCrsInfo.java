
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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "BusinessTaxJurisdiction"
})
public class BusinessCrsInfo implements Serializable, Cloneable
{

    @JsonProperty("BusinessTaxJurisdiction")
    private List<BusinessTaxJurisdiction> businessTaxJurisdiction = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7459180564506293845L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BusinessCrsInfo() {
    }

    /**
     * 
     * @param businessTaxJurisdiction
     */
    public BusinessCrsInfo(List<BusinessTaxJurisdiction> businessTaxJurisdiction) {
        super();
        this.businessTaxJurisdiction = businessTaxJurisdiction;
    }

    @JsonProperty("BusinessTaxJurisdiction")
    public List<BusinessTaxJurisdiction> getBusinessTaxJurisdiction() {
        return businessTaxJurisdiction;
    }

    @JsonProperty("BusinessTaxJurisdiction")
    public void setBusinessTaxJurisdiction(List<BusinessTaxJurisdiction> businessTaxJurisdiction) {
        this.businessTaxJurisdiction = businessTaxJurisdiction;
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
        return new ToStringBuilder(this).append("businessTaxJurisdiction", businessTaxJurisdiction).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(businessTaxJurisdiction).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BusinessCrsInfo) == false) {
            return false;
        }
        BusinessCrsInfo rhs = ((BusinessCrsInfo) other);
        return new EqualsBuilder().append(businessTaxJurisdiction, rhs.businessTaxJurisdiction).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
