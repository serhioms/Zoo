
package ca.mss.test.pojo.dest.simple;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alternateUserId",
    "alternateUserType",
    "userExpiryDatetime"
})
public class AlternateUserInfo {

    /**
     * Represents the user id, such as easyweb access card number, connect id, prospect id, prospect email
     * (Required)
     * 
     */
    @JsonProperty("alternateUserId")
    @JsonPropertyDescription("Represents the user id, such as easyweb access card number, connect id, prospect id, prospect email")
    @NotNull
    private String alternateUserId;
    /**
     * Represents the user type
     * (Required)
     * 
     */
    @JsonProperty("alternateUserType")
    @JsonPropertyDescription("Represents the user type")
    @NotNull
    private String alternateUserType;
    /**
     * the expirydatetime for the user if applicable, the datetime need to be in UTC: yyyy-mm-ddThh:mm:ssZ
     * 
     */
    @JsonProperty("userExpiryDatetime")
    @JsonPropertyDescription("the expirydatetime for the user if applicable, the datetime need to be in UTC: yyyy-mm-ddThh:mm:ssZ")
    private String userExpiryDatetime;

    /**
     * Represents the user id, such as easyweb access card number, connect id, prospect id, prospect email
     * (Required)
     * 
     */
    @JsonProperty("alternateUserId")
    public String getAlternateUserId() {
        return alternateUserId;
    }

    /**
     * Represents the user id, such as easyweb access card number, connect id, prospect id, prospect email
     * (Required)
     * 
     */
    @JsonProperty("alternateUserId")
    public void setAlternateUserId(String alternateUserId) {
        this.alternateUserId = alternateUserId;
    }

    /**
     * Represents the user type
     * (Required)
     * 
     */
    @JsonProperty("alternateUserType")
    public String getAlternateUserType() {
        return alternateUserType;
    }

    /**
     * Represents the user type
     * (Required)
     * 
     */
    @JsonProperty("alternateUserType")
    public void setAlternateUserType(String alternateUserType) {
        this.alternateUserType = alternateUserType;
    }

    /**
     * the expirydatetime for the user if applicable, the datetime need to be in UTC: yyyy-mm-ddThh:mm:ssZ
     * 
     */
    @JsonProperty("userExpiryDatetime")
    public String getUserExpiryDatetime() {
        return userExpiryDatetime;
    }

    /**
     * the expirydatetime for the user if applicable, the datetime need to be in UTC: yyyy-mm-ddThh:mm:ssZ
     * 
     */
    @JsonProperty("userExpiryDatetime")
    public void setUserExpiryDatetime(String userExpiryDatetime) {
        this.userExpiryDatetime = userExpiryDatetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("alternateUserId", alternateUserId).append("alternateUserType", alternateUserType).append("userExpiryDatetime", userExpiryDatetime).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(alternateUserId).append(userExpiryDatetime).append(alternateUserType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AlternateUserInfo) == false) {
            return false;
        }
        AlternateUserInfo rhs = ((AlternateUserInfo) other);
        return new EqualsBuilder().append(alternateUserId, rhs.alternateUserId).append(userExpiryDatetime, rhs.userExpiryDatetime).append(alternateUserType, rhs.alternateUserType).isEquals();
    }

}
