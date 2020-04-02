
package ca.mss.test.pojo.dest.complex;

import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Event caused by having contact with the Financial Institution either of a
 * personal nature where an employee talks to the customer, or an impersonal
 * nature where the customer uses the ATM or automatic call center orany other touch point.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "startDttm",
    "userInfo",
    "initiationLocatorId",
    "destinationLocatorId",
    "initiationChannelInstance",
    "authenticationInfo"
})
public class ContactEvent {

    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * 
     */
    @JsonProperty("startDttm")
    @JsonPropertyDescription("dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related \"timelines\", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the \u00b7value space\u00b7 of decimal, with integers given units of seconds.")
    private Date startDttm;
    /**
     * User who initiated the contact with enterprise.
     * 
     */
    @JsonProperty("userInfo")
    @JsonPropertyDescription("User who initiated the contact with enterprise.")
    @Valid
    private UserInfo userInfo;
    /**
     * Origin location of user contact e.g. user IP Address for Web, phone number calling for Phone Channel.
     * 
     */
    @JsonProperty("initiationLocatorId")
    @JsonPropertyDescription("Origin location of user contact e.g. user IP Address for Web, phone number calling for Phone Channel.")
    private String initiationLocatorId;
    /**
     * Target location of user interaction e.g. phone number called for phone Channel
     * 
     */
    @JsonProperty("destinationLocatorId")
    @JsonPropertyDescription("Target location of user interaction e.g. phone number called for phone Channel")
    private String destinationLocatorId;
    /**
     * Specific channel that user initiates interaction.
     * (Required)
     * 
     */
    @JsonProperty("initiationChannelInstance")
    @JsonPropertyDescription("Specific channel that user initiates interaction.")
    @Valid
    @NotNull
    private InitiationChannelInstance initiationChannelInstance;
    /**
     * User authentication information.
     * (Required)
     * 
     */
    @JsonProperty("authenticationInfo")
    @JsonPropertyDescription("User authentication information.")
    @Valid
    @NotNull
    private AuthenticationInfo authenticationInfo;

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
     * User who initiated the contact with enterprise.
     * 
     */
    @JsonProperty("userInfo")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * User who initiated the contact with enterprise.
     * 
     */
    @JsonProperty("userInfo")
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * Origin location of user contact e.g. user IP Address for Web, phone number calling for Phone Channel.
     * 
     */
    @JsonProperty("initiationLocatorId")
    public String getInitiationLocatorId() {
        return initiationLocatorId;
    }

    /**
     * Origin location of user contact e.g. user IP Address for Web, phone number calling for Phone Channel.
     * 
     */
    @JsonProperty("initiationLocatorId")
    public void setInitiationLocatorId(String initiationLocatorId) {
        this.initiationLocatorId = initiationLocatorId;
    }

    /**
     * Target location of user interaction e.g. phone number called for phone Channel
     * 
     */
    @JsonProperty("destinationLocatorId")
    public String getDestinationLocatorId() {
        return destinationLocatorId;
    }

    /**
     * Target location of user interaction e.g. phone number called for phone Channel
     * 
     */
    @JsonProperty("destinationLocatorId")
    public void setDestinationLocatorId(String destinationLocatorId) {
        this.destinationLocatorId = destinationLocatorId;
    }

    /**
     * Specific channel that user initiates interaction.
     * (Required)
     * 
     */
    @JsonProperty("initiationChannelInstance")
    public InitiationChannelInstance getInitiationChannelInstance() {
        return initiationChannelInstance;
    }

    /**
     * Specific channel that user initiates interaction.
     * (Required)
     * 
     */
    @JsonProperty("initiationChannelInstance")
    public void setInitiationChannelInstance(InitiationChannelInstance initiationChannelInstance) {
        this.initiationChannelInstance = initiationChannelInstance;
    }

    /**
     * User authentication information.
     * (Required)
     * 
     */
    @JsonProperty("authenticationInfo")
    public AuthenticationInfo getAuthenticationInfo() {
        return authenticationInfo;
    }

    /**
     * User authentication information.
     * (Required)
     * 
     */
    @JsonProperty("authenticationInfo")
    public void setAuthenticationInfo(AuthenticationInfo authenticationInfo) {
        this.authenticationInfo = authenticationInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("startDttm", startDttm).append("userInfo", userInfo).append("initiationLocatorId", initiationLocatorId).append("destinationLocatorId", destinationLocatorId).append("initiationChannelInstance", initiationChannelInstance).append("authenticationInfo", authenticationInfo).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(destinationLocatorId).append(userInfo).append(authenticationInfo).append(initiationChannelInstance).append(startDttm).append(initiationLocatorId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ContactEvent) == false) {
            return false;
        }
        ContactEvent rhs = ((ContactEvent) other);
        return new EqualsBuilder().append(destinationLocatorId, rhs.destinationLocatorId).append(userInfo, rhs.userInfo).append(authenticationInfo, rhs.authenticationInfo).append(initiationChannelInstance, rhs.initiationChannelInstance).append(startDttm, rhs.startDttm).append(initiationLocatorId, rhs.initiationLocatorId).isEquals();
    }

}
