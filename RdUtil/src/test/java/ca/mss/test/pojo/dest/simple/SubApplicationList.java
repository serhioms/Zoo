
package ca.mss.test.pojo.dest.simple;

import javax.validation.constraints.NotNull;
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
     * 
     */
    @JsonProperty("productId")
    @JsonPropertyDescription("corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_CD")
    private String productId;
    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_VERSION_NUM
     * 
     */
    @JsonProperty("productVersion")
    @JsonPropertyDescription("corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_VERSION_NUM")
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

    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_CD
     * 
     */
    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_CD
     * 
     */
    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_VERSION_NUM
     * 
     */
    @JsonProperty("productVersion")
    public String getProductVersion() {
        return productVersion;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_VERSION_NUM
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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("productId", productId).append("productVersion", productVersion).append("subApplicationId", subApplicationId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(productVersion).append(productId).append(subApplicationId).toHashCode();
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
        return new EqualsBuilder().append(productVersion, rhs.productVersion).append(productId, rhs.productId).append(subApplicationId, rhs.subApplicationId).isEquals();
    }

}
