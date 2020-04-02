
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


/**
 * This contains the alerts list which needs to be added / lodged on customer profile.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "logAlertFlag",
    "profileAlertList"
})
public class Alerts implements Serializable, Cloneable
{

    @JsonProperty("logAlertFlag")
    private Boolean logAlertFlag;
    @JsonProperty("profileAlertList")
    private List<String> profileAlertList = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6386931512192218184L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Alerts() {
    }

    /**
     * 
     * @param profileAlertList
     * @param logAlertFlag
     */
    public Alerts(Boolean logAlertFlag, List<String> profileAlertList) {
        super();
        this.logAlertFlag = logAlertFlag;
        this.profileAlertList = profileAlertList;
    }

    @JsonProperty("logAlertFlag")
    public Boolean getLogAlertFlag() {
        return logAlertFlag;
    }

    @JsonProperty("logAlertFlag")
    public void setLogAlertFlag(Boolean logAlertFlag) {
        this.logAlertFlag = logAlertFlag;
    }

    @JsonProperty("profileAlertList")
    public List<String> getProfileAlertList() {
        return profileAlertList;
    }

    @JsonProperty("profileAlertList")
    public void setProfileAlertList(List<String> profileAlertList) {
        this.profileAlertList = profileAlertList;
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
        return new ToStringBuilder(this).append("logAlertFlag", logAlertFlag).append("profileAlertList", profileAlertList).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(profileAlertList).append(additionalProperties).append(logAlertFlag).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Alerts) == false) {
            return false;
        }
        Alerts rhs = ((Alerts) other);
        return new EqualsBuilder().append(profileAlertList, rhs.profileAlertList).append(additionalProperties, rhs.additionalProperties).append(logAlertFlag, rhs.logAlertFlag).isEquals();
    }

}
