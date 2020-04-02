
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "chequeReturnInd",
    "statementType",
    "deliveryType",
    "comment"
})
public class AcctStatementDelivery implements Serializable
{

    @JsonProperty("chequeReturnInd")
    private String chequeReturnInd;
    @JsonProperty("statementType")
    private String statementType;
    @JsonProperty("deliveryType")
    private String deliveryType;
    @JsonProperty("comment")
    private String comment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7148371179424797436L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AcctStatementDelivery() {
    }

    /**
     * 
     * @param statementType
     * @param deliveryType
     * @param chequeReturnInd
     * @param comment
     */
    public AcctStatementDelivery(String chequeReturnInd, String statementType, String deliveryType, String comment) {
        super();
        this.chequeReturnInd = chequeReturnInd;
        this.statementType = statementType;
        this.deliveryType = deliveryType;
        this.comment = comment;
    }

    @JsonProperty("chequeReturnInd")
    public String getChequeReturnInd() {
        return chequeReturnInd;
    }

    @JsonProperty("chequeReturnInd")
    public void setChequeReturnInd(String chequeReturnInd) {
        this.chequeReturnInd = chequeReturnInd;
    }

    @JsonProperty("statementType")
    public String getStatementType() {
        return statementType;
    }

    @JsonProperty("statementType")
    public void setStatementType(String statementType) {
        this.statementType = statementType;
    }

    @JsonProperty("deliveryType")
    public String getDeliveryType() {
        return deliveryType;
    }

    @JsonProperty("deliveryType")
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
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
        return new ToStringBuilder(this).append("chequeReturnInd", chequeReturnInd).append("statementType", statementType).append("deliveryType", deliveryType).append("comment", comment).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deliveryType).append(chequeReturnInd).append(comment).append(additionalProperties).append(statementType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AcctStatementDelivery) == false) {
            return false;
        }
        AcctStatementDelivery rhs = ((AcctStatementDelivery) other);
        return new EqualsBuilder().append(deliveryType, rhs.deliveryType).append(chequeReturnInd, rhs.chequeReturnInd).append(comment, rhs.comment).append(additionalProperties, rhs.additionalProperties).append(statementType, rhs.statementType).isEquals();
    }

}
