
package ca.mss.test.pojo.src.simple;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    "partyID",
    "productType",
    "businessUnit",
    "role",
    "correlationID",
    "idReascertainment"
})
public class Data {

    /**
     * Party ID.
     * (Required)
     * 
     */
    @JsonProperty("partyID")
    @JsonPropertyDescription("Party ID.")
    @NotNull
    private String partyID;
    /**
     * Product type.
     * (Required)
     * 
     */
    @JsonProperty("productType")
    @JsonPropertyDescription("Product type.")
    @NotNull
    private String productType;
    /**
     * Business unit.
     * (Required)
     * 
     */
    @JsonProperty("businessUnit")
    @JsonPropertyDescription("Business unit.")
    @NotNull
    private String businessUnit;
    /**
     * Role.
     * (Required)
     * 
     */
    @JsonProperty("role")
    @JsonPropertyDescription("Role.")
    @NotNull
    private String role;
    /**
     * Correlation ID.
     * (Required)
     * 
     */
    @JsonProperty("correlationID")
    @JsonPropertyDescription("Correlation ID.")
    @NotNull
    private String correlationID;
    /**
     * The flag for additional ID check.
     * 
     */
    @JsonProperty("idReascertainment")
    @JsonPropertyDescription("The flag for additional ID check.")
    private Boolean idReascertainment = false;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Party ID.
     * (Required)
     * 
     */
    @JsonProperty("partyID")
    public String getPartyID() {
        return partyID;
    }

    /**
     * Party ID.
     * (Required)
     * 
     */
    @JsonProperty("partyID")
    public void setPartyID(String partyID) {
        this.partyID = partyID;
    }

    /**
     * Product type.
     * (Required)
     * 
     */
    @JsonProperty("productType")
    public String getProductType() {
        return productType;
    }

    /**
     * Product type.
     * (Required)
     * 
     */
    @JsonProperty("productType")
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * Business unit.
     * (Required)
     * 
     */
    @JsonProperty("businessUnit")
    public String getBusinessUnit() {
        return businessUnit;
    }

    /**
     * Business unit.
     * (Required)
     * 
     */
    @JsonProperty("businessUnit")
    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    /**
     * Role.
     * (Required)
     * 
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * Role.
     * (Required)
     * 
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Correlation ID.
     * (Required)
     * 
     */
    @JsonProperty("correlationID")
    public String getCorrelationID() {
        return correlationID;
    }

    /**
     * Correlation ID.
     * (Required)
     * 
     */
    @JsonProperty("correlationID")
    public void setCorrelationID(String correlationID) {
        this.correlationID = correlationID;
    }

    /**
     * The flag for additional ID check.
     * 
     */
    @JsonProperty("idReascertainment")
    public Boolean getIdReascertainment() {
        return idReascertainment;
    }

    /**
     * The flag for additional ID check.
     * 
     */
    @JsonProperty("idReascertainment")
    public void setIdReascertainment(Boolean idReascertainment) {
        this.idReascertainment = idReascertainment;
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
        return new ToStringBuilder(this).append("partyID", partyID).append("productType", productType).append("businessUnit", businessUnit).append("role", role).append("correlationID", correlationID).append("idReascertainment", idReascertainment).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(businessUnit).append(role).append(idReascertainment).append(correlationID).append(additionalProperties).append(partyID).append(productType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data) == false) {
            return false;
        }
        Data rhs = ((Data) other);
        return new EqualsBuilder().append(businessUnit, rhs.businessUnit).append(role, rhs.role).append(idReascertainment, rhs.idReascertainment).append(correlationID, rhs.correlationID).append(additionalProperties, rhs.additionalProperties).append(partyID, rhs.partyID).append(productType, rhs.productType).isEquals();
    }

}
