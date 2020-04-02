
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "usageCd",
    "locator"
})
public class Contact_ {

    /**
     * Contact Usage Canonical Code.
     * 
     */
    @JsonProperty("usageCd")
    @JsonPropertyDescription("Contact Usage Canonical Code.")
    private String usageCd;
    /**
     * Contact Locator.
     * (Required)
     * 
     */
    @JsonProperty("locator")
    @JsonPropertyDescription("Contact Locator.")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<Locator_> locator = new ArrayList<Locator_>();

    /**
     * Contact Usage Canonical Code.
     * 
     */
    @JsonProperty("usageCd")
    public String getUsageCd() {
        return usageCd;
    }

    /**
     * Contact Usage Canonical Code.
     * 
     */
    @JsonProperty("usageCd")
    public void setUsageCd(String usageCd) {
        this.usageCd = usageCd;
    }

    /**
     * Contact Locator.
     * (Required)
     * 
     */
    @JsonProperty("locator")
    public List<Locator_> getLocator() {
        return locator;
    }

    /**
     * Contact Locator.
     * (Required)
     * 
     */
    @JsonProperty("locator")
    public void setLocator(List<Locator_> locator) {
        this.locator = locator;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("usageCd", usageCd).append("locator", locator).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(locator).append(usageCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Contact_) == false) {
            return false;
        }
        Contact_ rhs = ((Contact_) other);
        return new EqualsBuilder().append(locator, rhs.locator).append(usageCd, rhs.usageCd).isEquals();
    }

}
