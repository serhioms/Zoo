
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
 * This attribute associated with the ending monetary amount of a range amount. This attribute could be null or the same amount as the "from" if only a single value.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amount",
    "currencyCd"
})
public class ToCcyamt {

    /**
     *  decimal represents a subset of the real numbers, which can be represented by decimal numerals. The ·value space· of decimal is the set of numbers that can be obtained by multiplying an integer by a non-positive power of ten, i.e., expressible as i × 10^-n where i and n are integers and n >= 0. Precision is not reflected in this value space; the number 2.0 is not distinct from the number 2.00. The ·order-relation· on decimal is the order relation on real numbers, restricted to this subset.
     * (Required)
     * 
     */
    @JsonProperty("amount")
    @JsonPropertyDescription(" decimal represents a subset of the real numbers, which can be represented by decimal numerals. The \u00b7value space\u00b7 of decimal is the set of numbers that can be obtained by multiplying an integer by a non-positive power of ten, i.e., expressible as i \u00d7 10^-n where i and n are integers and n >= 0. Precision is not reflected in this value space; the number 2.0 is not distinct from the number 2.00. The \u00b7order-relation\u00b7 on decimal is the order relation on real numbers, restricted to this subset.")
    @NotNull
    private Double amount;
    /**
     * ISO 4217 Currency Codes, for example, CAD, USD.
     * 
     */
    @JsonProperty("currencyCd")
    @JsonPropertyDescription("ISO 4217 Currency Codes, for example, CAD, USD.")
    private String currencyCd;

    /**
     *  decimal represents a subset of the real numbers, which can be represented by decimal numerals. The ·value space· of decimal is the set of numbers that can be obtained by multiplying an integer by a non-positive power of ten, i.e., expressible as i × 10^-n where i and n are integers and n >= 0. Precision is not reflected in this value space; the number 2.0 is not distinct from the number 2.00. The ·order-relation· on decimal is the order relation on real numbers, restricted to this subset.
     * (Required)
     * 
     */
    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    /**
     *  decimal represents a subset of the real numbers, which can be represented by decimal numerals. The ·value space· of decimal is the set of numbers that can be obtained by multiplying an integer by a non-positive power of ten, i.e., expressible as i × 10^-n where i and n are integers and n >= 0. Precision is not reflected in this value space; the number 2.0 is not distinct from the number 2.00. The ·order-relation· on decimal is the order relation on real numbers, restricted to this subset.
     * (Required)
     * 
     */
    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * ISO 4217 Currency Codes, for example, CAD, USD.
     * 
     */
    @JsonProperty("currencyCd")
    public String getCurrencyCd() {
        return currencyCd;
    }

    /**
     * ISO 4217 Currency Codes, for example, CAD, USD.
     * 
     */
    @JsonProperty("currencyCd")
    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("amount", amount).append("currencyCd", currencyCd).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(amount).append(currencyCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ToCcyamt) == false) {
            return false;
        }
        ToCcyamt rhs = ((ToCcyamt) other);
        return new EqualsBuilder().append(amount, rhs.amount).append(currencyCd, rhs.currencyCd).isEquals();
    }

}
