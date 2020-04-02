
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
    "countryCd",
    "taxpayerIdentificationNum",
    "actionCd",
    "taxpayerIdentificationNumNotProvidedInd"
})
public class TaxJurisdiction implements Serializable, Cloneable
{

    @JsonProperty("countryCd")
    private String countryCd;
    @JsonProperty("taxpayerIdentificationNum")
    private String taxpayerIdentificationNum;
    @JsonProperty("actionCd")
    private String actionCd;
    @JsonProperty("taxpayerIdentificationNumNotProvidedInd")
    private String taxpayerIdentificationNumNotProvidedInd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3158382012608792270L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TaxJurisdiction() {
    }

    /**
     * 
     * @param taxpayerIdentificationNumNotProvidedInd
     * @param taxpayerIdentificationNum
     * @param countryCd
     * @param actionCd
     */
    public TaxJurisdiction(String countryCd, String taxpayerIdentificationNum, String actionCd, String taxpayerIdentificationNumNotProvidedInd) {
        super();
        this.countryCd = countryCd;
        this.taxpayerIdentificationNum = taxpayerIdentificationNum;
        this.actionCd = actionCd;
        this.taxpayerIdentificationNumNotProvidedInd = taxpayerIdentificationNumNotProvidedInd;
    }

    @JsonProperty("countryCd")
    public String getCountryCd() {
        return countryCd;
    }

    @JsonProperty("countryCd")
    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    @JsonProperty("taxpayerIdentificationNum")
    public String getTaxpayerIdentificationNum() {
        return taxpayerIdentificationNum;
    }

    @JsonProperty("taxpayerIdentificationNum")
    public void setTaxpayerIdentificationNum(String taxpayerIdentificationNum) {
        this.taxpayerIdentificationNum = taxpayerIdentificationNum;
    }

    @JsonProperty("actionCd")
    public String getActionCd() {
        return actionCd;
    }

    @JsonProperty("actionCd")
    public void setActionCd(String actionCd) {
        this.actionCd = actionCd;
    }

    @JsonProperty("taxpayerIdentificationNumNotProvidedInd")
    public String getTaxpayerIdentificationNumNotProvidedInd() {
        return taxpayerIdentificationNumNotProvidedInd;
    }

    @JsonProperty("taxpayerIdentificationNumNotProvidedInd")
    public void setTaxpayerIdentificationNumNotProvidedInd(String taxpayerIdentificationNumNotProvidedInd) {
        this.taxpayerIdentificationNumNotProvidedInd = taxpayerIdentificationNumNotProvidedInd;
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
        return new ToStringBuilder(this).append("countryCd", countryCd).append("taxpayerIdentificationNum", taxpayerIdentificationNum).append("actionCd", actionCd).append("taxpayerIdentificationNumNotProvidedInd", taxpayerIdentificationNumNotProvidedInd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(countryCd).append(additionalProperties).append(taxpayerIdentificationNumNotProvidedInd).append(taxpayerIdentificationNum).append(actionCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TaxJurisdiction) == false) {
            return false;
        }
        TaxJurisdiction rhs = ((TaxJurisdiction) other);
        return new EqualsBuilder().append(countryCd, rhs.countryCd).append(additionalProperties, rhs.additionalProperties).append(taxpayerIdentificationNumNotProvidedInd, rhs.taxpayerIdentificationNumNotProvidedInd).append(taxpayerIdentificationNum, rhs.taxpayerIdentificationNum).append(actionCd, rhs.actionCd).isEquals();
    }

}
