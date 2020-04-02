
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
    "staffCd",
    "titlePrefix",
    "firstName",
    "middleName",
    "lastName",
    "suffix",
    "nickname",
    "birthDt",
    "gender",
    "maritalStatus",
    "email",
    "socialInsuranceNum",
    "socialInsuranceNumberCreditBureauSharingInd",
    "relationShip",
    "relationshipDetail",
    "percentageAllocated",
    "totalDependents",
    "description",
    "isCoapplicant",
    "partyType",
    "citizenShipList",
    "contact",
    "employment",
    "bankingIdentities",
    "nonBankingIdentities",
    "taxDetails",
    "liability",
    "financialInfo",
    "businessRelationship"
})
public class PersonalParty implements Serializable, Cloneable
{

    /**
     * This is a PartyId generated within a EasyApply (DA-DynamicApply), corresponding to EVENT.PARTY_ID.
     * 
     */
    @JsonProperty("daPartyId")
    @JsonPropertyDescription("This is a PartyId generated within a EasyApply (DA-DynamicApply), corresponding to EVENT.PARTY_ID.")
    private String daPartyId;
    /**
     * This field will identify whether applicant is staff or staff relatives or none. Possible values will be, 00 - Non Staff, 01 - Staff, 05 - Staff Related, 06 - Staff Executive, 08 - Restricted, S - Staff (Legacy)
     * 
     */
    @JsonProperty("staffCd")
    @JsonPropertyDescription("This field will identify whether applicant is staff or staff relatives or none. Possible values will be, 00 - Non Staff, 01 - Staff, 05 - Staff Related, 06 - Staff Executive, 08 - Restricted, S - Staff (Legacy)")
    private String staffCd;
    @JsonProperty("titlePrefix")
    private String titlePrefix;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("suffix")
    private String suffix;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("birthDt")
    private Long birthDt;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("maritalStatus")
    private String maritalStatus;
    @JsonProperty("email")
    private String email;
    @JsonProperty("socialInsuranceNum")
    private String socialInsuranceNum;
    /**
     * Indicator if customer wants to use SIN in credit bureau check. Enum: Y/N/blank
     * 
     */
    @JsonProperty("socialInsuranceNumberCreditBureauSharingInd")
    @JsonPropertyDescription("Indicator if customer wants to use SIN in credit bureau check. Enum: Y/N/blank")
    private String socialInsuranceNumberCreditBureauSharingInd;
    @JsonProperty("relationShip")
    private String relationShip;
    /**
     * If relationShip has 'other' as value than this field will have additional detail.
     * 
     */
    @JsonProperty("relationshipDetail")
    @JsonPropertyDescription("If relationShip has 'other' as value than this field will have additional detail.")
    private String relationshipDetail;
    @JsonProperty("percentageAllocated")
    private Integer percentageAllocated;
    @JsonProperty("totalDependents")
    private Integer totalDependents;
    @JsonProperty("description")
    private String description;
    @JsonProperty("isCoapplicant")
    private String isCoapplicant;
    @JsonProperty("partyType")
    private String partyType;
    @JsonProperty("citizenShipList")
    private List<String> citizenShipList = null;
    @JsonProperty("contact")
    private Contact contact;
    @JsonProperty("employment")
    private List<Employment> employment = null;
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
    @JsonProperty("taxDetails")
    private TaxDetails taxDetails;
    @JsonProperty("liability")
    private Liability liability;
    /**
     * Customer FinancialInfo.
     * 
     */
    @JsonProperty("financialInfo")
    @JsonPropertyDescription("Customer FinancialInfo.")
    private FinancialInfo financialInfo;
    /**
     * Version v1, Date; 20180529. BusinessRelationship Definition
     * 
     */
    @JsonProperty("businessRelationship")
    @JsonPropertyDescription("Version v1, Date; 20180529. BusinessRelationship Definition")
    private BusinessRelationship businessRelationship;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3642586050921678040L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PersonalParty() {
    }

    /**
     * 
     * @param lastName
     * @param staffCd
     * @param gender
     * @param taxDetails
     * @param description
     * @param nonBankingIdentities
     * @param suffix
     * @param partyType
     * @param relationShip
     * @param contact
     * @param nickname
     * @param titlePrefix
     * @param bankingIdentities
     * @param email
     * @param birthDt
     * @param daPartyId
     * @param isCoapplicant
     * @param liability
     * @param businessRelationship
     * @param socialInsuranceNum
     * @param employment
     * @param socialInsuranceNumberCreditBureauSharingInd
     * @param firstName
     * @param citizenShipList
     * @param relationshipDetail
     * @param percentageAllocated
     * @param financialInfo
     * @param totalDependents
     * @param middleName
     * @param maritalStatus
     */
    public PersonalParty(String daPartyId, String staffCd, String titlePrefix, String firstName, String middleName, String lastName, String suffix, String nickname, Long birthDt, String gender, String maritalStatus, String email, String socialInsuranceNum, String socialInsuranceNumberCreditBureauSharingInd, String relationShip, String relationshipDetail, Integer percentageAllocated, Integer totalDependents, String description, String isCoapplicant, String partyType, List<String> citizenShipList, Contact contact, List<Employment> employment, List<BankingIdentity> bankingIdentities, List<NonBankingIdentity> nonBankingIdentities, TaxDetails taxDetails, Liability liability, FinancialInfo financialInfo, BusinessRelationship businessRelationship) {
        super();
        this.daPartyId = daPartyId;
        this.staffCd = staffCd;
        this.titlePrefix = titlePrefix;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.nickname = nickname;
        this.birthDt = birthDt;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.email = email;
        this.socialInsuranceNum = socialInsuranceNum;
        this.socialInsuranceNumberCreditBureauSharingInd = socialInsuranceNumberCreditBureauSharingInd;
        this.relationShip = relationShip;
        this.relationshipDetail = relationshipDetail;
        this.percentageAllocated = percentageAllocated;
        this.totalDependents = totalDependents;
        this.description = description;
        this.isCoapplicant = isCoapplicant;
        this.partyType = partyType;
        this.citizenShipList = citizenShipList;
        this.contact = contact;
        this.employment = employment;
        this.bankingIdentities = bankingIdentities;
        this.nonBankingIdentities = nonBankingIdentities;
        this.taxDetails = taxDetails;
        this.liability = liability;
        this.financialInfo = financialInfo;
        this.businessRelationship = businessRelationship;
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
     * This field will identify whether applicant is staff or staff relatives or none. Possible values will be, 00 - Non Staff, 01 - Staff, 05 - Staff Related, 06 - Staff Executive, 08 - Restricted, S - Staff (Legacy)
     * 
     */
    @JsonProperty("staffCd")
    public String getStaffCd() {
        return staffCd;
    }

    /**
     * This field will identify whether applicant is staff or staff relatives or none. Possible values will be, 00 - Non Staff, 01 - Staff, 05 - Staff Related, 06 - Staff Executive, 08 - Restricted, S - Staff (Legacy)
     * 
     */
    @JsonProperty("staffCd")
    public void setStaffCd(String staffCd) {
        this.staffCd = staffCd;
    }

    @JsonProperty("titlePrefix")
    public String getTitlePrefix() {
        return titlePrefix;
    }

    @JsonProperty("titlePrefix")
    public void setTitlePrefix(String titlePrefix) {
        this.titlePrefix = titlePrefix;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("middleName")
    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("middleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("suffix")
    public String getSuffix() {
        return suffix;
    }

    @JsonProperty("suffix")
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @JsonProperty("nickname")
    public String getNickname() {
        return nickname;
    }

    @JsonProperty("nickname")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonProperty("birthDt")
    public Long getBirthDt() {
        return birthDt;
    }

    @JsonProperty("birthDt")
    public void setBirthDt(Long birthDt) {
        this.birthDt = birthDt;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("maritalStatus")
    public String getMaritalStatus() {
        return maritalStatus;
    }

    @JsonProperty("maritalStatus")
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("socialInsuranceNum")
    public String getSocialInsuranceNum() {
        return socialInsuranceNum;
    }

    @JsonProperty("socialInsuranceNum")
    public void setSocialInsuranceNum(String socialInsuranceNum) {
        this.socialInsuranceNum = socialInsuranceNum;
    }

    /**
     * Indicator if customer wants to use SIN in credit bureau check. Enum: Y/N/blank
     * 
     */
    @JsonProperty("socialInsuranceNumberCreditBureauSharingInd")
    public String getSocialInsuranceNumberCreditBureauSharingInd() {
        return socialInsuranceNumberCreditBureauSharingInd;
    }

    /**
     * Indicator if customer wants to use SIN in credit bureau check. Enum: Y/N/blank
     * 
     */
    @JsonProperty("socialInsuranceNumberCreditBureauSharingInd")
    public void setSocialInsuranceNumberCreditBureauSharingInd(String socialInsuranceNumberCreditBureauSharingInd) {
        this.socialInsuranceNumberCreditBureauSharingInd = socialInsuranceNumberCreditBureauSharingInd;
    }

    @JsonProperty("relationShip")
    public String getRelationShip() {
        return relationShip;
    }

    @JsonProperty("relationShip")
    public void setRelationShip(String relationShip) {
        this.relationShip = relationShip;
    }

    /**
     * If relationShip has 'other' as value than this field will have additional detail.
     * 
     */
    @JsonProperty("relationshipDetail")
    public String getRelationshipDetail() {
        return relationshipDetail;
    }

    /**
     * If relationShip has 'other' as value than this field will have additional detail.
     * 
     */
    @JsonProperty("relationshipDetail")
    public void setRelationshipDetail(String relationshipDetail) {
        this.relationshipDetail = relationshipDetail;
    }

    @JsonProperty("percentageAllocated")
    public Integer getPercentageAllocated() {
        return percentageAllocated;
    }

    @JsonProperty("percentageAllocated")
    public void setPercentageAllocated(Integer percentageAllocated) {
        this.percentageAllocated = percentageAllocated;
    }

    @JsonProperty("totalDependents")
    public Integer getTotalDependents() {
        return totalDependents;
    }

    @JsonProperty("totalDependents")
    public void setTotalDependents(Integer totalDependents) {
        this.totalDependents = totalDependents;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("isCoapplicant")
    public String getIsCoapplicant() {
        return isCoapplicant;
    }

    @JsonProperty("isCoapplicant")
    public void setIsCoapplicant(String isCoapplicant) {
        this.isCoapplicant = isCoapplicant;
    }

    @JsonProperty("partyType")
    public String getPartyType() {
        return partyType;
    }

    @JsonProperty("partyType")
    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    @JsonProperty("citizenShipList")
    public List<String> getCitizenShipList() {
        return citizenShipList;
    }

    @JsonProperty("citizenShipList")
    public void setCitizenShipList(List<String> citizenShipList) {
        this.citizenShipList = citizenShipList;
    }

    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    @JsonProperty("contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @JsonProperty("employment")
    public List<Employment> getEmployment() {
        return employment;
    }

    @JsonProperty("employment")
    public void setEmployment(List<Employment> employment) {
        this.employment = employment;
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

    @JsonProperty("taxDetails")
    public TaxDetails getTaxDetails() {
        return taxDetails;
    }

    @JsonProperty("taxDetails")
    public void setTaxDetails(TaxDetails taxDetails) {
        this.taxDetails = taxDetails;
    }

    @JsonProperty("liability")
    public Liability getLiability() {
        return liability;
    }

    @JsonProperty("liability")
    public void setLiability(Liability liability) {
        this.liability = liability;
    }

    /**
     * Customer FinancialInfo.
     * 
     */
    @JsonProperty("financialInfo")
    public FinancialInfo getFinancialInfo() {
        return financialInfo;
    }

    /**
     * Customer FinancialInfo.
     * 
     */
    @JsonProperty("financialInfo")
    public void setFinancialInfo(FinancialInfo financialInfo) {
        this.financialInfo = financialInfo;
    }

    /**
     * Version v1, Date; 20180529. BusinessRelationship Definition
     * 
     */
    @JsonProperty("businessRelationship")
    public BusinessRelationship getBusinessRelationship() {
        return businessRelationship;
    }

    /**
     * Version v1, Date; 20180529. BusinessRelationship Definition
     * 
     */
    @JsonProperty("businessRelationship")
    public void setBusinessRelationship(BusinessRelationship businessRelationship) {
        this.businessRelationship = businessRelationship;
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
        return new ToStringBuilder(this).append("daPartyId", daPartyId).append("staffCd", staffCd).append("titlePrefix", titlePrefix).append("firstName", firstName).append("middleName", middleName).append("lastName", lastName).append("suffix", suffix).append("nickname", nickname).append("birthDt", birthDt).append("gender", gender).append("maritalStatus", maritalStatus).append("email", email).append("socialInsuranceNum", socialInsuranceNum).append("socialInsuranceNumberCreditBureauSharingInd", socialInsuranceNumberCreditBureauSharingInd).append("relationShip", relationShip).append("relationshipDetail", relationshipDetail).append("percentageAllocated", percentageAllocated).append("totalDependents", totalDependents).append("description", description).append("isCoapplicant", isCoapplicant).append("partyType", partyType).append("citizenShipList", citizenShipList).append("contact", contact).append("employment", employment).append("bankingIdentities", bankingIdentities).append("nonBankingIdentities", nonBankingIdentities).append("taxDetails", taxDetails).append("liability", liability).append("financialInfo", financialInfo).append("businessRelationship", businessRelationship).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lastName).append(staffCd).append(gender).append(taxDetails).append(description).append(nonBankingIdentities).append(suffix).append(partyType).append(relationShip).append(contact).append(nickname).append(titlePrefix).append(bankingIdentities).append(email).append(birthDt).append(daPartyId).append(isCoapplicant).append(liability).append(businessRelationship).append(socialInsuranceNum).append(employment).append(socialInsuranceNumberCreditBureauSharingInd).append(firstName).append(citizenShipList).append(relationshipDetail).append(percentageAllocated).append(financialInfo).append(totalDependents).append(middleName).append(additionalProperties).append(maritalStatus).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PersonalParty) == false) {
            return false;
        }
        PersonalParty rhs = ((PersonalParty) other);
        return new EqualsBuilder().append(lastName, rhs.lastName).append(staffCd, rhs.staffCd).append(gender, rhs.gender).append(taxDetails, rhs.taxDetails).append(description, rhs.description).append(nonBankingIdentities, rhs.nonBankingIdentities).append(suffix, rhs.suffix).append(partyType, rhs.partyType).append(relationShip, rhs.relationShip).append(contact, rhs.contact).append(nickname, rhs.nickname).append(titlePrefix, rhs.titlePrefix).append(bankingIdentities, rhs.bankingIdentities).append(email, rhs.email).append(birthDt, rhs.birthDt).append(daPartyId, rhs.daPartyId).append(isCoapplicant, rhs.isCoapplicant).append(liability, rhs.liability).append(businessRelationship, rhs.businessRelationship).append(socialInsuranceNum, rhs.socialInsuranceNum).append(employment, rhs.employment).append(socialInsuranceNumberCreditBureauSharingInd, rhs.socialInsuranceNumberCreditBureauSharingInd).append(firstName, rhs.firstName).append(citizenShipList, rhs.citizenShipList).append(relationshipDetail, rhs.relationshipDetail).append(percentageAllocated, rhs.percentageAllocated).append(financialInfo, rhs.financialInfo).append(totalDependents, rhs.totalDependents).append(middleName, rhs.middleName).append(additionalProperties, rhs.additionalProperties).append(maritalStatus, rhs.maritalStatus).isEquals();
    }

}
