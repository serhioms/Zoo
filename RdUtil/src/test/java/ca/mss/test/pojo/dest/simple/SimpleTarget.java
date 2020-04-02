
package ca.mss.test.pojo.dest.simple;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Version: v1.  Date: 04052018. Request Schema for Post EVENTS
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "event",
    "metaData"
})
public class SimpleTarget {

    /**
     * DA Event
     * (Required)
     * 
     */
    @JsonProperty("event")
    @JsonPropertyDescription("DA Event")
    @Valid
    @NotNull
    private Event event;
    /**
     * Version 1, Date; 20180425. EA Metadata to be included in the Request Schemas and Appsnapshot Schema
     * 
     */
    @JsonProperty("metaData")
    @JsonPropertyDescription("Version 1, Date; 20180425. EA Metadata to be included in the Request Schemas and Appsnapshot Schema")
    @Valid
    private MetaData metaData;

    /**
     * DA Event
     * (Required)
     * 
     */
    @JsonProperty("event")
    public Event getEvent() {
        return event;
    }

    /**
     * DA Event
     * (Required)
     * 
     */
    @JsonProperty("event")
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * Version 1, Date; 20180425. EA Metadata to be included in the Request Schemas and Appsnapshot Schema
     * 
     */
    @JsonProperty("metaData")
    public MetaData getMetaData() {
        return metaData;
    }

    /**
     * Version 1, Date; 20180425. EA Metadata to be included in the Request Schemas and Appsnapshot Schema
     * 
     */
    @JsonProperty("metaData")
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("event", event).append("metaData", metaData).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(event).append(metaData).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SimpleTarget) == false) {
            return false;
        }
        SimpleTarget rhs = ((SimpleTarget) other);
        return new EqualsBuilder().append(event, rhs.event).append(metaData, rhs.metaData).isEquals();
    }

}
