
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
    "amount",
    "type",
    "currency"
})
public class OptionAmt implements Serializable, Cloneable
{

    @JsonProperty("amount")
    private Double amount;
    /**
     * periodicPaymentAmt/totalPaymentAmt/lastPaymentAmt/cobAmt/remainingBalanceAmt/approvedAmt/requestedAmt/acceptedAmt
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("periodicPaymentAmt/totalPaymentAmt/lastPaymentAmt/cobAmt/remainingBalanceAmt/approvedAmt/requestedAmt/acceptedAmt")
    private String type;
    @JsonProperty("currency")
    private String currency;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -9201422652214891266L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OptionAmt() {
    }

    /**
     * 
     * @param amount
     * @param currency
     * @param type
     */
    public OptionAmt(Double amount, String type, String currency) {
        super();
        this.amount = amount;
        this.type = type;
        this.currency = currency;
    }

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * periodicPaymentAmt/totalPaymentAmt/lastPaymentAmt/cobAmt/remainingBalanceAmt/approvedAmt/requestedAmt/acceptedAmt
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * periodicPaymentAmt/totalPaymentAmt/lastPaymentAmt/cobAmt/remainingBalanceAmt/approvedAmt/requestedAmt/acceptedAmt
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
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
        return new ToStringBuilder(this).append("amount", amount).append("type", type).append("currency", currency).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(amount).append(currency).append(additionalProperties).append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OptionAmt) == false) {
            return false;
        }
        OptionAmt rhs = ((OptionAmt) other);
        return new EqualsBuilder().append(amount, rhs.amount).append(currency, rhs.currency).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).isEquals();
    }

}
