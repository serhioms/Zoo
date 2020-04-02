
package ca.mss.test.pojo.src.complex;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "partyLiabilityId",
    "typeCd",
    "accountTypeCd",
    "financialInstitutionName",
    "liabilityDesc",
    "creditBureauBalanceAmt",
    "overrideBalanceAmt",
    "selected"
})
public class LiabilityList implements Serializable, Cloneable
{

    @JsonProperty("partyLiabilityId")
    private String partyLiabilityId;
    @JsonProperty("typeCd")
    private String typeCd;
    @JsonProperty("accountTypeCd")
    private String accountTypeCd;
    @JsonProperty("financialInstitutionName")
    private String financialInstitutionName;
    @JsonProperty("liabilityDesc")
    private String liabilityDesc;
    @JsonProperty("creditBureauBalanceAmt")
    private OptionAmt creditBureauBalanceAmt;
    @JsonProperty("overrideBalanceAmt")
    private OptionAmt overrideBalanceAmt;
    @JsonProperty("selected")
    private Boolean selected;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7772318324106875609L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LiabilityList() {
    }

    /**
     * 
     * @param typeCd
     * @param overrideBalanceAmt
     * @param creditBureauBalanceAmt
     * @param partyLiabilityId
     * @param accountTypeCd
     * @param liabilityDesc
     * @param financialInstitutionName
     * @param selected
     */
    public LiabilityList(String partyLiabilityId, String typeCd, String accountTypeCd, String financialInstitutionName, String liabilityDesc, OptionAmt creditBureauBalanceAmt, OptionAmt overrideBalanceAmt, Boolean selected) {
        super();
        this.partyLiabilityId = partyLiabilityId;
        this.typeCd = typeCd;
        this.accountTypeCd = accountTypeCd;
        this.financialInstitutionName = financialInstitutionName;
        this.liabilityDesc = liabilityDesc;
        this.creditBureauBalanceAmt = creditBureauBalanceAmt;
        this.overrideBalanceAmt = overrideBalanceAmt;
        this.selected = selected;
    }

    @JsonProperty("partyLiabilityId")
    public String getPartyLiabilityId() {
        return partyLiabilityId;
    }

    @JsonProperty("partyLiabilityId")
    public void setPartyLiabilityId(String partyLiabilityId) {
        this.partyLiabilityId = partyLiabilityId;
    }

    @JsonProperty("typeCd")
    public String getTypeCd() {
        return typeCd;
    }

    @JsonProperty("typeCd")
    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    @JsonProperty("accountTypeCd")
    public String getAccountTypeCd() {
        return accountTypeCd;
    }

    @JsonProperty("accountTypeCd")
    public void setAccountTypeCd(String accountTypeCd) {
        this.accountTypeCd = accountTypeCd;
    }

    @JsonProperty("financialInstitutionName")
    public String getFinancialInstitutionName() {
        return financialInstitutionName;
    }

    @JsonProperty("financialInstitutionName")
    public void setFinancialInstitutionName(String financialInstitutionName) {
        this.financialInstitutionName = financialInstitutionName;
    }

    @JsonProperty("liabilityDesc")
    public String getLiabilityDesc() {
        return liabilityDesc;
    }

    @JsonProperty("liabilityDesc")
    public void setLiabilityDesc(String liabilityDesc) {
        this.liabilityDesc = liabilityDesc;
    }

    @JsonProperty("creditBureauBalanceAmt")
    public OptionAmt getCreditBureauBalanceAmt() {
        return creditBureauBalanceAmt;
    }

    @JsonProperty("creditBureauBalanceAmt")
    public void setCreditBureauBalanceAmt(OptionAmt creditBureauBalanceAmt) {
        this.creditBureauBalanceAmt = creditBureauBalanceAmt;
    }

    @JsonProperty("overrideBalanceAmt")
    public OptionAmt getOverrideBalanceAmt() {
        return overrideBalanceAmt;
    }

    @JsonProperty("overrideBalanceAmt")
    public void setOverrideBalanceAmt(OptionAmt overrideBalanceAmt) {
        this.overrideBalanceAmt = overrideBalanceAmt;
    }

    @JsonProperty("selected")
    public Boolean getSelected() {
        return selected;
    }

    @JsonProperty("selected")
    public void setSelected(Boolean selected) {
        this.selected = selected;
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
        return new ToStringBuilder(this).append("partyLiabilityId", partyLiabilityId).append("typeCd", typeCd).append("accountTypeCd", accountTypeCd).append("financialInstitutionName", financialInstitutionName).append("liabilityDesc", liabilityDesc).append("creditBureauBalanceAmt", creditBureauBalanceAmt).append("overrideBalanceAmt", overrideBalanceAmt).append("selected", selected).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(typeCd).append(overrideBalanceAmt).append(creditBureauBalanceAmt).append(partyLiabilityId).append(accountTypeCd).append(additionalProperties).append(liabilityDesc).append(financialInstitutionName).append(selected).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LiabilityList) == false) {
            return false;
        }
        LiabilityList rhs = ((LiabilityList) other);
        return new EqualsBuilder().append(typeCd, rhs.typeCd).append(overrideBalanceAmt, rhs.overrideBalanceAmt).append(creditBureauBalanceAmt, rhs.creditBureauBalanceAmt).append(partyLiabilityId, rhs.partyLiabilityId).append(accountTypeCd, rhs.accountTypeCd).append(additionalProperties, rhs.additionalProperties).append(liabilityDesc, rhs.liabilityDesc).append(financialInstitutionName, rhs.financialInstitutionName).append(selected, rhs.selected).isEquals();
    }

}
