
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
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "agreementEventTypeCd",
    "agreement"
})
public class RelatedAgreementEvent__ {

    /**
     * Arrangement between two or more parties where there are terms and conditions.
     * 
     */
    @JsonProperty("agreementEventTypeCd")
    @JsonPropertyDescription("Arrangement between two or more parties where there are terms and conditions.")
    private String agreementEventTypeCd;
    /**
     * Arrangement between two or more parties where there are terms and conditions.
     * 
     */
    @JsonProperty("agreement")
    @JsonPropertyDescription("Arrangement between two or more parties where there are terms and conditions.")
    @Valid
    private Agreement___ agreement;

    /**
     * Arrangement between two or more parties where there are terms and conditions.
     * 
     */
    @JsonProperty("agreementEventTypeCd")
    public String getAgreementEventTypeCd() {
        return agreementEventTypeCd;
    }

    /**
     * Arrangement between two or more parties where there are terms and conditions.
     * 
     */
    @JsonProperty("agreementEventTypeCd")
    public void setAgreementEventTypeCd(String agreementEventTypeCd) {
        this.agreementEventTypeCd = agreementEventTypeCd;
    }

    /**
     * Arrangement between two or more parties where there are terms and conditions.
     * 
     */
    @JsonProperty("agreement")
    public Agreement___ getAgreement() {
        return agreement;
    }

    /**
     * Arrangement between two or more parties where there are terms and conditions.
     * 
     */
    @JsonProperty("agreement")
    public void setAgreement(Agreement___ agreement) {
        this.agreement = agreement;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("agreementEventTypeCd", agreementEventTypeCd).append("agreement", agreement).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(agreementEventTypeCd).append(agreement).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RelatedAgreementEvent__) == false) {
            return false;
        }
        RelatedAgreementEvent__ rhs = ((RelatedAgreementEvent__) other);
        return new EqualsBuilder().append(agreementEventTypeCd, rhs.agreementEventTypeCd).append(agreement, rhs.agreement).isEquals();
    }

}
