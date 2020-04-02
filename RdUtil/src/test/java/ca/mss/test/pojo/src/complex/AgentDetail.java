
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "firstName",
    "lastName",
    "token",
    "type",
    "role",
    "branches",
    "ids",
    "identity"
})
public class AgentDetail implements Serializable, Cloneable
{

    /**
     * Agents FirstName
     * 
     */
    @JsonProperty("firstName")
    @JsonPropertyDescription("Agents FirstName")
    private String firstName;
    /**
     * Agents LastName
     * 
     */
    @JsonProperty("lastName")
    @JsonPropertyDescription("Agents LastName")
    private String lastName;
    /**
     * Agents OAuthToken
     * 
     */
    @JsonProperty("token")
    @JsonPropertyDescription("Agents OAuthToken")
    private String token;
    /**
     * Agents type e.g. Supervisor etc.
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Agents type e.g. Supervisor etc.")
    private String type;
    /**
     * Agents Role
     * 
     */
    @JsonProperty("role")
    @JsonPropertyDescription("Agents Role")
    private String role;
    /**
     * Agents Branches. Agent can have different branches assigned.
     * 
     */
    @JsonProperty("branches")
    @JsonPropertyDescription("Agents Branches. Agent can have different branches assigned.")
    private List<Branch> branches = null;
    /**
     * Agents Id List. Agent can have different ids .
     * 
     */
    @JsonProperty("ids")
    @JsonPropertyDescription("Agents Id List. Agent can have different ids .")
    private List<Id> ids = null;
    @JsonProperty("identity")
    private BankingIdentity identity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6512937549497284403L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AgentDetail() {
    }

    /**
     * 
     * @param firstName
     * @param lastName
     * @param role
     * @param identity
     * @param ids
     * @param type
     * @param branches
     * @param token
     */
    public AgentDetail(String firstName, String lastName, String token, String type, String role, List<Branch> branches, List<Id> ids, BankingIdentity identity) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.token = token;
        this.type = type;
        this.role = role;
        this.branches = branches;
        this.ids = ids;
        this.identity = identity;
    }

    /**
     * Agents FirstName
     * 
     */
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Agents FirstName
     * 
     */
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Agents LastName
     * 
     */
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * Agents LastName
     * 
     */
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Agents OAuthToken
     * 
     */
    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    /**
     * Agents OAuthToken
     * 
     */
    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Agents type e.g. Supervisor etc.
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Agents type e.g. Supervisor etc.
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Agents Role
     * 
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * Agents Role
     * 
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Agents Branches. Agent can have different branches assigned.
     * 
     */
    @JsonProperty("branches")
    public List<Branch> getBranches() {
        return branches;
    }

    /**
     * Agents Branches. Agent can have different branches assigned.
     * 
     */
    @JsonProperty("branches")
    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    /**
     * Agents Id List. Agent can have different ids .
     * 
     */
    @JsonProperty("ids")
    public List<Id> getIds() {
        return ids;
    }

    /**
     * Agents Id List. Agent can have different ids .
     * 
     */
    @JsonProperty("ids")
    public void setIds(List<Id> ids) {
        this.ids = ids;
    }

    @JsonProperty("identity")
    public BankingIdentity getIdentity() {
        return identity;
    }

    @JsonProperty("identity")
    public void setIdentity(BankingIdentity identity) {
        this.identity = identity;
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
        return new ToStringBuilder(this).append("firstName", firstName).append("lastName", lastName).append("token", token).append("type", type).append("role", role).append("branches", branches).append("ids", ids).append("identity", identity).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(firstName).append(lastName).append(role).append(identity).append(ids).append(additionalProperties).append(type).append(branches).append(token).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgentDetail) == false) {
            return false;
        }
        AgentDetail rhs = ((AgentDetail) other);
        return new EqualsBuilder().append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(role, rhs.role).append(identity, rhs.identity).append(ids, rhs.ids).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(branches, rhs.branches).append(token, rhs.token).isEquals();
    }

}
