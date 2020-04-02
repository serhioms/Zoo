
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
    "responseKey",
    "responseValue",
    "responseComment"
})
public class SurveyResponse implements Serializable, Cloneable
{

    /**
     * Indicates the entry date of note or response key.
     * 
     */
    @JsonProperty("responseKey")
    @JsonPropertyDescription("Indicates the entry date of note or response key.")
    private String responseKey;
    /**
     * The text associated with the note. This can be a system assigned comment or a freeform comment.
     * 
     */
    @JsonProperty("responseValue")
    @JsonPropertyDescription("The text associated with the note. This can be a system assigned comment or a freeform comment.")
    private String responseValue;
    /**
     * Extra comment associated with the survey questions. This can be a system assigned comment or a freeform comment.
     * 
     */
    @JsonProperty("responseComment")
    @JsonPropertyDescription("Extra comment associated with the survey questions. This can be a system assigned comment or a freeform comment.")
    private String responseComment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8686705739738980817L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SurveyResponse() {
    }

    /**
     * 
     * @param responseKey
     * @param responseValue
     * @param responseComment
     */
    public SurveyResponse(String responseKey, String responseValue, String responseComment) {
        super();
        this.responseKey = responseKey;
        this.responseValue = responseValue;
        this.responseComment = responseComment;
    }

    /**
     * Indicates the entry date of note or response key.
     * 
     */
    @JsonProperty("responseKey")
    public String getResponseKey() {
        return responseKey;
    }

    /**
     * Indicates the entry date of note or response key.
     * 
     */
    @JsonProperty("responseKey")
    public void setResponseKey(String responseKey) {
        this.responseKey = responseKey;
    }

    /**
     * The text associated with the note. This can be a system assigned comment or a freeform comment.
     * 
     */
    @JsonProperty("responseValue")
    public String getResponseValue() {
        return responseValue;
    }

    /**
     * The text associated with the note. This can be a system assigned comment or a freeform comment.
     * 
     */
    @JsonProperty("responseValue")
    public void setResponseValue(String responseValue) {
        this.responseValue = responseValue;
    }

    /**
     * Extra comment associated with the survey questions. This can be a system assigned comment or a freeform comment.
     * 
     */
    @JsonProperty("responseComment")
    public String getResponseComment() {
        return responseComment;
    }

    /**
     * Extra comment associated with the survey questions. This can be a system assigned comment or a freeform comment.
     * 
     */
    @JsonProperty("responseComment")
    public void setResponseComment(String responseComment) {
        this.responseComment = responseComment;
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
        return new ToStringBuilder(this).append("responseKey", responseKey).append("responseValue", responseValue).append("responseComment", responseComment).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(responseKey).append(responseValue).append(responseComment).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SurveyResponse) == false) {
            return false;
        }
        SurveyResponse rhs = ((SurveyResponse) other);
        return new EqualsBuilder().append(responseKey, rhs.responseKey).append(responseValue, rhs.responseValue).append(responseComment, rhs.responseComment).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
