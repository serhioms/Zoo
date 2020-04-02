
package ca.mss.test.pojo.dest.simple;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 * Version 1, Date; 20180425. EA Metadata to be included in the Request Schemas and Appsnapshot Schema
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
    "testSystem",
    "daPartyId"
})
public class MetaData {

    /**
     * Corresponding to EVENT.APPLICATION_ID 
     * (Required)
     * 
     */
    @JsonProperty("applicationId")
    @JsonPropertyDescription("Corresponding to EVENT.APPLICATION_ID ")
    @NotNull
    private BigInteger applicationId;
    /**
     * List of subApplications.
     * (Required)
     * 
     */
    @JsonProperty("subApplicationList")
    @JsonPropertyDescription("List of subApplications.")
    @Valid
    @NotNull
    private List<SubApplicationList> subApplicationList = new ArrayList<SubApplicationList>();
    /**
     * This is Lob Code which may be specific to Product. It will be MULTI_PRODUCT for multiple product scenario. This will be used in determining job types or event sepcific operation in background.
     * (Required)
     * 
     */
    @JsonProperty("lobName")
    @JsonPropertyDescription("This is Lob Code which may be specific to Product. It will be MULTI_PRODUCT for multiple product scenario. This will be used in determining job types or event sepcific operation in background.")
    @NotNull
    private String lobName;
    /**
     * Channel from the source URL that redirects to EasyApply. It can be Web or EZW or ATM
     * (Required)
     * 
     */
    @JsonProperty("channel")
    @JsonPropertyDescription("Channel from the source URL that redirects to EasyApply. It can be Web or EZW or ATM")
    @NotNull
    private String channel;
    /**
     * Originating ChannelTypeCd e.g.FSRV(Full/Assisted Service), SSRV(SelfService), AUTO(AutoInitiated) 
     * 
     */
    @JsonProperty("originatingChannelCd")
    @JsonPropertyDescription("Originating ChannelTypeCd e.g.FSRV(Full/Assisted Service), SSRV(SelfService), AUTO(AutoInitiated) ")
    private String originatingChannelCd;
    /**
     * Source Code used by marketing campaign for a specific product during a specific time
     * 
     */
    @JsonProperty("sourceCd")
    @JsonPropertyDescription("Source Code used by marketing campaign for a specific product during a specific time")
    private String sourceCd;
    /**
     * This is a flow id e.g. N2B / EW / N2W / ExistingWealth
     * (Required)
     * 
     */
    @JsonProperty("flowId")
    @JsonPropertyDescription("This is a flow id e.g. N2B / EW / N2W / ExistingWealth")
    @NotNull
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
     * (Required)
     * 
     */
    @JsonProperty("sessionId")
    @JsonPropertyDescription("This is a UI session id populated by OCA.")
    @NotNull
    private String sessionId;
    /**
     * This is a application Stage e.g. AboutYou / Review etc. This value can be over-written accordingly.
     * (Required)
     * 
     */
    @JsonProperty("stage")
    @JsonPropertyDescription("This is a application Stage e.g. AboutYou / Review etc. This value can be over-written accordingly.")
    @NotNull
    private String stage;
    /**
     * This is a unique message id populated by OCA
     * (Required)
     * 
     */
    @JsonProperty("uniqueMessageId")
    @JsonPropertyDescription("This is a unique message id populated by OCA")
    @NotNull
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
    /**
     * da-party id of the acting party
     * 
     */
    @JsonProperty("daPartyId")
    @JsonPropertyDescription("da-party id of the acting party")
    private String daPartyId;

    /**
     * Corresponding to EVENT.APPLICATION_ID 
     * (Required)
     * 
     */
    @JsonProperty("applicationId")
    public BigInteger getApplicationId() {
        return applicationId;
    }

    /**
     * Corresponding to EVENT.APPLICATION_ID 
     * (Required)
     * 
     */
    @JsonProperty("applicationId")
    public void setApplicationId(BigInteger applicationId) {
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
     * Channel from the source URL that redirects to EasyApply. It can be Web or EZW or ATM
     * (Required)
     * 
     */
    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    /**
     * Channel from the source URL that redirects to EasyApply. It can be Web or EZW or ATM
     * (Required)
     * 
     */
    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * Originating ChannelTypeCd e.g.FSRV(Full/Assisted Service), SSRV(SelfService), AUTO(AutoInitiated) 
     * 
     */
    @JsonProperty("originatingChannelCd")
    public String getOriginatingChannelCd() {
        return originatingChannelCd;
    }

    /**
     * Originating ChannelTypeCd e.g.FSRV(Full/Assisted Service), SSRV(SelfService), AUTO(AutoInitiated) 
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
     * This is a flow id e.g. N2B / EW / N2W / ExistingWealth
     * (Required)
     * 
     */
    @JsonProperty("flowId")
    public String getFlowId() {
        return flowId;
    }

    /**
     * This is a flow id e.g. N2B / EW / N2W / ExistingWealth
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
     * (Required)
     * 
     */
    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
    }

    /**
     * This is a UI session id populated by OCA.
     * (Required)
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
     * (Required)
     * 
     */
    @JsonProperty("uniqueMessageId")
    public String getUniqueMessageId() {
        return uniqueMessageId;
    }

    /**
     * This is a unique message id populated by OCA
     * (Required)
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

    /**
     * da-party id of the acting party
     * 
     */
    @JsonProperty("daPartyId")
    public String getDaPartyId() {
        return daPartyId;
    }

    /**
     * da-party id of the acting party
     * 
     */
    @JsonProperty("daPartyId")
    public void setDaPartyId(String daPartyId) {
        this.daPartyId = daPartyId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("applicationId", applicationId).append("subApplicationList", subApplicationList).append("lobName", lobName).append("channel", channel).append("originatingChannelCd", originatingChannelCd).append("sourceCd", sourceCd).append("flowId", flowId).append("clientIp", clientIp).append("isSsoAuthenticated", isSsoAuthenticated).append("agentId", agentId).append("connectId", connectId).append("sessionId", sessionId).append("stage", stage).append("uniqueMessageId", uniqueMessageId).append("testSet", testSet).append("testSystem", testSystem).append("daPartyId", daPartyId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(agentId).append(testSystem).append(originatingChannelCd).append(testSet).append(daPartyId).append(channel).append(uniqueMessageId).append(sourceCd).append(sessionId).append(isSsoAuthenticated).append(stage).append(subApplicationList).append(clientIp).append(applicationId).append(connectId).append(flowId).append(lobName).toHashCode();
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
        return new EqualsBuilder().append(agentId, rhs.agentId).append(testSystem, rhs.testSystem).append(originatingChannelCd, rhs.originatingChannelCd).append(testSet, rhs.testSet).append(daPartyId, rhs.daPartyId).append(channel, rhs.channel).append(uniqueMessageId, rhs.uniqueMessageId).append(sourceCd, rhs.sourceCd).append(sessionId, rhs.sessionId).append(isSsoAuthenticated, rhs.isSsoAuthenticated).append(stage, rhs.stage).append(subApplicationList, rhs.subApplicationList).append(clientIp, rhs.clientIp).append(applicationId, rhs.applicationId).append(connectId, rhs.connectId).append(flowId, rhs.flowId).append(lobName, rhs.lobName).isEquals();
    }

}
