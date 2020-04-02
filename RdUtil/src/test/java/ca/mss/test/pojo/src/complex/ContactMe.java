
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
    "isEmailNotificationRequired",
    "isPhoneCallRequired",
    "emailAddress",
    "snailMail",
    "preferredPhoneNumber",
    "contactTimePreference",
    "languageCd"
})
public class ContactMe implements Serializable, Cloneable
{

    @JsonProperty("isEmailNotificationRequired")
    private Boolean isEmailNotificationRequired;
    @JsonProperty("isPhoneCallRequired")
    private Boolean isPhoneCallRequired;
    @JsonProperty("emailAddress")
    private String emailAddress;
    @JsonProperty("snailMail")
    private String snailMail;
    /**
     * Phone/contact Number information is stored in this object.
     * 
     */
    @JsonProperty("preferredPhoneNumber")
    @JsonPropertyDescription("Phone/contact Number information is stored in this object.")
    private PhoneList preferredPhoneNumber;
    @JsonProperty("contactTimePreference")
    private String contactTimePreference;
    /**
     * Language code which will be used for customer communication populated from CIF. If CIF does not have it then default it to ApplicationLanguage
     * 
     */
    @JsonProperty("languageCd")
    @JsonPropertyDescription("Language code which will be used for customer communication populated from CIF. If CIF does not have it then default it to ApplicationLanguage")
    private String languageCd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7736362512821669006L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ContactMe() {
    }

    /**
     * 
     * @param emailAddress
     * @param preferredPhoneNumber
     * @param languageCd
     * @param isEmailNotificationRequired
     * @param contactTimePreference
     * @param isPhoneCallRequired
     * @param snailMail
     */
    public ContactMe(Boolean isEmailNotificationRequired, Boolean isPhoneCallRequired, String emailAddress, String snailMail, PhoneList preferredPhoneNumber, String contactTimePreference, String languageCd) {
        super();
        this.isEmailNotificationRequired = isEmailNotificationRequired;
        this.isPhoneCallRequired = isPhoneCallRequired;
        this.emailAddress = emailAddress;
        this.snailMail = snailMail;
        this.preferredPhoneNumber = preferredPhoneNumber;
        this.contactTimePreference = contactTimePreference;
        this.languageCd = languageCd;
    }

    @JsonProperty("isEmailNotificationRequired")
    public Boolean getIsEmailNotificationRequired() {
        return isEmailNotificationRequired;
    }

    @JsonProperty("isEmailNotificationRequired")
    public void setIsEmailNotificationRequired(Boolean isEmailNotificationRequired) {
        this.isEmailNotificationRequired = isEmailNotificationRequired;
    }

    @JsonProperty("isPhoneCallRequired")
    public Boolean getIsPhoneCallRequired() {
        return isPhoneCallRequired;
    }

    @JsonProperty("isPhoneCallRequired")
    public void setIsPhoneCallRequired(Boolean isPhoneCallRequired) {
        this.isPhoneCallRequired = isPhoneCallRequired;
    }

    @JsonProperty("emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("emailAddress")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonProperty("snailMail")
    public String getSnailMail() {
        return snailMail;
    }

    @JsonProperty("snailMail")
    public void setSnailMail(String snailMail) {
        this.snailMail = snailMail;
    }

    /**
     * Phone/contact Number information is stored in this object.
     * 
     */
    @JsonProperty("preferredPhoneNumber")
    public PhoneList getPreferredPhoneNumber() {
        return preferredPhoneNumber;
    }

    /**
     * Phone/contact Number information is stored in this object.
     * 
     */
    @JsonProperty("preferredPhoneNumber")
    public void setPreferredPhoneNumber(PhoneList preferredPhoneNumber) {
        this.preferredPhoneNumber = preferredPhoneNumber;
    }

    @JsonProperty("contactTimePreference")
    public String getContactTimePreference() {
        return contactTimePreference;
    }

    @JsonProperty("contactTimePreference")
    public void setContactTimePreference(String contactTimePreference) {
        this.contactTimePreference = contactTimePreference;
    }

    /**
     * Language code which will be used for customer communication populated from CIF. If CIF does not have it then default it to ApplicationLanguage
     * 
     */
    @JsonProperty("languageCd")
    public String getLanguageCd() {
        return languageCd;
    }

    /**
     * Language code which will be used for customer communication populated from CIF. If CIF does not have it then default it to ApplicationLanguage
     * 
     */
    @JsonProperty("languageCd")
    public void setLanguageCd(String languageCd) {
        this.languageCd = languageCd;
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
        return new ToStringBuilder(this).append("isEmailNotificationRequired", isEmailNotificationRequired).append("isPhoneCallRequired", isPhoneCallRequired).append("emailAddress", emailAddress).append("snailMail", snailMail).append("preferredPhoneNumber", preferredPhoneNumber).append("contactTimePreference", contactTimePreference).append("languageCd", languageCd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(emailAddress).append(preferredPhoneNumber).append(languageCd).append(additionalProperties).append(isEmailNotificationRequired).append(contactTimePreference).append(isPhoneCallRequired).append(snailMail).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ContactMe) == false) {
            return false;
        }
        ContactMe rhs = ((ContactMe) other);
        return new EqualsBuilder().append(emailAddress, rhs.emailAddress).append(preferredPhoneNumber, rhs.preferredPhoneNumber).append(languageCd, rhs.languageCd).append(additionalProperties, rhs.additionalProperties).append(isEmailNotificationRequired, rhs.isEmailNotificationRequired).append(contactTimePreference, rhs.contactTimePreference).append(isPhoneCallRequired, rhs.isPhoneCallRequired).append(snailMail, rhs.snailMail).isEquals();
    }

}
