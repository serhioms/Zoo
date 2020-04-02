
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
    "subApplicationId",
    "agreementType",
    "investmentAgreementSurvey",
    "surveyResponse"
})
public class AgreementSurveyResponse implements Serializable, Cloneable
{

    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * 
     */
    @JsonProperty("subApplicationId")
    @JsonPropertyDescription("corresponding to EVENT. SUBAPPLICATION_ID")
    private String subApplicationId;
    /**
     * Answer value for Agreement Type.
     * 
     */
    @JsonProperty("agreementType")
    @JsonPropertyDescription("Answer value for Agreement Type.")
    private String agreementType;
    @JsonProperty("investmentAgreementSurvey")
    private InvestmentAgreementSurvey investmentAgreementSurvey;
    /**
     * Records one or more free-form answers to the survey.
     * 
     */
    @JsonProperty("surveyResponse")
    @JsonPropertyDescription("Records one or more free-form answers to the survey.")
    private List<SurveyResponse> surveyResponse = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -97917995191003390L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AgreementSurveyResponse() {
    }

    /**
     * 
     * @param agreementType
     * @param investmentAgreementSurvey
     * @param surveyResponse
     * @param subApplicationId
     */
    public AgreementSurveyResponse(String subApplicationId, String agreementType, InvestmentAgreementSurvey investmentAgreementSurvey, List<SurveyResponse> surveyResponse) {
        super();
        this.subApplicationId = subApplicationId;
        this.agreementType = agreementType;
        this.investmentAgreementSurvey = investmentAgreementSurvey;
        this.surveyResponse = surveyResponse;
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
     * Answer value for Agreement Type.
     * 
     */
    @JsonProperty("agreementType")
    public String getAgreementType() {
        return agreementType;
    }

    /**
     * Answer value for Agreement Type.
     * 
     */
    @JsonProperty("agreementType")
    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }

    @JsonProperty("investmentAgreementSurvey")
    public InvestmentAgreementSurvey getInvestmentAgreementSurvey() {
        return investmentAgreementSurvey;
    }

    @JsonProperty("investmentAgreementSurvey")
    public void setInvestmentAgreementSurvey(InvestmentAgreementSurvey investmentAgreementSurvey) {
        this.investmentAgreementSurvey = investmentAgreementSurvey;
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
        return new ToStringBuilder(this).append("subApplicationId", subApplicationId).append("agreementType", agreementType).append("investmentAgreementSurvey", investmentAgreementSurvey).append("surveyResponse", surveyResponse).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(agreementType).append(investmentAgreementSurvey).append(additionalProperties).append(surveyResponse).append(subApplicationId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgreementSurveyResponse) == false) {
            return false;
        }
        AgreementSurveyResponse rhs = ((AgreementSurveyResponse) other);
        return new EqualsBuilder().append(agreementType, rhs.agreementType).append(investmentAgreementSurvey, rhs.investmentAgreementSurvey).append(additionalProperties, rhs.additionalProperties).append(surveyResponse, rhs.surveyResponse).append(subApplicationId, rhs.subApplicationId).isEquals();
    }

}
