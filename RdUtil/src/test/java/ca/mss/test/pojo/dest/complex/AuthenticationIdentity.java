
package ca.mss.test.pojo.dest.complex;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Authentication digital identity.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authenticationMethodTypeCd",
    "identifierTypeCd",
    "identifierId",
    "authenticatedInd"
})
public class AuthenticationIdentity {

    /**
     * Authentication method classification code e.g. Password, PIN etc.
     * 
     */
    @JsonProperty("authenticationMethodTypeCd")
    @JsonPropertyDescription("Authentication method classification code e.g. Password, PIN etc.")
    private String authenticationMethodTypeCd;
    /**
     * Type of an authentication identifier e.g.  Connect ID, Accesscard, manual verification etc.
     * (Required)
     * 
     */
    @JsonProperty("identifierTypeCd")
    @JsonPropertyDescription("Type of an authentication identifier e.g.  Connect ID, Accesscard, manual verification etc.")
    @NotNull
    private String identifierTypeCd;
    /**
     * Number or value of an authentication identifier e.g. Accesscard Number,Connect ID or CustomerNumber.
     * (Required)
     * 
     */
    @JsonProperty("identifierId")
    @JsonPropertyDescription("Number or value of an authentication identifier e.g. Accesscard Number,Connect ID or CustomerNumber.")
    @NotNull
    private String identifierId;
    /**
     * Indicate whether the identity is used for authentication.
     * 
     */
    @JsonProperty("authenticatedInd")
    @JsonPropertyDescription("Indicate whether the identity is used for authentication.")
    private Boolean authenticatedInd;

    /**
     * Authentication method classification code e.g. Password, PIN etc.
     * 
     */
    @JsonProperty("authenticationMethodTypeCd")
    public String getAuthenticationMethodTypeCd() {
        return authenticationMethodTypeCd;
    }

    /**
     * Authentication method classification code e.g. Password, PIN etc.
     * 
     */
    @JsonProperty("authenticationMethodTypeCd")
    public void setAuthenticationMethodTypeCd(String authenticationMethodTypeCd) {
        this.authenticationMethodTypeCd = authenticationMethodTypeCd;
    }

    /**
     * Type of an authentication identifier e.g.  Connect ID, Accesscard, manual verification etc.
     * (Required)
     * 
     */
    @JsonProperty("identifierTypeCd")
    public String getIdentifierTypeCd() {
        return identifierTypeCd;
    }

    /**
     * Type of an authentication identifier e.g.  Connect ID, Accesscard, manual verification etc.
     * (Required)
     * 
     */
    @JsonProperty("identifierTypeCd")
    public void setIdentifierTypeCd(String identifierTypeCd) {
        this.identifierTypeCd = identifierTypeCd;
    }

    /**
     * Number or value of an authentication identifier e.g. Accesscard Number,Connect ID or CustomerNumber.
     * (Required)
     * 
     */
    @JsonProperty("identifierId")
    public String getIdentifierId() {
        return identifierId;
    }

    /**
     * Number or value of an authentication identifier e.g. Accesscard Number,Connect ID or CustomerNumber.
     * (Required)
     * 
     */
    @JsonProperty("identifierId")
    public void setIdentifierId(String identifierId) {
        this.identifierId = identifierId;
    }

    /**
     * Indicate whether the identity is used for authentication.
     * 
     */
    @JsonProperty("authenticatedInd")
    public Boolean getAuthenticatedInd() {
        return authenticatedInd;
    }

    /**
     * Indicate whether the identity is used for authentication.
     * 
     */
    @JsonProperty("authenticatedInd")
    public void setAuthenticatedInd(Boolean authenticatedInd) {
        this.authenticatedInd = authenticatedInd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("authenticationMethodTypeCd", authenticationMethodTypeCd).append("identifierTypeCd", identifierTypeCd).append("identifierId", identifierId).append("authenticatedInd", authenticatedInd).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(authenticatedInd).append(identifierId).append(identifierTypeCd).append(authenticationMethodTypeCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AuthenticationIdentity) == false) {
            return false;
        }
        AuthenticationIdentity rhs = ((AuthenticationIdentity) other);
        return new EqualsBuilder().append(authenticatedInd, rhs.authenticatedInd).append(identifierId, rhs.identifierId).append(identifierTypeCd, rhs.identifierTypeCd).append(authenticationMethodTypeCd, rhs.authenticationMethodTypeCd).isEquals();
    }

}
