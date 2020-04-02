
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
    "relatedEvent",
    "relatedAgreementEvent"
})
public class EventToEvent__ {

    /**
     * 
     * 
     */
    @JsonProperty("relatedEvent")
    @JsonPropertyDescription("")
    @Valid
    private RelatedEvent__ relatedEvent;
    /**
     * 
     * 
     */
    @JsonProperty("relatedAgreementEvent")
    @JsonPropertyDescription("")
    @Valid
    private RelatedAgreementEvent__ relatedAgreementEvent;

    /**
     * 
     * 
     */
    @JsonProperty("relatedEvent")
    public RelatedEvent__ getRelatedEvent() {
        return relatedEvent;
    }

    /**
     * 
     * 
     */
    @JsonProperty("relatedEvent")
    public void setRelatedEvent(RelatedEvent__ relatedEvent) {
        this.relatedEvent = relatedEvent;
    }

    /**
     * 
     * 
     */
    @JsonProperty("relatedAgreementEvent")
    public RelatedAgreementEvent__ getRelatedAgreementEvent() {
        return relatedAgreementEvent;
    }

    /**
     * 
     * 
     */
    @JsonProperty("relatedAgreementEvent")
    public void setRelatedAgreementEvent(RelatedAgreementEvent__ relatedAgreementEvent) {
        this.relatedAgreementEvent = relatedAgreementEvent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("relatedEvent", relatedEvent).append("relatedAgreementEvent", relatedAgreementEvent).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(relatedAgreementEvent).append(relatedEvent).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EventToEvent__) == false) {
            return false;
        }
        EventToEvent__ rhs = ((EventToEvent__) other);
        return new EqualsBuilder().append(relatedAgreementEvent, rhs.relatedAgreementEvent).append(relatedEvent, rhs.relatedEvent).isEquals();
    }

}
