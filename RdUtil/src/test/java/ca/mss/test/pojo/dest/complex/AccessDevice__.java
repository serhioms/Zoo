
package ca.mss.test.pojo.dest.complex;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * A means by which a customer has access to one or more accounts. Examples of types include credit card plastic, key chain card, cell phone, and personal computer. A device may access more than one account such as both credit card and banking accounts. The device is used to access a channel hence it is not the same thing as a channel. For example, a card (device) accesses an ATM (channel) to get information about an account. Each instance represents one physical access device..
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessDeviceId",
    "typeCd"
})
public class AccessDevice__ {

    /**
     * Access Device Identifier.
     * A unique identifier for the ACCESS DEVICE.
     * There is one instance for each physical device.
     * 
     */
    @JsonProperty("accessDeviceId")
    @JsonPropertyDescription("Access Device Identifier.\r\nA unique identifier for the ACCESS DEVICE.\r\nThere is one instance for each physical device.")
    private String accessDeviceId;
    /**
     * Specifies the type of access device.
     * 
     */
    @JsonProperty("typeCd")
    @JsonPropertyDescription("Specifies the type of access device.")
    private String typeCd;

    /**
     * Access Device Identifier.
     * A unique identifier for the ACCESS DEVICE.
     * There is one instance for each physical device.
     * 
     */
    @JsonProperty("accessDeviceId")
    public String getAccessDeviceId() {
        return accessDeviceId;
    }

    /**
     * Access Device Identifier.
     * A unique identifier for the ACCESS DEVICE.
     * There is one instance for each physical device.
     * 
     */
    @JsonProperty("accessDeviceId")
    public void setAccessDeviceId(String accessDeviceId) {
        this.accessDeviceId = accessDeviceId;
    }

    /**
     * Specifies the type of access device.
     * 
     */
    @JsonProperty("typeCd")
    public String getTypeCd() {
        return typeCd;
    }

    /**
     * Specifies the type of access device.
     * 
     */
    @JsonProperty("typeCd")
    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("accessDeviceId", accessDeviceId).append("typeCd", typeCd).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accessDeviceId).append(typeCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AccessDevice__) == false) {
            return false;
        }
        AccessDevice__ rhs = ((AccessDevice__) other);
        return new EqualsBuilder().append(accessDeviceId, rhs.accessDeviceId).append(typeCd, rhs.typeCd).isEquals();
    }

}
