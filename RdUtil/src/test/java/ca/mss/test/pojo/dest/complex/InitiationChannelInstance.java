
package ca.mss.test.pojo.dest.complex;

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
 * Specific channel that user initiates interaction.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sourceSessionId",
    "channelInstanceId",
    "channelTypeCd",
    "locatorId",
    "organizationName",
    "softwareApplication"
})
public class InitiationChannelInstance {

    /**
     * This is a unique identifier denoting the session identifier utilized by the source data provider.
     * 
     */
    @JsonProperty("sourceSessionId")
    @JsonPropertyDescription("This is a unique identifier denoting the session identifier utilized by the source data provider.")
    private String sourceSessionId;
    /**
     * The unique identifier for the specific channel instance e.g. terminal workstation id.
     * 
     */
    @JsonProperty("channelInstanceId")
    @JsonPropertyDescription("The unique identifier for the specific channel instance e.g. terminal workstation id.")
    private String channelInstanceId;
    /**
     * A code for the type of channel e.g. self or full serve.
     * 
     */
    @JsonProperty("channelTypeCd")
    @JsonPropertyDescription("A code for the type of channel e.g. self or full serve.")
    private String channelTypeCd;
    /**
     * Location of channel instance where transaction was originated.
     * 
     */
    @JsonProperty("locatorId")
    @JsonPropertyDescription("Location of channel instance where transaction was originated.")
    private String locatorId;
    /**
     * Initiating organization unit within the bank.
     * 
     */
    @JsonProperty("organizationName")
    @JsonPropertyDescription("Initiating organization unit within the bank.")
    private String organizationName;
    /**
     * Software application of initiating channel.
     * (Required)
     * 
     */
    @JsonProperty("softwareApplication")
    @JsonPropertyDescription("Software application of initiating channel.")
    @Valid
    @NotNull
    private SoftwareApplication softwareApplication;

    /**
     * This is a unique identifier denoting the session identifier utilized by the source data provider.
     * 
     */
    @JsonProperty("sourceSessionId")
    public String getSourceSessionId() {
        return sourceSessionId;
    }

    /**
     * This is a unique identifier denoting the session identifier utilized by the source data provider.
     * 
     */
    @JsonProperty("sourceSessionId")
    public void setSourceSessionId(String sourceSessionId) {
        this.sourceSessionId = sourceSessionId;
    }

    /**
     * The unique identifier for the specific channel instance e.g. terminal workstation id.
     * 
     */
    @JsonProperty("channelInstanceId")
    public String getChannelInstanceId() {
        return channelInstanceId;
    }

    /**
     * The unique identifier for the specific channel instance e.g. terminal workstation id.
     * 
     */
    @JsonProperty("channelInstanceId")
    public void setChannelInstanceId(String channelInstanceId) {
        this.channelInstanceId = channelInstanceId;
    }

    /**
     * A code for the type of channel e.g. self or full serve.
     * 
     */
    @JsonProperty("channelTypeCd")
    public String getChannelTypeCd() {
        return channelTypeCd;
    }

    /**
     * A code for the type of channel e.g. self or full serve.
     * 
     */
    @JsonProperty("channelTypeCd")
    public void setChannelTypeCd(String channelTypeCd) {
        this.channelTypeCd = channelTypeCd;
    }

    /**
     * Location of channel instance where transaction was originated.
     * 
     */
    @JsonProperty("locatorId")
    public String getLocatorId() {
        return locatorId;
    }

    /**
     * Location of channel instance where transaction was originated.
     * 
     */
    @JsonProperty("locatorId")
    public void setLocatorId(String locatorId) {
        this.locatorId = locatorId;
    }

    /**
     * Initiating organization unit within the bank.
     * 
     */
    @JsonProperty("organizationName")
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Initiating organization unit within the bank.
     * 
     */
    @JsonProperty("organizationName")
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    /**
     * Software application of initiating channel.
     * (Required)
     * 
     */
    @JsonProperty("softwareApplication")
    public SoftwareApplication getSoftwareApplication() {
        return softwareApplication;
    }

    /**
     * Software application of initiating channel.
     * (Required)
     * 
     */
    @JsonProperty("softwareApplication")
    public void setSoftwareApplication(SoftwareApplication softwareApplication) {
        this.softwareApplication = softwareApplication;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sourceSessionId", sourceSessionId).append("channelInstanceId", channelInstanceId).append("channelTypeCd", channelTypeCd).append("locatorId", locatorId).append("organizationName", organizationName).append("softwareApplication", softwareApplication).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(organizationName).append(channelInstanceId).append(locatorId).append(sourceSessionId).append(channelTypeCd).append(softwareApplication).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InitiationChannelInstance) == false) {
            return false;
        }
        InitiationChannelInstance rhs = ((InitiationChannelInstance) other);
        return new EqualsBuilder().append(organizationName, rhs.organizationName).append(channelInstanceId, rhs.channelInstanceId).append(locatorId, rhs.locatorId).append(sourceSessionId, rhs.sourceSessionId).append(channelTypeCd, rhs.channelTypeCd).append(softwareApplication, rhs.softwareApplication).isEquals();
    }

}
