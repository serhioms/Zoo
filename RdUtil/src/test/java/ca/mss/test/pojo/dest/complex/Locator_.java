
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
    "streetAddress",
    "telephoneNumber",
    "emailAddress"
})
public class Locator_ {

    /**
     * 
     * 
     */
    @JsonProperty("streetAddress")
    @JsonPropertyDescription("")
    @Valid
    private StreetAddress_ streetAddress;
    /**
     * 
     * 
     */
    @JsonProperty("telephoneNumber")
    @JsonPropertyDescription("")
    @Valid
    private TelephoneNumber_ telephoneNumber;
    /**
     * 
     * 
     */
    @JsonProperty("emailAddress")
    @JsonPropertyDescription("")
    @Valid
    private EmailAddress_ emailAddress;

    /**
     * 
     * 
     */
    @JsonProperty("streetAddress")
    public StreetAddress_ getStreetAddress() {
        return streetAddress;
    }

    /**
     * 
     * 
     */
    @JsonProperty("streetAddress")
    public void setStreetAddress(StreetAddress_ streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * 
     * 
     */
    @JsonProperty("telephoneNumber")
    public TelephoneNumber_ getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * 
     * 
     */
    @JsonProperty("telephoneNumber")
    public void setTelephoneNumber(TelephoneNumber_ telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * 
     * 
     */
    @JsonProperty("emailAddress")
    public EmailAddress_ getEmailAddress() {
        return emailAddress;
    }

    /**
     * 
     * 
     */
    @JsonProperty("emailAddress")
    public void setEmailAddress(EmailAddress_ emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("streetAddress", streetAddress).append("telephoneNumber", telephoneNumber).append("emailAddress", emailAddress).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(emailAddress).append(telephoneNumber).append(streetAddress).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Locator_) == false) {
            return false;
        }
        Locator_ rhs = ((Locator_) other);
        return new EqualsBuilder().append(emailAddress, rhs.emailAddress).append(telephoneNumber, rhs.telephoneNumber).append(streetAddress, rhs.streetAddress).isEquals();
    }

}
