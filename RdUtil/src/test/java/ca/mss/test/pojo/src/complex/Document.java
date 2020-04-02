
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
    "documentId",
    "fileNetMetaData",
    "documentDate"
})
public class Document implements Serializable, Cloneable
{

    @JsonProperty("documentId")
    private String documentId;
    @JsonProperty("fileNetMetaData")
    private FileNetMetaData fileNetMetaData;
    @JsonProperty("documentDate")
    private Double documentDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 648195078919486002L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Document() {
    }

    /**
     * 
     * @param documentDate
     * @param fileNetMetaData
     * @param documentId
     */
    public Document(String documentId, FileNetMetaData fileNetMetaData, Double documentDate) {
        super();
        this.documentId = documentId;
        this.fileNetMetaData = fileNetMetaData;
        this.documentDate = documentDate;
    }

    @JsonProperty("documentId")
    public String getDocumentId() {
        return documentId;
    }

    @JsonProperty("documentId")
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    @JsonProperty("fileNetMetaData")
    public FileNetMetaData getFileNetMetaData() {
        return fileNetMetaData;
    }

    @JsonProperty("fileNetMetaData")
    public void setFileNetMetaData(FileNetMetaData fileNetMetaData) {
        this.fileNetMetaData = fileNetMetaData;
    }

    @JsonProperty("documentDate")
    public Double getDocumentDate() {
        return documentDate;
    }

    @JsonProperty("documentDate")
    public void setDocumentDate(Double documentDate) {
        this.documentDate = documentDate;
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
        return new ToStringBuilder(this).append("documentId", documentId).append("fileNetMetaData", fileNetMetaData).append("documentDate", documentDate).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(documentDate).append(documentId).append(additionalProperties).append(fileNetMetaData).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Document) == false) {
            return false;
        }
        Document rhs = ((Document) other);
        return new EqualsBuilder().append(documentDate, rhs.documentDate).append(documentId, rhs.documentId).append(additionalProperties, rhs.additionalProperties).append(fileNetMetaData, rhs.fileNetMetaData).isEquals();
    }

}
