
package ca.mss.test.pojo.dest.complex;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Describe the relationships that this agreement has with parties. Examples include primary obligor, secondary obligor, and cosigner.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "roleCd",
    "fullName",
    "nameTypeCd",
    "contact"
})
public class AgreementToParty__ {

    /**
     * Roles that parties have with the agreement such as primary obligor, secondary obligor, and cosigner.
     * 
     */
    @JsonProperty("roleCd")
    @JsonPropertyDescription("Roles that parties have with the agreement such as primary obligor, secondary obligor, and cosigner.")
    @Valid
    private List<String> roleCd = new ArrayList<String>();
    /**
     * Party Full Name.
     * The full name of the party, individual or company.
     * 
     */
    @JsonProperty("fullName")
    @JsonPropertyDescription("Party Full Name.\r\nThe full name of the party, individual or company.")
    private String fullName;
    /**
     * Type of Party Full Name.
     * 
     */
    @JsonProperty("nameTypeCd")
    @JsonPropertyDescription("Type of Party Full Name.")
    private String nameTypeCd;
    /**
     * Party Contact Information.
     * 
     */
    @JsonProperty("contact")
    @JsonPropertyDescription("Party Contact Information.")
    @Valid
    private List<Contact__> contact = new ArrayList<Contact__>();

    /**
     * Roles that parties have with the agreement such as primary obligor, secondary obligor, and cosigner.
     * 
     */
    @JsonProperty("roleCd")
    public List<String> getRoleCd() {
        return roleCd;
    }

    /**
     * Roles that parties have with the agreement such as primary obligor, secondary obligor, and cosigner.
     * 
     */
    @JsonProperty("roleCd")
    public void setRoleCd(List<String> roleCd) {
        this.roleCd = roleCd;
    }

    /**
     * Party Full Name.
     * The full name of the party, individual or company.
     * 
     */
    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    /**
     * Party Full Name.
     * The full name of the party, individual or company.
     * 
     */
    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Type of Party Full Name.
     * 
     */
    @JsonProperty("nameTypeCd")
    public String getNameTypeCd() {
        return nameTypeCd;
    }

    /**
     * Type of Party Full Name.
     * 
     */
    @JsonProperty("nameTypeCd")
    public void setNameTypeCd(String nameTypeCd) {
        this.nameTypeCd = nameTypeCd;
    }

    /**
     * Party Contact Information.
     * 
     */
    @JsonProperty("contact")
    public List<Contact__> getContact() {
        return contact;
    }

    /**
     * Party Contact Information.
     * 
     */
    @JsonProperty("contact")
    public void setContact(List<Contact__> contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("roleCd", roleCd).append("fullName", fullName).append("nameTypeCd", nameTypeCd).append("contact", contact).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(roleCd).append(nameTypeCd).append(fullName).append(contact).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgreementToParty__) == false) {
            return false;
        }
        AgreementToParty__ rhs = ((AgreementToParty__) other);
        return new EqualsBuilder().append(roleCd, rhs.roleCd).append(nameTypeCd, rhs.nameTypeCd).append(fullName, rhs.fullName).append(contact, rhs.contact).isEquals();
    }

}
