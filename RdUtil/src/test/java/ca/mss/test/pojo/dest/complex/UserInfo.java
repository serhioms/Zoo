
package ca.mss.test.pojo.dest.complex;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * User who initiated the contact with enterprise.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "loginId",
    "partyFunctionCd",
    "regionId"
})
public class UserInfo {

    /**
     * System login id of the user.
     * 
     */
    @JsonProperty("loginId")
    @JsonPropertyDescription("System login id of the user.")
    private String loginId;
    /**
     * The code for the function that the user can perform in organization e.g. CSR.
     * 
     */
    @JsonProperty("partyFunctionCd")
    @JsonPropertyDescription("The code for the function that the user can perform in organization e.g. CSR.")
    private String partyFunctionCd;
    /**
     * The unique identifier for a REGION.
     * 
     */
    @JsonProperty("regionId")
    @JsonPropertyDescription("The unique identifier for a REGION.")
    private String regionId;

    /**
     * System login id of the user.
     * 
     */
    @JsonProperty("loginId")
    public String getLoginId() {
        return loginId;
    }

    /**
     * System login id of the user.
     * 
     */
    @JsonProperty("loginId")
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * The code for the function that the user can perform in organization e.g. CSR.
     * 
     */
    @JsonProperty("partyFunctionCd")
    public String getPartyFunctionCd() {
        return partyFunctionCd;
    }

    /**
     * The code for the function that the user can perform in organization e.g. CSR.
     * 
     */
    @JsonProperty("partyFunctionCd")
    public void setPartyFunctionCd(String partyFunctionCd) {
        this.partyFunctionCd = partyFunctionCd;
    }

    /**
     * The unique identifier for a REGION.
     * 
     */
    @JsonProperty("regionId")
    public String getRegionId() {
        return regionId;
    }

    /**
     * The unique identifier for a REGION.
     * 
     */
    @JsonProperty("regionId")
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("loginId", loginId).append("partyFunctionCd", partyFunctionCd).append("regionId", regionId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(loginId).append(partyFunctionCd).append(regionId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserInfo) == false) {
            return false;
        }
        UserInfo rhs = ((UserInfo) other);
        return new EqualsBuilder().append(loginId, rhs.loginId).append(partyFunctionCd, rhs.partyFunctionCd).append(regionId, rhs.regionId).isEquals();
    }

}
