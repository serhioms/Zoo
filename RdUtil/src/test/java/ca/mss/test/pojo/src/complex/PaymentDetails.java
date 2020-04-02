
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
    "timePeriodCount",
    "timePeriodCd",
    "optionAmt",
    "firstPaymentDt",
    "lastPaymentDt",
    "plannedAgreementOpenDt",
    "paymentCount",
    "totalPaymentAmt ",
    "lastPaymentAmt",
    "remainingBalanceAmt",
    "amortizationPeriodMonthCnt"
})
public class PaymentDetails implements Serializable, Cloneable
{

    /**
     * The number of period, or term, to pay back the loan amount
     * 
     */
    @JsonProperty("timePeriodCount")
    @JsonPropertyDescription("The number of period, or term, to pay back the loan amount")
    private Double timePeriodCount;
    /**
     * Period definition M(Monthly)/SM(SemiMonthly)/WK(Weekly)/BW(Biweekly)/BR(Biweekly Rapid)/WR(Weekly Rapid)
     * 
     */
    @JsonProperty("timePeriodCd")
    @JsonPropertyDescription("Period definition M(Monthly)/SM(SemiMonthly)/WK(Weekly)/BW(Biweekly)/BR(Biweekly Rapid)/WR(Weekly Rapid)")
    private String timePeriodCd;
    @JsonProperty("optionAmt")
    private OptionAmt optionAmt;
    @JsonProperty("firstPaymentDt")
    private Long firstPaymentDt;
    @JsonProperty("lastPaymentDt")
    private Long lastPaymentDt;
    /**
     * for borrowing, it is deposit date
     * 
     */
    @JsonProperty("plannedAgreementOpenDt")
    @JsonPropertyDescription("for borrowing, it is deposit date")
    private Long plannedAgreementOpenDt;
    /**
     * Number of payments during the period (term)
     * 
     */
    @JsonProperty("paymentCount")
    @JsonPropertyDescription("Number of payments during the period (term)")
    private Integer paymentCount;
    @JsonProperty("totalPaymentAmt ")
    private OptionAmt totalPaymentAmt;
    @JsonProperty("lastPaymentAmt")
    private OptionAmt lastPaymentAmt;
    @JsonProperty("remainingBalanceAmt")
    private OptionAmt remainingBalanceAmt;
    /**
     * Number of amortization period
     * 
     */
    @JsonProperty("amortizationPeriodMonthCnt")
    @JsonPropertyDescription("Number of amortization period")
    private Integer amortizationPeriodMonthCnt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -9163068671725860519L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PaymentDetails() {
    }

    /**
     * 
     * @param lastPaymentAmt
     * @param totalPaymentAmt
     * @param firstPaymentDt
     * @param lastPaymentDt
     * @param remainingBalanceAmt
     * @param timePeriodCount
     * @param timePeriodCd
     * @param amortizationPeriodMonthCnt
     * @param optionAmt
     * @param plannedAgreementOpenDt
     * @param paymentCount
     */
    public PaymentDetails(Double timePeriodCount, String timePeriodCd, OptionAmt optionAmt, Long firstPaymentDt, Long lastPaymentDt, Long plannedAgreementOpenDt, Integer paymentCount, OptionAmt totalPaymentAmt, OptionAmt lastPaymentAmt, OptionAmt remainingBalanceAmt, Integer amortizationPeriodMonthCnt) {
        super();
        this.timePeriodCount = timePeriodCount;
        this.timePeriodCd = timePeriodCd;
        this.optionAmt = optionAmt;
        this.firstPaymentDt = firstPaymentDt;
        this.lastPaymentDt = lastPaymentDt;
        this.plannedAgreementOpenDt = plannedAgreementOpenDt;
        this.paymentCount = paymentCount;
        this.totalPaymentAmt = totalPaymentAmt;
        this.lastPaymentAmt = lastPaymentAmt;
        this.remainingBalanceAmt = remainingBalanceAmt;
        this.amortizationPeriodMonthCnt = amortizationPeriodMonthCnt;
    }

    /**
     * The number of period, or term, to pay back the loan amount
     * 
     */
    @JsonProperty("timePeriodCount")
    public Double getTimePeriodCount() {
        return timePeriodCount;
    }

    /**
     * The number of period, or term, to pay back the loan amount
     * 
     */
    @JsonProperty("timePeriodCount")
    public void setTimePeriodCount(Double timePeriodCount) {
        this.timePeriodCount = timePeriodCount;
    }

    /**
     * Period definition M(Monthly)/SM(SemiMonthly)/WK(Weekly)/BW(Biweekly)/BR(Biweekly Rapid)/WR(Weekly Rapid)
     * 
     */
    @JsonProperty("timePeriodCd")
    public String getTimePeriodCd() {
        return timePeriodCd;
    }

    /**
     * Period definition M(Monthly)/SM(SemiMonthly)/WK(Weekly)/BW(Biweekly)/BR(Biweekly Rapid)/WR(Weekly Rapid)
     * 
     */
    @JsonProperty("timePeriodCd")
    public void setTimePeriodCd(String timePeriodCd) {
        this.timePeriodCd = timePeriodCd;
    }

    @JsonProperty("optionAmt")
    public OptionAmt getOptionAmt() {
        return optionAmt;
    }

    @JsonProperty("optionAmt")
    public void setOptionAmt(OptionAmt optionAmt) {
        this.optionAmt = optionAmt;
    }

    @JsonProperty("firstPaymentDt")
    public Long getFirstPaymentDt() {
        return firstPaymentDt;
    }

    @JsonProperty("firstPaymentDt")
    public void setFirstPaymentDt(Long firstPaymentDt) {
        this.firstPaymentDt = firstPaymentDt;
    }

    @JsonProperty("lastPaymentDt")
    public Long getLastPaymentDt() {
        return lastPaymentDt;
    }

    @JsonProperty("lastPaymentDt")
    public void setLastPaymentDt(Long lastPaymentDt) {
        this.lastPaymentDt = lastPaymentDt;
    }

    /**
     * for borrowing, it is deposit date
     * 
     */
    @JsonProperty("plannedAgreementOpenDt")
    public Long getPlannedAgreementOpenDt() {
        return plannedAgreementOpenDt;
    }

    /**
     * for borrowing, it is deposit date
     * 
     */
    @JsonProperty("plannedAgreementOpenDt")
    public void setPlannedAgreementOpenDt(Long plannedAgreementOpenDt) {
        this.plannedAgreementOpenDt = plannedAgreementOpenDt;
    }

    /**
     * Number of payments during the period (term)
     * 
     */
    @JsonProperty("paymentCount")
    public Integer getPaymentCount() {
        return paymentCount;
    }

    /**
     * Number of payments during the period (term)
     * 
     */
    @JsonProperty("paymentCount")
    public void setPaymentCount(Integer paymentCount) {
        this.paymentCount = paymentCount;
    }

    @JsonProperty("totalPaymentAmt ")
    public OptionAmt getTotalPaymentAmt() {
        return totalPaymentAmt;
    }

    @JsonProperty("totalPaymentAmt ")
    public void setTotalPaymentAmt(OptionAmt totalPaymentAmt) {
        this.totalPaymentAmt = totalPaymentAmt;
    }

    @JsonProperty("lastPaymentAmt")
    public OptionAmt getLastPaymentAmt() {
        return lastPaymentAmt;
    }

    @JsonProperty("lastPaymentAmt")
    public void setLastPaymentAmt(OptionAmt lastPaymentAmt) {
        this.lastPaymentAmt = lastPaymentAmt;
    }

    @JsonProperty("remainingBalanceAmt")
    public OptionAmt getRemainingBalanceAmt() {
        return remainingBalanceAmt;
    }

    @JsonProperty("remainingBalanceAmt")
    public void setRemainingBalanceAmt(OptionAmt remainingBalanceAmt) {
        this.remainingBalanceAmt = remainingBalanceAmt;
    }

    /**
     * Number of amortization period
     * 
     */
    @JsonProperty("amortizationPeriodMonthCnt")
    public Integer getAmortizationPeriodMonthCnt() {
        return amortizationPeriodMonthCnt;
    }

    /**
     * Number of amortization period
     * 
     */
    @JsonProperty("amortizationPeriodMonthCnt")
    public void setAmortizationPeriodMonthCnt(Integer amortizationPeriodMonthCnt) {
        this.amortizationPeriodMonthCnt = amortizationPeriodMonthCnt;
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
        return new ToStringBuilder(this).append("timePeriodCount", timePeriodCount).append("timePeriodCd", timePeriodCd).append("optionAmt", optionAmt).append("firstPaymentDt", firstPaymentDt).append("lastPaymentDt", lastPaymentDt).append("plannedAgreementOpenDt", plannedAgreementOpenDt).append("paymentCount", paymentCount).append("totalPaymentAmt", totalPaymentAmt).append("lastPaymentAmt", lastPaymentAmt).append("remainingBalanceAmt", remainingBalanceAmt).append("amortizationPeriodMonthCnt", amortizationPeriodMonthCnt).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lastPaymentAmt).append(firstPaymentDt).append(lastPaymentDt).append(timePeriodCount).append(timePeriodCd).append(optionAmt).append(totalPaymentAmt).append(remainingBalanceAmt).append(amortizationPeriodMonthCnt).append(additionalProperties).append(plannedAgreementOpenDt).append(paymentCount).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentDetails) == false) {
            return false;
        }
        PaymentDetails rhs = ((PaymentDetails) other);
        return new EqualsBuilder().append(lastPaymentAmt, rhs.lastPaymentAmt).append(firstPaymentDt, rhs.firstPaymentDt).append(lastPaymentDt, rhs.lastPaymentDt).append(timePeriodCount, rhs.timePeriodCount).append(timePeriodCd, rhs.timePeriodCd).append(optionAmt, rhs.optionAmt).append(totalPaymentAmt, rhs.totalPaymentAmt).append(remainingBalanceAmt, rhs.remainingBalanceAmt).append(amortizationPeriodMonthCnt, rhs.amortizationPeriodMonthCnt).append(additionalProperties, rhs.additionalProperties).append(plannedAgreementOpenDt, rhs.plannedAgreementOpenDt).append(paymentCount, rhs.paymentCount).isEquals();
    }

}
