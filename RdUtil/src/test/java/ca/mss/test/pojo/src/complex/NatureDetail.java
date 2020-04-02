
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
    "serviceProductOffered",
    "marketIndustryServed"
})
public class NatureDetail implements Serializable
{

    /**
     * Service and Products offered by the business
     * 
     */
    @JsonProperty("serviceProductOffered")
    @JsonPropertyDescription("Service and Products offered by the business")
    private String serviceProductOffered;
    /**
     * Market or industry served by the business
     * 
     */
    @JsonProperty("marketIndustryServed")
    @JsonPropertyDescription("Market or industry served by the business")
    private String marketIndustryServed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -9212245736510305506L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NatureDetail() {
    }

    /**
     * 
     * @param marketIndustryServed
     * @param serviceProductOffered
     */
    public NatureDetail(String serviceProductOffered, String marketIndustryServed) {
        super();
        this.serviceProductOffered = serviceProductOffered;
        this.marketIndustryServed = marketIndustryServed;
    }

    /**
     * Service and Products offered by the business
     * 
     */
    @JsonProperty("serviceProductOffered")
    public String getServiceProductOffered() {
        return serviceProductOffered;
    }

    /**
     * Service and Products offered by the business
     * 
     */
    @JsonProperty("serviceProductOffered")
    public void setServiceProductOffered(String serviceProductOffered) {
        this.serviceProductOffered = serviceProductOffered;
    }

    /**
     * Market or industry served by the business
     * 
     */
    @JsonProperty("marketIndustryServed")
    public String getMarketIndustryServed() {
        return marketIndustryServed;
    }

    /**
     * Market or industry served by the business
     * 
     */
    @JsonProperty("marketIndustryServed")
    public void setMarketIndustryServed(String marketIndustryServed) {
        this.marketIndustryServed = marketIndustryServed;
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
        return new ToStringBuilder(this).append("serviceProductOffered", serviceProductOffered).append("marketIndustryServed", marketIndustryServed).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(marketIndustryServed).append(serviceProductOffered).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NatureDetail) == false) {
            return false;
        }
        NatureDetail rhs = ((NatureDetail) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(marketIndustryServed, rhs.marketIndustryServed).append(serviceProductOffered, rhs.serviceProductOffered).isEquals();
    }

}
