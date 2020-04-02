
package ca.mss.test.pojo.dest.complex;

import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "featureClassificationCd",
    "featureDesc",
    "commonFeatureName",
    "fromCcyamt",
    "toCcyamt"
})
public class AmountFeature____ {

    /**
     * A code for the type of feature such as cash advance balance, purchase balance, limits, grace periods, and deductibles.
     * 
     */
    @JsonProperty("featureClassificationCd")
    @JsonPropertyDescription("A code for the type of feature such as cash advance balance, purchase balance, limits, grace periods, and deductibles.")
    private String featureClassificationCd;
    /**
     * The description of the feature.
     * 
     */
    @JsonProperty("featureDesc")
    @JsonPropertyDescription("The description of the feature.")
    private String featureDesc;
    /**
     * The identifier that is commonly used to identify the feature. Insurance examples are: AD&D - Accidental Death and Dismemberment ADB - Accidental Death Benefit FBR - Family Benefit Rider GI - Guaranteed Insurability IR - Impairment rider LBR - Living Benefit Rider
     * 
     */
    @JsonProperty("commonFeatureName")
    @JsonPropertyDescription("The identifier that is commonly used to identify the feature. Insurance examples are: AD&D - Accidental Death and Dismemberment ADB - Accidental Death Benefit FBR - Family Benefit Rider GI - Guaranteed Insurability IR - Impairment rider LBR - Living Benefit Rider")
    private String commonFeatureName;
    /**
     * This attribute associated with the beginning monetary amount of a range amount or a single amount. Banking: The beginning or minimum balance amount. Insurance: The limit or deductible amount.
     * 
     */
    @JsonProperty("fromCcyamt")
    @JsonPropertyDescription("This attribute associated with the beginning monetary amount of a range amount or a single amount. Banking: The beginning or minimum balance amount. Insurance: The limit or deductible amount.")
    @Valid
    private FromCcyamt____ fromCcyamt;
    /**
     * This attribute associated with the ending monetary amount of a range amount. This attribute could be null or the same amount as the "from" if only a single value.
     * 
     */
    @JsonProperty("toCcyamt")
    @JsonPropertyDescription("This attribute associated with the ending monetary amount of a range amount. This attribute could be null or the same amount as the \"from\" if only a single value.")
    @Valid
    private ToCcyamt____ toCcyamt;

    /**
     * A code for the type of feature such as cash advance balance, purchase balance, limits, grace periods, and deductibles.
     * 
     */
    @JsonProperty("featureClassificationCd")
    public String getFeatureClassificationCd() {
        return featureClassificationCd;
    }

    /**
     * A code for the type of feature such as cash advance balance, purchase balance, limits, grace periods, and deductibles.
     * 
     */
    @JsonProperty("featureClassificationCd")
    public void setFeatureClassificationCd(String featureClassificationCd) {
        this.featureClassificationCd = featureClassificationCd;
    }

    /**
     * The description of the feature.
     * 
     */
    @JsonProperty("featureDesc")
    public String getFeatureDesc() {
        return featureDesc;
    }

    /**
     * The description of the feature.
     * 
     */
    @JsonProperty("featureDesc")
    public void setFeatureDesc(String featureDesc) {
        this.featureDesc = featureDesc;
    }

    /**
     * The identifier that is commonly used to identify the feature. Insurance examples are: AD&D - Accidental Death and Dismemberment ADB - Accidental Death Benefit FBR - Family Benefit Rider GI - Guaranteed Insurability IR - Impairment rider LBR - Living Benefit Rider
     * 
     */
    @JsonProperty("commonFeatureName")
    public String getCommonFeatureName() {
        return commonFeatureName;
    }

    /**
     * The identifier that is commonly used to identify the feature. Insurance examples are: AD&D - Accidental Death and Dismemberment ADB - Accidental Death Benefit FBR - Family Benefit Rider GI - Guaranteed Insurability IR - Impairment rider LBR - Living Benefit Rider
     * 
     */
    @JsonProperty("commonFeatureName")
    public void setCommonFeatureName(String commonFeatureName) {
        this.commonFeatureName = commonFeatureName;
    }

    /**
     * This attribute associated with the beginning monetary amount of a range amount or a single amount. Banking: The beginning or minimum balance amount. Insurance: The limit or deductible amount.
     * 
     */
    @JsonProperty("fromCcyamt")
    public FromCcyamt____ getFromCcyamt() {
        return fromCcyamt;
    }

    /**
     * This attribute associated with the beginning monetary amount of a range amount or a single amount. Banking: The beginning or minimum balance amount. Insurance: The limit or deductible amount.
     * 
     */
    @JsonProperty("fromCcyamt")
    public void setFromCcyamt(FromCcyamt____ fromCcyamt) {
        this.fromCcyamt = fromCcyamt;
    }

    /**
     * This attribute associated with the ending monetary amount of a range amount. This attribute could be null or the same amount as the "from" if only a single value.
     * 
     */
    @JsonProperty("toCcyamt")
    public ToCcyamt____ getToCcyamt() {
        return toCcyamt;
    }

    /**
     * This attribute associated with the ending monetary amount of a range amount. This attribute could be null or the same amount as the "from" if only a single value.
     * 
     */
    @JsonProperty("toCcyamt")
    public void setToCcyamt(ToCcyamt____ toCcyamt) {
        this.toCcyamt = toCcyamt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("featureClassificationCd", featureClassificationCd).append("featureDesc", featureDesc).append("commonFeatureName", commonFeatureName).append("fromCcyamt", fromCcyamt).append("toCcyamt", toCcyamt).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(commonFeatureName).append(toCcyamt).append(featureClassificationCd).append(featureDesc).append(fromCcyamt).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AmountFeature____) == false) {
            return false;
        }
        AmountFeature____ rhs = ((AmountFeature____) other);
        return new EqualsBuilder().append(commonFeatureName, rhs.commonFeatureName).append(toCcyamt, rhs.toCcyamt).append(featureClassificationCd, rhs.featureClassificationCd).append(featureDesc, rhs.featureDesc).append(fromCcyamt, rhs.fromCcyamt).isEquals();
    }

}
