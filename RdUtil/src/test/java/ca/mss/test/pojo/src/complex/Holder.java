
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
    "name",
    "type",
    "relationShip"
})
public class Holder implements Serializable, Cloneable
{

    @JsonProperty("name")
    private String name;
    /**
     * This holds whether account holder is primary / joint account holder
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("This holds whether account holder is primary / joint account holder")
    private String type;
    @JsonProperty("relationShip")
    private String relationShip;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6507473062944046171L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Holder() {
    }

    /**
     * 
     * @param name
     * @param type
     * @param relationShip
     */
    public Holder(String name, String type, String relationShip) {
        super();
        this.name = name;
        this.type = type;
        this.relationShip = relationShip;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This holds whether account holder is primary / joint account holder
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * This holds whether account holder is primary / joint account holder
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("relationShip")
    public String getRelationShip() {
        return relationShip;
    }

    @JsonProperty("relationShip")
    public void setRelationShip(String relationShip) {
        this.relationShip = relationShip;
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
        return new ToStringBuilder(this).append("name", name).append("type", type).append("relationShip", relationShip).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(additionalProperties).append(type).append(relationShip).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Holder) == false) {
            return false;
        }
        Holder rhs = ((Holder) other);
        return new EqualsBuilder().append(name, rhs.name).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(relationShip, rhs.relationShip).isEquals();
    }

}
