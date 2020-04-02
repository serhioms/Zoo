
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


/**
 * Version 1, Date; 20181022. Request Schema for Assess Party Compliance Request
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "metaData"
})
public class SimpleSource {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("data")
    @Valid
    @NotNull
    private Data data;
    /**
     * Version 1, Date; 20181025. EA Metadata to be included in the Request Schemas and Appsnapshot Schema
     * 
     */
    @JsonProperty("metaData")
    @JsonPropertyDescription("Version 1, Date; 20181025. EA Metadata to be included in the Request Schemas and Appsnapshot Schema")
    @Valid
    private MetaData metaData;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * Version 1, Date; 20181025. EA Metadata to be included in the Request Schemas and Appsnapshot Schema
     * 
     */
    @JsonProperty("metaData")
    public MetaData getMetaData() {
        return metaData;
    }

    /**
     * Version 1, Date; 20181025. EA Metadata to be included in the Request Schemas and Appsnapshot Schema
     * 
     */
    @JsonProperty("metaData")
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
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
        return new ToStringBuilder(this).append("data", data).append("metaData", metaData).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(metaData).append(additionalProperties).append(data).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SimpleSource) == false) {
            return false;
        }
        SimpleSource rhs = ((SimpleSource) other);
        return new EqualsBuilder().append(metaData, rhs.metaData).append(additionalProperties, rhs.additionalProperties).append(data, rhs.data).isEquals();
    }

}
