
package ca.mss.test.pojo.dest.complex;

import java.util.Date;
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
    "relatedEventId",
    "eventSubtypeCd",
    "activityTypeCd",
    "activitySubtypeCd",
    "reasonCd",
    "startDttm",
    "endDttm"
})
public class RelatedEvent_ {

    /**
     * This is the other event in the relationship.
     * 
     */
    @JsonProperty("relatedEventId")
    @JsonPropertyDescription("This is the other event in the relationship.")
    private String relatedEventId;
    /**
     * Discriminator that identifies the subtype of EVENT e.g. NonFinancial, Financial.
     * 
     */
    @JsonProperty("eventSubtypeCd")
    @JsonPropertyDescription("Discriminator that identifies the subtype of EVENT e.g. NonFinancial, Financial.")
    private String eventSubtypeCd;
    /**
     * A code for the type of event such as alert, consent, deposit, withdrawal, inquiry, payment.
     * 
     */
    @JsonProperty("activityTypeCd")
    @JsonPropertyDescription("A code for the type of event such as alert, consent, deposit, withdrawal, inquiry, payment.")
    private String activityTypeCd;
    /**
     * A code for the subtype of the event.
     * 
     */
    @JsonProperty("activitySubtypeCd")
    @JsonPropertyDescription("A code for the subtype of the event.")
    private String activitySubtypeCd;
    /**
     * A code for the type of relationship that one event has with another event. For example, one event could be the follow-up to another event.
     * 
     */
    @JsonProperty("reasonCd")
    @JsonPropertyDescription("A code for the type of relationship that one event has with another event. For example, one event could be the follow-up to another event.")
    private String reasonCd;
    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * 
     */
    @JsonProperty("startDttm")
    @JsonPropertyDescription("dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related \"timelines\", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the \u00b7value space\u00b7 of decimal, with integers given units of seconds.")
    private Date startDttm;
    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * 
     */
    @JsonProperty("endDttm")
    @JsonPropertyDescription("dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related \"timelines\", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the \u00b7value space\u00b7 of decimal, with integers given units of seconds.")
    private Date endDttm;

    /**
     * This is the other event in the relationship.
     * 
     */
    @JsonProperty("relatedEventId")
    public String getRelatedEventId() {
        return relatedEventId;
    }

    /**
     * This is the other event in the relationship.
     * 
     */
    @JsonProperty("relatedEventId")
    public void setRelatedEventId(String relatedEventId) {
        this.relatedEventId = relatedEventId;
    }

    /**
     * Discriminator that identifies the subtype of EVENT e.g. NonFinancial, Financial.
     * 
     */
    @JsonProperty("eventSubtypeCd")
    public String getEventSubtypeCd() {
        return eventSubtypeCd;
    }

    /**
     * Discriminator that identifies the subtype of EVENT e.g. NonFinancial, Financial.
     * 
     */
    @JsonProperty("eventSubtypeCd")
    public void setEventSubtypeCd(String eventSubtypeCd) {
        this.eventSubtypeCd = eventSubtypeCd;
    }

    /**
     * A code for the type of event such as alert, consent, deposit, withdrawal, inquiry, payment.
     * 
     */
    @JsonProperty("activityTypeCd")
    public String getActivityTypeCd() {
        return activityTypeCd;
    }

    /**
     * A code for the type of event such as alert, consent, deposit, withdrawal, inquiry, payment.
     * 
     */
    @JsonProperty("activityTypeCd")
    public void setActivityTypeCd(String activityTypeCd) {
        this.activityTypeCd = activityTypeCd;
    }

    /**
     * A code for the subtype of the event.
     * 
     */
    @JsonProperty("activitySubtypeCd")
    public String getActivitySubtypeCd() {
        return activitySubtypeCd;
    }

    /**
     * A code for the subtype of the event.
     * 
     */
    @JsonProperty("activitySubtypeCd")
    public void setActivitySubtypeCd(String activitySubtypeCd) {
        this.activitySubtypeCd = activitySubtypeCd;
    }

    /**
     * A code for the type of relationship that one event has with another event. For example, one event could be the follow-up to another event.
     * 
     */
    @JsonProperty("reasonCd")
    public String getReasonCd() {
        return reasonCd;
    }

    /**
     * A code for the type of relationship that one event has with another event. For example, one event could be the follow-up to another event.
     * 
     */
    @JsonProperty("reasonCd")
    public void setReasonCd(String reasonCd) {
        this.reasonCd = reasonCd;
    }

    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * 
     */
    @JsonProperty("startDttm")
    public Date getStartDttm() {
        return startDttm;
    }

    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * 
     */
    @JsonProperty("startDttm")
    public void setStartDttm(Date startDttm) {
        this.startDttm = startDttm;
    }

    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * 
     */
    @JsonProperty("endDttm")
    public Date getEndDttm() {
        return endDttm;
    }

    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * 
     */
    @JsonProperty("endDttm")
    public void setEndDttm(Date endDttm) {
        this.endDttm = endDttm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("relatedEventId", relatedEventId).append("eventSubtypeCd", eventSubtypeCd).append("activityTypeCd", activityTypeCd).append("activitySubtypeCd", activitySubtypeCd).append("reasonCd", reasonCd).append("startDttm", startDttm).append("endDttm", endDttm).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(activityTypeCd).append(relatedEventId).append(eventSubtypeCd).append(activitySubtypeCd).append(startDttm).append(endDttm).append(reasonCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RelatedEvent_) == false) {
            return false;
        }
        RelatedEvent_ rhs = ((RelatedEvent_) other);
        return new EqualsBuilder().append(activityTypeCd, rhs.activityTypeCd).append(relatedEventId, rhs.relatedEventId).append(eventSubtypeCd, rhs.eventSubtypeCd).append(activitySubtypeCd, rhs.activitySubtypeCd).append(startDttm, rhs.startDttm).append(endDttm, rhs.endDttm).append(reasonCd, rhs.reasonCd).isEquals();
    }

}
