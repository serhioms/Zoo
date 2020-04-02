
package ca.mss.test.pojo.dest.complex;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Agreement Alternative Key.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bankNum",
    "branchNum",
    "accountNum",
    "agreementTypeCd"
})
public class Altkey____ {

    /**
     * 
     * 
     */
    @JsonProperty("bankNum")
    @JsonPropertyDescription("")
    private String bankNum;
    /**
     * 
     * 
     */
    @JsonProperty("branchNum")
    @JsonPropertyDescription("")
    private String branchNum;
    /**
     * 
     * 
     */
    @JsonProperty("accountNum")
    @JsonPropertyDescription("")
    private String accountNum;
    /**
     * A code used to discriminate the type of agreement e.g. LON - loan agreement, MTG - mortgage agreement.
     * 
     */
    @JsonProperty("agreementTypeCd")
    @JsonPropertyDescription("A code used to discriminate the type of agreement e.g. LON - loan agreement, MTG - mortgage agreement.")
    private String agreementTypeCd;

    /**
     * 
     * 
     */
    @JsonProperty("bankNum")
    public String getBankNum() {
        return bankNum;
    }

    /**
     * 
     * 
     */
    @JsonProperty("bankNum")
    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    /**
     * 
     * 
     */
    @JsonProperty("branchNum")
    public String getBranchNum() {
        return branchNum;
    }

    /**
     * 
     * 
     */
    @JsonProperty("branchNum")
    public void setBranchNum(String branchNum) {
        this.branchNum = branchNum;
    }

    /**
     * 
     * 
     */
    @JsonProperty("accountNum")
    public String getAccountNum() {
        return accountNum;
    }

    /**
     * 
     * 
     */
    @JsonProperty("accountNum")
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    /**
     * A code used to discriminate the type of agreement e.g. LON - loan agreement, MTG - mortgage agreement.
     * 
     */
    @JsonProperty("agreementTypeCd")
    public String getAgreementTypeCd() {
        return agreementTypeCd;
    }

    /**
     * A code used to discriminate the type of agreement e.g. LON - loan agreement, MTG - mortgage agreement.
     * 
     */
    @JsonProperty("agreementTypeCd")
    public void setAgreementTypeCd(String agreementTypeCd) {
        this.agreementTypeCd = agreementTypeCd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("bankNum", bankNum).append("branchNum", branchNum).append("accountNum", accountNum).append("agreementTypeCd", agreementTypeCd).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(branchNum).append(bankNum).append(agreementTypeCd).append(accountNum).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Altkey____) == false) {
            return false;
        }
        Altkey____ rhs = ((Altkey____) other);
        return new EqualsBuilder().append(branchNum, rhs.branchNum).append(bankNum, rhs.bankNum).append(agreementTypeCd, rhs.agreementTypeCd).append(accountNum, rhs.accountNum).isEquals();
    }

}
