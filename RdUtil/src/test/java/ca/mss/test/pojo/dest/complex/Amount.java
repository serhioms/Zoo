
package ca.mss.test.pojo.dest.complex;

import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Monetary amount information associated with a financial event.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "typeCd",
    "cccyamt"
})
public class Amount {

    /**
     * A code captures information that classifies the types of financial event amounts.
     * 
     */
    @JsonProperty("typeCd")
    @JsonPropertyDescription("A code captures information that classifies the types of financial event amounts.")
    private String typeCd;
    /**
     * The amount of the event in the transacted currency.
     * 
     */
    @JsonProperty("cccyamt")
    @JsonPropertyDescription("The amount of the event in the transacted currency.")
    @Valid
    private Cccyamt cccyamt;

    /**
     * A code captures information that classifies the types of financial event amounts.
     * 
     */
    @JsonProperty("typeCd")
    public String getTypeCd() {
        return typeCd;
    }

    /**
     * A code captures information that classifies the types of financial event amounts.
     * 
     */
    @JsonProperty("typeCd")
    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    /**
     * The amount of the event in the transacted currency.
     * 
     */
    @JsonProperty("cccyamt")
    public Cccyamt getCccyamt() {
        return cccyamt;
    }

    /**
     * The amount of the event in the transacted currency.
     * 
     */
    @JsonProperty("cccyamt")
    public void setCccyamt(Cccyamt cccyamt) {
        this.cccyamt = cccyamt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("typeCd", typeCd).append("cccyamt", cccyamt).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(typeCd).append(cccyamt).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Amount) == false) {
            return false;
        }
        Amount rhs = ((Amount) other);
        return new EqualsBuilder().append(typeCd, rhs.typeCd).append(cccyamt, rhs.cccyamt).isEquals();
    }

}
