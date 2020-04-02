
package ca.mss.test.pojo.dest.complex;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * User authentication information.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authenticationIdentity",
    "attemptedCnt",
    "resultCd"
})
public class AuthenticationInfo {

    /**
     * Identity for user authentication.
     * (Required)
     * 
     */
    @JsonProperty("authenticationIdentity")
    @JsonPropertyDescription("Identity for user authentication.")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<AuthenticationIdentity> authenticationIdentity = new ArrayList<AuthenticationIdentity>();
    /**
     * Number of attempts were made for authentication.
     * 
     */
    @JsonProperty("attemptedCnt")
    @JsonPropertyDescription("Number of attempts were made for authentication.")
    private Integer attemptedCnt;
    /**
     * Result of user authentication check.
     * 
     */
    @JsonProperty("resultCd")
    @JsonPropertyDescription("Result of user authentication check.")
    private String resultCd;

    /**
     * Identity for user authentication.
     * (Required)
     * 
     */
    @JsonProperty("authenticationIdentity")
    public List<AuthenticationIdentity> getAuthenticationIdentity() {
        return authenticationIdentity;
    }

    /**
     * Identity for user authentication.
     * (Required)
     * 
     */
    @JsonProperty("authenticationIdentity")
    public void setAuthenticationIdentity(List<AuthenticationIdentity> authenticationIdentity) {
        this.authenticationIdentity = authenticationIdentity;
    }

    /**
     * Number of attempts were made for authentication.
     * 
     */
    @JsonProperty("attemptedCnt")
    public Integer getAttemptedCnt() {
        return attemptedCnt;
    }

    /**
     * Number of attempts were made for authentication.
     * 
     */
    @JsonProperty("attemptedCnt")
    public void setAttemptedCnt(Integer attemptedCnt) {
        this.attemptedCnt = attemptedCnt;
    }

    /**
     * Result of user authentication check.
     * 
     */
    @JsonProperty("resultCd")
    public String getResultCd() {
        return resultCd;
    }

    /**
     * Result of user authentication check.
     * 
     */
    @JsonProperty("resultCd")
    public void setResultCd(String resultCd) {
        this.resultCd = resultCd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("authenticationIdentity", authenticationIdentity).append("attemptedCnt", attemptedCnt).append("resultCd", resultCd).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(authenticationIdentity).append(resultCd).append(attemptedCnt).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AuthenticationInfo) == false) {
            return false;
        }
        AuthenticationInfo rhs = ((AuthenticationInfo) other);
        return new EqualsBuilder().append(authenticationIdentity, rhs.authenticationIdentity).append(resultCd, rhs.resultCd).append(attemptedCnt, rhs.attemptedCnt).isEquals();
    }

}
