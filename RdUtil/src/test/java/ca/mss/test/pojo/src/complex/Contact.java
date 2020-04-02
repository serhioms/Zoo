
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
    "phoneList",
    "address"
})
public class Contact implements Serializable, Cloneable
{

    @JsonProperty("phoneList")
    private List<PhoneList> phoneList = null;
    @JsonProperty("address")
    private List<Address> address = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3821472347871834085L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Contact() {
    }

    /**
     * 
     * @param address
     * @param phoneList
     */
    public Contact(List<PhoneList> phoneList, List<Address> address) {
        super();
        this.phoneList = phoneList;
        this.address = address;
    }

    @JsonProperty("phoneList")
    public List<PhoneList> getPhoneList() {
        return phoneList;
    }

    @JsonProperty("phoneList")
    public void setPhoneList(List<PhoneList> phoneList) {
        this.phoneList = phoneList;
    }

    @JsonProperty("address")
    public List<Address> getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(List<Address> address) {
        this.address = address;
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
        return new ToStringBuilder(this).append("phoneList", phoneList).append("address", address).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(phoneList).append(address).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Contact) == false) {
            return false;
        }
        Contact rhs = ((Contact) other);
        return new EqualsBuilder().append(phoneList, rhs.phoneList).append(address, rhs.address).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
