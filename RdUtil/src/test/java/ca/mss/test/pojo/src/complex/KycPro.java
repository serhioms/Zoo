
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
    "whoIsPRO",
    "isPROAtTD",
    "firstName",
    "middleName",
    "lastName",
    "relationship"
})
public class KycPro implements Serializable, Cloneable
{

    @JsonProperty("whoIsPRO")
    private String whoIsPRO;
    @JsonProperty("isPROAtTD")
    private Boolean isPROAtTD;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("relationship")
    private String relationship;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7096060976436015532L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public KycPro() {
    }

    /**
     * 
     * @param firstName
     * @param lastName
     * @param isPROAtTD
     * @param middleName
     * @param relationship
     * @param whoIsPRO
     */
    public KycPro(String whoIsPRO, Boolean isPROAtTD, String firstName, String middleName, String lastName, String relationship) {
        super();
        this.whoIsPRO = whoIsPRO;
        this.isPROAtTD = isPROAtTD;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.relationship = relationship;
    }

    @JsonProperty("whoIsPRO")
    public String getWhoIsPRO() {
        return whoIsPRO;
    }

    @JsonProperty("whoIsPRO")
    public void setWhoIsPRO(String whoIsPRO) {
        this.whoIsPRO = whoIsPRO;
    }

    @JsonProperty("isPROAtTD")
    public Boolean getIsPROAtTD() {
        return isPROAtTD;
    }

    @JsonProperty("isPROAtTD")
    public void setIsPROAtTD(Boolean isPROAtTD) {
        this.isPROAtTD = isPROAtTD;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("middleName")
    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("middleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("relationship")
    public String getRelationship() {
        return relationship;
    }

    @JsonProperty("relationship")
    public void setRelationship(String relationship) {
        this.relationship = relationship;
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
        return new ToStringBuilder(this).append("whoIsPRO", whoIsPRO).append("isPROAtTD", isPROAtTD).append("firstName", firstName).append("middleName", middleName).append("lastName", lastName).append("relationship", relationship).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(firstName).append(lastName).append(isPROAtTD).append(middleName).append(additionalProperties).append(relationship).append(whoIsPRO).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof KycPro) == false) {
            return false;
        }
        KycPro rhs = ((KycPro) other);
        return new EqualsBuilder().append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(isPROAtTD, rhs.isPROAtTD).append(middleName, rhs.middleName).append(additionalProperties, rhs.additionalProperties).append(relationship, rhs.relationship).append(whoIsPRO, rhs.whoIsPRO).isEquals();
    }

}
