
package ca.mss.test.pojo.dest.complex;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Event extension data segment for FRD.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "eventReference"
})
public class FrdExtension_ {

    /**
     * Generic IFX-based element to accommodate misc key/value pairs.
     * 
     */
    @JsonProperty("eventReference")
    @JsonPropertyDescription("Generic IFX-based element to accommodate misc key/value pairs.")
    @Valid
    private List<EventReference_> eventReference = new ArrayList<EventReference_>();

    /**
     * Generic IFX-based element to accommodate misc key/value pairs.
     * 
     */
    @JsonProperty("eventReference")
    public List<EventReference_> getEventReference() {
        return eventReference;
    }

    /**
     * Generic IFX-based element to accommodate misc key/value pairs.
     * 
     */
    @JsonProperty("eventReference")
    public void setEventReference(List<EventReference_> eventReference) {
        this.eventReference = eventReference;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("eventReference", eventReference).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(eventReference).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FrdExtension_) == false) {
            return false;
        }
        FrdExtension_ rhs = ((FrdExtension_) other);
        return new EqualsBuilder().append(eventReference, rhs.eventReference).isEquals();
    }

}
