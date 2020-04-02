
package ca.mss.test.pojo.src.complex;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
    "documentClassCd",
    "metadataItem"
})
public class FileNetMetaData implements Serializable, Cloneable
{

    @JsonProperty("documentClassCd")
    private String documentClassCd;
    @JsonProperty("metadataItem")
    private List<MetadataItem> metadataItem = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -478780306677253956L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FileNetMetaData() {
    }

    /**
     * 
     * @param documentClassCd
     * @param metadataItem
     */
    public FileNetMetaData(String documentClassCd, List<MetadataItem> metadataItem) {
        super();
        this.documentClassCd = documentClassCd;
        this.metadataItem = metadataItem;
    }

    @JsonProperty("documentClassCd")
    public String getDocumentClassCd() {
        return documentClassCd;
    }

    @JsonProperty("documentClassCd")
    public void setDocumentClassCd(String documentClassCd) {
        this.documentClassCd = documentClassCd;
    }

    @JsonProperty("metadataItem")
    public List<MetadataItem> getMetadataItem() {
        return metadataItem;
    }

    @JsonProperty("metadataItem")
    public void setMetadataItem(List<MetadataItem> metadataItem) {
        this.metadataItem = metadataItem;
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
        return new ToStringBuilder(this).append("documentClassCd", documentClassCd).append("metadataItem", metadataItem).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(documentClassCd).append(metadataItem).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FileNetMetaData) == false) {
            return false;
        }
        FileNetMetaData rhs = ((FileNetMetaData) other);
        return new EqualsBuilder().append(documentClassCd, rhs.documentClassCd).append(metadataItem, rhs.metadataItem).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
