
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
    "externalProductId",
    "productId",
    "productVersion",
    "metaData",
    "subApplicationId",
    "isOffer",
    "offerCd",
    "offerTypeCd",
    "presentmentId",
    "offerAcceptedInd"
})
public class Product implements Serializable, Cloneable
{

    /**
     * corresponding to PRODUCT_TYPE_LIST.SOURCE_PRODUCT_TYPE_CD
     * 
     */
    @JsonProperty("externalProductId")
    @JsonPropertyDescription("corresponding to PRODUCT_TYPE_LIST.SOURCE_PRODUCT_TYPE_CD")
    private String externalProductId;
    /**
     * corresponding to PRODUCT_TYPE_LIST. PRODUCT_TYPE_CD
     * 
     */
    @JsonProperty("productId")
    @JsonPropertyDescription("corresponding to PRODUCT_TYPE_LIST. PRODUCT_TYPE_CD")
    private String productId;
    /**
     * corresponding to PRODUCT_TYPE_LIST. PRODUCT_TYPE_VERSION_NUM
     * 
     */
    @JsonProperty("productVersion")
    @JsonPropertyDescription("corresponding to PRODUCT_TYPE_LIST. PRODUCT_TYPE_VERSION_NUM")
    private Integer productVersion;
    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_JSON_METADATA, it is an object representing JSON.
     * 
     */
    @JsonProperty("metaData")
    @JsonPropertyDescription("corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_JSON_METADATA, it is an object representing JSON.")
    private String metaData;
    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * 
     */
    @JsonProperty("subApplicationId")
    @JsonPropertyDescription("corresponding to EVENT. SUBAPPLICATION_ID")
    private String subApplicationId;
    /**
     * whether the application has an offer to the customer
     * 
     */
    @JsonProperty("isOffer")
    @JsonPropertyDescription("whether the application has an offer to the customer")
    private Boolean isOffer;
    /**
     * the code that represents an offer or promotion to a customer
     * 
     */
    @JsonProperty("offerCd")
    @JsonPropertyDescription("the code that represents an offer or promotion to a customer")
    private String offerCd;
    /**
     * the code that represents an offer type.
     * 
     */
    @JsonProperty("offerTypeCd")
    @JsonPropertyDescription("the code that represents an offer type.")
    private String offerTypeCd;
    /**
     * The presentMentId is specific to UI Presentment when it displayed to customer
     * 
     */
    @JsonProperty("presentmentId")
    @JsonPropertyDescription("The presentMentId is specific to UI Presentment when it displayed to customer")
    private String presentmentId;
    /**
     * The flag stats whether offer is accepted or rejected by customer.
     * 
     */
    @JsonProperty("offerAcceptedInd")
    @JsonPropertyDescription("The flag stats whether offer is accepted or rejected by customer.")
    private Boolean offerAcceptedInd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5651328848621622124L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Product() {
    }

    /**
     * 
     * @param metaData
     * @param productVersion
     * @param offerCd
     * @param productId
     * @param offerTypeCd
     * @param isOffer
     * @param subApplicationId
     * @param presentmentId
     * @param offerAcceptedInd
     * @param externalProductId
     */
    public Product(String externalProductId, String productId, Integer productVersion, String metaData, String subApplicationId, Boolean isOffer, String offerCd, String offerTypeCd, String presentmentId, Boolean offerAcceptedInd) {
        super();
        this.externalProductId = externalProductId;
        this.productId = productId;
        this.productVersion = productVersion;
        this.metaData = metaData;
        this.subApplicationId = subApplicationId;
        this.isOffer = isOffer;
        this.offerCd = offerCd;
        this.offerTypeCd = offerTypeCd;
        this.presentmentId = presentmentId;
        this.offerAcceptedInd = offerAcceptedInd;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST.SOURCE_PRODUCT_TYPE_CD
     * 
     */
    @JsonProperty("externalProductId")
    public String getExternalProductId() {
        return externalProductId;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST.SOURCE_PRODUCT_TYPE_CD
     * 
     */
    @JsonProperty("externalProductId")
    public void setExternalProductId(String externalProductId) {
        this.externalProductId = externalProductId;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST. PRODUCT_TYPE_CD
     * 
     */
    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST. PRODUCT_TYPE_CD
     * 
     */
    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST. PRODUCT_TYPE_VERSION_NUM
     * 
     */
    @JsonProperty("productVersion")
    public Integer getProductVersion() {
        return productVersion;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST. PRODUCT_TYPE_VERSION_NUM
     * 
     */
    @JsonProperty("productVersion")
    public void setProductVersion(Integer productVersion) {
        this.productVersion = productVersion;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_JSON_METADATA, it is an object representing JSON.
     * 
     */
    @JsonProperty("metaData")
    public String getMetaData() {
        return metaData;
    }

    /**
     * corresponding to PRODUCT_TYPE_LIST.PRODUCT_TYPE_JSON_METADATA, it is an object representing JSON.
     * 
     */
    @JsonProperty("metaData")
    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * 
     */
    @JsonProperty("subApplicationId")
    public String getSubApplicationId() {
        return subApplicationId;
    }

    /**
     * corresponding to EVENT. SUBAPPLICATION_ID
     * 
     */
    @JsonProperty("subApplicationId")
    public void setSubApplicationId(String subApplicationId) {
        this.subApplicationId = subApplicationId;
    }

    /**
     * whether the application has an offer to the customer
     * 
     */
    @JsonProperty("isOffer")
    public Boolean getIsOffer() {
        return isOffer;
    }

    /**
     * whether the application has an offer to the customer
     * 
     */
    @JsonProperty("isOffer")
    public void setIsOffer(Boolean isOffer) {
        this.isOffer = isOffer;
    }

    /**
     * the code that represents an offer or promotion to a customer
     * 
     */
    @JsonProperty("offerCd")
    public String getOfferCd() {
        return offerCd;
    }

    /**
     * the code that represents an offer or promotion to a customer
     * 
     */
    @JsonProperty("offerCd")
    public void setOfferCd(String offerCd) {
        this.offerCd = offerCd;
    }

    /**
     * the code that represents an offer type.
     * 
     */
    @JsonProperty("offerTypeCd")
    public String getOfferTypeCd() {
        return offerTypeCd;
    }

    /**
     * the code that represents an offer type.
     * 
     */
    @JsonProperty("offerTypeCd")
    public void setOfferTypeCd(String offerTypeCd) {
        this.offerTypeCd = offerTypeCd;
    }

    /**
     * The presentMentId is specific to UI Presentment when it displayed to customer
     * 
     */
    @JsonProperty("presentmentId")
    public String getPresentmentId() {
        return presentmentId;
    }

    /**
     * The presentMentId is specific to UI Presentment when it displayed to customer
     * 
     */
    @JsonProperty("presentmentId")
    public void setPresentmentId(String presentmentId) {
        this.presentmentId = presentmentId;
    }

    /**
     * The flag stats whether offer is accepted or rejected by customer.
     * 
     */
    @JsonProperty("offerAcceptedInd")
    public Boolean getOfferAcceptedInd() {
        return offerAcceptedInd;
    }

    /**
     * The flag stats whether offer is accepted or rejected by customer.
     * 
     */
    @JsonProperty("offerAcceptedInd")
    public void setOfferAcceptedInd(Boolean offerAcceptedInd) {
        this.offerAcceptedInd = offerAcceptedInd;
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
        return new ToStringBuilder(this).append("externalProductId", externalProductId).append("productId", productId).append("productVersion", productVersion).append("metaData", metaData).append("subApplicationId", subApplicationId).append("isOffer", isOffer).append("offerCd", offerCd).append("offerTypeCd", offerTypeCd).append("presentmentId", presentmentId).append("offerAcceptedInd", offerAcceptedInd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(metaData).append(productVersion).append(offerCd).append(productId).append(offerTypeCd).append(isOffer).append(subApplicationId).append(presentmentId).append(offerAcceptedInd).append(additionalProperties).append(externalProductId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Product) == false) {
            return false;
        }
        Product rhs = ((Product) other);
        return new EqualsBuilder().append(metaData, rhs.metaData).append(productVersion, rhs.productVersion).append(offerCd, rhs.offerCd).append(productId, rhs.productId).append(offerTypeCd, rhs.offerTypeCd).append(isOffer, rhs.isOffer).append(subApplicationId, rhs.subApplicationId).append(presentmentId, rhs.presentmentId).append(offerAcceptedInd, rhs.offerAcceptedInd).append(additionalProperties, rhs.additionalProperties).append(externalProductId, rhs.externalProductId).isEquals();
    }

}
