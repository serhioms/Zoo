
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
    "keyName",
    "value",
    "typeCd"
})
public class MetadataItem implements Serializable, Cloneable
{

    @JsonProperty("keyName")
    private String keyName;
    @JsonProperty("value")
    private List<String> value = null;
    @JsonProperty("typeCd")
    private String typeCd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4030119637885781964L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MetadataItem() {
    }

    /**
     * 
     * @param typeCd
     * @param keyName
     * @param value
     */
    public MetadataItem(String keyName, List<String> value, String typeCd) {
        super();
        this.keyName = keyName;
        this.value = value;
        this.typeCd = typeCd;
    }

    @JsonProperty("keyName")
    public String getKeyName() {
        return keyName;
    }

    @JsonProperty("keyName")
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    @JsonProperty("value")
    public List<String> getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(List<String> value) {
        this.value = value;
    }

    @JsonProperty("typeCd")
    public String getTypeCd() {
        return typeCd;
    }

    @JsonProperty("typeCd")
    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
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
        return new ToStringBuilder(this).append("keyName", keyName).append("value", value).append("typeCd", typeCd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(keyName).append(additionalProperties).append(typeCd).append(value).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MetadataItem) == false) {
            return false;
        }
        MetadataItem rhs = ((MetadataItem) other);
        return new EqualsBuilder().append(keyName, rhs.keyName).append(additionalProperties, rhs.additionalProperties).append(typeCd, rhs.typeCd).append(value, rhs.value).isEquals();
    }

}
