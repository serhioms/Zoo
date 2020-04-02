
package ca.mss.test.pojo.dest.complex;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * This entity contains scores related to a potential case such as the probability that this potential case is fraudulent.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ruleId",
    "scoreVal"
})
public class FraudScore__ {

    /**
     * Rule triggered resolution of the potential fraud case.
     * 
     */
    @JsonProperty("ruleId")
    @JsonPropertyDescription("Rule triggered resolution of the potential fraud case.")
    private String ruleId;
    /**
     * Score value for a potential fraud case based on a predictive analytical model.
     * 
     */
    @JsonProperty("scoreVal")
    @JsonPropertyDescription("Score value for a potential fraud case based on a predictive analytical model.")
    private String scoreVal;

    /**
     * Rule triggered resolution of the potential fraud case.
     * 
     */
    @JsonProperty("ruleId")
    public String getRuleId() {
        return ruleId;
    }

    /**
     * Rule triggered resolution of the potential fraud case.
     * 
     */
    @JsonProperty("ruleId")
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * Score value for a potential fraud case based on a predictive analytical model.
     * 
     */
    @JsonProperty("scoreVal")
    public String getScoreVal() {
        return scoreVal;
    }

    /**
     * Score value for a potential fraud case based on a predictive analytical model.
     * 
     */
    @JsonProperty("scoreVal")
    public void setScoreVal(String scoreVal) {
        this.scoreVal = scoreVal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("ruleId", ruleId).append("scoreVal", scoreVal).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ruleId).append(scoreVal).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FraudScore__) == false) {
            return false;
        }
        FraudScore__ rhs = ((FraudScore__) other);
        return new EqualsBuilder().append(ruleId, rhs.ruleId).append(scoreVal, rhs.scoreVal).isEquals();
    }

}
