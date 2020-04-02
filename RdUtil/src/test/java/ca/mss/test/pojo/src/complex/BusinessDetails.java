
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
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Version v1, Date; 20180529. BusinessDetails Definition
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fundingSource",
    "otherPurpose",
    "monthlyActivity",
    "signingRequirements"
})
public class BusinessDetails implements Serializable
{

    @JsonProperty("fundingSource")
    private List<String> fundingSource = null;
    /**
     * If Account.purpose has value as 'other' then otherPurpose should have description to the other purpose.
     * 
     */
    @JsonProperty("otherPurpose")
    @JsonPropertyDescription("If Account.purpose has value as 'other' then otherPurpose should have description to the other purpose.")
    private String otherPurpose;
    @JsonProperty("monthlyActivity")
    private String monthlyActivity;
    @JsonProperty("signingRequirements")
    private String signingRequirements;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3740023592007148977L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BusinessDetails() {
    }

    /**
     * 
     * @param signingRequirements
     * @param otherPurpose
     * @param monthlyActivity
     * @param fundingSource
     */
    public BusinessDetails(List<String> fundingSource, String otherPurpose, String monthlyActivity, String signingRequirements) {
        super();
        this.fundingSource = fundingSource;
        this.otherPurpose = otherPurpose;
        this.monthlyActivity = monthlyActivity;
        this.signingRequirements = signingRequirements;
    }

    @JsonProperty("fundingSource")
    public List<String> getFundingSource() {
        return fundingSource;
    }

    @JsonProperty("fundingSource")
    public void setFundingSource(List<String> fundingSource) {
        this.fundingSource = fundingSource;
    }

    /**
     * If Account.purpose has value as 'other' then otherPurpose should have description to the other purpose.
     * 
     */
    @JsonProperty("otherPurpose")
    public String getOtherPurpose() {
        return otherPurpose;
    }

    /**
     * If Account.purpose has value as 'other' then otherPurpose should have description to the other purpose.
     * 
     */
    @JsonProperty("otherPurpose")
    public void setOtherPurpose(String otherPurpose) {
        this.otherPurpose = otherPurpose;
    }

    @JsonProperty("monthlyActivity")
    public String getMonthlyActivity() {
        return monthlyActivity;
    }

    @JsonProperty("monthlyActivity")
    public void setMonthlyActivity(String monthlyActivity) {
        this.monthlyActivity = monthlyActivity;
    }

    @JsonProperty("signingRequirements")
    public String getSigningRequirements() {
        return signingRequirements;
    }

    @JsonProperty("signingRequirements")
    public void setSigningRequirements(String signingRequirements) {
        this.signingRequirements = signingRequirements;
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
        return new ToStringBuilder(this).append("fundingSource", fundingSource).append("otherPurpose", otherPurpose).append("monthlyActivity", monthlyActivity).append("signingRequirements", signingRequirements).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(monthlyActivity).append(signingRequirements).append(additionalProperties).append(fundingSource).append(otherPurpose).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BusinessDetails) == false) {
            return false;
        }
        BusinessDetails rhs = ((BusinessDetails) other);
        return new EqualsBuilder().append(monthlyActivity, rhs.monthlyActivity).append(signingRequirements, rhs.signingRequirements).append(additionalProperties, rhs.additionalProperties).append(fundingSource, rhs.fundingSource).append(otherPurpose, rhs.otherPurpose).isEquals();
    }

}
