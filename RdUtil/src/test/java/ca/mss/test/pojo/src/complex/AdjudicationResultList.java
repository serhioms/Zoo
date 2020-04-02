
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
    "subApplicationId",
    "adjudicationReferenceNo",
    "autoAdjudicated",
    "adjudicationDate",
    "adjudicationResponseCd",
    "adjudicationReasonCd",
    "adjudicationTypeCd"
})
public class AdjudicationResultList implements Serializable, Cloneable
{

    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * 
     */
    @JsonProperty("subApplicationId")
    @JsonPropertyDescription("corresponding to EVENT. SUBAPPLICATION_ID")
    private String subApplicationId;
    /**
     * This is an adjudication referenceNumber from a fulfillment system.
     * 
     */
    @JsonProperty("adjudicationReferenceNo")
    @JsonPropertyDescription("This is an adjudication referenceNumber from a fulfillment system.")
    private String adjudicationReferenceNo;
    /**
     * Used to determine if the application was auto adjudicated
     * 
     */
    @JsonProperty("autoAdjudicated")
    @JsonPropertyDescription("Used to determine if the application was auto adjudicated")
    private Boolean autoAdjudicated;
    /**
     * The date received in adjudication decision/response. If no explicit info from downstream, then it will be corresponding to REC_ADJ_NOTIFICATION event's EVENT_TMSTMP
     * 
     */
    @JsonProperty("adjudicationDate")
    @JsonPropertyDescription("The date received in adjudication decision/response. If no explicit info from downstream, then it will be corresponding to REC_ADJ_NOTIFICATION event's EVENT_TMSTMP")
    private Long adjudicationDate;
    /**
     * adjudication decision code  such as Declined, Approved etc.
     * 
     */
    @JsonProperty("adjudicationResponseCd")
    @JsonPropertyDescription("adjudication decision code  such as Declined, Approved etc.")
    private String adjudicationResponseCd;
    /**
     * This is a reason code for adjudication result if application is declined or pending etc.
     * 
     */
    @JsonProperty("adjudicationReasonCd")
    @JsonPropertyDescription("This is a reason code for adjudication result if application is declined or pending etc.")
    private String adjudicationReasonCd;
    /**
     * .
     * 
     */
    @JsonProperty("adjudicationTypeCd")
    @JsonPropertyDescription(".")
    private String adjudicationTypeCd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 558045222972385902L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AdjudicationResultList() {
    }

    /**
     * 
     * @param adjudicationDate
     * @param adjudicationReasonCd
     * @param subApplicationId
     * @param autoAdjudicated
     * @param adjudicationTypeCd
     * @param adjudicationResponseCd
     * @param adjudicationReferenceNo
     */
    public AdjudicationResultList(String subApplicationId, String adjudicationReferenceNo, Boolean autoAdjudicated, Long adjudicationDate, String adjudicationResponseCd, String adjudicationReasonCd, String adjudicationTypeCd) {
        super();
        this.subApplicationId = subApplicationId;
        this.adjudicationReferenceNo = adjudicationReferenceNo;
        this.autoAdjudicated = autoAdjudicated;
        this.adjudicationDate = adjudicationDate;
        this.adjudicationResponseCd = adjudicationResponseCd;
        this.adjudicationReasonCd = adjudicationReasonCd;
        this.adjudicationTypeCd = adjudicationTypeCd;
    }

    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * 
     */
    @JsonProperty("subApplicationId")
    public String getSubApplicationId() {
        return subApplicationId;
    }

    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * 
     */
    @JsonProperty("subApplicationId")
    public void setSubApplicationId(String subApplicationId) {
        this.subApplicationId = subApplicationId;
    }

    /**
     * This is an adjudication referenceNumber from a fulfillment system.
     * 
     */
    @JsonProperty("adjudicationReferenceNo")
    public String getAdjudicationReferenceNo() {
        return adjudicationReferenceNo;
    }

    /**
     * This is an adjudication referenceNumber from a fulfillment system.
     * 
     */
    @JsonProperty("adjudicationReferenceNo")
    public void setAdjudicationReferenceNo(String adjudicationReferenceNo) {
        this.adjudicationReferenceNo = adjudicationReferenceNo;
    }

    /**
     * Used to determine if the application was auto adjudicated
     * 
     */
    @JsonProperty("autoAdjudicated")
    public Boolean getAutoAdjudicated() {
        return autoAdjudicated;
    }

    /**
     * Used to determine if the application was auto adjudicated
     * 
     */
    @JsonProperty("autoAdjudicated")
    public void setAutoAdjudicated(Boolean autoAdjudicated) {
        this.autoAdjudicated = autoAdjudicated;
    }

    /**
     * The date received in adjudication decision/response. If no explicit info from downstream, then it will be corresponding to REC_ADJ_NOTIFICATION event's EVENT_TMSTMP
     * 
     */
    @JsonProperty("adjudicationDate")
    public Long getAdjudicationDate() {
        return adjudicationDate;
    }

    /**
     * The date received in adjudication decision/response. If no explicit info from downstream, then it will be corresponding to REC_ADJ_NOTIFICATION event's EVENT_TMSTMP
     * 
     */
    @JsonProperty("adjudicationDate")
    public void setAdjudicationDate(Long adjudicationDate) {
        this.adjudicationDate = adjudicationDate;
    }

    /**
     * adjudication decision code  such as Declined, Approved etc.
     * 
     */
    @JsonProperty("adjudicationResponseCd")
    public String getAdjudicationResponseCd() {
        return adjudicationResponseCd;
    }

    /**
     * adjudication decision code  such as Declined, Approved etc.
     * 
     */
    @JsonProperty("adjudicationResponseCd")
    public void setAdjudicationResponseCd(String adjudicationResponseCd) {
        this.adjudicationResponseCd = adjudicationResponseCd;
    }

    /**
     * This is a reason code for adjudication result if application is declined or pending etc.
     * 
     */
    @JsonProperty("adjudicationReasonCd")
    public String getAdjudicationReasonCd() {
        return adjudicationReasonCd;
    }

    /**
     * This is a reason code for adjudication result if application is declined or pending etc.
     * 
     */
    @JsonProperty("adjudicationReasonCd")
    public void setAdjudicationReasonCd(String adjudicationReasonCd) {
        this.adjudicationReasonCd = adjudicationReasonCd;
    }

    /**
     * .
     * 
     */
    @JsonProperty("adjudicationTypeCd")
    public String getAdjudicationTypeCd() {
        return adjudicationTypeCd;
    }

    /**
     * .
     * 
     */
    @JsonProperty("adjudicationTypeCd")
    public void setAdjudicationTypeCd(String adjudicationTypeCd) {
        this.adjudicationTypeCd = adjudicationTypeCd;
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
        return new ToStringBuilder(this).append("subApplicationId", subApplicationId).append("adjudicationReferenceNo", adjudicationReferenceNo).append("autoAdjudicated", autoAdjudicated).append("adjudicationDate", adjudicationDate).append("adjudicationResponseCd", adjudicationResponseCd).append("adjudicationReasonCd", adjudicationReasonCd).append("adjudicationTypeCd", adjudicationTypeCd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(adjudicationDate).append(adjudicationReasonCd).append(subApplicationId).append(autoAdjudicated).append(adjudicationTypeCd).append(adjudicationResponseCd).append(additionalProperties).append(adjudicationReferenceNo).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AdjudicationResultList) == false) {
            return false;
        }
        AdjudicationResultList rhs = ((AdjudicationResultList) other);
        return new EqualsBuilder().append(adjudicationDate, rhs.adjudicationDate).append(adjudicationReasonCd, rhs.adjudicationReasonCd).append(subApplicationId, rhs.subApplicationId).append(autoAdjudicated, rhs.autoAdjudicated).append(adjudicationTypeCd, rhs.adjudicationTypeCd).append(adjudicationResponseCd, rhs.adjudicationResponseCd).append(additionalProperties, rhs.additionalProperties).append(adjudicationReferenceNo, rhs.adjudicationReferenceNo).isEquals();
    }

}
