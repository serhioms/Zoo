package ca.mss.test.pojo.dest;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "eventId",
    "parentEventId",
    "eventGroupCd",
    "eventTypeCd",
    "applicationId",
    "subApplicationId",
    "eventStatusCd",
    "eventTmstmp",
    "partyId",
    "partyRoleCd",
    "auditId",
    "eventMetaDataJSON",
    "businessOutcomeCd",
    "eventJsonSchemaCd",
    "subApplicationSnapshotTmstmp",
    "subApplicationSnapshot",
    "productTypeCd",
    "lobCd"
})
public class Event implements Serializable
{

    /**
     * Id to represent an event.
     * 
     */
    @JsonProperty("eventId")
    @JsonPropertyDescription("Id to represent an event.")
    private String eventId;
    /**
     * Id to represent parent event
     * 
     */
    @JsonProperty("parentEventId")
    @JsonPropertyDescription("Id to represent parent event")
    private String parentEventId;
    /**
     * Code to represent a event group, OCA passes in using the same if it is the same user session
     * 
     */
    @JsonProperty("eventGroupCd")
    @JsonPropertyDescription("Code to represent a event group, OCA passes in using the same if it is the same user session")
    private String eventGroupCd;
    /**
     * type of the event, must present in EVENT_TYPE_LIST table. In general, only one event type code is included. When multiple events need to be handled in one transaction, multiple event type codes can be added
     * 
     */
    @JsonProperty("eventTypeCd")
    @JsonPropertyDescription("type of the event, must present in EVENT_TYPE_LIST table. In general, only one event type code is included. When multiple events need to be handled in one transaction, multiple event type codes can be added")
    private String eventTypeCd;
    /**
     * Id to represent an application.
     * 
     */
    @JsonProperty("applicationId")
    @JsonPropertyDescription("Id to represent an application.")
    private String applicationId;
    /**
     * Id to represent an application.
     * 
     */
    @JsonProperty("subApplicationId")
    @JsonPropertyDescription("Id to represent an application.")
    private String subApplicationId;
    /**
     * Event status code
     * 
     */
    @JsonProperty("eventStatusCd")
    @JsonPropertyDescription("Event status code")
    private String eventStatusCd;
    /**
     * Event time stamp
     * 
     */
    @JsonProperty("eventTmstmp")
    @JsonPropertyDescription("Event time stamp")
    private String eventTmstmp;
    /**
     * DA Party Id of Party, for back ward compatibility the name has been kept as partyId.
     * 
     */
    @JsonProperty("partyId")
    @JsonPropertyDescription("DA Party Id of Party, for back ward compatibility the name has been kept as partyId.")
    private String partyId;
    /**
     * Type of party id.
     * 
     */
    @JsonProperty("partyRoleCd")
    @JsonPropertyDescription("Type of party id.")
    private String partyRoleCd;
    /**
     * Id to represent audit
     * 
     */
    @JsonProperty("auditId")
    @JsonPropertyDescription("Id to represent audit")
    private String auditId;
    /**
     * json object for event metadata. 
     * 
     */
    @JsonProperty("eventMetaDataJSON")
    @JsonPropertyDescription("json object for event metadata. ")
    private String eventMetaDataJSON;
    /**
     * Business Outcome code
     * 
     */
    @JsonProperty("businessOutcomeCd")
    @JsonPropertyDescription("Business Outcome code")
    private String businessOutcomeCd;
    /**
     * Event json schema code.
     * 
     */
    @JsonProperty("eventJsonSchemaCd")
    @JsonPropertyDescription("Event json schema code.")
    private String eventJsonSchemaCd;
    /**
     * Sub application time stamp
     * 
     */
    @JsonProperty("subApplicationSnapshotTmstmp")
    @JsonPropertyDescription("Sub application time stamp")
    private String subApplicationSnapshotTmstmp;
    /**
     * Sub application snapshot.
     * 
     */
    @JsonProperty("subApplicationSnapshot")
    @JsonPropertyDescription("Sub application snapshot.")
    private String subApplicationSnapshot;
    /**
     * Product type code.
     * 
     */
    @JsonProperty("productTypeCd")
    @JsonPropertyDescription("Product type code.")
    private String productTypeCd;
    /**
     * Line of business code.
     * 
     */
    @JsonProperty("lobCd")
    @JsonPropertyDescription("Line of business code.")
    private String lobCd;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5872145372991247864L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Event() {
    }

    /**
     * 
     * @param auditId
     * @param productTypeCd
     * @param eventId
     * @param eventTmstmp
     * @param businessOutcomeCd
     * @param eventMetaDataJSON
     * @param lobCd
     * @param eventGroupCd
     * @param subApplicationId
     * @param eventTypeCd
     * @param partyRoleCd
     * @param subApplicationSnapshotTmstmp
     * @param eventJsonSchemaCd
     * @param parentEventId
     * @param applicationId
     * @param partyId
     * @param subApplicationSnapshot
     * @param eventStatusCd
     */
    public Event(String eventId, String parentEventId, String eventGroupCd, String eventTypeCd, String applicationId, String subApplicationId, String eventStatusCd, String eventTmstmp, String partyId, String partyRoleCd, String auditId, String eventMetaDataJSON, String businessOutcomeCd, String eventJsonSchemaCd, String subApplicationSnapshotTmstmp, String subApplicationSnapshot, String productTypeCd, String lobCd) {
        super();
        this.eventId = eventId;
        this.parentEventId = parentEventId;
        this.eventGroupCd = eventGroupCd;
        this.eventTypeCd = eventTypeCd;
        this.applicationId = applicationId;
        this.subApplicationId = subApplicationId;
        this.eventStatusCd = eventStatusCd;
        this.eventTmstmp = eventTmstmp;
        this.partyId = partyId;
        this.partyRoleCd = partyRoleCd;
        this.auditId = auditId;
        this.eventMetaDataJSON = eventMetaDataJSON;
        this.businessOutcomeCd = businessOutcomeCd;
        this.eventJsonSchemaCd = eventJsonSchemaCd;
        this.subApplicationSnapshotTmstmp = subApplicationSnapshotTmstmp;
        this.subApplicationSnapshot = subApplicationSnapshot;
        this.productTypeCd = productTypeCd;
        this.lobCd = lobCd;
    }

    /**
     * Id to represent an event.
     * 
     */
    @JsonProperty("eventId")
    public String getEventId() {
        return eventId;
    }

    /**
     * Id to represent an event.
     * 
     */
    @JsonProperty("eventId")
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Event withEventId(String eventId) {
        this.eventId = eventId;
        return this;
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

    public Event withParentEventId(String parentEventId) {
        this.parentEventId = parentEventId;
        return this;
    }

    /**
     * Code to represent a event group, OCA passes in using the same if it is the same user session
     * 
     */
    @JsonProperty("eventGroupCd")
    public String getEventGroupCd() {
        return eventGroupCd;
    }

    /**
     * Code to represent a event group, OCA passes in using the same if it is the same user session
     * 
     */
    @JsonProperty("eventGroupCd")
    public void setEventGroupCd(String eventGroupCd) {
        this.eventGroupCd = eventGroupCd;
    }

    public Event withEventGroupCd(String eventGroupCd) {
        this.eventGroupCd = eventGroupCd;
        return this;
    }

    /**
     * type of the event, must present in EVENT_TYPE_LIST table. In general, only one event type code is included. When multiple events need to be handled in one transaction, multiple event type codes can be added
     * 
     */
    @JsonProperty("eventTypeCd")
    public String getEventTypeCd() {
        return eventTypeCd;
    }

    /**
     * type of the event, must present in EVENT_TYPE_LIST table. In general, only one event type code is included. When multiple events need to be handled in one transaction, multiple event type codes can be added
     * 
     */
    @JsonProperty("eventTypeCd")
    public void setEventTypeCd(String eventTypeCd) {
        this.eventTypeCd = eventTypeCd;
    }

    public Event withEventTypeCd(String eventTypeCd) {
        this.eventTypeCd = eventTypeCd;
        return this;
    }

    /**
     * Id to represent an application.
     * 
     */
    @JsonProperty("applicationId")
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Id to represent an application.
     * 
     */
    @JsonProperty("applicationId")
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Event withApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    /**
     * Id to represent an application.
     * 
     */
    @JsonProperty("subApplicationId")
    public String getSubApplicationId() {
        return subApplicationId;
    }

    /**
     * Id to represent an application.
     * 
     */
    @JsonProperty("subApplicationId")
    public void setSubApplicationId(String subApplicationId) {
        this.subApplicationId = subApplicationId;
    }

    public Event withSubApplicationId(String subApplicationId) {
        this.subApplicationId = subApplicationId;
        return this;
    }

    /**
     * Event status code
     * 
     */
    @JsonProperty("eventStatusCd")
    public String getEventStatusCd() {
        return eventStatusCd;
    }

    /**
     * Event status code
     * 
     */
    @JsonProperty("eventStatusCd")
    public void setEventStatusCd(String eventStatusCd) {
        this.eventStatusCd = eventStatusCd;
    }

    public Event withEventStatusCd(String eventStatusCd) {
        this.eventStatusCd = eventStatusCd;
        return this;
    }

    /**
     * Event time stamp
     * 
     */
    @JsonProperty("eventTmstmp")
    public String getEventTmstmp() {
        return eventTmstmp;
    }

    /**
     * Event time stamp
     * 
     */
    @JsonProperty("eventTmstmp")
    public void setEventTmstmp(String eventTmstmp) {
        this.eventTmstmp = eventTmstmp;
    }

    public Event withEventTmstmp(String eventTmstmp) {
        this.eventTmstmp = eventTmstmp;
        return this;
    }

    /**
     * DA Party Id of Party, for back ward compatibility the name has been kept as partyId.
     * 
     */
    @JsonProperty("partyId")
    public String getPartyId() {
        return partyId;
    }

    /**
     * DA Party Id of Party, for back ward compatibility the name has been kept as partyId.
     * 
     */
    @JsonProperty("partyId")
    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public Event withPartyId(String partyId) {
        this.partyId = partyId;
        return this;
    }

    /**
     * Type of party id.
     * 
     */
    @JsonProperty("partyRoleCd")
    public String getPartyRoleCd() {
        return partyRoleCd;
    }

    /**
     * Type of party id.
     * 
     */
    @JsonProperty("partyRoleCd")
    public void setPartyRoleCd(String partyRoleCd) {
        this.partyRoleCd = partyRoleCd;
    }

    public Event withPartyRoleCd(String partyRoleCd) {
        this.partyRoleCd = partyRoleCd;
        return this;
    }

    /**
     * Id to represent audit
     * 
     */
    @JsonProperty("auditId")
    public String getAuditId() {
        return auditId;
    }

    /**
     * Id to represent audit
     * 
     */
    @JsonProperty("auditId")
    public void setAuditId(String auditId) {
        this.auditId = auditId;
    }

    public Event withAuditId(String auditId) {
        this.auditId = auditId;
        return this;
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

    public Event withEventMetaDataJSON(String eventMetaDataJSON) {
        this.eventMetaDataJSON = eventMetaDataJSON;
        return this;
    }

    /**
     * Business Outcome code
     * 
     */
    @JsonProperty("businessOutcomeCd")
    public String getBusinessOutcomeCd() {
        return businessOutcomeCd;
    }

    /**
     * Business Outcome code
     * 
     */
    @JsonProperty("businessOutcomeCd")
    public void setBusinessOutcomeCd(String businessOutcomeCd) {
        this.businessOutcomeCd = businessOutcomeCd;
    }

    public Event withBusinessOutcomeCd(String businessOutcomeCd) {
        this.businessOutcomeCd = businessOutcomeCd;
        return this;
    }

    /**
     * Event json schema code.
     * 
     */
    @JsonProperty("eventJsonSchemaCd")
    public String getEventJsonSchemaCd() {
        return eventJsonSchemaCd;
    }

    /**
     * Event json schema code.
     * 
     */
    @JsonProperty("eventJsonSchemaCd")
    public void setEventJsonSchemaCd(String eventJsonSchemaCd) {
        this.eventJsonSchemaCd = eventJsonSchemaCd;
    }

    public Event withEventJsonSchemaCd(String eventJsonSchemaCd) {
        this.eventJsonSchemaCd = eventJsonSchemaCd;
        return this;
    }

    /**
     * Sub application time stamp
     * 
     */
    @JsonProperty("subApplicationSnapshotTmstmp")
    public String getSubApplicationSnapshotTmstmp() {
        return subApplicationSnapshotTmstmp;
    }

    /**
     * Sub application time stamp
     * 
     */
    @JsonProperty("subApplicationSnapshotTmstmp")
    public void setSubApplicationSnapshotTmstmp(String subApplicationSnapshotTmstmp) {
        this.subApplicationSnapshotTmstmp = subApplicationSnapshotTmstmp;
    }

    public Event withSubApplicationSnapshotTmstmp(String subApplicationSnapshotTmstmp) {
        this.subApplicationSnapshotTmstmp = subApplicationSnapshotTmstmp;
        return this;
    }

    /**
     * Sub application snapshot.
     * 
     */
    @JsonProperty("subApplicationSnapshot")
    public String getSubApplicationSnapshot() {
        return subApplicationSnapshot;
    }

    /**
     * Sub application snapshot.
     * 
     */
    @JsonProperty("subApplicationSnapshot")
    public void setSubApplicationSnapshot(String subApplicationSnapshot) {
        this.subApplicationSnapshot = subApplicationSnapshot;
    }

    public Event withSubApplicationSnapshot(String subApplicationSnapshot) {
        this.subApplicationSnapshot = subApplicationSnapshot;
        return this;
    }

    /**
     * Product type code.
     * 
     */
    @JsonProperty("productTypeCd")
    public String getProductTypeCd() {
        return productTypeCd;
    }

    /**
     * Product type code.
     * 
     */
    @JsonProperty("productTypeCd")
    public void setProductTypeCd(String productTypeCd) {
        this.productTypeCd = productTypeCd;
    }

    public Event withProductTypeCd(String productTypeCd) {
        this.productTypeCd = productTypeCd;
        return this;
    }

    /**
     * Line of business code.
     * 
     */
    @JsonProperty("lobCd")
    public String getLobCd() {
        return lobCd;
    }

    /**
     * Line of business code.
     * 
     */
    @JsonProperty("lobCd")
    public void setLobCd(String lobCd) {
        this.lobCd = lobCd;
    }

    public Event withLobCd(String lobCd) {
        this.lobCd = lobCd;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Event withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("eventId", eventId).append("parentEventId", parentEventId).append("eventGroupCd", eventGroupCd).append("eventTypeCd", eventTypeCd).append("applicationId", applicationId).append("subApplicationId", subApplicationId).append("eventStatusCd", eventStatusCd).append("eventTmstmp", eventTmstmp).append("partyId", partyId).append("partyRoleCd", partyRoleCd).append("auditId", auditId).append("eventMetaDataJSON", eventMetaDataJSON).append("businessOutcomeCd", businessOutcomeCd).append("eventJsonSchemaCd", eventJsonSchemaCd).append("subApplicationSnapshotTmstmp", subApplicationSnapshotTmstmp).append("subApplicationSnapshot", subApplicationSnapshot).append("productTypeCd", productTypeCd).append("lobCd", lobCd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(auditId).append(productTypeCd).append(eventId).append(eventTmstmp).append(businessOutcomeCd).append(eventMetaDataJSON).append(lobCd).append(eventGroupCd).append(subApplicationId).append(eventTypeCd).append(partyRoleCd).append(subApplicationSnapshotTmstmp).append(eventJsonSchemaCd).append(parentEventId).append(additionalProperties).append(applicationId).append(partyId).append(subApplicationSnapshot).append(eventStatusCd).toHashCode();
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
        return new EqualsBuilder().append(auditId, rhs.auditId).append(productTypeCd, rhs.productTypeCd).append(eventId, rhs.eventId).append(eventTmstmp, rhs.eventTmstmp).append(businessOutcomeCd, rhs.businessOutcomeCd).append(eventMetaDataJSON, rhs.eventMetaDataJSON).append(lobCd, rhs.lobCd).append(eventGroupCd, rhs.eventGroupCd).append(subApplicationId, rhs.subApplicationId).append(eventTypeCd, rhs.eventTypeCd).append(partyRoleCd, rhs.partyRoleCd).append(subApplicationSnapshotTmstmp, rhs.subApplicationSnapshotTmstmp).append(eventJsonSchemaCd, rhs.eventJsonSchemaCd).append(parentEventId, rhs.parentEventId).append(additionalProperties, rhs.additionalProperties).append(applicationId, rhs.applicationId).append(partyId, rhs.partyId).append(subApplicationSnapshot, rhs.subApplicationSnapshot).append(eventStatusCd, rhs.eventStatusCd).isEquals();
    }

}
