
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
    "languageCd",
    "isComplianceRequired",
    "applicationDate",
    "resumeDate",
    "expiryDate",
    "submittedDate",
    "externalApplicationNum",
    "alertCheckResponse",
    "alerts",
    "branch",
    "otherBranches",
    "eConsents",
    "accounts",
    "amounts",
    "transactionsList",
    "otherParty",
    "products",
    "adjudicationResultList",
    "primary",
    "documents",
    "statementDelivery",
    "edbApplication",
    "diApplication",
    "loanApplication",
    "psiApplication",
    "isContactMe",
    "contactMe",
    "agentDetails",
    "agreementSurveyResponse",
    "individualSurveyResponse"
})
public class Data implements Serializable, Cloneable
{

    /**
     * Language code which will be used for customer communication. Typically passed from source URL
     * 
     */
    @JsonProperty("languageCd")
    @JsonPropertyDescription("Language code which will be used for customer communication. Typically passed from source URL")
    private String languageCd;
    @JsonProperty("isComplianceRequired")
    private Boolean isComplianceRequired;
    /**
     * This date is pre-populated while CreateApplication
     * 
     */
    @JsonProperty("applicationDate")
    @JsonPropertyDescription("This date is pre-populated while CreateApplication")
    private Long applicationDate;
    /**
     * ResumeDate will be always overwritten whenever application is resumed.
     * 
     */
    @JsonProperty("resumeDate")
    @JsonPropertyDescription("ResumeDate will be always overwritten whenever application is resumed.")
    private Long resumeDate;
    /**
     * As every LoB has respective application expiry so we need to have application expiry on this snapshot which needs to be prepopulated while CreateApplication
     * 
     */
    @JsonProperty("expiryDate")
    @JsonPropertyDescription("As every LoB has respective application expiry so we need to have application expiry on this snapshot which needs to be prepopulated while CreateApplication")
    private Long expiryDate;
    /**
     * This date is populated when application is submitted for adjudication.
     * 
     */
    @JsonProperty("submittedDate")
    @JsonPropertyDescription("This date is populated when application is submitted for adjudication.")
    private Long submittedDate;
    /**
     * This is an External ApplicationRefNumber.
     * 
     */
    @JsonProperty("externalApplicationNum")
    @JsonPropertyDescription("This is an External ApplicationRefNumber.")
    private String externalApplicationNum;
    /**
     * This contains the existing alerts details which are present on customer profile
     * 
     */
    @JsonProperty("alertCheckResponse")
    @JsonPropertyDescription("This contains the existing alerts details which are present on customer profile")
    private AlertCheckResponse alertCheckResponse;
    /**
     * This contains the alerts list which needs to be added / lodged on customer profile.
     * 
     */
    @JsonProperty("alerts")
    @JsonPropertyDescription("This contains the alerts list which needs to be added / lodged on customer profile.")
    private Alerts alerts;
    @JsonProperty("branch")
    private Branch branch;
    /**
     * Other Branches which are acting on application.
     * 
     */
    @JsonProperty("otherBranches")
    @JsonPropertyDescription("Other Branches which are acting on application.")
    private List<Branch> otherBranches = null;
    /**
     * Version v1, Date; 20180427. EConsent Definition
     * 
     */
    @JsonProperty("eConsents")
    @JsonPropertyDescription("Version v1, Date; 20180427. EConsent Definition")
    private EConsents eConsents;
    @JsonProperty("accounts")
    private List<Account> accounts = null;
    /**
     * This list may contains all the different amounts related to application if not linked to account.
     * 
     */
    @JsonProperty("amounts")
    @JsonPropertyDescription("This list may contains all the different amounts related to application if not linked to account.")
    private List<OptionAmt> amounts = null;
    @JsonProperty("transactionsList")
    private List<TransactionsList> transactionsList = null;
    @JsonProperty("otherParty")
    private List<OtherParty> otherParty = null;
    @JsonProperty("products")
    private List<Product> products = null;
    /**
     * This list contains the adjudication result of all subapplications.
     * 
     */
    @JsonProperty("adjudicationResultList")
    @JsonPropertyDescription("This list contains the adjudication result of all subapplications.")
    private List<AdjudicationResultList> adjudicationResultList = null;
    @JsonProperty("primary")
    private Primary primary;
    @JsonProperty("documents")
    private List<Document> documents = null;
    /**
     * data.statementDelivery is copied over as definitions.Account.statementDelivery and data.statementDelivery will be deprecated later as currently EDB and DI are using data.statementDelivery
     * 
     */
    @JsonProperty("statementDelivery")
    @JsonPropertyDescription("data.statementDelivery is copied over as definitions.Account.statementDelivery and data.statementDelivery will be deprecated later as currently EDB and DI are using data.statementDelivery")
    private StatementDelivery statementDelivery;
    /**
     * This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.
     * 
     */
    @JsonProperty("edbApplication")
    @JsonPropertyDescription("This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.")
    private EdbApplication edbApplication;
    /**
     * This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.
     * 
     */
    @JsonProperty("diApplication")
    @JsonPropertyDescription("This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.")
    private DiApplication diApplication;
    /**
     * This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.
     * 
     */
    @JsonProperty("loanApplication")
    @JsonPropertyDescription("This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.")
    private LoanApplication loanApplication;
    /**
     * This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.
     * 
     */
    @JsonProperty("psiApplication")
    @JsonPropertyDescription("This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.")
    private PsiApplication psiApplication;
    @JsonProperty("isContactMe")
    private Boolean isContactMe;
    @JsonProperty("contactMe")
    private ContactMe contactMe;
    /**
     * Agent information for onBehalf case. It will be always overwritten by latest AgentInfo who is acting on it.
     * 
     */
    @JsonProperty("agentDetails")
    @JsonPropertyDescription("Agent information for onBehalf case. It will be always overwritten by latest AgentInfo who is acting on it.")
    private List<AgentDetail> agentDetails = null;
    /**
     * Agreement Survey List
     * 
     */
    @JsonProperty("agreementSurveyResponse")
    @JsonPropertyDescription("Agreement Survey List")
    private List<AgreementSurveyResponse> agreementSurveyResponse = null;
    /**
     * Individual Investment Survey List
     * 
     */
    @JsonProperty("individualSurveyResponse")
    @JsonPropertyDescription("Individual Investment Survey List")
    private List<IndividualSurveyResponse> individualSurveyResponse = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6592748235970486547L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param otherBranches
     * @param loanApplication
     * @param documents
     * @param submittedDate
     * @param branch
     * @param transactionsList
     * @param products
     * @param expiryDate
     * @param diApplication
     * @param agreementSurveyResponse
     * @param edbApplication
     * @param amounts
     * @param alertCheckResponse
     * @param externalApplicationNum
     * @param statementDelivery
     * @param languageCd
     * @param adjudicationResultList
     * @param psiApplication
     * @param individualSurveyResponse
     * @param eConsents
     * @param contactMe
     * @param isComplianceRequired
     * @param alerts
     * @param otherParty
     * @param agentDetails
     * @param isContactMe
     * @param accounts
     * @param applicationDate
     * @param resumeDate
     * @param primary
     */
    public Data(String languageCd, Boolean isComplianceRequired, Long applicationDate, Long resumeDate, Long expiryDate, Long submittedDate, String externalApplicationNum, AlertCheckResponse alertCheckResponse, Alerts alerts, Branch branch, List<Branch> otherBranches, EConsents eConsents, List<Account> accounts, List<OptionAmt> amounts, List<TransactionsList> transactionsList, List<OtherParty> otherParty, List<Product> products, List<AdjudicationResultList> adjudicationResultList, Primary primary, List<Document> documents, StatementDelivery statementDelivery, EdbApplication edbApplication, DiApplication diApplication, LoanApplication loanApplication, PsiApplication psiApplication, Boolean isContactMe, ContactMe contactMe, List<AgentDetail> agentDetails, List<AgreementSurveyResponse> agreementSurveyResponse, List<IndividualSurveyResponse> individualSurveyResponse) {
        super();
        this.languageCd = languageCd;
        this.isComplianceRequired = isComplianceRequired;
        this.applicationDate = applicationDate;
        this.resumeDate = resumeDate;
        this.expiryDate = expiryDate;
        this.submittedDate = submittedDate;
        this.externalApplicationNum = externalApplicationNum;
        this.alertCheckResponse = alertCheckResponse;
        this.alerts = alerts;
        this.branch = branch;
        this.otherBranches = otherBranches;
        this.eConsents = eConsents;
        this.accounts = accounts;
        this.amounts = amounts;
        this.transactionsList = transactionsList;
        this.otherParty = otherParty;
        this.products = products;
        this.adjudicationResultList = adjudicationResultList;
        this.primary = primary;
        this.documents = documents;
        this.statementDelivery = statementDelivery;
        this.edbApplication = edbApplication;
        this.diApplication = diApplication;
        this.loanApplication = loanApplication;
        this.psiApplication = psiApplication;
        this.isContactMe = isContactMe;
        this.contactMe = contactMe;
        this.agentDetails = agentDetails;
        this.agreementSurveyResponse = agreementSurveyResponse;
        this.individualSurveyResponse = individualSurveyResponse;
    }

    /**
     * Language code which will be used for customer communication. Typically passed from source URL
     * 
     */
    @JsonProperty("languageCd")
    public String getLanguageCd() {
        return languageCd;
    }

    /**
     * Language code which will be used for customer communication. Typically passed from source URL
     * 
     */
    @JsonProperty("languageCd")
    public void setLanguageCd(String languageCd) {
        this.languageCd = languageCd;
    }

    @JsonProperty("isComplianceRequired")
    public Boolean getIsComplianceRequired() {
        return isComplianceRequired;
    }

    @JsonProperty("isComplianceRequired")
    public void setIsComplianceRequired(Boolean isComplianceRequired) {
        this.isComplianceRequired = isComplianceRequired;
    }

    /**
     * This date is pre-populated while CreateApplication
     * 
     */
    @JsonProperty("applicationDate")
    public Long getApplicationDate() {
        return applicationDate;
    }

    /**
     * This date is pre-populated while CreateApplication
     * 
     */
    @JsonProperty("applicationDate")
    public void setApplicationDate(Long applicationDate) {
        this.applicationDate = applicationDate;
    }

    /**
     * ResumeDate will be always overwritten whenever application is resumed.
     * 
     */
    @JsonProperty("resumeDate")
    public Long getResumeDate() {
        return resumeDate;
    }

    /**
     * ResumeDate will be always overwritten whenever application is resumed.
     * 
     */
    @JsonProperty("resumeDate")
    public void setResumeDate(Long resumeDate) {
        this.resumeDate = resumeDate;
    }

    /**
     * As every LoB has respective application expiry so we need to have application expiry on this snapshot which needs to be prepopulated while CreateApplication
     * 
     */
    @JsonProperty("expiryDate")
    public Long getExpiryDate() {
        return expiryDate;
    }

    /**
     * As every LoB has respective application expiry so we need to have application expiry on this snapshot which needs to be prepopulated while CreateApplication
     * 
     */
    @JsonProperty("expiryDate")
    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * This date is populated when application is submitted for adjudication.
     * 
     */
    @JsonProperty("submittedDate")
    public Long getSubmittedDate() {
        return submittedDate;
    }

    /**
     * This date is populated when application is submitted for adjudication.
     * 
     */
    @JsonProperty("submittedDate")
    public void setSubmittedDate(Long submittedDate) {
        this.submittedDate = submittedDate;
    }

    /**
     * This is an External ApplicationRefNumber.
     * 
     */
    @JsonProperty("externalApplicationNum")
    public String getExternalApplicationNum() {
        return externalApplicationNum;
    }

    /**
     * This is an External ApplicationRefNumber.
     * 
     */
    @JsonProperty("externalApplicationNum")
    public void setExternalApplicationNum(String externalApplicationNum) {
        this.externalApplicationNum = externalApplicationNum;
    }

    /**
     * This contains the existing alerts details which are present on customer profile
     * 
     */
    @JsonProperty("alertCheckResponse")
    public AlertCheckResponse getAlertCheckResponse() {
        return alertCheckResponse;
    }

    /**
     * This contains the existing alerts details which are present on customer profile
     * 
     */
    @JsonProperty("alertCheckResponse")
    public void setAlertCheckResponse(AlertCheckResponse alertCheckResponse) {
        this.alertCheckResponse = alertCheckResponse;
    }

    /**
     * This contains the alerts list which needs to be added / lodged on customer profile.
     * 
     */
    @JsonProperty("alerts")
    public Alerts getAlerts() {
        return alerts;
    }

    /**
     * This contains the alerts list which needs to be added / lodged on customer profile.
     * 
     */
    @JsonProperty("alerts")
    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }

    @JsonProperty("branch")
    public Branch getBranch() {
        return branch;
    }

    @JsonProperty("branch")
    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    /**
     * Other Branches which are acting on application.
     * 
     */
    @JsonProperty("otherBranches")
    public List<Branch> getOtherBranches() {
        return otherBranches;
    }

    /**
     * Other Branches which are acting on application.
     * 
     */
    @JsonProperty("otherBranches")
    public void setOtherBranches(List<Branch> otherBranches) {
        this.otherBranches = otherBranches;
    }

    /**
     * Version v1, Date; 20180427. EConsent Definition
     * 
     */
    @JsonProperty("eConsents")
    public EConsents getEConsents() {
        return eConsents;
    }

    /**
     * Version v1, Date; 20180427. EConsent Definition
     * 
     */
    @JsonProperty("eConsents")
    public void setEConsents(EConsents eConsents) {
        this.eConsents = eConsents;
    }

    @JsonProperty("accounts")
    public List<Account> getAccounts() {
        return accounts;
    }

    @JsonProperty("accounts")
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * This list may contains all the different amounts related to application if not linked to account.
     * 
     */
    @JsonProperty("amounts")
    public List<OptionAmt> getAmounts() {
        return amounts;
    }

    /**
     * This list may contains all the different amounts related to application if not linked to account.
     * 
     */
    @JsonProperty("amounts")
    public void setAmounts(List<OptionAmt> amounts) {
        this.amounts = amounts;
    }

    @JsonProperty("transactionsList")
    public List<TransactionsList> getTransactionsList() {
        return transactionsList;
    }

    @JsonProperty("transactionsList")
    public void setTransactionsList(List<TransactionsList> transactionsList) {
        this.transactionsList = transactionsList;
    }

    @JsonProperty("otherParty")
    public List<OtherParty> getOtherParty() {
        return otherParty;
    }

    @JsonProperty("otherParty")
    public void setOtherParty(List<OtherParty> otherParty) {
        this.otherParty = otherParty;
    }

    @JsonProperty("products")
    public List<Product> getProducts() {
        return products;
    }

    @JsonProperty("products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * This list contains the adjudication result of all subapplications.
     * 
     */
    @JsonProperty("adjudicationResultList")
    public List<AdjudicationResultList> getAdjudicationResultList() {
        return adjudicationResultList;
    }

    /**
     * This list contains the adjudication result of all subapplications.
     * 
     */
    @JsonProperty("adjudicationResultList")
    public void setAdjudicationResultList(List<AdjudicationResultList> adjudicationResultList) {
        this.adjudicationResultList = adjudicationResultList;
    }

    @JsonProperty("primary")
    public Primary getPrimary() {
        return primary;
    }

    @JsonProperty("primary")
    public void setPrimary(Primary primary) {
        this.primary = primary;
    }

    @JsonProperty("documents")
    public List<Document> getDocuments() {
        return documents;
    }

    @JsonProperty("documents")
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    /**
     * data.statementDelivery is copied over as definitions.Account.statementDelivery and data.statementDelivery will be deprecated later as currently EDB and DI are using data.statementDelivery
     * 
     */
    @JsonProperty("statementDelivery")
    public StatementDelivery getStatementDelivery() {
        return statementDelivery;
    }

    /**
     * data.statementDelivery is copied over as definitions.Account.statementDelivery and data.statementDelivery will be deprecated later as currently EDB and DI are using data.statementDelivery
     * 
     */
    @JsonProperty("statementDelivery")
    public void setStatementDelivery(StatementDelivery statementDelivery) {
        this.statementDelivery = statementDelivery;
    }

    /**
     * This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.
     * 
     */
    @JsonProperty("edbApplication")
    public EdbApplication getEdbApplication() {
        return edbApplication;
    }

    /**
     * This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.
     * 
     */
    @JsonProperty("edbApplication")
    public void setEdbApplication(EdbApplication edbApplication) {
        this.edbApplication = edbApplication;
    }

    /**
     * This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.
     * 
     */
    @JsonProperty("diApplication")
    public DiApplication getDiApplication() {
        return diApplication;
    }

    /**
     * This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.
     * 
     */
    @JsonProperty("diApplication")
    public void setDiApplication(DiApplication diApplication) {
        this.diApplication = diApplication;
    }

    /**
     * This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.
     * 
     */
    @JsonProperty("loanApplication")
    public LoanApplication getLoanApplication() {
        return loanApplication;
    }

    /**
     * This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.
     * 
     */
    @JsonProperty("loanApplication")
    public void setLoanApplication(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }

    /**
     * This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.
     * 
     */
    @JsonProperty("psiApplication")
    public PsiApplication getPsiApplication() {
        return psiApplication;
    }

    /**
     * This LoB specific object is added only for flexibility purpose. Before using this, please discuss with SolutionLead.
     * 
     */
    @JsonProperty("psiApplication")
    public void setPsiApplication(PsiApplication psiApplication) {
        this.psiApplication = psiApplication;
    }

    @JsonProperty("isContactMe")
    public Boolean getIsContactMe() {
        return isContactMe;
    }

    @JsonProperty("isContactMe")
    public void setIsContactMe(Boolean isContactMe) {
        this.isContactMe = isContactMe;
    }

    @JsonProperty("contactMe")
    public ContactMe getContactMe() {
        return contactMe;
    }

    @JsonProperty("contactMe")
    public void setContactMe(ContactMe contactMe) {
        this.contactMe = contactMe;
    }

    /**
     * Agent information for onBehalf case. It will be always overwritten by latest AgentInfo who is acting on it.
     * 
     */
    @JsonProperty("agentDetails")
    public List<AgentDetail> getAgentDetails() {
        return agentDetails;
    }

    /**
     * Agent information for onBehalf case. It will be always overwritten by latest AgentInfo who is acting on it.
     * 
     */
    @JsonProperty("agentDetails")
    public void setAgentDetails(List<AgentDetail> agentDetails) {
        this.agentDetails = agentDetails;
    }

    /**
     * Agreement Survey List
     * 
     */
    @JsonProperty("agreementSurveyResponse")
    public List<AgreementSurveyResponse> getAgreementSurveyResponse() {
        return agreementSurveyResponse;
    }

    /**
     * Agreement Survey List
     * 
     */
    @JsonProperty("agreementSurveyResponse")
    public void setAgreementSurveyResponse(List<AgreementSurveyResponse> agreementSurveyResponse) {
        this.agreementSurveyResponse = agreementSurveyResponse;
    }

    /**
     * Individual Investment Survey List
     * 
     */
    @JsonProperty("individualSurveyResponse")
    public List<IndividualSurveyResponse> getIndividualSurveyResponse() {
        return individualSurveyResponse;
    }

    /**
     * Individual Investment Survey List
     * 
     */
    @JsonProperty("individualSurveyResponse")
    public void setIndividualSurveyResponse(List<IndividualSurveyResponse> individualSurveyResponse) {
        this.individualSurveyResponse = individualSurveyResponse;
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
        return new ToStringBuilder(this).append("languageCd", languageCd).append("isComplianceRequired", isComplianceRequired).append("applicationDate", applicationDate).append("resumeDate", resumeDate).append("expiryDate", expiryDate).append("submittedDate", submittedDate).append("externalApplicationNum", externalApplicationNum).append("alertCheckResponse", alertCheckResponse).append("alerts", alerts).append("branch", branch).append("otherBranches", otherBranches).append("eConsents", eConsents).append("accounts", accounts).append("amounts", amounts).append("transactionsList", transactionsList).append("otherParty", otherParty).append("products", products).append("adjudicationResultList", adjudicationResultList).append("primary", primary).append("documents", documents).append("statementDelivery", statementDelivery).append("edbApplication", edbApplication).append("diApplication", diApplication).append("loanApplication", loanApplication).append("psiApplication", psiApplication).append("isContactMe", isContactMe).append("contactMe", contactMe).append("agentDetails", agentDetails).append("agreementSurveyResponse", agreementSurveyResponse).append("individualSurveyResponse", individualSurveyResponse).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(otherBranches).append(loanApplication).append(documents).append(submittedDate).append(branch).append(transactionsList).append(products).append(expiryDate).append(diApplication).append(agreementSurveyResponse).append(edbApplication).append(amounts).append(alertCheckResponse).append(externalApplicationNum).append(statementDelivery).append(languageCd).append(adjudicationResultList).append(psiApplication).append(individualSurveyResponse).append(eConsents).append(contactMe).append(isComplianceRequired).append(alerts).append(otherParty).append(agentDetails).append(isContactMe).append(accounts).append(additionalProperties).append(applicationDate).append(resumeDate).append(primary).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data) == false) {
            return false;
        }
        Data rhs = ((Data) other);
        return new EqualsBuilder().append(otherBranches, rhs.otherBranches).append(loanApplication, rhs.loanApplication).append(documents, rhs.documents).append(submittedDate, rhs.submittedDate).append(branch, rhs.branch).append(transactionsList, rhs.transactionsList).append(products, rhs.products).append(expiryDate, rhs.expiryDate).append(diApplication, rhs.diApplication).append(agreementSurveyResponse, rhs.agreementSurveyResponse).append(edbApplication, rhs.edbApplication).append(amounts, rhs.amounts).append(alertCheckResponse, rhs.alertCheckResponse).append(externalApplicationNum, rhs.externalApplicationNum).append(statementDelivery, rhs.statementDelivery).append(languageCd, rhs.languageCd).append(adjudicationResultList, rhs.adjudicationResultList).append(psiApplication, rhs.psiApplication).append(individualSurveyResponse, rhs.individualSurveyResponse).append(eConsents, rhs.eConsents).append(contactMe, rhs.contactMe).append(isComplianceRequired, rhs.isComplianceRequired).append(alerts, rhs.alerts).append(otherParty, rhs.otherParty).append(agentDetails, rhs.agentDetails).append(isContactMe, rhs.isContactMe).append(accounts, rhs.accounts).append(additionalProperties, rhs.additionalProperties).append(applicationDate, rhs.applicationDate).append(resumeDate, rhs.resumeDate).append(primary, rhs.primary).isEquals();
    }

}
