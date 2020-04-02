
package ca.mss.test.pojo.dest.complex;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "text",
    "domainName"
})
public class EmailAddress_ {

    /**
     * The entire electronic address text string.
     * 
     */
    @JsonProperty("text")
    @JsonPropertyDescription("The entire electronic address text string.")
    private String text;
    /**
     * The name of the registered InterNIC (Internet Network Information Center in the US) domain such as: AOL, Microsoft, Earthlink, etc.
     * 
     */
    @JsonProperty("domainName")
    @JsonPropertyDescription("The name of the registered InterNIC (Internet Network Information Center in the US) domain such as: AOL, Microsoft, Earthlink, etc.")
    private String domainName;

    /**
     * The entire electronic address text string.
     * 
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * The entire electronic address text string.
     * 
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     * The name of the registered InterNIC (Internet Network Information Center in the US) domain such as: AOL, Microsoft, Earthlink, etc.
     * 
     */
    @JsonProperty("domainName")
    public String getDomainName() {
        return domainName;
    }

    /**
     * The name of the registered InterNIC (Internet Network Information Center in the US) domain such as: AOL, Microsoft, Earthlink, etc.
     * 
     */
    @JsonProperty("domainName")
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("text", text).append("domainName", domainName).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(text).append(domainName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EmailAddress_) == false) {
            return false;
        }
        EmailAddress_ rhs = ((EmailAddress_) other);
        return new EqualsBuilder().append(text, rhs.text).append(domainName, rhs.domainName).isEquals();
    }

}
