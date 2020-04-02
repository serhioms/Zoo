
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
    "type",
    "partyId",
    "investmentSurveyResponse",
    "surveyResponse"
})
public class IndividualSurveyResponse implements Serializable, Cloneable
{

    /**
     * Survey Type.
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Survey Type.")
    private String type;
    /**
     * PartyId of applicant or coapplicant etc. who are involved into survey.
     * 
     */
    @JsonProperty("partyId")
    @JsonPropertyDescription("PartyId of applicant or coapplicant etc. who are involved into survey.")
    private String partyId;
    @JsonProperty("investmentSurveyResponse")
    private InvestmentSurveyResponse investmentSurveyResponse;
    /**
     * Records one or more free-form answers to the survey.
     * 
     */
    @JsonProperty("surveyResponse")
    @JsonPropertyDescription("Records one or more free-form answers to the survey.")
    private List<SurveyResponse> surveyResponse = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4462858491354035367L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public IndividualSurveyResponse() {
    }

    /**
     * 
     * @param surveyResponse
     * @param investmentSurveyResponse
     * @param type
     * @param partyId
     */
    public IndividualSurveyResponse(String type, String partyId, InvestmentSurveyResponse investmentSurveyResponse, List<SurveyResponse> surveyResponse) {
        super();
        this.type = type;
        this.partyId = partyId;
        this.investmentSurveyResponse = investmentSurveyResponse;
        this.surveyResponse = surveyResponse;
    }

    /**
     * Survey Type.
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Survey Type.
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * PartyId of applicant or coapplicant etc. who are involved into survey.
     * 
     */
    @JsonProperty("partyId")
    public String getPartyId() {
        return partyId;
    }

    /**
     * PartyId of applicant or coapplicant etc. who are involved into survey.
     * 
     */
    @JsonProperty("partyId")
    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    @JsonProperty("investmentSurveyResponse")
    public InvestmentSurveyResponse getInvestmentSurveyResponse() {
        return investmentSurveyResponse;
    }

    @JsonProperty("investmentSurveyResponse")
    public void setInvestmentSurveyResponse(InvestmentSurveyResponse investmentSurveyResponse) {
        this.investmentSurveyResponse = investmentSurveyResponse;
    }

    /**
     * Records one or more free-form answers to the survey.
     * 
     */
    @JsonProperty("surveyResponse")
    public List<SurveyResponse> getSurveyResponse() {
        return surveyResponse;
    }

    /**
     * Records one or more free-form answers to the survey.
     * 
     */
    @JsonProperty("surveyResponse")
    public void setSurveyResponse(List<SurveyResponse> surveyResponse) {
        this.surveyResponse = surveyResponse;
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
        return new ToStringBuilder(this).append("type", type).append("partyId", partyId).append("investmentSurveyResponse", investmentSurveyResponse).append("surveyResponse", surveyResponse).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(investmentSurveyResponse).append(additionalProperties).append(type).append(partyId).append(surveyResponse).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IndividualSurveyResponse) == false) {
            return false;
        }
        IndividualSurveyResponse rhs = ((IndividualSurveyResponse) other);
        return new EqualsBuilder().append(investmentSurveyResponse, rhs.investmentSurveyResponse).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(partyId, rhs.partyId).append(surveyResponse, rhs.surveyResponse).isEquals();
    }

}
