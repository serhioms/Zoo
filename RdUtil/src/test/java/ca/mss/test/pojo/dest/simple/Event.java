
package ca.mss.test.pojo.dest.simple;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * DA Event
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "applicationId",
    "subApplicationId",
    "productId",
    "parentEventId",
    "productVersion",
    "partyId",
    "subApplicationSnapshotJSON",
    "subApplicationSnapshotSchemaCD",
    "eventMetaDataJSON",
    "eventMetaDataSchemaCD",
    "eventTypeCD",
    "eventStatus",
    "eventGroupId",
    "subAppStatus",
    "businessOutcomeCD",
    "alternateUserInfo",
    "subApplicationSnapshotNodePaths"
})
public class Event {

    /**
     * Id to represent an application. OCA passes uses the application id returned when application is created by Engine
     * 
     */
    @JsonProperty("applicationId")
    @JsonPropertyDescription("Id to represent an application. OCA passes uses the application id returned when application is created by Engine")
    private Integer applicationId;
    /**
     * Id to represent an application. OCA passes uses the sub application id returned when the sub application is created by Engine
     * 
     */
    @JsonProperty("subApplicationId")
    @JsonPropertyDescription("Id to represent an application. OCA passes uses the sub application id returned when the sub application is created by Engine")
    @Pattern(regexp = "^(\\s|\\S)*(\\S)+(\\s|\\S)*$")
    @Size(min = 1)
    private String subApplicationId;
    /**
     * Id to represent product
     * 
     */
    @JsonProperty("productId")
    @JsonPropertyDescription("Id to represent product")
    private String productId;
    /**
     * Id to represent parent event
     * 
     */
    @JsonProperty("parentEventId")
    @JsonPropertyDescription("Id to represent parent event")
    private String parentEventId;
    /**
     * Id to represent product
     * 
     */
    @JsonProperty("productVersion")
    @JsonPropertyDescription("Id to represent product")
    private String productVersion;
    /**
     * Id to represent party.OCA passes uses the sub application id returned when the party is created by Engine
     * 
     */
    @JsonProperty("partyId")
    @JsonPropertyDescription("Id to represent party.OCA passes uses the sub application id returned when the party is created by Engine")
    private String partyId;
    /**
     * sub application snapshot. When an event results in the application snapshot change, OCA needs to be pass in snapshot
     * 
     */
    @JsonProperty("subApplicationSnapshotJSON")
    @JsonPropertyDescription("sub application snapshot. When an event results in the application snapshot change, OCA needs to be pass in snapshot")
    private String subApplicationSnapshotJSON;
    /**
     * sub application snapshot's schema version. OCA caches this for the lob
     * 
     */
    @JsonProperty("subApplicationSnapshotSchemaCD")
    @JsonPropertyDescription("sub application snapshot's schema version. OCA caches this for the lob")
    private String subApplicationSnapshotSchemaCD;
    /**
     * json object for event metadata. 
     * 
     */
    @JsonProperty("eventMetaDataJSON")
    @JsonPropertyDescription("json object for event metadata. ")
    private String eventMetaDataJSON;
    /**
     * Schema version code for event metadata
     * 
     */
    @JsonProperty("eventMetaDataSchemaCD")
    @JsonPropertyDescription("Schema version code for event metadata")
    private String eventMetaDataSchemaCD;
    /**
     * type of the event, must present in EVENT_TYPE_LIST table. In general, only one event type code is included. When multiple events need to be handled in one transaction, multiple event type codes can be added
     * (Required)
     * 
     */
    @JsonProperty("eventTypeCD")
    @JsonPropertyDescription("type of the event, must present in EVENT_TYPE_LIST table. In general, only one event type code is included. When multiple events need to be handled in one transaction, multiple event type codes can be added")
    @Pattern(regexp = "^(\\s|\\S)*(\\S)+(\\s|\\S)*$")
    @Size(min = 1)
    @NotNull
    private String eventTypeCD;
    @JsonProperty("eventStatus")
    private String eventStatus;
    /**
     * Id to represent a event group, OCA passes in using the same if it is the same user session
     * 
     */
    @JsonProperty("eventGroupId")
    @JsonPropertyDescription("Id to represent a event group, OCA passes in using the same if it is the same user session")
    private String eventGroupId;
    /**
     * This element must be passed in if this event indicate a milestone status for the sub application, ie an SUBAPP_STATUS event need to be creatd
     * 
     */
    @JsonProperty("subAppStatus")
    @JsonPropertyDescription("This element must be passed in if this event indicate a milestone status for the sub application, ie an SUBAPP_STATUS event need to be creatd")
    private String subAppStatus;
    @JsonProperty("businessOutcomeCD")
    private String businessOutcomeCD;
    @JsonProperty("alternateUserInfo")
    @Valid
    private List<AlternateUserInfo> alternateUserInfo = new ArrayList<AlternateUserInfo>();
    @JsonProperty("subApplicationSnapshotNodePaths")
    @Valid
    private List<String> subApplicationSnapshotNodePaths = new ArrayList<String>();

    /**
     * Id to represent an application. OCA passes uses the application id returned when application is created by Engine
     * 
     */
    @JsonProperty("applicationId")
    public Integer getApplicationId() {
        return applicationId;
    }

    /**
     * Id to represent an application. OCA passes uses the application id returned when application is created by Engine
     * 
     */
    @JsonProperty("applicationId")
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * Id to represent an application. OCA passes uses the sub application id returned when the sub application is created by Engine
     * 
     */
    @JsonProperty("subApplicationId")
    public String getSubApplicationId() {
        return subApplicationId;
    }

    /**
     * Id to represent an application. OCA passes uses the sub application id returned when the sub application is created by Engine
     * 
     */
    @JsonProperty("subApplicationId")
    public void setSubApplicationId(String subApplicationId) {
        this.subApplicationId = subApplicationId;
    }

    /**
     * Id to represent product
     * 
     */
    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    /**
     * Id to represent product
     * 
     */
    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Id to represent parent event
     * 
     */
    @JsonProperty("parentEventId")
    public String getParentEventId() {
        return parentEventId;
    }

    /**
     * Id to represent parent event
     * 
     */
    @JsonProperty("parentEventId")
    public void setParentEventId(String parentEventId) {
        this.parentEventId = parentEventId;
    }

    /**
     * Id to represent product
     * 
     */
    @JsonProperty("productVersion")
    public String getProductVersion() {
        return productVersion;
    }

    /**
     * Id to represent product
     * 
     */
    @JsonProperty("productVersion")
    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    /**
     * Id to represent party.OCA passes uses the sub application id returned when the party is created by Engine
     * 
     */
    @JsonProperty("partyId")
    public String getPartyId() {
        return partyId;
    }

    /**
     * Id to represent party.OCA passes uses the sub application id returned when the party is created by Engine
     * 
     */
    @JsonProperty("partyId")
    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    /**
     * sub application snapshot. When an event results in the application snapshot change, OCA needs to be pass in snapshot
     * 
     */
    @JsonProperty("subApplicationSnapshotJSON")
    public String getSubApplicationSnapshotJSON() {
        return subApplicationSnapshotJSON;
    }

    /**
     * sub application snapshot. When an event results in the application snapshot change, OCA needs to be pass in snapshot
     * 
     */
    @JsonProperty("subApplicationSnapshotJSON")
    public void setSubApplicationSnapshotJSON(String subApplicationSnapshotJSON) {
        this.subApplicationSnapshotJSON = subApplicationSnapshotJSON;
    }

    /**
     * sub application snapshot's schema version. OCA caches this for the lob
     * 
     */
    @JsonProperty("subApplicationSnapshotSchemaCD")
    public String getSubApplicationSnapshotSchemaCD() {
        return subApplicationSnapshotSchemaCD;
    }

    /**
     * sub application snapshot's schema version. OCA caches this for the lob
     * 
     */
    @JsonProperty("subApplicationSnapshotSchemaCD")
    public void setSubApplicationSnapshotSchemaCD(String subApplicationSnapshotSchemaCD) {
        this.subApplicationSnapshotSchemaCD = subApplicationSnapshotSchemaCD;
    }

    /**
     * json object for event metadata. 
     * 
     */
    @JsonProperty("eventMetaDataJSON")
    public String getEventMetaDataJSON() {
        return eventMetaDataJSON;
    }

    /**
     * json object for event metadata. 
     * 
     */
    @JsonProperty("eventMetaDataJSON")
    public void setEventMetaDataJSON(String eventMetaDataJSON) {
        this.eventMetaDataJSON = eventMetaDataJSON;
    }

    /**
     * Schema version code for event metadata
     * 
     */
    @JsonProperty("eventMetaDataSchemaCD")
    public String getEventMetaDataSchemaCD() {
        return eventMetaDataSchemaCD;
    }

    /**
     * Schema version code for event metadata
     * 
     */
    @JsonProperty("eventMetaDataSchemaCD")
    public void setEventMetaDataSchemaCD(String eventMetaDataSchemaCD) {
        this.eventMetaDataSchemaCD = eventMetaDataSchemaCD;
    }

    /**
     * type of the event, must present in EVENT_TYPE_LIST table. In general, only one event type code is included. When multiple events need to be handled in one transaction, multiple event type codes can be added
     * (Required)
     * 
     */
    @JsonProperty("eventTypeCD")
    public String getEventTypeCD() {
        return eventTypeCD;
    }

    /**
     * type of the event, must present in EVENT_TYPE_LIST table. In general, only one event type code is included. When multiple events need to be handled in one transaction, multiple event type codes can be added
     * (Required)
     * 
     */
    @JsonProperty("eventTypeCD")
    public void setEventTypeCD(String eventTypeCD) {
        this.eventTypeCD = eventTypeCD;
    }

    @JsonProperty("eventStatus")
    public String getEventStatus() {
        return eventStatus;
    }

    @JsonProperty("eventStatus")
    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    /**
     * Id to represent a event group, OCA passes in using the same if it is the same user session
     * 
     */
    @JsonProperty("eventGroupId")
    public String getEventGroupId() {
        return eventGroupId;
    }

    /**
     * Id to represent a event group, OCA passes in using the same if it is the same user session
     * 
     */
    @JsonProperty("eventGroupId")
    public void setEventGroupId(String eventGroupId) {
        this.eventGroupId = eventGroupId;
    }

    /**
     * This element must be passed in if this event indicate a milestone status for the sub application, ie an SUBAPP_STATUS event need to be creatd
     * 
     */
    @JsonProperty("subAppStatus")
    public String getSubAppStatus() {
        return subAppStatus;
    }

    /**
     * This element must be passed in if this event indicate a milestone status for the sub application, ie an SUBAPP_STATUS event need to be creatd
     * 
     */
    @JsonProperty("subAppStatus")
    public void setSubAppStatus(String subAppStatus) {
        this.subAppStatus = subAppStatus;
    }

    @JsonProperty("businessOutcomeCD")
    public String getBusinessOutcomeCD() {
        return businessOutcomeCD;
    }

    @JsonProperty("businessOutcomeCD")
    public void setBusinessOutcomeCD(String businessOutcomeCD) {
        this.businessOutcomeCD = businessOutcomeCD;
    }

    @JsonProperty("alternateUserInfo")
    public List<AlternateUserInfo> getAlternateUserInfo() {
        return alternateUserInfo;
    }

    @JsonProperty("alternateUserInfo")
    public void setAlternateUserInfo(List<AlternateUserInfo> alternateUserInfo) {
        this.alternateUserInfo = alternateUserInfo;
    }

    @JsonProperty("subApplicationSnapshotNodePaths")
    public List<String> getSubApplicationSnapshotNodePaths() {
        return subApplicationSnapshotNodePaths;
    }

    @JsonProperty("subApplicationSnapshotNodePaths")
    public void setSubApplicationSnapshotNodePaths(List<String> subApplicationSnapshotNodePaths) {
        this.subApplicationSnapshotNodePaths = subApplicationSnapshotNodePaths;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("applicationId", applicationId).append("subApplicationId", subApplicationId).append("productId", productId).append("parentEventId", parentEventId).append("productVersion", productVersion).append("partyId", partyId).append("subApplicationSnapshotJSON", subApplicationSnapshotJSON).append("subApplicationSnapshotSchemaCD", subApplicationSnapshotSchemaCD).append("eventMetaDataJSON", eventMetaDataJSON).append("eventMetaDataSchemaCD", eventMetaDataSchemaCD).append("eventTypeCD", eventTypeCD).append("eventStatus", eventStatus).append("eventGroupId", eventGroupId).append("subAppStatus", subAppStatus).append("businessOutcomeCD", businessOutcomeCD).append("alternateUserInfo", alternateUserInfo).append("subApplicationSnapshotNodePaths", subApplicationSnapshotNodePaths).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(eventGroupId).append(businessOutcomeCD).append(productId).append(eventMetaDataJSON).append(subApplicationId).append(eventTypeCD).append(subApplicationSnapshotJSON).append(alternateUserInfo).append(productVersion).append(eventMetaDataSchemaCD).append(subAppStatus).append(subApplicationSnapshotNodePaths).append(eventStatus).append(parentEventId).append(applicationId).append(partyId).append(subApplicationSnapshotSchemaCD).toHashCode();
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
        return new EqualsBuilder().append(eventGroupId, rhs.eventGroupId).append(businessOutcomeCD, rhs.businessOutcomeCD).append(productId, rhs.productId).append(eventMetaDataJSON, rhs.eventMetaDataJSON).append(subApplicationId, rhs.subApplicationId).append(eventTypeCD, rhs.eventTypeCD).append(subApplicationSnapshotJSON, rhs.subApplicationSnapshotJSON).append(alternateUserInfo, rhs.alternateUserInfo).append(productVersion, rhs.productVersion).append(eventMetaDataSchemaCD, rhs.eventMetaDataSchemaCD).append(subAppStatus, rhs.subAppStatus).append(subApplicationSnapshotNodePaths, rhs.subApplicationSnapshotNodePaths).append(eventStatus, rhs.eventStatus).append(parentEventId, rhs.parentEventId).append(applicationId, rhs.applicationId).append(partyId, rhs.partyId).append(subApplicationSnapshotSchemaCD, rhs.subApplicationSnapshotSchemaCD).isEquals();
    }

}
