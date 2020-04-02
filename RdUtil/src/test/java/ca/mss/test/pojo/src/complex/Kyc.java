
package ca.mss.test.pojo.src.complex;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
    "areThirdPartiesInterested",
    "shareInfoSecurityHolder",
    "shareholderCommunication",
    "stockExperienceNumYears",
    "bondsExperienceNumYears",
    "optionsExperienceNumYears",
    "mutualFundsExperienceNumYears",
    "shortSellingExperienceNumYears",
    "areYouInControlPosition",
    "kycControlPosition",
    "areYouDirectorOfficer",
    "kycDirectorOfficer",
    "anyInvestmentProsInTheHousehold",
    "kycPro",
    "doYouHaveOtherAccounts",
    "brokerageAccounts"
})
public class Kyc implements Serializable, Cloneable
{

    @JsonProperty("areThirdPartiesInterested")
    private String areThirdPartiesInterested;
    /**
     * This can be Y/N/NA used specifically by DI.
     * 
     */
    @JsonProperty("shareInfoSecurityHolder")
    @JsonPropertyDescription("This can be Y/N/NA used specifically by DI.")
    private String shareInfoSecurityHolder;
    /**
     * This can be RECEIVE_ALL /DECLINE_ALL used specifically by DI.
     * 
     */
    @JsonProperty("shareholderCommunication")
    @JsonPropertyDescription("This can be RECEIVE_ALL /DECLINE_ALL used specifically by DI.")
    private String shareholderCommunication;
    @JsonProperty("stockExperienceNumYears")
    private Double stockExperienceNumYears;
    @JsonProperty("bondsExperienceNumYears")
    private Double bondsExperienceNumYears;
    @JsonProperty("optionsExperienceNumYears")
    private Double optionsExperienceNumYears;
    @JsonProperty("mutualFundsExperienceNumYears")
    private Double mutualFundsExperienceNumYears;
    @JsonProperty("shortSellingExperienceNumYears")
    private Double shortSellingExperienceNumYears;
    @JsonProperty("areYouInControlPosition")
    private Boolean areYouInControlPosition;
    @JsonProperty("kycControlPosition")
    private List<KycControlPosition> kycControlPosition = null;
    @JsonProperty("areYouDirectorOfficer")
    private Boolean areYouDirectorOfficer;
    @JsonProperty("kycDirectorOfficer")
    private List<KycDirectorOfficer> kycDirectorOfficer = null;
    @JsonProperty("anyInvestmentProsInTheHousehold")
    private Boolean anyInvestmentProsInTheHousehold;
    @JsonProperty("kycPro")
    private List<KycPro> kycPro = null;
    @JsonProperty("doYouHaveOtherAccounts")
    private Boolean doYouHaveOtherAccounts;
    @JsonProperty("brokerageAccounts")
    private List<Account> brokerageAccounts = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7985770485112644976L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Kyc() {
    }

    /**
     * 
     * @param shortSellingExperienceNumYears
     * @param optionsExperienceNumYears
     * @param brokerageAccounts
     * @param shareInfoSecurityHolder
     * @param doYouHaveOtherAccounts
     * @param areYouInControlPosition
     * @param areThirdPartiesInterested
     * @param mutualFundsExperienceNumYears
     * @param stockExperienceNumYears
     * @param areYouDirectorOfficer
     * @param kycPro
     * @param kycControlPosition
     * @param kycDirectorOfficer
     * @param anyInvestmentProsInTheHousehold
     * @param shareholderCommunication
     * @param bondsExperienceNumYears
     */
    public Kyc(String areThirdPartiesInterested, String shareInfoSecurityHolder, String shareholderCommunication, Double stockExperienceNumYears, Double bondsExperienceNumYears, Double optionsExperienceNumYears, Double mutualFundsExperienceNumYears, Double shortSellingExperienceNumYears, Boolean areYouInControlPosition, List<KycControlPosition> kycControlPosition, Boolean areYouDirectorOfficer, List<KycDirectorOfficer> kycDirectorOfficer, Boolean anyInvestmentProsInTheHousehold, List<KycPro> kycPro, Boolean doYouHaveOtherAccounts, List<Account> brokerageAccounts) {
        super();
        this.areThirdPartiesInterested = areThirdPartiesInterested;
        this.shareInfoSecurityHolder = shareInfoSecurityHolder;
        this.shareholderCommunication = shareholderCommunication;
        this.stockExperienceNumYears = stockExperienceNumYears;
        this.bondsExperienceNumYears = bondsExperienceNumYears;
        this.optionsExperienceNumYears = optionsExperienceNumYears;
        this.mutualFundsExperienceNumYears = mutualFundsExperienceNumYears;
        this.shortSellingExperienceNumYears = shortSellingExperienceNumYears;
        this.areYouInControlPosition = areYouInControlPosition;
        this.kycControlPosition = kycControlPosition;
        this.areYouDirectorOfficer = areYouDirectorOfficer;
        this.kycDirectorOfficer = kycDirectorOfficer;
        this.anyInvestmentProsInTheHousehold = anyInvestmentProsInTheHousehold;
        this.kycPro = kycPro;
        this.doYouHaveOtherAccounts = doYouHaveOtherAccounts;
        this.brokerageAccounts = brokerageAccounts;
    }

    @JsonProperty("areThirdPartiesInterested")
    public String getAreThirdPartiesInterested() {
        return areThirdPartiesInterested;
    }

    @JsonProperty("areThirdPartiesInterested")
    public void setAreThirdPartiesInterested(String areThirdPartiesInterested) {
        this.areThirdPartiesInterested = areThirdPartiesInterested;
    }

    /**
     * This can be Y/N/NA used specifically by DI.
     * 
     */
    @JsonProperty("shareInfoSecurityHolder")
    public String getShareInfoSecurityHolder() {
        return shareInfoSecurityHolder;
    }

    /**
     * This can be Y/N/NA used specifically by DI.
     * 
     */
    @JsonProperty("shareInfoSecurityHolder")
    public void setShareInfoSecurityHolder(String shareInfoSecurityHolder) {
        this.shareInfoSecurityHolder = shareInfoSecurityHolder;
    }

    /**
     * This can be RECEIVE_ALL /DECLINE_ALL used specifically by DI.
     * 
     */
    @JsonProperty("shareholderCommunication")
    public String getShareholderCommunication() {
        return shareholderCommunication;
    }

    /**
     * This can be RECEIVE_ALL /DECLINE_ALL used specifically by DI.
     * 
     */
    @JsonProperty("shareholderCommunication")
    public void setShareholderCommunication(String shareholderCommunication) {
        this.shareholderCommunication = shareholderCommunication;
    }

    @JsonProperty("stockExperienceNumYears")
    public Double getStockExperienceNumYears() {
        return stockExperienceNumYears;
    }

    @JsonProperty("stockExperienceNumYears")
    public void setStockExperienceNumYears(Double stockExperienceNumYears) {
        this.stockExperienceNumYears = stockExperienceNumYears;
    }

    @JsonProperty("bondsExperienceNumYears")
    public Double getBondsExperienceNumYears() {
        return bondsExperienceNumYears;
    }

    @JsonProperty("bondsExperienceNumYears")
    public void setBondsExperienceNumYears(Double bondsExperienceNumYears) {
        this.bondsExperienceNumYears = bondsExperienceNumYears;
    }

    @JsonProperty("optionsExperienceNumYears")
    public Double getOptionsExperienceNumYears() {
        return optionsExperienceNumYears;
    }

    @JsonProperty("optionsExperienceNumYears")
    public void setOptionsExperienceNumYears(Double optionsExperienceNumYears) {
        this.optionsExperienceNumYears = optionsExperienceNumYears;
    }

    @JsonProperty("mutualFundsExperienceNumYears")
    public Double getMutualFundsExperienceNumYears() {
        return mutualFundsExperienceNumYears;
    }

    @JsonProperty("mutualFundsExperienceNumYears")
    public void setMutualFundsExperienceNumYears(Double mutualFundsExperienceNumYears) {
        this.mutualFundsExperienceNumYears = mutualFundsExperienceNumYears;
    }

    @JsonProperty("shortSellingExperienceNumYears")
    public Double getShortSellingExperienceNumYears() {
        return shortSellingExperienceNumYears;
    }

    @JsonProperty("shortSellingExperienceNumYears")
    public void setShortSellingExperienceNumYears(Double shortSellingExperienceNumYears) {
        this.shortSellingExperienceNumYears = shortSellingExperienceNumYears;
    }

    @JsonProperty("areYouInControlPosition")
    public Boolean getAreYouInControlPosition() {
        return areYouInControlPosition;
    }

    @JsonProperty("areYouInControlPosition")
    public void setAreYouInControlPosition(Boolean areYouInControlPosition) {
        this.areYouInControlPosition = areYouInControlPosition;
    }

    @JsonProperty("kycControlPosition")
    public List<KycControlPosition> getKycControlPosition() {
        return kycControlPosition;
    }

    @JsonProperty("kycControlPosition")
    public void setKycControlPosition(List<KycControlPosition> kycControlPosition) {
        this.kycControlPosition = kycControlPosition;
    }

    @JsonProperty("areYouDirectorOfficer")
    public Boolean getAreYouDirectorOfficer() {
        return areYouDirectorOfficer;
    }

    @JsonProperty("areYouDirectorOfficer")
    public void setAreYouDirectorOfficer(Boolean areYouDirectorOfficer) {
        this.areYouDirectorOfficer = areYouDirectorOfficer;
    }

    @JsonProperty("kycDirectorOfficer")
    public List<KycDirectorOfficer> getKycDirectorOfficer() {
        return kycDirectorOfficer;
    }

    @JsonProperty("kycDirectorOfficer")
    public void setKycDirectorOfficer(List<KycDirectorOfficer> kycDirectorOfficer) {
        this.kycDirectorOfficer = kycDirectorOfficer;
    }

    @JsonProperty("anyInvestmentProsInTheHousehold")
    public Boolean getAnyInvestmentProsInTheHousehold() {
        return anyInvestmentProsInTheHousehold;
    }

    @JsonProperty("anyInvestmentProsInTheHousehold")
    public void setAnyInvestmentProsInTheHousehold(Boolean anyInvestmentProsInTheHousehold) {
        this.anyInvestmentProsInTheHousehold = anyInvestmentProsInTheHousehold;
    }

    @JsonProperty("kycPro")
    public List<KycPro> getKycPro() {
        return kycPro;
    }

    @JsonProperty("kycPro")
    public void setKycPro(List<KycPro> kycPro) {
        this.kycPro = kycPro;
    }

    @JsonProperty("doYouHaveOtherAccounts")
    public Boolean getDoYouHaveOtherAccounts() {
        return doYouHaveOtherAccounts;
    }

    @JsonProperty("doYouHaveOtherAccounts")
    public void setDoYouHaveOtherAccounts(Boolean doYouHaveOtherAccounts) {
        this.doYouHaveOtherAccounts = doYouHaveOtherAccounts;
    }

    @JsonProperty("brokerageAccounts")
    public List<Account> getBrokerageAccounts() {
        return brokerageAccounts;
    }

    @JsonProperty("brokerageAccounts")
    public void setBrokerageAccounts(List<Account> brokerageAccounts) {
        this.brokerageAccounts = brokerageAccounts;
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
        return new ToStringBuilder(this).append("areThirdPartiesInterested", areThirdPartiesInterested).append("shareInfoSecurityHolder", shareInfoSecurityHolder).append("shareholderCommunication", shareholderCommunication).append("stockExperienceNumYears", stockExperienceNumYears).append("bondsExperienceNumYears", bondsExperienceNumYears).append("optionsExperienceNumYears", optionsExperienceNumYears).append("mutualFundsExperienceNumYears", mutualFundsExperienceNumYears).append("shortSellingExperienceNumYears", shortSellingExperienceNumYears).append("areYouInControlPosition", areYouInControlPosition).append("kycControlPosition", kycControlPosition).append("areYouDirectorOfficer", areYouDirectorOfficer).append("kycDirectorOfficer", kycDirectorOfficer).append("anyInvestmentProsInTheHousehold", anyInvestmentProsInTheHousehold).append("kycPro", kycPro).append("doYouHaveOtherAccounts", doYouHaveOtherAccounts).append("brokerageAccounts", brokerageAccounts).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(shortSellingExperienceNumYears).append(optionsExperienceNumYears).append(brokerageAccounts).append(shareInfoSecurityHolder).append(doYouHaveOtherAccounts).append(areYouInControlPosition).append(areThirdPartiesInterested).append(mutualFundsExperienceNumYears).append(stockExperienceNumYears).append(areYouDirectorOfficer).append(kycPro).append(kycControlPosition).append(kycDirectorOfficer).append(anyInvestmentProsInTheHousehold).append(additionalProperties).append(shareholderCommunication).append(bondsExperienceNumYears).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Kyc) == false) {
            return false;
        }
        Kyc rhs = ((Kyc) other);
        return new EqualsBuilder().append(shortSellingExperienceNumYears, rhs.shortSellingExperienceNumYears).append(optionsExperienceNumYears, rhs.optionsExperienceNumYears).append(brokerageAccounts, rhs.brokerageAccounts).append(shareInfoSecurityHolder, rhs.shareInfoSecurityHolder).append(doYouHaveOtherAccounts, rhs.doYouHaveOtherAccounts).append(areYouInControlPosition, rhs.areYouInControlPosition).append(areThirdPartiesInterested, rhs.areThirdPartiesInterested).append(mutualFundsExperienceNumYears, rhs.mutualFundsExperienceNumYears).append(stockExperienceNumYears, rhs.stockExperienceNumYears).append(areYouDirectorOfficer, rhs.areYouDirectorOfficer).append(kycPro, rhs.kycPro).append(kycControlPosition, rhs.kycControlPosition).append(kycDirectorOfficer, rhs.kycDirectorOfficer).append(anyInvestmentProsInTheHousehold, rhs.anyInvestmentProsInTheHousehold).append(additionalProperties, rhs.additionalProperties).append(shareholderCommunication, rhs.shareholderCommunication).append(bondsExperienceNumYears, rhs.bondsExperienceNumYears).isEquals();
    }

}
