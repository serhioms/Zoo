
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
    "taxJurisdiction"
})
public class CrsInfo implements Serializable, Cloneable
{

    @JsonProperty("taxJurisdiction")
    private List<TaxJurisdiction> taxJurisdiction = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7153331908114772084L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CrsInfo() {
    }

    /**
     * 
     * @param taxJurisdiction
     */
    public CrsInfo(List<TaxJurisdiction> taxJurisdiction) {
        super();
        this.taxJurisdiction = taxJurisdiction;
    }

    @JsonProperty("taxJurisdiction")
    public List<TaxJurisdiction> getTaxJurisdiction() {
        return taxJurisdiction;
    }

    @JsonProperty("taxJurisdiction")
    public void setTaxJurisdiction(List<TaxJurisdiction> taxJurisdiction) {
        this.taxJurisdiction = taxJurisdiction;
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
        return new ToStringBuilder(this).append("taxJurisdiction", taxJurisdiction).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(taxJurisdiction).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CrsInfo) == false) {
            return false;
        }
        CrsInfo rhs = ((CrsInfo) other);
        return new EqualsBuilder().append(taxJurisdiction, rhs.taxJurisdiction).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
