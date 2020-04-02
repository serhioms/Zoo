
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
 * Version v1, Date; 20180529. BusinessRelationship Definition
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "titlePrefix",
    "title",
    "signingOfficerInd",
    "ownerInd",
    "directorInd",
    "ownershipPct"
})
public class BusinessRelationship implements Serializable
{

    /**
     * Title prefix
     * 
     */
    @JsonProperty("titlePrefix")
    @JsonPropertyDescription("Title prefix")
    private String titlePrefix;
    @JsonProperty("title")
    private String title;
    @JsonProperty("signingOfficerInd")
    private Boolean signingOfficerInd;
    @JsonProperty("ownerInd")
    private Boolean ownerInd;
    /**
     * This is to specifically indicate whether person is director or not.
     * 
     */
    @JsonProperty("directorInd")
    @JsonPropertyDescription("This is to specifically indicate whether person is director or not.")
    private Boolean directorInd;
    @JsonProperty("ownershipPct")
    private String ownershipPct;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2349488431942951716L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BusinessRelationship() {
    }

    /**
     * 
     * @param directorInd
     * @param signingOfficerInd
     * @param ownershipPct
     * @param titlePrefix
     * @param title
     * @param ownerInd
     */
    public BusinessRelationship(String titlePrefix, String title, Boolean signingOfficerInd, Boolean ownerInd, Boolean directorInd, String ownershipPct) {
        super();
        this.titlePrefix = titlePrefix;
        this.title = title;
        this.signingOfficerInd = signingOfficerInd;
        this.ownerInd = ownerInd;
        this.directorInd = directorInd;
        this.ownershipPct = ownershipPct;
    }

    /**
     * Title prefix
     * 
     */
    @JsonProperty("titlePrefix")
    public String getTitlePrefix() {
        return titlePrefix;
    }

    /**
     * Title prefix
     * 
     */
    @JsonProperty("titlePrefix")
    public void setTitlePrefix(String titlePrefix) {
        this.titlePrefix = titlePrefix;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("signingOfficerInd")
    public Boolean getSigningOfficerInd() {
        return signingOfficerInd;
    }

    @JsonProperty("signingOfficerInd")
    public void setSigningOfficerInd(Boolean signingOfficerInd) {
        this.signingOfficerInd = signingOfficerInd;
    }

    @JsonProperty("ownerInd")
    public Boolean getOwnerInd() {
        return ownerInd;
    }

    @JsonProperty("ownerInd")
    public void setOwnerInd(Boolean ownerInd) {
        this.ownerInd = ownerInd;
    }

    /**
     * This is to specifically indicate whether person is director or not.
     * 
     */
    @JsonProperty("directorInd")
    public Boolean getDirectorInd() {
        return directorInd;
    }

    /**
     * This is to specifically indicate whether person is director or not.
     * 
     */
    @JsonProperty("directorInd")
    public void setDirectorInd(Boolean directorInd) {
        this.directorInd = directorInd;
    }

    @JsonProperty("ownershipPct")
    public String getOwnershipPct() {
        return ownershipPct;
    }

    @JsonProperty("ownershipPct")
    public void setOwnershipPct(String ownershipPct) {
        this.ownershipPct = ownershipPct;
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
        return new ToStringBuilder(this).append("titlePrefix", titlePrefix).append("title", title).append("signingOfficerInd", signingOfficerInd).append("ownerInd", ownerInd).append("directorInd", directorInd).append("ownershipPct", ownershipPct).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(directorInd).append(signingOfficerInd).append(ownershipPct).append(titlePrefix).append(additionalProperties).append(title).append(ownerInd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BusinessRelationship) == false) {
            return false;
        }
        BusinessRelationship rhs = ((BusinessRelationship) other);
        return new EqualsBuilder().append(directorInd, rhs.directorInd).append(signingOfficerInd, rhs.signingOfficerInd).append(ownershipPct, rhs.ownershipPct).append(titlePrefix, rhs.titlePrefix).append(additionalProperties, rhs.additionalProperties).append(title, rhs.title).append(ownerInd, rhs.ownerInd).isEquals();
    }

}
