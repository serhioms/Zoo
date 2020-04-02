
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
    "productId",
    "productVersion",
    "subApplicationId"
})
public class SubApplicationList implements Serializable
{

    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_CD
     * 
     */
    @JsonProperty("productId")
    @JsonPropertyDescription("corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_CD")
    private String productId;
    /**
     * Corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_VERSION_NUM
     * 
     */
    @JsonProperty("productVersion")
    @JsonPropertyDescription("Corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_VERSION_NUM")
    private String productVersion;
    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * (Required)
     * 
     */
    @JsonProperty("subApplicationId")
    @JsonPropertyDescription("corresponding to EVENT. SUBAPPLICATION_ID")
    private String subApplicationId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -9017124934424846967L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubApplicationList() {
    }

    /**
     * 
     * @param productVersion
     * @param productId
     * @param subApplicationId
     */
    public SubApplicationList(String productId, String productVersion, String subApplicationId) {
        super();
        this.productId = productId;
        this.productVersion = productVersion;
        this.subApplicationId = subApplicationId;
    }

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
     * Corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_VERSION_NUM
     * 
     */
    @JsonProperty("productVersion")
    public String getProductVersion() {
        return productVersion;
    }

    /**
     * Corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_VERSION_NUM
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
