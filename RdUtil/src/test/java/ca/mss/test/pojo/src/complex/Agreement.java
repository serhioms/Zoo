
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
    "arrangementTypeCD",
    "contentType",
    "documentCreateDT",
    "documentLanguageCD",
    "documentTypeCD",
    "isAgreed",
    "isStored",
    "productTypeCD",
    "publishedDocumentDT",
    "agreementId"
})
public class Agreement implements Serializable, Cloneable
{

    @JsonProperty("arrangementTypeCD")
    private String arrangementTypeCD;
    @JsonProperty("contentType")
    private String contentType;
    @JsonProperty("documentCreateDT")
    private String documentCreateDT;
    @JsonProperty("documentLanguageCD")
    private String documentLanguageCD;
    @JsonProperty("documentTypeCD")
    private String documentTypeCD;
    @JsonProperty("isAgreed")
    private Boolean isAgreed;
    @JsonProperty("isStored")
    private Boolean isStored;
    @JsonProperty("productTypeCD")
    private String productTypeCD;
    @JsonProperty("publishedDocumentDT")
    private Long publishedDocumentDT;
    /**
     * This holds the agreement id returned from eConsent service after registering consent.
     * 
     */
    @JsonProperty("agreementId")
    @JsonPropertyDescription("This holds the agreement id returned from eConsent service after registering consent.")
    private String agreementId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7801771218997531742L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Agreement() {
    }

    /**
     * 
     * @param productTypeCD
     * @param isAgreed
     * @param documentLanguageCD
     * @param publishedDocumentDT
     * @param documentCreateDT
     * @param agreementId
     * @param arrangementTypeCD
     * @param isStored
     * @param contentType
     * @param documentTypeCD
     */
    public Agreement(String arrangementTypeCD, String contentType, String documentCreateDT, String documentLanguageCD, String documentTypeCD, Boolean isAgreed, Boolean isStored, String productTypeCD, Long publishedDocumentDT, String agreementId) {
        super();
        this.arrangementTypeCD = arrangementTypeCD;
        this.contentType = contentType;
        this.documentCreateDT = documentCreateDT;
        this.documentLanguageCD = documentLanguageCD;
        this.documentTypeCD = documentTypeCD;
        this.isAgreed = isAgreed;
        this.isStored = isStored;
        this.productTypeCD = productTypeCD;
        this.publishedDocumentDT = publishedDocumentDT;
        this.agreementId = agreementId;
    }

    @JsonProperty("arrangementTypeCD")
    public String getArrangementTypeCD() {
        return arrangementTypeCD;
    }

    @JsonProperty("arrangementTypeCD")
    public void setArrangementTypeCD(String arrangementTypeCD) {
        this.arrangementTypeCD = arrangementTypeCD;
    }

    @JsonProperty("contentType")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("contentType")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonProperty("documentCreateDT")
    public String getDocumentCreateDT() {
        return documentCreateDT;
    }

    @JsonProperty("documentCreateDT")
    public void setDocumentCreateDT(String documentCreateDT) {
        this.documentCreateDT = documentCreateDT;
    }

    @JsonProperty("documentLanguageCD")
    public String getDocumentLanguageCD() {
        return documentLanguageCD;
    }

    @JsonProperty("documentLanguageCD")
    public void setDocumentLanguageCD(String documentLanguageCD) {
        this.documentLanguageCD = documentLanguageCD;
    }

    @JsonProperty("documentTypeCD")
    public String getDocumentTypeCD() {
        return documentTypeCD;
    }

    @JsonProperty("documentTypeCD")
    public void setDocumentTypeCD(String documentTypeCD) {
        this.documentTypeCD = documentTypeCD;
    }

    @JsonProperty("isAgreed")
    public Boolean getIsAgreed() {
        return isAgreed;
    }

    @JsonProperty("isAgreed")
    public void setIsAgreed(Boolean isAgreed) {
        this.isAgreed = isAgreed;
    }

    @JsonProperty("isStored")
    public Boolean getIsStored() {
        return isStored;
    }

    @JsonProperty("isStored")
    public void setIsStored(Boolean isStored) {
        this.isStored = isStored;
    }

    @JsonProperty("productTypeCD")
    public String getProductTypeCD() {
        return productTypeCD;
    }

    @JsonProperty("productTypeCD")
    public void setProductTypeCD(String productTypeCD) {
        this.productTypeCD = productTypeCD;
    }

    @JsonProperty("publishedDocumentDT")
    public Long getPublishedDocumentDT() {
        return publishedDocumentDT;
    }

    @JsonProperty("publishedDocumentDT")
    public void setPublishedDocumentDT(Long publishedDocumentDT) {
        this.publishedDocumentDT = publishedDocumentDT;
    }

    /**
     * This holds the agreement id returned from eConsent service after registering consent.
     * 
     */
    @JsonProperty("agreementId")
    public String getAgreementId() {
        return agreementId;
    }

    /**
     * This holds the agreement id returned from eConsent service after registering consent.
     * 
     */
    @JsonProperty("agreementId")
    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
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
        return new ToStringBuilder(this).append("arrangementTypeCD", arrangementTypeCD).append("contentType", contentType).append("documentCreateDT", documentCreateDT).append("documentLanguageCD", documentLanguageCD).append("documentTypeCD", documentTypeCD).append("isAgreed", isAgreed).append("isStored", isStored).append("productTypeCD", productTypeCD).append("publishedDocumentDT", publishedDocumentDT).append("agreementId", agreementId).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(productTypeCD).append(isAgreed).append(documentLanguageCD).append(publishedDocumentDT).append(documentCreateDT).append(agreementId).append(arrangementTypeCD).append(additionalProperties).append(isStored).append(contentType).append(documentTypeCD).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Agreement) == false) {
            return false;
        }
        Agreement rhs = ((Agreement) other);
        return new EqualsBuilder().append(productTypeCD, rhs.productTypeCD).append(isAgreed, rhs.isAgreed).append(documentLanguageCD, rhs.documentLanguageCD).append(publishedDocumentDT, rhs.publishedDocumentDT).append(documentCreateDT, rhs.documentCreateDT).append(agreementId, rhs.agreementId).append(arrangementTypeCD, rhs.arrangementTypeCD).append(additionalProperties, rhs.additionalProperties).append(isStored, rhs.isStored).append(contentType, rhs.contentType).append(documentTypeCD, rhs.documentTypeCD).isEquals();
    }

}
