
package ca.mss.test.pojo.src.complex;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


/**
 * SnapshotMetaData Version v3, Date; 20180530. Include metaDataDef in the definitions of the Appsnapshot Schema. Change from last version: Changed applicationid from integer to string
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "applicationId",
    "subApplicationList",
    "lobName",
    "channel",
    "originatingChannelCd",
    "sourceCd",
    "flowId",
    "clientIp",
    "isSsoAuthenticated",
    "agentId",
    "connectId",
    "sessionId",
    "stage",
    "uniqueMessageId",
    "testSet",
    "testSystem"
})
public class MetaData implements Serializable
{

    /**
     * Corresponding to EVENT.APPLICATION_ID.
     * (Required)
     * 
     */
    @JsonProperty("applicationId")
    @JsonPropertyDescription("Corresponding to EVENT.APPLICATION_ID.")
    private String applicationId;
    /**
     * List of subApplications.
     * (Required)
     * 
     */
    @JsonProperty("subApplicationList")
    @JsonPropertyDescription("List of subApplications.")
    private List<SubApplicationList> subApplicationList = null;
    /**
     * This is Lob Code which may be specific to Product. It will be MULTI_PRODUCT for multiple product scenario. This will be used in determining job types or event sepcific operation in background.
     * (Required)
     * 
     */
    @JsonProperty("lobName")
    @JsonPropertyDescription("This is Lob Code which may be specific to Product. It will be MULTI_PRODUCT for multiple product scenario. This will be used in determining job types or event sepcific operation in background.")
    private String lobName;
    /**
     * This is the channel is the the application is currently in. Channel should be updated as needed if the application channel changes. Enumeration is;
     * SSRV: Self Service
     * FSRV: Full Service
     * (Required)
     * 
     */
    @JsonProperty("channel")
    @JsonPropertyDescription("This is the channel is the the application is currently in. Channel should be updated as needed if the application channel changes. Enumeration is;\r\nSSRV: Self Service\r\nFSRV: Full Service")
    private String channel;
    /**
     * The channel the application began in. Should be set in the beginning of the application and not changed thereafter. Enumeration is;
     * SSRV: Self Service
     * FSRV: Full Service
     * 
     */
    @JsonProperty("originatingChannelCd")
    @JsonPropertyDescription("The channel the application began in. Should be set in the beginning of the application and not changed thereafter. Enumeration is;\r\nSSRV: Self Service\r\nFSRV: Full Service")
    private String originatingChannelCd;
    /**
     * Source Code used by marketing campaign for a specific product during a specific time
     * 
     */
    @JsonProperty("sourceCd")
    @JsonPropertyDescription("Source Code used by marketing campaign for a specific product during a specific time")
    private String sourceCd;
    /**
     * This is a flow id e.g. N2B / EW / N2W / ExistingWealth. With backward compatibility, going forward the flowId will contain values of Authentication, User Type, Source Application and Related Application concatenated by underscore ( _ ). E.g. SSO_E2B_EW_DTDW~C3 . refer https://collaborate.td.com/display/ESODA/Application+SnapShot for more detail
     * (Required)
     * 
     */
    @JsonProperty("flowId")
    @JsonPropertyDescription("This is a flow id e.g. N2B / EW / N2W / ExistingWealth. With backward compatibility, going forward the flowId will contain values of Authentication, User Type, Source Application and Related Application concatenated by underscore ( _ ). E.g. SSO_E2B_EW_DTDW~C3 . refer https://collaborate.td.com/display/ESODA/Application+SnapShot for more detail")
    private String flowId;
    /**
     * Client Brower/System IP Address. It is populated from UI/OCA.
     * 
     */
    @JsonProperty("clientIp")
    @JsonPropertyDescription("Client Brower/System IP Address. It is populated from UI/OCA.")
    private String clientIp;
    /**
     * set to TRUE when SSO is successful; set to FALSE after CUSTOMER_LOGIN.
     * 
     */
    @JsonProperty("isSsoAuthenticated")
    @JsonPropertyDescription("set to TRUE when SSO is successful; set to FALSE after CUSTOMER_LOGIN.")
    private Boolean isSsoAuthenticated;
    /**
     * this agent id is added by the filter, the value is taken from OCA token.
     * 
     */
    @JsonProperty("agentId")
    @JsonPropertyDescription("this agent id is added by the filter, the value is taken from OCA token.")
    private String agentId;
    /**
     * connectId is taken when EA is re-directed by Easyweb or post Easyweb log in
     * 
     */
    @JsonProperty("connectId")
    @JsonPropertyDescription("connectId is taken when EA is re-directed by Easyweb or post Easyweb log in")
    private String connectId;
    /**
     * This is a UI session id populated by OCA.
     * 
     */
    @JsonProperty("sessionId")
    @JsonPropertyDescription("This is a UI session id populated by OCA.")
    private String sessionId;
    /**
     * This is a application Stage e.g. AboutYou / Review etc. This value can be over-written accordingly.
     * (Required)
     * 
     */
    @JsonProperty("stage")
    @JsonPropertyDescription("This is a application Stage e.g. AboutYou / Review etc. This value can be over-written accordingly.")
    private String stage;
    /**
     * This is a unique message id populated by OCA
     * 
     */
    @JsonProperty("uniqueMessageId")
    @JsonPropertyDescription("This is a unique message id populated by OCA")
    private String uniqueMessageId;
    /**
     * TestSet to be used by Host
     * 
     */
    @JsonProperty("testSet")
    @JsonPropertyDescription("TestSet to be used by Host")
    private String testSet;
    /**
     * TestSystem to be used by Host
     * 
     */
    @JsonProperty("testSystem")
    @JsonPropertyDescription("TestSystem to be used by Host")
    private String testSystem;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3217016233957448763L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MetaData() {
    }

    /**
     * 
     * @param agentId
     * @param testSystem
     * @param originatingChannelCd
     * @param testSet
     * @param channel
     * @param uniqueMessageId
     * @param sourceCd
     * @param sessionId
     * @param isSsoAuthenticated
     * @param stage
     * @param subApplicationList
     * @param clientIp
     * @param applicationId
     * @param connectId
     * @param flowId
     * @param lobName
     */
    public MetaData(String applicationId, List<SubApplicationList> subApplicationList, String lobName, String channel, String originatingChannelCd, String sourceCd, String flowId, String clientIp, Boolean isSsoAuthenticated, String agentId, String connectId, String sessionId, String stage, String uniqueMessageId, String testSet, String testSystem) {
        super();
        this.applicationId = applicationId;
        this.subApplicationList = subApplicationList;
        this.lobName = lobName;
        this.channel = channel;
        this.originatingChannelCd = originatingChannelCd;
        this.sourceCd = sourceCd;
        this.flowId = flowId;
        this.clientIp = clientIp;
        this.isSsoAuthenticated = isSsoAuthenticated;
        this.agentId = agentId;
        this.connectId = connectId;
        this.sessionId = sessionId;
        this.stage = stage;
        this.uniqueMessageId = uniqueMessageId;
        this.testSet = testSet;
        this.testSystem = testSystem;
    }

    /**
     * Corresponding to EVENT.APPLICATION_ID.
     * (Required)
     * 
     */
    @JsonProperty("applicationId")
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Corresponding to EVENT.APPLICATION_ID.
     * (Required)
     * 
     */
    @JsonProperty("applicationId")
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * List of subApplications.
     * (Required)
     * 
     */
    @JsonProperty("subApplicationList")
    public List<SubApplicationList> getSubApplicationList() {
        return subApplicationList;
    }

    /**
     * List of subApplications.
     * (Required)
     * 
     */
    @JsonProperty("subApplicationList")
    public void setSubApplicationList(List<SubApplicationList> subApplicationList) {
        this.subApplicationList = subApplicationList;
    }

    /**
     * This is Lob Code which may be specific to Product. It will be MULTI_PRODUCT for multiple product scenario. This will be used in determining job types or event sepcific operation in background.
     * (Required)
     * 
     */
    @JsonProperty("lobName")
    public String getLobName() {
        return lobName;
    }

    /**
     * This is Lob Code which may be specific to Product. It will be MULTI_PRODUCT for multiple product scenario. This will be used in determining job types or event sepcific operation in background.
     * (Required)
     * 
     */
    @JsonProperty("lobName")
    public void setLobName(String lobName) {
        this.lobName = lobName;
    }

    /**
     * This is the channel is the the application is currently in. Channel should be updated as needed if the application channel changes. Enumeration is;
     * SSRV: Self Service
     * FSRV: Full Service
     * (Required)
     * 
     */
    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    /**
     * This is the channel is the the application is currently in. Channel should be updated as needed if the application channel changes. Enumeration is;
     * SSRV: Self Service
     * FSRV: Full Service
     * (Required)
     * 
     */
    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * The channel the application began in. Should be set in the beginning of the application and not changed thereafter. Enumeration is;
     * SSRV: Self Service
     * FSRV: Full Service
     * 
     */
    @JsonProperty("originatingChannelCd")
    public String getOriginatingChannelCd() {
        return originatingChannelCd;
    }

    /**
     * The channel the application began in. Should be set in the beginning of the application and not changed thereafter. Enumeration is;
     * SSRV: Self Service
     * FSRV: Full Service
     * 
     */
    @JsonProperty("originatingChannelCd")
    public void setOriginatingChannelCd(String originatingChannelCd) {
        this.originatingChannelCd = originatingChannelCd;
    }

    /**
     * Source Code used by marketing campaign for a specific product during a specific time
     * 
     */
    @JsonProperty("sourceCd")
    public String getSourceCd() {
        return sourceCd;
    }

    /**
     * Source Code used by marketing campaign for a specific product during a specific time
     * 
     */
    @JsonProperty("sourceCd")
    public void setSourceCd(String sourceCd) {
        this.sourceCd = sourceCd;
    }

    /**
     * This is a flow id e.g. N2B / EW / N2W / ExistingWealth. With backward compatibility, going forward the flowId will contain values of Authentication, User Type, Source Application and Related Application concatenated by underscore ( _ ). E.g. SSO_E2B_EW_DTDW~C3 . refer https://collaborate.td.com/display/ESODA/Application+SnapShot for more detail
     * (Required)
     * 
     */
    @JsonProperty("flowId")
    public String getFlowId() {
        return flowId;
    }

    /**
     * This is a flow id e.g. N2B / EW / N2W / ExistingWealth. With backward compatibility, going forward the flowId will contain values of Authentication, User Type, Source Application and Related Application concatenated by underscore ( _ ). E.g. SSO_E2B_EW_DTDW~C3 . refer https://collaborate.td.com/display/ESODA/Application+SnapShot for more detail
     * (Required)
     * 
     */
    @JsonProperty("flowId")
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    /**
     * Client Brower/System IP Address. It is populated from UI/OCA.
     * 
     */
    @JsonProperty("clientIp")
    public String getClientIp() {
        return clientIp;
    }

    /**
     * Client Brower/System IP Address. It is populated from UI/OCA.
     * 
     */
    @JsonProperty("clientIp")
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * set to TRUE when SSO is successful; set to FALSE after CUSTOMER_LOGIN.
     * 
     */
    @JsonProperty("isSsoAuthenticated")
    public Boolean getIsSsoAuthenticated() {
        return isSsoAuthenticated;
    }

    /**
     * set to TRUE when SSO is successful; set to FALSE after CUSTOMER_LOGIN.
     * 
     */
    @JsonProperty("isSsoAuthenticated")
    public void setIsSsoAuthenticated(Boolean isSsoAuthenticated) {
        this.isSsoAuthenticated = isSsoAuthenticated;
    }

    /**
     * this agent id is added by the filter, the value is taken from OCA token.
     * 
     */
    @JsonProperty("agentId")
    public String getAgentId() {
        return agentId;
    }

    /**
     * this agent id is added by the filter, the value is taken from OCA token.
     * 
     */
    @JsonProperty("agentId")
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    /**
     * connectId is taken when EA is re-directed by Easyweb or post Easyweb log in
     * 
     */
    @JsonProperty("connectId")
    public String getConnectId() {
        return connectId;
    }

    /**
     * connectId is taken when EA is re-directed by Easyweb or post Easyweb log in
     * 
     */
    @JsonProperty("connectId")
    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    /**
     * This is a UI session id populated by OCA.
     * 
     */
    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
    }

    /**
     * This is a UI session id populated by OCA.
     * 
     */
    @JsonProperty("sessionId")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * This is a application Stage e.g. AboutYou / Review etc. This value can be over-written accordingly.
     * (Required)
     * 
     */
    @JsonProperty("stage")
    public String getStage() {
        return stage;
    }

    /**
     * This is a application Stage e.g. AboutYou / Review etc. This value can be over-written accordingly.
     * (Required)
     * 
     */
    @JsonProperty("stage")
    public void setStage(String stage) {
        this.stage = stage;
    }

    /**
     * This is a unique message id populated by OCA
     * 
     */
    @JsonProperty("uniqueMessageId")
    public String getUniqueMessageId() {
        return uniqueMessageId;
    }

    /**
     * This is a unique message id populated by OCA
     * 
     */
    @JsonProperty("uniqueMessageId")
    public void setUniqueMessageId(String uniqueMessageId) {
        this.uniqueMessageId = uniqueMessageId;
    }

    /**
     * TestSet to be used by Host
     * 
     */
    @JsonProperty("testSet")
    public String getTestSet() {
        return testSet;
    }

    /**
     * TestSet to be used by Host
     * 
     */
    @JsonProperty("testSet")
    public void setTestSet(String testSet) {
        this.testSet = testSet;
    }

    /**
     * TestSystem to be used by Host
     * 
     */
    @JsonProperty("testSystem")
    public String getTestSystem() {
        return testSystem;
    }

    /**
     * TestSystem to be used by Host
     * 
     */
    @JsonProperty("testSystem")
    public void setTestSystem(String testSystem) {
        this.testSystem = testSystem;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("applicationId", applicationId).append("subApplicationList", subApplicationList).append("lobName", lobName).append("channel", channel).append("originatingChannelCd", originatingChannelCd).append("sourceCd", sourceCd).append("flowId", flowId).append("clientIp", clientIp).append("isSsoAuthenticated", isSsoAuthenticated).append("agentId", agentId).append("connectId", connectId).append("sessionId", sessionId).append("stage", stage).append("uniqueMessageId", uniqueMessageId).append("testSet", testSet).append("testSystem", testSystem).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(agentId).append(testSystem).append(originatingChannelCd).append(testSet).append(channel).append(uniqueMessageId).append(sourceCd).append(sessionId).append(isSsoAuthenticated).append(stage).append(subApplicationList).append(clientIp).append(additionalProperties).append(applicationId).append(connectId).append(flowId).append(lobName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MetaData) == false) {
            return false;
        }
        MetaData rhs = ((MetaData) other);
        return new EqualsBuilder().append(agentId, rhs.agentId).append(testSystem, rhs.testSystem).append(originatingChannelCd, rhs.originatingChannelCd).append(testSet, rhs.testSet).append(channel, rhs.channel).append(uniqueMessageId, rhs.uniqueMessageId).append(sourceCd, rhs.sourceCd).append(sessionId, rhs.sessionId).append(isSsoAuthenticated, rhs.isSsoAuthenticated).append(stage, rhs.stage).append(subApplicationList, rhs.subApplicationList).append(clientIp, rhs.clientIp).append(additionalProperties, rhs.additionalProperties).append(applicationId, rhs.applicationId).append(connectId, rhs.connectId).append(flowId, rhs.flowId).append(lobName, rhs.lobName).isEquals();
    }

}
