
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


/**
 * Version: v49, Last Update Date 20180831. staffCd is added under PersonaParty and statusCd is added under business party.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metaData",
    "data"
})
public class ComplexSource implements Serializable
{

    /**
     * SnapshotMetaData Version v3, Date; 20180530. Include metaDataDef in the definitions of the Appsnapshot Schema. Change from last version: Changed applicationid from integer to string
     * 
     */
    @JsonProperty("metaData")
    @JsonPropertyDescription("SnapshotMetaData Version v3, Date; 20180530. Include metaDataDef in the definitions of the Appsnapshot Schema. Change from last version: Changed applicationid from integer to string")
    private MetaData metaData;
    @JsonProperty("data")
    private Data data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1034737045340424041L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ComplexSource() {
    }

    /**
     * 
     * @param metaData
     * @param data
     */
    public ComplexSource(MetaData metaData, Data data) {
        super();
        this.metaData = metaData;
        this.data = data;
    }

    /**
     * SnapshotMetaData Version v3, Date; 20180530. Include metaDataDef in the definitions of the Appsnapshot Schema. Change from last version: Changed applicationid from integer to string
     * 
     */
    @JsonProperty("metaData")
    public MetaData getMetaData() {
        return metaData;
    }

    /**
     * SnapshotMetaData Version v3, Date; 20180530. Include metaDataDef in the definitions of the Appsnapshot Schema. Change from last version: Changed applicationid from integer to string
     * 
     */
    @JsonProperty("metaData")
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
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
        return new ToStringBuilder(this).append("metaData", metaData).append("data", data).append("additionalProperties", additionalProperties).toString();
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
        if ((other instanceof ComplexSource) == false) {
            return false;
        }
        ComplexSource rhs = ((ComplexSource) other);
        return new EqualsBuilder().append(metaData, rhs.metaData).append(additionalProperties, rhs.additionalProperties).append(data, rhs.data).isEquals();
    }

}
