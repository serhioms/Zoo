
package ca.mss.test.pojo.src.complex;

import java.io.Serializable;
import java.util.HashMap;
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "partyType",
    "userId",
    "connectId",
    "cifId",
    "prospectId",
    "clientMasterId",
    "employeeId",
    "accessCard"
})
public class BankingIdentity implements Serializable, Cloneable
{

    @JsonProperty("partyType")
    private String partyType;
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("connectId")
    private String connectId;
    /**
     * This will be populated from CIF in case of EW customer. For N2B, it will be post create CIF.
     * 
     */
    @JsonProperty("cifId")
    @JsonPropertyDescription("This will be populated from CIF in case of EW customer. For N2B, it will be post create CIF.")
    private String cifId;
    /**
     * This will be populated while customer login if available. 
     * 
     */
    @JsonProperty("prospectId")
    @JsonPropertyDescription("This will be populated while customer login if available. ")
    private String prospectId;
    /**
     * This will be populated from CustomerMaster in case of Wealth customer. For N2B, it will be post create CustomerProfile.
     * 
     */
    @JsonProperty("clientMasterId")
    @JsonPropertyDescription("This will be populated from CustomerMaster in case of Wealth customer. For N2B, it will be post create CustomerProfile.")
    private String clientMasterId;
    @JsonProperty("employeeId")
    private String employeeId;
    /**
     * This will be populated while customer login if available. This will not be populated from CIF at all.
     * 
     */
    @JsonProperty("accessCard")
    @JsonPropertyDescription("This will be populated while customer login if available. This will not be populated from CIF at all.")
    private String accessCard;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 1668815954933469447L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BankingIdentity() {
    }

    /**
     * 
     * @param prospectId
     * @param clientMasterId
     * @param accessCard
     * @param employeeId
     * @param partyType
     * @param connectId
     * @param userId
     * @param cifId
     */
    public BankingIdentity(String partyType, String userId, String connectId, String cifId, String prospectId, String clientMasterId, String employeeId, String accessCard) {
        super();
        this.partyType = partyType;
        this.userId = userId;
        this.connectId = connectId;
        this.cifId = cifId;
        this.prospectId = prospectId;
        this.clientMasterId = clientMasterId;
        this.employeeId = employeeId;
        this.accessCard = accessCard;
    }

    @JsonProperty("partyType")
    public String getPartyType() {
        return partyType;
    }

    @JsonProperty("partyType")
    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("connectId")
    public String getConnectId() {
        return connectId;
    }

    @JsonProperty("connectId")
    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    /**
     * This will be populated from CIF in case of EW customer. For N2B, it will be post create CIF.
     * 
     */
    @JsonProperty("cifId")
    public String getCifId() {
        return cifId;
    }

    /**
     * This will be populated from CIF in case of EW customer. For N2B, it will be post create CIF.
     * 
     */
    @JsonProperty("cifId")
    public void setCifId(String cifId) {
        this.cifId = cifId;
    }

    /**
     * This will be populated while customer login if available. 
     * 
     */
    @JsonProperty("prospectId")
    public String getProspectId() {
        return prospectId;
    }

    /**
     * This will be populated while customer login if available. 
     * 
     */
    @JsonProperty("prospectId")
    public void setProspectId(String prospectId) {
        this.prospectId = prospectId;
    }

    /**
     * This will be populated from CustomerMaster in case of Wealth customer. For N2B, it will be post create CustomerProfile.
     * 
     */
    @JsonProperty("clientMasterId")
    public String getClientMasterId() {
        return clientMasterId;
    }

    /**
     * This will be populated from CustomerMaster in case of Wealth customer. For N2B, it will be post create CustomerProfile.
     * 
     */
    @JsonProperty("clientMasterId")
    public void setClientMasterId(String clientMasterId) {
        this.clientMasterId = clientMasterId;
    }

    @JsonProperty("employeeId")
    public String getEmployeeId() {
        return employeeId;
    }

    @JsonProperty("employeeId")
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * This will be populated while customer login if available. This will not be populated from CIF at all.
     * 
     */
    @JsonProperty("accessCard")
    public String getAccessCard() {
        return accessCard;
    }

    /**
     * This will be populated while customer login if available. This will not be populated from CIF at all.
     * 
     */
    @JsonProperty("accessCard")
    public void setAccessCard(String accessCard) {
        this.accessCard = accessCard;
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
        return new ToStringBuilder(this).append("partyType", partyType).append("userId", userId).append("connectId", connectId).append("cifId", cifId).append("prospectId", prospectId).append("clientMasterId", clientMasterId).append("employeeId", employeeId).append("accessCard", accessCard).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(prospectId).append(clientMasterId).append(accessCard).append(employeeId).append(additionalProperties).append(partyType).append(connectId).append(userId).append(cifId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BankingIdentity) == false) {
            return false;
        }
        BankingIdentity rhs = ((BankingIdentity) other);
        return new EqualsBuilder().append(prospectId, rhs.prospectId).append(clientMasterId, rhs.clientMasterId).append(accessCard, rhs.accessCard).append(employeeId, rhs.employeeId).append(additionalProperties, rhs.additionalProperties).append(partyType, rhs.partyType).append(connectId, rhs.connectId).append(userId, rhs.userId).append(cifId, rhs.cifId).isEquals();
    }

}
