
package ca.mss.test.pojo.dest.complex;

import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Feature related to the agreement.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amountFeature"
})
public class Feature__ {

    /**
     * 
     * 
     */
    @JsonProperty("amountFeature")
    @JsonPropertyDescription("")
    @Valid
    private AmountFeature__ amountFeature;

    /**
     * 
     * 
     */
    @JsonProperty("amountFeature")
    public AmountFeature__ getAmountFeature() {
        return amountFeature;
    }

    /**
     * 
     * 
     */
    @JsonProperty("amountFeature")
    public void setAmountFeature(AmountFeature__ amountFeature) {
        this.amountFeature = amountFeature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("amountFeature", amountFeature).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(amountFeature).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Feature__) == false) {
            return false;
        }
        Feature__ rhs = ((Feature__) other);
        return new EqualsBuilder().append(amountFeature, rhs.amountFeature).isEquals();
    }

}
