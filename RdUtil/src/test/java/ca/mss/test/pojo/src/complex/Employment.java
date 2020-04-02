
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
    "employerName",
    "address",
    "industryCd",
    "occupationCd",
    "industryDescription",
    "occupationDescription",
    "startDateVal",
    "sinceDateVal",
    "statusCd",
    "wage",
    "selfEmployed",
    "workPhone",
    "payFrequency",
    "confirmed",
    "schoolName",
    "studentEducationLevel",
    "id",
    "studentFullTime",
    "studentGraduationDate",
    "amount",
    "isActive",
    "isPrimary",
    "employmentType",
    "employed",
    "corelationId",
    "actionInd"
})
public class Employment implements Serializable, Cloneable
{

    @JsonProperty("employerName")
    private String employerName;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("industryCd")
    private String industryCd;
    @JsonProperty("occupationCd")
    private String occupationCd;
    @JsonProperty("industryDescription")
    private String industryDescription;
    @JsonProperty("occupationDescription")
    private String occupationDescription;
    @JsonProperty("startDateVal")
    private String startDateVal;
    @JsonProperty("sinceDateVal")
    private String sinceDateVal;
    @JsonProperty("statusCd")
    private String statusCd;
    @JsonProperty("wage")
    private String wage;
    @JsonProperty("selfEmployed")
    private Boolean selfEmployed;
    /**
     * Phone/contact Number information is stored in this object.
     * 
     */
    @JsonProperty("workPhone")
    @JsonPropertyDescription("Phone/contact Number information is stored in this object.")
    private PhoneList workPhone;
    @JsonProperty("payFrequency")
    private String payFrequency;
    @JsonProperty("confirmed")
    private List<String> confirmed = null;
    @JsonProperty("schoolName")
    private String schoolName;
    /**
     * This is student's educational level e.g. Undergraduate/Graduate/Diploma/Certificate/Other.
     * 
     */
    @JsonProperty("studentEducationLevel")
    @JsonPropertyDescription("This is student's educational level e.g. Undergraduate/Graduate/Diploma/Certificate/Other.")
    private String studentEducationLevel;
    /**
     * This is used to store employmentid or student id.
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("This is used to store employmentid or student id.")
    private String id;
    /**
     * This is used to stored students full/part time.
     * 
     */
    @JsonProperty("studentFullTime")
    @JsonPropertyDescription("This is used to stored students full/part time.")
    private String studentFullTime;
    /**
     * This is used to stored students graduation date stored in mm/yyyy format.
     * 
     */
    @JsonProperty("studentGraduationDate")
    @JsonPropertyDescription("This is used to stored students graduation date stored in mm/yyyy format.")
    private String studentGraduationDate;
    @JsonProperty("amount")
    private OptionAmt amount;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("isPrimary")
    private Boolean isPrimary;
    @JsonProperty("employmentType")
    private String employmentType;
    @JsonProperty("employed")
    private String employed;
    @JsonProperty("corelationId")
    private String corelationId;
    /**
     * Action Details :: 0 -Do nothing :: 1 -Create = Ignore Corelationid and Generate Corelationid :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.For Employment, we need to ignore corelationId from Employment Address always.
     * 
     */
    @JsonProperty("actionInd")
    @JsonPropertyDescription("Action Details :: 0 -Do nothing :: 1 -Create = Ignore Corelationid and Generate Corelationid :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.For Employment, we need to ignore corelationId from Employment Address always.")
    private String actionInd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6881488336094621823L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Employment() {
    }

    /**
     * 
     * @param studentGraduationDate
     * @param studentFullTime
     * @param occupationDescription
     * @param payFrequency
     * @param employerName
     * @param isActive
     * @param confirmed
     * @param sinceDateVal
     * @param employed
     * @param startDateVal
     * @param industryCd
     * @param isPrimary
     * @param actionInd
     * @param corelationId
     * @param id
     * @param selfEmployed
     * @param schoolName
     * @param occupationCd
     * @param wage
     * @param studentEducationLevel
     * @param amount
     * @param address
     * @param employmentType
     * @param statusCd
     * @param industryDescription
     * @param workPhone
     */
    public Employment(String employerName, Address address, String industryCd, String occupationCd, String industryDescription, String occupationDescription, String startDateVal, String sinceDateVal, String statusCd, String wage, Boolean selfEmployed, PhoneList workPhone, String payFrequency, List<String> confirmed, String schoolName, String studentEducationLevel, String id, String studentFullTime, String studentGraduationDate, OptionAmt amount, Boolean isActive, Boolean isPrimary, String employmentType, String employed, String corelationId, String actionInd) {
        super();
        this.employerName = employerName;
        this.address = address;
        this.industryCd = industryCd;
        this.occupationCd = occupationCd;
        this.industryDescription = industryDescription;
        this.occupationDescription = occupationDescription;
        this.startDateVal = startDateVal;
        this.sinceDateVal = sinceDateVal;
        this.statusCd = statusCd;
        this.wage = wage;
        this.selfEmployed = selfEmployed;
        this.workPhone = workPhone;
        this.payFrequency = payFrequency;
        this.confirmed = confirmed;
        this.schoolName = schoolName;
        this.studentEducationLevel = studentEducationLevel;
        this.id = id;
        this.studentFullTime = studentFullTime;
        this.studentGraduationDate = studentGraduationDate;
        this.amount = amount;
        this.isActive = isActive;
        this.isPrimary = isPrimary;
        this.employmentType = employmentType;
        this.employed = employed;
        this.corelationId = corelationId;
        this.actionInd = actionInd;
    }

    @JsonProperty("employerName")
    public String getEmployerName() {
        return employerName;
    }

    @JsonProperty("employerName")
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("industryCd")
    public String getIndustryCd() {
        return industryCd;
    }

    @JsonProperty("industryCd")
    public void setIndustryCd(String industryCd) {
        this.industryCd = industryCd;
    }

    @JsonProperty("occupationCd")
    public String getOccupationCd() {
        return occupationCd;
    }

    @JsonProperty("occupationCd")
    public void setOccupationCd(String occupationCd) {
        this.occupationCd = occupationCd;
    }

    @JsonProperty("industryDescription")
    public String getIndustryDescription() {
        return industryDescription;
    }

    @JsonProperty("industryDescription")
    public void setIndustryDescription(String industryDescription) {
        this.industryDescription = industryDescription;
    }

    @JsonProperty("occupationDescription")
    public String getOccupationDescription() {
        return occupationDescription;
    }

    @JsonProperty("occupationDescription")
    public void setOccupationDescription(String occupationDescription) {
        this.occupationDescription = occupationDescription;
    }

    @JsonProperty("startDateVal")
    public String getStartDateVal() {
        return startDateVal;
    }

    @JsonProperty("startDateVal")
    public void setStartDateVal(String startDateVal) {
        this.startDateVal = startDateVal;
    }

    @JsonProperty("sinceDateVal")
    public String getSinceDateVal() {
        return sinceDateVal;
    }

    @JsonProperty("sinceDateVal")
    public void setSinceDateVal(String sinceDateVal) {
        this.sinceDateVal = sinceDateVal;
    }

    @JsonProperty("statusCd")
    public String getStatusCd() {
        return statusCd;
    }

    @JsonProperty("statusCd")
    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    @JsonProperty("wage")
    public String getWage() {
        return wage;
    }

    @JsonProperty("wage")
    public void setWage(String wage) {
        this.wage = wage;
    }

    @JsonProperty("selfEmployed")
    public Boolean getSelfEmployed() {
        return selfEmployed;
    }

    @JsonProperty("selfEmployed")
    public void setSelfEmployed(Boolean selfEmployed) {
        this.selfEmployed = selfEmployed;
    }

    /**
     * Phone/contact Number information is stored in this object.
     * 
     */
    @JsonProperty("workPhone")
    public PhoneList getWorkPhone() {
        return workPhone;
    }

    /**
     * Phone/contact Number information is stored in this object.
     * 
     */
    @JsonProperty("workPhone")
    public void setWorkPhone(PhoneList workPhone) {
        this.workPhone = workPhone;
    }

    @JsonProperty("payFrequency")
    public String getPayFrequency() {
        return payFrequency;
    }

    @JsonProperty("payFrequency")
    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency;
    }

    @JsonProperty("confirmed")
    public List<String> getConfirmed() {
        return confirmed;
    }

    @JsonProperty("confirmed")
    public void setConfirmed(List<String> confirmed) {
        this.confirmed = confirmed;
    }

    @JsonProperty("schoolName")
    public String getSchoolName() {
        return schoolName;
    }

    @JsonProperty("schoolName")
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * This is student's educational level e.g. Undergraduate/Graduate/Diploma/Certificate/Other.
     * 
     */
    @JsonProperty("studentEducationLevel")
    public String getStudentEducationLevel() {
        return studentEducationLevel;
    }

    /**
     * This is student's educational level e.g. Undergraduate/Graduate/Diploma/Certificate/Other.
     * 
     */
    @JsonProperty("studentEducationLevel")
    public void setStudentEducationLevel(String studentEducationLevel) {
        this.studentEducationLevel = studentEducationLevel;
    }

    /**
     * This is used to store employmentid or student id.
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * This is used to store employmentid or student id.
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This is used to stored students full/part time.
     * 
     */
    @JsonProperty("studentFullTime")
    public String getStudentFullTime() {
        return studentFullTime;
    }

    /**
     * This is used to stored students full/part time.
     * 
     */
    @JsonProperty("studentFullTime")
    public void setStudentFullTime(String studentFullTime) {
        this.studentFullTime = studentFullTime;
    }

    /**
     * This is used to stored students graduation date stored in mm/yyyy format.
     * 
     */
    @JsonProperty("studentGraduationDate")
    public String getStudentGraduationDate() {
        return studentGraduationDate;
    }

    /**
     * This is used to stored students graduation date stored in mm/yyyy format.
     * 
     */
    @JsonProperty("studentGraduationDate")
    public void setStudentGraduationDate(String studentGraduationDate) {
        this.studentGraduationDate = studentGraduationDate;
    }

    @JsonProperty("amount")
    public OptionAmt getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(OptionAmt amount) {
        this.amount = amount;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("isPrimary")
    public Boolean getIsPrimary() {
        return isPrimary;
    }

    @JsonProperty("isPrimary")
    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    @JsonProperty("employmentType")
    public String getEmploymentType() {
        return employmentType;
    }

    @JsonProperty("employmentType")
    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    @JsonProperty("employed")
    public String getEmployed() {
        return employed;
    }

    @JsonProperty("employed")
    public void setEmployed(String employed) {
        this.employed = employed;
    }

    @JsonProperty("corelationId")
    public String getCorelationId() {
        return corelationId;
    }

    @JsonProperty("corelationId")
    public void setCorelationId(String corelationId) {
        this.corelationId = corelationId;
    }

    /**
     * Action Details :: 0 -Do nothing :: 1 -Create = Ignore Corelationid and Generate Corelationid :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.For Employment, we need to ignore corelationId from Employment Address always.
     * 
     */
    @JsonProperty("actionInd")
    public String getActionInd() {
        return actionInd;
    }

    /**
     * Action Details :: 0 -Do nothing :: 1 -Create = Ignore Corelationid and Generate Corelationid :: 2 -Update :: 3- Delete. Action Indicator should be added by OCA Layer. App Engine will use this indicator to do respective txn.For Employment, we need to ignore corelationId from Employment Address always.
     * 
     */
    @JsonProperty("actionInd")
    public void setActionInd(String actionInd) {
        this.actionInd = actionInd;
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
        return new ToStringBuilder(this).append("employerName", employerName).append("address", address).append("industryCd", industryCd).append("occupationCd", occupationCd).append("industryDescription", industryDescription).append("occupationDescription", occupationDescription).append("startDateVal", startDateVal).append("sinceDateVal", sinceDateVal).append("statusCd", statusCd).append("wage", wage).append("selfEmployed", selfEmployed).append("workPhone", workPhone).append("payFrequency", payFrequency).append("confirmed", confirmed).append("schoolName", schoolName).append("studentEducationLevel", studentEducationLevel).append("id", id).append("studentFullTime", studentFullTime).append("studentGraduationDate", studentGraduationDate).append("amount", amount).append("isActive", isActive).append("isPrimary", isPrimary).append("employmentType", employmentType).append("employed", employed).append("corelationId", corelationId).append("actionInd", actionInd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(studentGraduationDate).append(studentFullTime).append(occupationDescription).append(payFrequency).append(employerName).append(isActive).append(confirmed).append(sinceDateVal).append(employed).append(startDateVal).append(industryCd).append(isPrimary).append(actionInd).append(corelationId).append(id).append(selfEmployed).append(schoolName).append(occupationCd).append(wage).append(studentEducationLevel).append(amount).append(address).append(employmentType).append(statusCd).append(industryDescription).append(workPhone).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Employment) == false) {
            return false;
        }
        Employment rhs = ((Employment) other);
        return new EqualsBuilder().append(studentGraduationDate, rhs.studentGraduationDate).append(studentFullTime, rhs.studentFullTime).append(occupationDescription, rhs.occupationDescription).append(payFrequency, rhs.payFrequency).append(employerName, rhs.employerName).append(isActive, rhs.isActive).append(confirmed, rhs.confirmed).append(sinceDateVal, rhs.sinceDateVal).append(employed, rhs.employed).append(startDateVal, rhs.startDateVal).append(industryCd, rhs.industryCd).append(isPrimary, rhs.isPrimary).append(actionInd, rhs.actionInd).append(corelationId, rhs.corelationId).append(id, rhs.id).append(selfEmployed, rhs.selfEmployed).append(schoolName, rhs.schoolName).append(occupationCd, rhs.occupationCd).append(wage, rhs.wage).append(studentEducationLevel, rhs.studentEducationLevel).append(amount, rhs.amount).append(address, rhs.address).append(employmentType, rhs.employmentType).append(statusCd, rhs.statusCd).append(industryDescription, rhs.industryDescription).append(workPhone, rhs.workPhone).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
