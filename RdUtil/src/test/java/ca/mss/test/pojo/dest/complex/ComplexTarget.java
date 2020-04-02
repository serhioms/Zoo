
package ca.mss.test.pojo.dest.complex;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "contactEvent",
    "event"
})
public class ComplexTarget {

    /**
     * Event caused by having contact with the Financial Institution either of a
     * personal nature where an employee talks to the customer, or an impersonal
     * nature where the customer uses the ATM or automatic call center orany other touch point.
     * (Required)
     * 
     */
    @JsonProperty("contactEvent")
    @JsonPropertyDescription("Event caused by having contact with the Financial Institution either of a\r\npersonal nature where an employee talks to the customer, or an impersonal\r\nnature where the customer uses the ATM or automatic call center orany other touch point.")
    @Valid
    @NotNull
    private ContactEvent contactEvent;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("event")
    @JsonPropertyDescription("")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<Event> event = new ArrayList<Event>();

    /**
     * Event caused by having contact with the Financial Institution either of a
     * personal nature where an employee talks to the customer, or an impersonal
     * nature where the customer uses the ATM or automatic call center orany other touch point.
     * (Required)
     * 
     */
    @JsonProperty("contactEvent")
    public ContactEvent getContactEvent() {
        return contactEvent;
    }

    /**
     * Event caused by having contact with the Financial Institution either of a
     * personal nature where an employee talks to the customer, or an impersonal
     * nature where the customer uses the ATM or automatic call center orany other touch point.
     * (Required)
     * 
     */
    @JsonProperty("contactEvent")
    public void setContactEvent(ContactEvent contactEvent) {
        this.contactEvent = contactEvent;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("event")
    public List<Event> getEvent() {
        return event;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("event")
    public void setEvent(List<Event> event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("contactEvent", contactEvent).append("event", event).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(event).append(contactEvent).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ComplexTarget) == false) {
            return false;
        }
        ComplexTarget rhs = ((ComplexTarget) other);
        return new EqualsBuilder().append(event, rhs.event).append(contactEvent, rhs.contactEvent).isEquals();
    }

}
