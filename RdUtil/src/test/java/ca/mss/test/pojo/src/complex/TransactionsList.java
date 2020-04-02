
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
    "id",
    "sourceAccount",
    "destinationAccount",
    "type",
    "amount",
    "date",
    "depositOption",
    "purpose"
})
public class TransactionsList implements Serializable, Cloneable
{

    /**
     * This is a txnId which is related to application or completed for a specific account open application. This is generated in UI and added it at Account Level as well for which this txn needs to be linked.
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("This is a txnId which is related to application or completed for a specific account open application. This is generated in UI and added it at Account Level as well for which this txn needs to be linked.")
    private String id;
    @JsonProperty("sourceAccount")
    private Account sourceAccount;
    @JsonProperty("destinationAccount")
    private Account destinationAccount;
    /**
     * Transaction Types such as 0 -CreditTxn, 1 -DebitTxn
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Transaction Types such as 0 -CreditTxn, 1 -DebitTxn")
    private String type;
    @JsonProperty("amount")
    private OptionAmt amount;
    @JsonProperty("date")
    private Long date;
    /**
     * Enum: TD2TD - TD to TD transfer / OFI - Other Financial Institution Transfer
     * 
     */
    @JsonProperty("depositOption")
    @JsonPropertyDescription("Enum: TD2TD - TD to TD transfer / OFI - Other Financial Institution Transfer")
    private String depositOption;
    @JsonProperty("purpose")
    private String purpose;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -756840194286273325L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TransactionsList() {
    }

    /**
     * 
     * @param date
     * @param amount
     * @param sourceAccount
     * @param depositOption
     * @param purpose
     * @param id
     * @param type
     * @param destinationAccount
     */
    public TransactionsList(String id, Account sourceAccount, Account destinationAccount, String type, OptionAmt amount, Long date, String depositOption, String purpose) {
        super();
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.depositOption = depositOption;
        this.purpose = purpose;
    }

    /**
     * This is a txnId which is related to application or completed for a specific account open application. This is generated in UI and added it at Account Level as well for which this txn needs to be linked.
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * This is a txnId which is related to application or completed for a specific account open application. This is generated in UI and added it at Account Level as well for which this txn needs to be linked.
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("sourceAccount")
    public Account getSourceAccount() {
        return sourceAccount;
    }

    @JsonProperty("sourceAccount")
    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    @JsonProperty("destinationAccount")
    public Account getDestinationAccount() {
        return destinationAccount;
    }

    @JsonProperty("destinationAccount")
    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    /**
     * Transaction Types such as 0 -CreditTxn, 1 -DebitTxn
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Transaction Types such as 0 -CreditTxn, 1 -DebitTxn
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("amount")
    public OptionAmt getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(OptionAmt amount) {
        this.amount = amount;
    }

    @JsonProperty("date")
    public Long getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(Long date) {
        this.date = date;
    }

    /**
     * Enum: TD2TD - TD to TD transfer / OFI - Other Financial Institution Transfer
     * 
     */
    @JsonProperty("depositOption")
    public String getDepositOption() {
        return depositOption;
    }

    /**
     * Enum: TD2TD - TD to TD transfer / OFI - Other Financial Institution Transfer
     * 
     */
    @JsonProperty("depositOption")
    public void setDepositOption(String depositOption) {
        this.depositOption = depositOption;
    }

    @JsonProperty("purpose")
    public String getPurpose() {
        return purpose;
    }

    @JsonProperty("purpose")
    public void setPurpose(String purpose) {
        this.purpose = purpose;
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
        return new ToStringBuilder(this).append("id", id).append("sourceAccount", sourceAccount).append("destinationAccount", destinationAccount).append("type", type).append("amount", amount).append("date", date).append("depositOption", depositOption).append("purpose", purpose).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(date).append(amount).append(sourceAccount).append(depositOption).append(purpose).append(id).append(additionalProperties).append(type).append(destinationAccount).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionsList) == false) {
            return false;
        }
        TransactionsList rhs = ((TransactionsList) other);
        return new EqualsBuilder().append(date, rhs.date).append(amount, rhs.amount).append(sourceAccount, rhs.sourceAccount).append(depositOption, rhs.depositOption).append(purpose, rhs.purpose).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(destinationAccount, rhs.destinationAccount).isEquals();
    }

}
