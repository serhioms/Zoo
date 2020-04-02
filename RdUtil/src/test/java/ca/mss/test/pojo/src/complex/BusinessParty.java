
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
    "daPartyId",
    "industryCd",
    "industryClassCd",
    "tradeName",
    "statusCd",
    "businessType",
    "corporationType",
    "patentLettersInd",
    "BusinessTaxDetails",
    "transactionCountryCds",
    "officeLocationCountryCds",
    "notForProfitRegistrationCd",
    "notForProfitInd",
    "legallyFormedCountryCds",
    "franchiseInd",
    "communicationLanguageCd",
    "legalName",
    "nature",
    "ownedSinceDt",
    "establishedDt",
    "email",
    "taxNumber",
    "contact",
    "natureDetail",
    "bankingIdentities",
    "nonBankingIdentities",
    "liability"
})
public class BusinessParty implements Serializable, Cloneable
{

    /**
     * This is a PartyId generated within a EasyApply (DA-DynamicApply), corresponding to EVENT.PARTY_ID.
     * 
     */
    @JsonProperty("daPartyId")
    @JsonPropertyDescription("This is a PartyId generated within a EasyApply (DA-DynamicApply), corresponding to EVENT.PARTY_ID.")
    private String daPartyId;
    /**
     * SIC - Standard Industry Code
     * 
     */
    @JsonProperty("industryCd")
    @JsonPropertyDescription("SIC - Standard Industry Code")
    private String industryCd;
    /**
     * Industry Class Code
     * 
     */
    @JsonProperty("industryClassCd")
    @JsonPropertyDescription("Industry Class Code")
    private String industryClassCd;
    /**
     * Trade Name of Business - If your business uses a Registered Trade Name (trademark) different than Business Name
     * 
     */
    @JsonProperty("tradeName")
    @JsonPropertyDescription("Trade Name of Business - If your business uses a Registered Trade Name (trademark) different than Business Name")
    private String tradeName;
    /**
     * statusCd will store the business status provided in the response by the BSR API. Possible values will be ACTIVE, INACTIVE, NOT FOUND or MISMATCH 
     * 
     */
    @JsonProperty("statusCd")
    @JsonPropertyDescription("statusCd will store the business status provided in the response by the BSR API. Possible values will be ACTIVE, INACTIVE, NOT FOUND or MISMATCH ")
    private String statusCd;
    /**
     * Describes business type as SOLE_PROPRIETOR, PARTNERSHIP, CORPORATION, ASSOCIATION, SOCIETY
     * 
     */
    @JsonProperty("businessType")
    @JsonPropertyDescription("Describes business type as SOLE_PROPRIETOR, PARTNERSHIP, CORPORATION, ASSOCIATION, SOCIETY")
    private String businessType;
    /**
     * If Company Type = Association or Society, then Incorporated or Unincorporated. If Company Type = Corporation, then Private or Publicly
     * 
     */
    @JsonProperty("corporationType")
    @JsonPropertyDescription("If Company Type = Association or Society, then Incorporated or Unincorporated. If Company Type = Corporation, then Private or Publicly")
    private String corporationType;
    /**
     * Yes or No to indicate whether business have patent letter
     * 
     */
    @JsonProperty("patentLettersInd")
    @JsonPropertyDescription("Yes or No to indicate whether business have patent letter")
    private Boolean patentLettersInd;
    @JsonProperty("BusinessTaxDetails")
    private BusinessTaxDetails businessTaxDetails;
    @JsonProperty("transactionCountryCds")
    private List<String> transactionCountryCds = null;
    @JsonProperty("officeLocationCountryCds")
    private List<String> officeLocationCountryCds = null;
    @JsonProperty("notForProfitRegistrationCd")
    private String notForProfitRegistrationCd;
    @JsonProperty("notForProfitInd")
    private Boolean notForProfitInd;
    @JsonProperty("legallyFormedCountryCds")
    private List<String> legallyFormedCountryCds = null;
    @JsonProperty("franchiseInd")
    private Boolean franchiseInd;
    @JsonProperty("communicationLanguageCd")
    private String communicationLanguageCd;
    @JsonProperty("legalName")
    private String legalName;
    @JsonProperty("nature")
    private String nature;
    @JsonProperty("ownedSinceDt")
    private Long ownedSinceDt;
    @JsonProperty("establishedDt")
    private Long establishedDt;
    @JsonProperty("email")
    private String email;
    @JsonProperty("taxNumber")
    private String taxNumber;
    @JsonProperty("contact")
    private Contact contact;
    @JsonProperty("natureDetail")
    private NatureDetail natureDetail;
    /**
     * This is an identity List related to banking Information.
     * 
     */
    @JsonProperty("bankingIdentities")
    @JsonPropertyDescription("This is an identity List related to banking Information.")
    private List<BankingIdentity> bankingIdentities = null;
    /**
     * This is a list of government issued identities such as passport, Driving license etc.
     * 
     */
    @JsonProperty("nonBankingIdentities")
    @JsonPropertyDescription("This is a list of government issued identities such as passport, Driving license etc.")
    private List<NonBankingIdentity> nonBankingIdentities = null;
    @JsonProperty("liability")
    private List<LiabilityList> liability = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3112401543981750118L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BusinessParty() {
    }

    /**
     * 
     * @param communicationLanguageCd
     * @param patentLettersInd
     * @param nonBankingIdentities
     * @param legallyFormedCountryCds
     * @param legalName
     * @param tradeName
     * @param industryCd
     * @param industryClassCd
     * @param officeLocationCountryCds
     * @param contact
     * @param corporationType
     * @param businessTaxDetails
     * @param bankingIdentities
     * @param email
     * @param franchiseInd
     * @param nature
     * @param daPartyId
     * @param liability
     * @param taxNumber
     * @param statusCd
     * @param ownedSinceDt
     * @param natureDetail
     * @param notForProfitInd
     * @param establishedDt
     * @param notForProfitRegistrationCd
     * @param transactionCountryCds
     * @param businessType
     */
    public BusinessParty(String daPartyId, String industryCd, String industryClassCd, String tradeName, String statusCd, String businessType, String corporationType, Boolean patentLettersInd, BusinessTaxDetails businessTaxDetails, List<String> transactionCountryCds, List<String> officeLocationCountryCds, String notForProfitRegistrationCd, Boolean notForProfitInd, List<String> legallyFormedCountryCds, Boolean franchiseInd, String communicationLanguageCd, String legalName, String nature, Long ownedSinceDt, Long establishedDt, String email, String taxNumber, Contact contact, NatureDetail natureDetail, List<BankingIdentity> bankingIdentities, List<NonBankingIdentity> nonBankingIdentities, List<LiabilityList> liability) {
        super();
        this.daPartyId = daPartyId;
        this.industryCd = industryCd;
        this.industryClassCd = industryClassCd;
        this.tradeName = tradeName;
        this.statusCd = statusCd;
        this.businessType = businessType;
        this.corporationType = corporationType;
        this.patentLettersInd = patentLettersInd;
        this.businessTaxDetails = businessTaxDetails;
        this.transactionCountryCds = transactionCountryCds;
        this.officeLocationCountryCds = officeLocationCountryCds;
        this.notForProfitRegistrationCd = notForProfitRegistrationCd;
        this.notForProfitInd = notForProfitInd;
        this.legallyFormedCountryCds = legallyFormedCountryCds;
        this.franchiseInd = franchiseInd;
        this.communicationLanguageCd = communicationLanguageCd;
        this.legalName = legalName;
        this.nature = nature;
        this.ownedSinceDt = ownedSinceDt;
        this.establishedDt = establishedDt;
        this.email = email;
        this.taxNumber = taxNumber;
        this.contact = contact;
        this.natureDetail = natureDetail;
        this.bankingIdentities = bankingIdentities;
        this.nonBankingIdentities = nonBankingIdentities;
        this.liability = liability;
    }

    /**
     * This is a PartyId generated within a EasyApply (DA-DynamicApply), corresponding to EVENT.PARTY_ID.
     * 
     */
    @JsonProperty("daPartyId")
    public String getDaPartyId() {
        return daPartyId;
    }

    /**
     * This is a PartyId generated within a EasyApply (DA-DynamicApply), corresponding to EVENT.PARTY_ID.
     * 
     */
    @JsonProperty("daPartyId")
    public void setDaPartyId(String daPartyId) {
        this.daPartyId = daPartyId;
    }

    /**
     * SIC - Standard Industry Code
     * 
     */
    @JsonProperty("industryCd")
    public String getIndustryCd() {
        return industryCd;
    }

    /**
     * SIC - Standard Industry Code
     * 
     */
    @JsonProperty("industryCd")
    public void setIndustryCd(String industryCd) {
        this.industryCd = industryCd;
    }

    /**
     * Industry Class Code
     * 
     */
    @JsonProperty("industryClassCd")
    public String getIndustryClassCd() {
        return industryClassCd;
    }

    /**
     * Industry Class Code
     * 
     */
    @JsonProperty("industryClassCd")
    public void setIndustryClassCd(String industryClassCd) {
        this.industryClassCd = industryClassCd;
    }

    /**
     * Trade Name of Business - If your business uses a Registered Trade Name (trademark) different than Business Name
     * 
     */
    @JsonProperty("tradeName")
    public String getTradeName() {
        return tradeName;
    }

    /**
     * Trade Name of Business - If your business uses a Registered Trade Name (trademark) different than Business Name
     * 
     */
    @JsonProperty("tradeName")
    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    /**
     * statusCd will store the business status provided in the response by the BSR API. Possible values will be ACTIVE, INACTIVE, NOT FOUND or MISMATCH 
     * 
     */
    @JsonProperty("statusCd")
    public String getStatusCd() {
        return statusCd;
    }

    /**
     * statusCd will store the business status provided in the response by the BSR API. Possible values will be ACTIVE, INACTIVE, NOT FOUND or MISMATCH 
     * 
     */
    @JsonProperty("statusCd")
    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    /**
     * Describes business type as SOLE_PROPRIETOR, PARTNERSHIP, CORPORATION, ASSOCIATION, SOCIETY
     * 
     */
    @JsonProperty("businessType")
    public String getBusinessType() {
        return businessType;
    }

    /**
     * Describes business type as SOLE_PROPRIETOR, PARTNERSHIP, CORPORATION, ASSOCIATION, SOCIETY
     * 
     */
    @JsonProperty("businessType")
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * If Company Type = Association or Society, then Incorporated or Unincorporated. If Company Type = Corporation, then Private or Publicly
     * 
     */
    @JsonProperty("corporationType")
    public String getCorporationType() {
        return corporationType;
    }

    /**
     * If Company Type = Association or Society, then Incorporated or Unincorporated. If Company Type = Corporation, then Private or Publicly
     * 
     */
    @JsonProperty("corporationType")
    public void setCorporationType(String corporationType) {
        this.corporationType = corporationType;
    }

    /**
     * Yes or No to indicate whether business have patent letter
     * 
     */
    @JsonProperty("patentLettersInd")
    public Boolean getPatentLettersInd() {
        return patentLettersInd;
    }

    /**
     * Yes or No to indicate whether business have patent letter
     * 
     */
    @JsonProperty("patentLettersInd")
    public void setPatentLettersInd(Boolean patentLettersInd) {
        this.patentLettersInd = patentLettersInd;
    }

    @JsonProperty("BusinessTaxDetails")
    public BusinessTaxDetails getBusinessTaxDetails() {
        return businessTaxDetails;
    }

    @JsonProperty("BusinessTaxDetails")
    public void setBusinessTaxDetails(BusinessTaxDetails businessTaxDetails) {
        this.businessTaxDetails = businessTaxDetails;
    }

    @JsonProperty("transactionCountryCds")
    public List<String> getTransactionCountryCds() {
        return transactionCountryCds;
    }

    @JsonProperty("transactionCountryCds")
    public void setTransactionCountryCds(List<String> transactionCountryCds) {
        this.transactionCountryCds = transactionCountryCds;
    }

    @JsonProperty("officeLocationCountryCds")
    public List<String> getOfficeLocationCountryCds() {
        return officeLocationCountryCds;
    }

    @JsonProperty("officeLocationCountryCds")
    public void setOfficeLocationCountryCds(List<String> officeLocationCountryCds) {
        this.officeLocationCountryCds = officeLocationCountryCds;
    }

    @JsonProperty("notForProfitRegistrationCd")
    public String getNotForProfitRegistrationCd() {
        return notForProfitRegistrationCd;
    }

    @JsonProperty("notForProfitRegistrationCd")
    public void setNotForProfitRegistrationCd(String notForProfitRegistrationCd) {
        this.notForProfitRegistrationCd = notForProfitRegistrationCd;
    }

    @JsonProperty("notForProfitInd")
    public Boolean getNotForProfitInd() {
        return notForProfitInd;
    }

    @JsonProperty("notForProfitInd")
    public void setNotForProfitInd(Boolean notForProfitInd) {
        this.notForProfitInd = notForProfitInd;
    }

    @JsonProperty("legallyFormedCountryCds")
    public List<String> getLegallyFormedCountryCds() {
        return legallyFormedCountryCds;
    }

    @JsonProperty("legallyFormedCountryCds")
    public void setLegallyFormedCountryCds(List<String> legallyFormedCountryCds) {
        this.legallyFormedCountryCds = legallyFormedCountryCds;
    }

    @JsonProperty("franchiseInd")
    public Boolean getFranchiseInd() {
        return franchiseInd;
    }

    @JsonProperty("franchiseInd")
    public void setFranchiseInd(Boolean franchiseInd) {
        this.franchiseInd = franchiseInd;
    }

    @JsonProperty("communicationLanguageCd")
    public String getCommunicationLanguageCd() {
        return communicationLanguageCd;
    }

    @JsonProperty("communicationLanguageCd")
    public void setCommunicationLanguageCd(String communicationLanguageCd) {
        this.communicationLanguageCd = communicationLanguageCd;
    }

    @JsonProperty("legalName")
    public String getLegalName() {
        return legalName;
    }

    @JsonProperty("legalName")
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    @JsonProperty("nature")
    public String getNature() {
        return nature;
    }

    @JsonProperty("nature")
    public void setNature(String nature) {
        this.nature = nature;
    }

    @JsonProperty("ownedSinceDt")
    public Long getOwnedSinceDt() {
        return ownedSinceDt;
    }

    @JsonProperty("ownedSinceDt")
    public void setOwnedSinceDt(Long ownedSinceDt) {
        this.ownedSinceDt = ownedSinceDt;
    }

    @JsonProperty("establishedDt")
    public Long getEstablishedDt() {
        return establishedDt;
    }

    @JsonProperty("establishedDt")
    public void setEstablishedDt(Long establishedDt) {
        this.establishedDt = establishedDt;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("taxNumber")
    public String getTaxNumber() {
        return taxNumber;
    }

    @JsonProperty("taxNumber")
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    @JsonProperty("contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @JsonProperty("natureDetail")
    public NatureDetail getNatureDetail() {
        return natureDetail;
    }

    @JsonProperty("natureDetail")
    public void setNatureDetail(NatureDetail natureDetail) {
        this.natureDetail = natureDetail;
    }

    /**
     * This is an identity List related to banking Information.
     * 
     */
    @JsonProperty("bankingIdentities")
    public List<BankingIdentity> getBankingIdentities() {
        return bankingIdentities;
    }

    /**
     * This is an identity List related to banking Information.
     * 
     */
    @JsonProperty("bankingIdentities")
    public void setBankingIdentities(List<BankingIdentity> bankingIdentities) {
        this.bankingIdentities = bankingIdentities;
    }

    /**
     * This is a list of government issued identities such as passport, Driving license etc.
     * 
     */
    @JsonProperty("nonBankingIdentities")
    public List<NonBankingIdentity> getNonBankingIdentities() {
        return nonBankingIdentities;
    }

    /**
     * This is a list of government issued identities such as passport, Driving license etc.
     * 
     */
    @JsonProperty("nonBankingIdentities")
    public void setNonBankingIdentities(List<NonBankingIdentity> nonBankingIdentities) {
        this.nonBankingIdentities = nonBankingIdentities;
    }

    @JsonProperty("liability")
    public List<LiabilityList> getLiability() {
        return liability;
    }

    @JsonProperty("liability")
    public void setLiability(List<LiabilityList> liability) {
        this.liability = liability;
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
        return new ToStringBuilder(this).append("daPartyId", daPartyId).append("industryCd", industryCd).append("industryClassCd", industryClassCd).append("tradeName", tradeName).append("statusCd", statusCd).append("businessType", businessType).append("corporationType", corporationType).append("patentLettersInd", patentLettersInd).append("businessTaxDetails", businessTaxDetails).append("transactionCountryCds", transactionCountryCds).append("officeLocationCountryCds", officeLocationCountryCds).append("notForProfitRegistrationCd", notForProfitRegistrationCd).append("notForProfitInd", notForProfitInd).append("legallyFormedCountryCds", legallyFormedCountryCds).append("franchiseInd", franchiseInd).append("communicationLanguageCd", communicationLanguageCd).append("legalName", legalName).append("nature", nature).append("ownedSinceDt", ownedSinceDt).append("establishedDt", establishedDt).append("email", email).append("taxNumber", taxNumber).append("contact", contact).append("natureDetail", natureDetail).append("bankingIdentities", bankingIdentities).append("nonBankingIdentities", nonBankingIdentities).append("liability", liability).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(communicationLanguageCd).append(patentLettersInd).append(nonBankingIdentities).append(legallyFormedCountryCds).append(legalName).append(tradeName).append(industryCd).append(industryClassCd).append(officeLocationCountryCds).append(contact).append(corporationType).append(businessTaxDetails).append(bankingIdentities).append(email).append(franchiseInd).append(nature).append(daPartyId).append(liability).append(taxNumber).append(statusCd).append(ownedSinceDt).append(natureDetail).append(notForProfitInd).append(establishedDt).append(notForProfitRegistrationCd).append(transactionCountryCds).append(additionalProperties).append(businessType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BusinessParty) == false) {
            return false;
        }
        BusinessParty rhs = ((BusinessParty) other);
        return new EqualsBuilder().append(communicationLanguageCd, rhs.communicationLanguageCd).append(patentLettersInd, rhs.patentLettersInd).append(nonBankingIdentities, rhs.nonBankingIdentities).append(legallyFormedCountryCds, rhs.legallyFormedCountryCds).append(legalName, rhs.legalName).append(tradeName, rhs.tradeName).append(industryCd, rhs.industryCd).append(industryClassCd, rhs.industryClassCd).append(officeLocationCountryCds, rhs.officeLocationCountryCds).append(contact, rhs.contact).append(corporationType, rhs.corporationType).append(businessTaxDetails, rhs.businessTaxDetails).append(bankingIdentities, rhs.bankingIdentities).append(email, rhs.email).append(franchiseInd, rhs.franchiseInd).append(nature, rhs.nature).append(daPartyId, rhs.daPartyId).append(liability, rhs.liability).append(taxNumber, rhs.taxNumber).append(statusCd, rhs.statusCd).append(ownedSinceDt, rhs.ownedSinceDt).append(natureDetail, rhs.natureDetail).append(notForProfitInd, rhs.notForProfitInd).append(establishedDt, rhs.establishedDt).append(notForProfitRegistrationCd, rhs.notForProfitRegistrationCd).append(transactionCountryCds, rhs.transactionCountryCds).append(additionalProperties, rhs.additionalProperties).append(businessType, rhs.businessType).isEquals();
    }

}
