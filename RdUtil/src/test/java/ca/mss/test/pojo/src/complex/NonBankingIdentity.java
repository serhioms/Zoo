
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
    "type",
    "issuer",
    "countryOfBirth",
    "issuedCountry",
    "placeOfIssue",
    "issueDate",
    "expiryDate",
    "verifyDate",
    "actionCd"
})
public class NonBankingIdentity implements Serializable, Cloneable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    /**
     * The party issued the identification. Example: Goverment of Canada or CRA
     * 
     */
    @JsonProperty("issuer")
    @JsonPropertyDescription("The party issued the identification. Example: Goverment of Canada or CRA")
    private String issuer;
    @JsonProperty("countryOfBirth")
    private String countryOfBirth;
    @JsonProperty("issuedCountry")
    private String issuedCountry;
    /**
     * Issuing Terrotitory. Example: issuing province or state. Like Ontario or New York.
     * 
     */
    @JsonProperty("placeOfIssue")
    @JsonPropertyDescription("Issuing Terrotitory. Example: issuing province or state. Like Ontario or New York.")
    private String placeOfIssue;
    /**
     * IssueDate of the Id.
     * 
     */
    @JsonProperty("issueDate")
    @JsonPropertyDescription("IssueDate of the Id.")
    private Long issueDate;
    /**
     * ExpiryDate of the Id.
     * 
     */
    @JsonProperty("expiryDate")
    @JsonPropertyDescription("ExpiryDate of the Id.")
    private Long expiryDate;
    /**
     * VerificationDate of the Id.
     * 
     */
    @JsonProperty("verifyDate")
    @JsonPropertyDescription("VerificationDate of the Id.")
    private Long verifyDate;
    /**
     * CIF action enumeration;
     *  0: Do nothing 
     *  1: Create
     *  2: Replace
     *  3: Delete
     * -2: ID from IPR action is add
     * -3: ID from IPR action is replace
     * 
     */
    @JsonProperty("actionCd")
    @JsonPropertyDescription("CIF action enumeration;\r\n0: Do nothing \r\n1: Create\r\n2: Replace\r\n3: Delete\r\n-2: ID from IPR action is add\r\n-3: ID from IPR action is replace")
    private String actionCd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 771687111887925915L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NonBankingIdentity() {
    }

    /**
     * 
     * @param expiryDate
     * @param placeOfIssue
     * @param verifyDate
     * @param countryOfBirth
     * @param issuedCountry
     * @param id
     * @param type
     * @param issueDate
     * @param issuer
     * @param actionCd
     */
    public NonBankingIdentity(String id, String type, String issuer, String countryOfBirth, String issuedCountry, String placeOfIssue, Long issueDate, Long expiryDate, Long verifyDate, String actionCd) {
        super();
        this.id = id;
        this.type = type;
        this.issuer = issuer;
        this.countryOfBirth = countryOfBirth;
        this.issuedCountry = issuedCountry;
        this.placeOfIssue = placeOfIssue;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.verifyDate = verifyDate;
        this.actionCd = actionCd;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The party issued the identification. Example: Goverment of Canada or CRA
     * 
     */
    @JsonProperty("issuer")
    public String getIssuer() {
        return issuer;
    }

    /**
     * The party issued the identification. Example: Goverment of Canada or CRA
     * 
     */
    @JsonProperty("issuer")
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @JsonProperty("countryOfBirth")
    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    @JsonProperty("countryOfBirth")
    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    @JsonProperty("issuedCountry")
    public String getIssuedCountry() {
        return issuedCountry;
    }

    @JsonProperty("issuedCountry")
    public void setIssuedCountry(String issuedCountry) {
        this.issuedCountry = issuedCountry;
    }

    /**
     * Issuing Terrotitory. Example: issuing province or state. Like Ontario or New York.
     * 
     */
    @JsonProperty("placeOfIssue")
    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    /**
     * Issuing Terrotitory. Example: issuing province or state. Like Ontario or New York.
     * 
     */
    @JsonProperty("placeOfIssue")
    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    /**
     * IssueDate of the Id.
     * 
     */
    @JsonProperty("issueDate")
    public Long getIssueDate() {
        return issueDate;
    }

    /**
     * IssueDate of the Id.
     * 
     */
    @JsonProperty("issueDate")
    public void setIssueDate(Long issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * ExpiryDate of the Id.
     * 
     */
    @JsonProperty("expiryDate")
    public Long getExpiryDate() {
        return expiryDate;
    }

    /**
     * ExpiryDate of the Id.
     * 
     */
    @JsonProperty("expiryDate")
    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * VerificationDate of the Id.
     * 
     */
    @JsonProperty("verifyDate")
    public Long getVerifyDate() {
        return verifyDate;
    }

    /**
     * VerificationDate of the Id.
     * 
     */
    @JsonProperty("verifyDate")
    public void setVerifyDate(Long verifyDate) {
        this.verifyDate = verifyDate;
    }

    /**
     * CIF action enumeration;
     *  0: Do nothing 
     *  1: Create
     *  2: Replace
     *  3: Delete
     * -2: ID from IPR action is add
     * -3: ID from IPR action is replace
     * 
     */
    @JsonProperty("actionCd")
    public String getActionCd() {
        return actionCd;
    }

    /**
     * CIF action enumeration;
     *  0: Do nothing 
     *  1: Create
     *  2: Replace
     *  3: Delete
     * -2: ID from IPR action is add
     * -3: ID from IPR action is replace
     * 
     */
    @JsonProperty("actionCd")
    public void setActionCd(String actionCd) {
        this.actionCd = actionCd;
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
        return new ToStringBuilder(this).append("id", id).append("type", type).append("issuer", issuer).append("countryOfBirth", countryOfBirth).append("issuedCountry", issuedCountry).append("placeOfIssue", placeOfIssue).append("issueDate", issueDate).append("expiryDate", expiryDate).append("verifyDate", verifyDate).append("actionCd", actionCd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(expiryDate).append(placeOfIssue).append(verifyDate).append(countryOfBirth).append(issuedCountry).append(id).append(additionalProperties).append(type).append(issueDate).append(issuer).append(actionCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NonBankingIdentity) == false) {
            return false;
        }
        NonBankingIdentity rhs = ((NonBankingIdentity) other);
        return new EqualsBuilder().append(expiryDate, rhs.expiryDate).append(placeOfIssue, rhs.placeOfIssue).append(verifyDate, rhs.verifyDate).append(countryOfBirth, rhs.countryOfBirth).append(issuedCountry, rhs.issuedCountry).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(issueDate, rhs.issueDate).append(issuer, rhs.issuer).append(actionCd, rhs.actionCd).isEquals();
    }

}
