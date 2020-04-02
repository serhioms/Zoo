
package ca.mss.test.pojo.dest.complex;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Associates the agreement with features that are specific to the agreement.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "roleCd",
    "feature"
})
public class AgreementToFeature {

    /**
     * Relationship of the feature to account related subjects.
     * 
     */
    @JsonProperty("roleCd")
    @JsonPropertyDescription("Relationship of the feature to account related subjects.")
    private String roleCd;
    /**
     * Feature related to the agreement.
     * (Required)
     * 
     */
    @JsonProperty("feature")
    @JsonPropertyDescription("Feature related to the agreement.")
    @Valid
    @NotNull
    private Feature feature;

    /**
     * Relationship of the feature to account related subjects.
     * 
     */
    @JsonProperty("roleCd")
    public String getRoleCd() {
        return roleCd;
    }

    /**
     * Relationship of the feature to account related subjects.
     * 
     */
    @JsonProperty("roleCd")
    public void setRoleCd(String roleCd) {
        this.roleCd = roleCd;
    }

    /**
     * Feature related to the agreement.
     * (Required)
     * 
     */
    @JsonProperty("feature")
    public Feature getFeature() {
        return feature;
    }

    /**
     * Feature related to the agreement.
     * (Required)
     * 
     */
    @JsonProperty("feature")
    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("roleCd", roleCd).append("feature", feature).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(roleCd).append(feature).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgreementToFeature) == false) {
            return false;
        }
        AgreementToFeature rhs = ((AgreementToFeature) other);
        return new EqualsBuilder().append(roleCd, rhs.roleCd).append(feature, rhs.feature).isEquals();
    }

}
