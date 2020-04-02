
package ca.mss.test.pojo.src.complex;

import java.io.Serializable;
import java.util.HashMap;
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
 * data.statementDelivery is copied over as definitions.Account.statementDelivery and data.statementDelivery will be deprecated later as currently EDB and DI are using data.statementDelivery
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "chequeReturnInd",
    "statementMailTypeCd"
})
public class StatementDelivery implements Serializable, Cloneable
{

    @JsonProperty("chequeReturnInd")
    private String chequeReturnInd;
    @JsonProperty("statementMailTypeCd")
    private String statementMailTypeCd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7600694934278467726L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public StatementDelivery() {
    }

    /**
     * 
     * @param statementMailTypeCd
     * @param chequeReturnInd
     */
    public StatementDelivery(String chequeReturnInd, String statementMailTypeCd) {
        super();
        this.chequeReturnInd = chequeReturnInd;
        this.statementMailTypeCd = statementMailTypeCd;
    }

    @JsonProperty("chequeReturnInd")
    public String getChequeReturnInd() {
        return chequeReturnInd;
    }

    @JsonProperty("chequeReturnInd")
    public void setChequeReturnInd(String chequeReturnInd) {
        this.chequeReturnInd = chequeReturnInd;
    }

    @JsonProperty("statementMailTypeCd")
    public String getStatementMailTypeCd() {
        return statementMailTypeCd;
    }

    @JsonProperty("statementMailTypeCd")
    public void setStatementMailTypeCd(String statementMailTypeCd) {
        this.statementMailTypeCd = statementMailTypeCd;
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
        return new ToStringBuilder(this).append("chequeReturnInd", chequeReturnInd).append("statementMailTypeCd", statementMailTypeCd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(chequeReturnInd).append(additionalProperties).append(statementMailTypeCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StatementDelivery) == false) {
            return false;
        }
        StatementDelivery rhs = ((StatementDelivery) other);
        return new EqualsBuilder().append(chequeReturnInd, rhs.chequeReturnInd).append(additionalProperties, rhs.additionalProperties).append(statementMailTypeCd, rhs.statementMailTypeCd).isEquals();
    }

}
