
package ca.mss.test.pojo.dest.complex;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Generic IFX-based element to accommodate misc key/value pairs.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "referenceCategoryCd",
    "referenceTypeCd",
    "referenceVal"
})
public class EventReference_ {

    /**
     * 
     * 
     */
    @JsonProperty("referenceCategoryCd")
    @JsonPropertyDescription("")
    private String referenceCategoryCd;
    /**
     * 
     * 
     */
    @JsonProperty("referenceTypeCd")
    @JsonPropertyDescription("")
    private String referenceTypeCd;
    /**
     * 
     * 
     */
    @JsonProperty("referenceVal")
    @JsonPropertyDescription("")
    private String referenceVal;

    /**
     * 
     * 
     */
    @JsonProperty("referenceCategoryCd")
    public String getReferenceCategoryCd() {
        return referenceCategoryCd;
    }

    /**
     * 
     * 
     */
    @JsonProperty("referenceCategoryCd")
    public void setReferenceCategoryCd(String referenceCategoryCd) {
        this.referenceCategoryCd = referenceCategoryCd;
    }

    /**
     * 
     * 
     */
    @JsonProperty("referenceTypeCd")
    public String getReferenceTypeCd() {
        return referenceTypeCd;
    }

    /**
     * 
     * 
     */
    @JsonProperty("referenceTypeCd")
    public void setReferenceTypeCd(String referenceTypeCd) {
        this.referenceTypeCd = referenceTypeCd;
    }

    /**
     * 
     * 
     */
    @JsonProperty("referenceVal")
    public String getReferenceVal() {
        return referenceVal;
    }

    /**
     * 
     * 
     */
    @JsonProperty("referenceVal")
    public void setReferenceVal(String referenceVal) {
        this.referenceVal = referenceVal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("referenceCategoryCd", referenceCategoryCd).append("referenceTypeCd", referenceTypeCd).append("referenceVal", referenceVal).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(referenceCategoryCd).append(referenceTypeCd).append(referenceVal).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EventReference_) == false) {
            return false;
        }
        EventReference_ rhs = ((EventReference_) other);
        return new EqualsBuilder().append(referenceCategoryCd, rhs.referenceCategoryCd).append(referenceTypeCd, rhs.referenceTypeCd).append(referenceVal, rhs.referenceVal).isEquals();
    }

}
