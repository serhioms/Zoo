
package ca.mss.test.pojo.src.simple;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    "productId",
    "productVersion",
    "subApplicationId"
})
public class SubApplicationList {

    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_CD
     * (Required)
     * 
     */
    @JsonProperty("productId")
    @JsonPropertyDescription("corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_CD")
    @NotNull
    private String productId;
    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_VERSION_NUM
     * (Required)
     * 
     */
    @JsonProperty("productVersion")
    @JsonPropertyDescription("corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_VERSION_NUM")
    @NotNull
    private String productVersion;
    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * (Required)
     * 
     */
    @JsonProperty("subApplicationId")
    @JsonPropertyDescription("corresponding to EVENT. SUBAPPLICATION_ID")
    @NotNull
    private String subApplicationId;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_CD
     * (Required)
     * 
     */
    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_CD
     * (Required)
     * 
     */
    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_VERSION_NUM
     * (Required)
     * 
     */
    @JsonProperty("productVersion")
    public String getProductVersion() {
        return productVersion;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_VERSION_NUM
     * (Required)
     * 
     */
    @JsonProperty("productVersion")
    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * (Required)
     * 
     */
    @JsonProperty("subApplicationId")
    public String getSubApplicationId() {
        return subApplicationId;
    }

    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * (Required)
     * 
     */
    @JsonProperty("subApplicationId")
    public void setSubApplicationId(String subApplicationId) {
        this.subApplicationId = subApplicationId;
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
        return new ToStringBuilder(this).append("productId", productId).append("productVersion", productVersion).append("subApplicationId", subApplicationId).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(productVersion).append(additionalProperties).append(productId).append(subApplicationId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SubApplicationList) == false) {
            return false;
        }
        SubApplicationList rhs = ((SubApplicationList) other);
        return new EqualsBuilder().append(productVersion, rhs.productVersion).append(additionalProperties, rhs.additionalProperties).append(productId, rhs.productId).append(subApplicationId, rhs.subApplicationId).isEquals();
    }

}
