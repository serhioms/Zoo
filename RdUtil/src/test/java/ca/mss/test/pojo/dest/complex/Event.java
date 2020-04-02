
package ca.mss.test.pojo.dest.complex;

import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "agreementEvent",
    "financialEvent",
    "financialAgreementEvent"
})
public class Event {

    /**
     * 
     * 
     */
    @JsonProperty("agreementEvent")
    @JsonPropertyDescription("")
    @Valid
    private AgreementEvent agreementEvent;
    /**
     * 
     * 
     */
    @JsonProperty("financialEvent")
    @JsonPropertyDescription("")
    @Valid
    private FinancialEvent financialEvent;
    /**
     * 
     * 
     */
    @JsonProperty("financialAgreementEvent")
    @JsonPropertyDescription("")
    @Valid
    private FinancialAgreementEvent financialAgreementEvent;

    /**
     * 
     * 
     */
    @JsonProperty("agreementEvent")
    public AgreementEvent getAgreementEvent() {
        return agreementEvent;
    }

    /**
     * 
     * 
     */
    @JsonProperty("agreementEvent")
    public void setAgreementEvent(AgreementEvent agreementEvent) {
        this.agreementEvent = agreementEvent;
    }

    /**
     * 
     * 
     */
    @JsonProperty("financialEvent")
    public FinancialEvent getFinancialEvent() {
        return financialEvent;
    }

    /**
     * 
     * 
     */
    @JsonProperty("financialEvent")
    public void setFinancialEvent(FinancialEvent financialEvent) {
        this.financialEvent = financialEvent;
    }

    /**
     * 
     * 
     */
    @JsonProperty("financialAgreementEvent")
    public FinancialAgreementEvent getFinancialAgreementEvent() {
        return financialAgreementEvent;
    }

    /**
     * 
     * 
     */
    @JsonProperty("financialAgreementEvent")
    public void setFinancialAgreementEvent(FinancialAgreementEvent financialAgreementEvent) {
        this.financialAgreementEvent = financialAgreementEvent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("agreementEvent", agreementEvent).append("financialEvent", financialEvent).append("financialAgreementEvent", financialAgreementEvent).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(financialEvent).append(agreementEvent).append(financialAgreementEvent).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Event) == false) {
            return false;
        }
        Event rhs = ((Event) other);
        return new EqualsBuilder().append(financialEvent, rhs.financialEvent).append(agreementEvent, rhs.agreementEvent).append(financialAgreementEvent, rhs.financialAgreementEvent).isEquals();
    }

}
