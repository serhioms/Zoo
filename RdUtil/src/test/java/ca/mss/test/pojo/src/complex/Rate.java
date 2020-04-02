
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
    "type",
    "description",
    "rate",
    "discountType",
    "discount",
    "spread",
    "period",
    "status",
    "paymentDetails"
})
public class Rate implements Serializable, Cloneable
{

    /**
     * prime/variance/variable/fixed/cobAnnual
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("prime/variance/variable/fixed/cobAnnual")
    private String type;
    @JsonProperty("description")
    private String description;
    @JsonProperty("rate")
    private Double rate;
    @JsonProperty("discountType")
    private String discountType;
    @JsonProperty("discount")
    private Double discount;
    @JsonProperty("spread")
    private Double spread;
    /**
     * M(Monthly)/SM(SemiMonthly)/WK(Weekly)/BW(Biweekly)/BR(Biweekly Rapid)/WR(Weekly Rapid)
     * 
     */
    @JsonProperty("period")
    @JsonPropertyDescription("M(Monthly)/SM(SemiMonthly)/WK(Weekly)/BW(Biweekly)/BR(Biweekly Rapid)/WR(Weekly Rapid)")
    private String period;
    /**
     * presubmit/approved/preApproved/accepted/rejected/selected/requested
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("presubmit/approved/preApproved/accepted/rejected/selected/requested")
    private String status;
    @JsonProperty("paymentDetails")
    private PaymentDetails paymentDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 2113144549238444315L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rate() {
    }

    /**
     * 
     * @param period
     * @param rate
     * @param description
     * @param discount
     * @param discountType
     * @param type
     * @param paymentDetails
     * @param spread
     * @param status
     */
    public Rate(String type, String description, Double rate, String discountType, Double discount, Double spread, String period, String status, PaymentDetails paymentDetails) {
        super();
        this.type = type;
        this.description = description;
        this.rate = rate;
        this.discountType = discountType;
        this.discount = discount;
        this.spread = spread;
        this.period = period;
        this.status = status;
        this.paymentDetails = paymentDetails;
    }

    /**
     * prime/variance/variable/fixed/cobAnnual
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * prime/variance/variable/fixed/cobAnnual
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("rate")
    public Double getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(Double rate) {
        this.rate = rate;
    }

    @JsonProperty("discountType")
    public String getDiscountType() {
        return discountType;
    }

    @JsonProperty("discountType")
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    @JsonProperty("discount")
    public Double getDiscount() {
        return discount;
    }

    @JsonProperty("discount")
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @JsonProperty("spread")
    public Double getSpread() {
        return spread;
    }

    @JsonProperty("spread")
    public void setSpread(Double spread) {
        this.spread = spread;
    }

    /**
     * M(Monthly)/SM(SemiMonthly)/WK(Weekly)/BW(Biweekly)/BR(Biweekly Rapid)/WR(Weekly Rapid)
     * 
     */
    @JsonProperty("period")
    public String getPeriod() {
        return period;
    }

    /**
     * M(Monthly)/SM(SemiMonthly)/WK(Weekly)/BW(Biweekly)/BR(Biweekly Rapid)/WR(Weekly Rapid)
     * 
     */
    @JsonProperty("period")
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * presubmit/approved/preApproved/accepted/rejected/selected/requested
     * 
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * presubmit/approved/preApproved/accepted/rejected/selected/requested
     * 
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("paymentDetails")
    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    @JsonProperty("paymentDetails")
    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
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
        return new ToStringBuilder(this).append("type", type).append("description", description).append("rate", rate).append("discountType", discountType).append("discount", discount).append("spread", spread).append("period", period).append("status", status).append("paymentDetails", paymentDetails).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(period).append(rate).append(description).append(discount).append(discountType).append(additionalProperties).append(type).append(paymentDetails).append(spread).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rate) == false) {
            return false;
        }
        Rate rhs = ((Rate) other);
        return new EqualsBuilder().append(period, rhs.period).append(rate, rhs.rate).append(description, rhs.description).append(discount, rhs.discount).append(discountType, rhs.discountType).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(paymentDetails, rhs.paymentDetails).append(spread, rhs.spread).append(status, rhs.status).isEquals();
    }

}
