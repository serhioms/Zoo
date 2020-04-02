
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
    "liabilityList",
    "totalConsolidation",
    "cashInHand"
})
public class Liability implements Serializable, Cloneable
{

    @JsonProperty("liabilityList")
    private List<LiabilityList> liabilityList = null;
    @JsonProperty("totalConsolidation")
    private Integer totalConsolidation;
    @JsonProperty("cashInHand")
    private Integer cashInHand;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3972670624833519501L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Liability() {
    }

    /**
     * 
     * @param cashInHand
     * @param totalConsolidation
     * @param liabilityList
     */
    public Liability(List<LiabilityList> liabilityList, Integer totalConsolidation, Integer cashInHand) {
        super();
        this.liabilityList = liabilityList;
        this.totalConsolidation = totalConsolidation;
        this.cashInHand = cashInHand;
    }

    @JsonProperty("liabilityList")
    public List<LiabilityList> getLiabilityList() {
        return liabilityList;
    }

    @JsonProperty("liabilityList")
    public void setLiabilityList(List<LiabilityList> liabilityList) {
        this.liabilityList = liabilityList;
    }

    @JsonProperty("totalConsolidation")
    public Integer getTotalConsolidation() {
        return totalConsolidation;
    }

    @JsonProperty("totalConsolidation")
    public void setTotalConsolidation(Integer totalConsolidation) {
        this.totalConsolidation = totalConsolidation;
    }

    @JsonProperty("cashInHand")
    public Integer getCashInHand() {
        return cashInHand;
    }

    @JsonProperty("cashInHand")
    public void setCashInHand(Integer cashInHand) {
        this.cashInHand = cashInHand;
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
        return new ToStringBuilder(this).append("liabilityList", liabilityList).append("totalConsolidation", totalConsolidation).append("cashInHand", cashInHand).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cashInHand).append(additionalProperties).append(liabilityList).append(totalConsolidation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Liability) == false) {
            return false;
        }
        Liability rhs = ((Liability) other);
        return new EqualsBuilder().append(cashInHand, rhs.cashInHand).append(additionalProperties, rhs.additionalProperties).append(liabilityList, rhs.liabilityList).append(totalConsolidation, rhs.totalConsolidation).isEquals();
    }

}
