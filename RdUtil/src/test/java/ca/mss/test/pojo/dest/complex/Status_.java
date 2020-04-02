
package ca.mss.test.pojo.dest.complex;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * This entity defines the response status of this event
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "typeCd",
    "subtypeCd",
    "reasonCd"
})
public class Status_ {

    /**
     * A code for the status of an event such as completed, not completed, pending, in progress, suspended, canceled, abandoned, refused, etc.
     * 
     */
    @JsonProperty("typeCd")
    @JsonPropertyDescription("A code for the status of an event such as completed, not completed, pending, in progress, suspended, canceled, abandoned, refused, etc.")
    private String typeCd;
    /**
     * A subtype discriminator based on the response type of the event e.g. Status, Cause etc..
     * 
     */
    @JsonProperty("subtypeCd")
    @JsonPropertyDescription("A subtype discriminator based on the response type of the event e.g. Status, Cause etc..")
    private String subtypeCd;
    /**
     * The reason for the event response status. For example, if the event status is rejected, the event status reason will describe the reason the event was rejected. Reasons include insufficient funds, credit limit exceeded, card reported as stolen, etc.
     * 
     */
    @JsonProperty("reasonCd")
    @JsonPropertyDescription("The reason for the event response status. For example, if the event status is rejected, the event status reason will describe the reason the event was rejected. Reasons include insufficient funds, credit limit exceeded, card reported as stolen, etc.")
    private String reasonCd;

    /**
     * A code for the status of an event such as completed, not completed, pending, in progress, suspended, canceled, abandoned, refused, etc.
     * 
     */
    @JsonProperty("typeCd")
    public String getTypeCd() {
        return typeCd;
    }

    /**
     * A code for the status of an event such as completed, not completed, pending, in progress, suspended, canceled, abandoned, refused, etc.
     * 
     */
    @JsonProperty("typeCd")
    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    /**
     * A subtype discriminator based on the response type of the event e.g. Status, Cause etc..
     * 
     */
    @JsonProperty("subtypeCd")
    public String getSubtypeCd() {
        return subtypeCd;
    }

    /**
     * A subtype discriminator based on the response type of the event e.g. Status, Cause etc..
     * 
     */
    @JsonProperty("subtypeCd")
    public void setSubtypeCd(String subtypeCd) {
        this.subtypeCd = subtypeCd;
    }

    /**
     * The reason for the event response status. For example, if the event status is rejected, the event status reason will describe the reason the event was rejected. Reasons include insufficient funds, credit limit exceeded, card reported as stolen, etc.
     * 
     */
    @JsonProperty("reasonCd")
    public String getReasonCd() {
        return reasonCd;
    }

    /**
     * The reason for the event response status. For example, if the event status is rejected, the event status reason will describe the reason the event was rejected. Reasons include insufficient funds, credit limit exceeded, card reported as stolen, etc.
     * 
     */
    @JsonProperty("reasonCd")
    public void setReasonCd(String reasonCd) {
        this.reasonCd = reasonCd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("typeCd", typeCd).append("subtypeCd", subtypeCd).append("reasonCd", reasonCd).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(subtypeCd).append(typeCd).append(reasonCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Status_) == false) {
            return false;
        }
        Status_ rhs = ((Status_) other);
        return new EqualsBuilder().append(subtypeCd, rhs.subtypeCd).append(typeCd, rhs.typeCd).append(reasonCd, rhs.reasonCd).isEquals();
    }

}
