
package ca.mss.test.pojo.dest.complex;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Software application of initiating channel.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "applicationPlatformCd",
    "softwareName",
    "softwareVersionNum",
    "providerName"
})
public class SoftwareApplication {

    /**
     * Platform of the channel application initiated the transaction.
     * (Required)
     * 
     */
    @JsonProperty("applicationPlatformCd")
    @JsonPropertyDescription("Platform of the channel application initiated the transaction.")
    @NotNull
    private String applicationPlatformCd;
    /**
     * Software used by initiating channel.
     * 
     */
    @JsonProperty("softwareName")
    @JsonPropertyDescription("Software used by initiating channel.")
    private String softwareName;
    /**
     * Version of the software used by initiating channel.
     * 
     */
    @JsonProperty("softwareVersionNum")
    @JsonPropertyDescription("Version of the software used by initiating channel.")
    private String softwareVersionNum;
    /**
     * Vendor name of the software that supports the calling channel e.g. IBM-CC, CheckFree
     * 
     */
    @JsonProperty("providerName")
    @JsonPropertyDescription("Vendor name of the software that supports the calling channel e.g. IBM-CC, CheckFree")
    private String providerName;

    /**
     * Platform of the channel application initiated the transaction.
     * (Required)
     * 
     */
    @JsonProperty("applicationPlatformCd")
    public String getApplicationPlatformCd() {
        return applicationPlatformCd;
    }

    /**
     * Platform of the channel application initiated the transaction.
     * (Required)
     * 
     */
    @JsonProperty("applicationPlatformCd")
    public void setApplicationPlatformCd(String applicationPlatformCd) {
        this.applicationPlatformCd = applicationPlatformCd;
    }

    /**
     * Software used by initiating channel.
     * 
     */
    @JsonProperty("softwareName")
    public String getSoftwareName() {
        return softwareName;
    }

    /**
     * Software used by initiating channel.
     * 
     */
    @JsonProperty("softwareName")
    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    /**
     * Version of the software used by initiating channel.
     * 
     */
    @JsonProperty("softwareVersionNum")
    public String getSoftwareVersionNum() {
        return softwareVersionNum;
    }

    /**
     * Version of the software used by initiating channel.
     * 
     */
    @JsonProperty("softwareVersionNum")
    public void setSoftwareVersionNum(String softwareVersionNum) {
        this.softwareVersionNum = softwareVersionNum;
    }

    /**
     * Vendor name of the software that supports the calling channel e.g. IBM-CC, CheckFree
     * 
     */
    @JsonProperty("providerName")
    public String getProviderName() {
        return providerName;
    }

    /**
     * Vendor name of the software that supports the calling channel e.g. IBM-CC, CheckFree
     * 
     */
    @JsonProperty("providerName")
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("applicationPlatformCd", applicationPlatformCd).append("softwareName", softwareName).append("softwareVersionNum", softwareVersionNum).append("providerName", providerName).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(softwareName).append(applicationPlatformCd).append(softwareVersionNum).append(providerName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SoftwareApplication) == false) {
            return false;
        }
        SoftwareApplication rhs = ((SoftwareApplication) other);
        return new EqualsBuilder().append(softwareName, rhs.softwareName).append(applicationPlatformCd, rhs.applicationPlatformCd).append(softwareVersionNum, rhs.softwareVersionNum).append(providerName, rhs.providerName).isEquals();
    }

}
