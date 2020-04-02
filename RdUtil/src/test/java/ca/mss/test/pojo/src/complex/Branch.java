
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
    "address",
    "phone",
    "id",
    "bankNum",
    "role",
    "name",
    "serviceType"
})
public class Branch implements Serializable, Cloneable
{

    @JsonProperty("address")
    private Address address;
    /**
     * Phone/contact Number information is stored in this object.
     * 
     */
    @JsonProperty("phone")
    @JsonPropertyDescription("Phone/contact Number information is stored in this object.")
    private Phone phone;
    @JsonProperty("id")
    private String id;
    @JsonProperty("bankNum")
    private String bankNum;
    /**
     * Branch Role.
     * 
     */
    @JsonProperty("role")
    @JsonPropertyDescription("Branch Role.")
    private String role;
    /**
     * Branch Name.
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Branch Name.")
    private String name;
    /**
     * Branch Service Type.
     * 
     */
    @JsonProperty("serviceType")
    @JsonPropertyDescription("Branch Service Type.")
    private String serviceType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -189859199349479940L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Branch() {
    }

    /**
     * 
     * @param serviceType
     * @param bankNum
     * @param address
     * @param role
     * @param phone
     * @param name
     * @param id
     */
    public Branch(Address address, Phone phone, String id, String bankNum, String role, String name, String serviceType) {
        super();
        this.address = address;
        this.phone = phone;
        this.id = id;
        this.bankNum = bankNum;
        this.role = role;
        this.name = name;
        this.serviceType = serviceType;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Phone/contact Number information is stored in this object.
     * 
     */
    @JsonProperty("phone")
    public Phone getPhone() {
        return phone;
    }

    /**
     * Phone/contact Number information is stored in this object.
     * 
     */
    @JsonProperty("phone")
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("bankNum")
    public String getBankNum() {
        return bankNum;
    }

    @JsonProperty("bankNum")
    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    /**
     * Branch Role.
     * 
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * Branch Role.
     * 
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Branch Name.
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Branch Name.
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Branch Service Type.
     * 
     */
    @JsonProperty("serviceType")
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Branch Service Type.
     * 
     */
    @JsonProperty("serviceType")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
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
        return new ToStringBuilder(this).append("address", address).append("phone", phone).append("id", id).append("bankNum", bankNum).append("role", role).append("name", name).append("serviceType", serviceType).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serviceType).append(bankNum).append(address).append(role).append(phone).append(name).append(id).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Branch) == false) {
            return false;
        }
        Branch rhs = ((Branch) other);
        return new EqualsBuilder().append(serviceType, rhs.serviceType).append(bankNum, rhs.bankNum).append(address, rhs.address).append(role, rhs.role).append(phone, rhs.phone).append(name, rhs.name).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
