
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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Version v1, Date; 20180427. EConsent Definition
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "agreement",
    "communicationLanguageCD",
    "initiatingLocationID",
    "sourceApplicationCD"
})
public class EConsents implements Serializable, Cloneable
{

    @JsonProperty("agreement")
    private List<Agreement> agreement = null;
    @JsonProperty("communicationLanguageCD")
    private String communicationLanguageCD;
    @JsonProperty("initiatingLocationID")
    private String initiatingLocationID;
    @JsonProperty("sourceApplicationCD")
    private String sourceApplicationCD;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -745873023010867863L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public EConsents() {
    }

    /**
     * 
     * @param communicationLanguageCD
     * @param sourceApplicationCD
     * @param agreement
     * @param initiatingLocationID
     */
    public EConsents(List<Agreement> agreement, String communicationLanguageCD, String initiatingLocationID, String sourceApplicationCD) {
        super();
        this.agreement = agreement;
        this.communicationLanguageCD = communicationLanguageCD;
        this.initiatingLocationID = initiatingLocationID;
        this.sourceApplicationCD = sourceApplicationCD;
    }

    @JsonProperty("agreement")
    public List<Agreement> getAgreement() {
        return agreement;
    }

    @JsonProperty("agreement")
    public void setAgreement(List<Agreement> agreement) {
        this.agreement = agreement;
    }

    @JsonProperty("communicationLanguageCD")
    public String getCommunicationLanguageCD() {
        return communicationLanguageCD;
    }

    @JsonProperty("communicationLanguageCD")
    public void setCommunicationLanguageCD(String communicationLanguageCD) {
        this.communicationLanguageCD = communicationLanguageCD;
    }

    @JsonProperty("initiatingLocationID")
    public String getInitiatingLocationID() {
        return initiatingLocationID;
    }

    @JsonProperty("initiatingLocationID")
    public void setInitiatingLocationID(String initiatingLocationID) {
        this.initiatingLocationID = initiatingLocationID;
    }

    @JsonProperty("sourceApplicationCD")
    public String getSourceApplicationCD() {
        return sourceApplicationCD;
    }

    @JsonProperty("sourceApplicationCD")
    public void setSourceApplicationCD(String sourceApplicationCD) {
        this.sourceApplicationCD = sourceApplicationCD;
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
        return new ToStringBuilder(this).append("agreement", agreement).append("communicationLanguageCD", communicationLanguageCD).append("initiatingLocationID", initiatingLocationID).append("sourceApplicationCD", sourceApplicationCD).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(communicationLanguageCD).append(sourceApplicationCD).append(agreement).append(additionalProperties).append(initiatingLocationID).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EConsents) == false) {
            return false;
        }
        EConsents rhs = ((EConsents) other);
        return new EqualsBuilder().append(communicationLanguageCD, rhs.communicationLanguageCD).append(sourceApplicationCD, rhs.sourceApplicationCD).append(agreement, rhs.agreement).append(additionalProperties, rhs.additionalProperties).append(initiatingLocationID, rhs.initiatingLocationID).isEquals();
    }

}
