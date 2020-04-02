
package ca.mss.test.pojo.dest.complex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "eventId",
    "eventSubtypeCd",
    "startDttm",
    "endDttm",
    "activityTypeCd",
    "activitySubtypeCd",
    "accessDevice",
    "status",
    "eventToEvent",
    "fraudResolutionTypeCd",
    "fraudStatusCd",
    "fraudScore",
    "frdExtension",
    "agreement",
    "agreementEventTypeCd"
})
public class AgreementEvent {

    /**
     * The system generated unique Identifier of the EVENT.
     * 
     */
    @JsonProperty("eventId")
    @JsonPropertyDescription("The system generated unique Identifier of the EVENT.")
    private String eventId;
    /**
     * discriminator that identifies the subtype of EVENT e.g. NonFinancial, Financial.
     * (Required)
     * 
     */
    @JsonProperty("eventSubtypeCd")
    @JsonPropertyDescription("discriminator that identifies the subtype of EVENT e.g. NonFinancial, Financial.")
    @NotNull
    private String eventSubtypeCd;
    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * (Required)
     * 
     */
    @JsonProperty("startDttm")
    @JsonPropertyDescription("dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related \"timelines\", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the \u00b7value space\u00b7 of decimal, with integers given units of seconds.")
    @NotNull
	@JsonSerialize(using=ca.mss.test.pojo.dest.JsonDateSerializer.class)
    private Date startDttm;
    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * 
     */
    @JsonProperty("endDttm")
    @JsonPropertyDescription("dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related \"timelines\", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the \u00b7value space\u00b7 of decimal, with integers given units of seconds.")
	@JsonSerialize(using=ca.mss.test.pojo.dest.JsonDateSerializer.class)
    private Date endDttm;
    /**
     * A code for the type of event such as deposit, withdrawal, inquiry, payment.
     * (Required)
     * 
     */
    @JsonProperty("activityTypeCd")
    @JsonPropertyDescription("A code for the type of event such as deposit, withdrawal, inquiry, payment.")
    @NotNull
    private String activityTypeCd;
    /**
     * A code for the subtype of the event.
     * 
     */
    @JsonProperty("activitySubtypeCd")
    @JsonPropertyDescription("A code for the subtype of the event.")
    private String activitySubtypeCd;
    /**
     * A means by which a customer has access to one or more accounts. Examples of types include credit card plastic, key chain card, cell phone, and personal computer. A device may access more than one account such as both credit card and banking accounts. The device is used to access a channel hence it is not the same thing as a channel. For example, a card (device) accesses an ATM (channel) to get information about an account. Each instance represents one physical access device..
     * 
     */
    @JsonProperty("accessDevice")
    @JsonPropertyDescription("A means by which a customer has access to one or more accounts. Examples of types include credit card plastic, key chain card, cell phone, and personal computer. A device may access more than one account such as both credit card and banking accounts. The device is used to access a channel hence it is not the same thing as a channel. For example, a card (device) accesses an ATM (channel) to get information about an account. Each instance represents one physical access device..")
    @Valid
    private AccessDevice accessDevice;
    /**
     * This entity defines the response status of this event.
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("This entity defines the response status of this event.")
    @Valid
    private List<Status> status = new ArrayList<Status>();
    /**
     * A history of the relationships that exist between separate Events.
     * 
     */
    @JsonProperty("eventToEvent")
    @JsonPropertyDescription("A history of the relationships that exist between separate Events.")
    @Valid
    private List<EventToEvent> eventToEvent = new ArrayList<EventToEvent>();
    /**
     * A code for the resolution of the potential fraud case such as fraud confirmed and handed over to legal authorities, not fraudulent, in process – no resolution, and identity theft.
     * 
     */
    @JsonProperty("fraudResolutionTypeCd")
    @JsonPropertyDescription("A code for the resolution of the potential fraud case such as fraud confirmed and handed over to legal authorities, not fraudulent, in process \u2013 no resolution, and identity theft.")
    private String fraudResolutionTypeCd;
    /**
     * A code for the type of potential fraud case status.
     * 
     */
    @JsonProperty("fraudStatusCd")
    @JsonPropertyDescription("A code for the type of potential fraud case status.")
    private String fraudStatusCd;
    /**
     * Scores related to a potential fraud case such as the probability that this case is fraudulent.
     * 
     */
    @JsonProperty("fraudScore")
    @JsonPropertyDescription("Scores related to a potential fraud case such as the probability that this case is fraudulent.")
    @Valid
    private List<FraudScore> fraudScore = new ArrayList<FraudScore>();
    /**
     * Event extension data segment for FRD.
     * 
     */
    @JsonProperty("frdExtension")
    @JsonPropertyDescription("Event extension data segment for FRD.")
    @Valid
    private FrdExtension frdExtension;
    /**
     * Arrangement between two or more parties where there are terms and conditions.
     * 
     */
    @JsonProperty("agreement")
    @JsonPropertyDescription("Arrangement between two or more parties where there are terms and conditions.")
    @Valid
    private Agreement_ agreement;
    /**
     * Arrangement between two or more parties where there are terms and conditions.
     * 
     */
    @JsonProperty("agreementEventTypeCd")
    @JsonPropertyDescription("Arrangement between two or more parties where there are terms and conditions.")
    private String agreementEventTypeCd;

    /**
     * The system generated unique Identifier of the EVENT.
     * 
     */
    @JsonProperty("eventId")
    public String getEventId() {
        return eventId;
    }

    /**
     * The system generated unique Identifier of the EVENT.
     * 
     */
    @JsonProperty("eventId")
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    /**
     * discriminator that identifies the subtype of EVENT e.g. NonFinancial, Financial.
     * (Required)
     * 
     */
    @JsonProperty("eventSubtypeCd")
    public String getEventSubtypeCd() {
        return eventSubtypeCd;
    }

    /**
     * discriminator that identifies the subtype of EVENT e.g. NonFinancial, Financial.
     * (Required)
     * 
     */
    @JsonProperty("eventSubtypeCd")
    public void setEventSubtypeCd(String eventSubtypeCd) {
        this.eventSubtypeCd = eventSubtypeCd;
    }

    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * (Required)
     * 
     */
    @JsonProperty("startDttm")
    public Date getStartDttm() {
        return startDttm;
    }

    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * (Required)
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

    /**
     * A code for the type of event such as deposit, withdrawal, inquiry, payment.
     * (Required)
     * 
     */
    @JsonProperty("activityTypeCd")
    public String getActivityTypeCd() {
        return activityTypeCd;
    }

    /**
     * A code for the type of event such as deposit, withdrawal, inquiry, payment.
     * (Required)
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
     * A means by which a customer has access to one or more accounts. Examples of types include credit card plastic, key chain card, cell phone, and personal computer. A device may access more than one account such as both credit card and banking accounts. The device is used to access a channel hence it is not the same thing as a channel. For example, a card (device) accesses an ATM (channel) to get information about an account. Each instance represents one physical access device..
     * 
     */
    @JsonProperty("accessDevice")
    public AccessDevice getAccessDevice() {
        return accessDevice;
    }

    /**
     * A means by which a customer has access to one or more accounts. Examples of types include credit card plastic, key chain card, cell phone, and personal computer. A device may access more than one account such as both credit card and banking accounts. The device is used to access a channel hence it is not the same thing as a channel. For example, a card (device) accesses an ATM (channel) to get information about an account. Each instance represents one physical access device..
     * 
     */
    @JsonProperty("accessDevice")
    public void setAccessDevice(AccessDevice accessDevice) {
        this.accessDevice = accessDevice;
    }

    /**
     * This entity defines the response status of this event.
     * 
     */
    @JsonProperty("status")
    public List<Status> getStatus() {
        return status;
    }

    /**
     * This entity defines the response status of this event.
     * 
     */
    @JsonProperty("status")
    public void setStatus(List<Status> status) {
        this.status = status;
    }

    /**
     * A history of the relationships that exist between separate Events.
     * 
     */
    @JsonProperty("eventToEvent")
    public List<EventToEvent> getEventToEvent() {
        return eventToEvent;
    }

    /**
     * A history of the relationships that exist between separate Events.
     * 
     */
    @JsonProperty("eventToEvent")
    public void setEventToEvent(List<EventToEvent> eventToEvent) {
        this.eventToEvent = eventToEvent;
    }

    /**
     * A code for the resolution of the potential fraud case such as fraud confirmed and handed over to legal authorities, not fraudulent, in process – no resolution, and identity theft.
     * 
     */
    @JsonProperty("fraudResolutionTypeCd")
    public String getFraudResolutionTypeCd() {
        return fraudResolutionTypeCd;
    }

    /**
     * A code for the resolution of the potential fraud case such as fraud confirmed and handed over to legal authorities, not fraudulent, in process – no resolution, and identity theft.
     * 
     */
    @JsonProperty("fraudResolutionTypeCd")
    public void setFraudResolutionTypeCd(String fraudResolutionTypeCd) {
        this.fraudResolutionTypeCd = fraudResolutionTypeCd;
    }

    /**
     * A code for the type of potential fraud case status.
     * 
     */
    @JsonProperty("fraudStatusCd")
    public String getFraudStatusCd() {
        return fraudStatusCd;
    }

    /**
     * A code for the type of potential fraud case status.
     * 
     */
    @JsonProperty("fraudStatusCd")
    public void setFraudStatusCd(String fraudStatusCd) {
        this.fraudStatusCd = fraudStatusCd;
    }

    /**
     * Scores related to a potential fraud case such as the probability that this case is fraudulent.
     * 
     */
    @JsonProperty("fraudScore")
    public List<FraudScore> getFraudScore() {
        return fraudScore;
    }

    /**
     * Scores related to a potential fraud case such as the probability that this case is fraudulent.
     * 
     */
    @JsonProperty("fraudScore")
    public void setFraudScore(List<FraudScore> fraudScore) {
        this.fraudScore = fraudScore;
    }

    /**
     * Event extension data segment for FRD.
     * 
     */
    @JsonProperty("frdExtension")
    public FrdExtension getFrdExtension() {
        return frdExtension;
    }

    /**
     * Event extension data segment for FRD.
     * 
     */
    @JsonProperty("frdExtension")
    public void setFrdExtension(FrdExtension frdExtension) {
        this.frdExtension = frdExtension;
    }

    /**
     * Arrangement between two or more parties where there are terms and conditions.
     * 
     */
    @JsonProperty("agreement")
    public Agreement_ getAgreement() {
        return agreement;
    }

    /**
     * Arrangement between two or more parties where there are terms and conditions.
     * 
     */
    @JsonProperty("agreement")
    public void setAgreement(Agreement_ agreement) {
        this.agreement = agreement;
    }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("eventId", eventId).append("eventSubtypeCd", eventSubtypeCd).append("startDttm", startDttm).append("endDttm", endDttm).append("activityTypeCd", activityTypeCd).append("activitySubtypeCd", activitySubtypeCd).append("accessDevice", accessDevice).append("status", status).append("eventToEvent", eventToEvent).append("fraudResolutionTypeCd", fraudResolutionTypeCd).append("fraudStatusCd", fraudStatusCd).append("fraudScore", fraudScore).append("frdExtension", frdExtension).append("agreement", agreement).append("agreementEventTypeCd", agreementEventTypeCd).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(eventId).append(activitySubtypeCd).append(fraudResolutionTypeCd).append(fraudScore).append(agreement).append(startDttm).append(eventToEvent).append(endDttm).append(agreementEventTypeCd).append(fraudStatusCd).append(activityTypeCd).append(accessDevice).append(eventSubtypeCd).append(frdExtension).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgreementEvent) == false) {
            return false;
        }
        AgreementEvent rhs = ((AgreementEvent) other);
        return new EqualsBuilder().append(eventId, rhs.eventId).append(activitySubtypeCd, rhs.activitySubtypeCd).append(fraudResolutionTypeCd, rhs.fraudResolutionTypeCd).append(fraudScore, rhs.fraudScore).append(agreement, rhs.agreement).append(startDttm, rhs.startDttm).append(eventToEvent, rhs.eventToEvent).append(endDttm, rhs.endDttm).append(agreementEventTypeCd, rhs.agreementEventTypeCd).append(fraudStatusCd, rhs.fraudStatusCd).append(activityTypeCd, rhs.activityTypeCd).append(accessDevice, rhs.accessDevice).append(eventSubtypeCd, rhs.eventSubtypeCd).append(frdExtension, rhs.frdExtension).append(status, rhs.status).isEquals();
    }

}
