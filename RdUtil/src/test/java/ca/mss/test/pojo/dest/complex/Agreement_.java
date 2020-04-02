
package ca.mss.test.pojo.dest.complex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Arrangement between two or more parties where there are terms and conditions.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "altkey",
    "financialInstitutionTypeCd",
    "openDttm",
    "statusCd",
    "statusReasonCd",
    "sourceCd",
    "agreementToFeature"
})
public class Agreement_ {

    /**
     * Agreement Alternative Key.
     * 
     */
    @JsonProperty("altkey")
    @JsonPropertyDescription("Agreement Alternative Key.")
    @Valid
    private Altkey_ altkey;
    /**
     * Financial intitution where the agreement is opened.
     * A code that identifies the type of the financial institution such as savings and loan, bank, credit union, and mortgage banker.
     * 
     */
    @JsonProperty("financialInstitutionTypeCd")
    @JsonPropertyDescription("Financial intitution where the agreement is opened.\r\nA code that identifies the type of the financial institution such as savings and loan, bank, credit union, and mortgage banker.")
    private String financialInstitutionTypeCd;
    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * 
     */
    @JsonProperty("openDttm")
    @JsonPropertyDescription("dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related \"timelines\", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the \u00b7value space\u00b7 of decimal, with integers given units of seconds.")
    private Date openDttm;
    /**
     * Agreement status.
     * 
     */
    @JsonProperty("statusCd")
    @JsonPropertyDescription("Agreement status.")
    private String statusCd;
    /**
     * Reason for the Agreement status.
     * 
     */
    @JsonProperty("statusReasonCd")
    @JsonPropertyDescription("Reason for the Agreement status.")
    private String statusReasonCd;
    /**
     * A code for the source of information for the agreement e.g. source system code.
     * 
     */
    @JsonProperty("sourceCd")
    @JsonPropertyDescription("A code for the source of information for the agreement e.g. source system code.")
    private String sourceCd;
    /**
     * Associates the agreement with features that are specific to the agreement.
     * 
     */
    @JsonProperty("agreementToFeature")
    @JsonPropertyDescription("Associates the agreement with features that are specific to the agreement.")
    @Valid
    private List<AgreementToFeature_> agreementToFeature = new ArrayList<AgreementToFeature_>();

    /**
     * Agreement Alternative Key.
     * 
     */
    @JsonProperty("altkey")
    public Altkey_ getAltkey() {
        return altkey;
    }

    /**
     * Agreement Alternative Key.
     * 
     */
    @JsonProperty("altkey")
    public void setAltkey(Altkey_ altkey) {
        this.altkey = altkey;
    }

    /**
     * Financial intitution where the agreement is opened.
     * A code that identifies the type of the financial institution such as savings and loan, bank, credit union, and mortgage banker.
     * 
     */
    @JsonProperty("financialInstitutionTypeCd")
    public String getFinancialInstitutionTypeCd() {
        return financialInstitutionTypeCd;
    }

    /**
     * Financial intitution where the agreement is opened.
     * A code that identifies the type of the financial institution such as savings and loan, bank, credit union, and mortgage banker.
     * 
     */
    @JsonProperty("financialInstitutionTypeCd")
    public void setFinancialInstitutionTypeCd(String financialInstitutionTypeCd) {
        this.financialInstitutionTypeCd = financialInstitutionTypeCd;
    }

    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * 
     */
    @JsonProperty("openDttm")
    public Date getOpenDttm() {
        return openDttm;
    }

    /**
     * dateTime values may be viewed as objects with integer-valued year, month, day, hour and minute properties, a decimal-valued second property, and a boolean timezoned property. Each such object also has one decimal-valued method or computed property, timeOnTimeline, whose value is always a decimal number; the values are dimensioned in seconds, the integer 0 is 0001-01-01T00:00:00 and the value of timeOnTimeline for other dateTime values is computed using the Gregorian algorithm as modified for leap-seconds. The timeOnTimeline values form two related "timelines", one for timezoned values and one for non-timezoned values. Each timeline is a copy of the ·value space· of decimal, with integers given units of seconds.
     * 
     */
    @JsonProperty("openDttm")
    public void setOpenDttm(Date openDttm) {
        this.openDttm = openDttm;
    }

    /**
     * Agreement status.
     * 
     */
    @JsonProperty("statusCd")
    public String getStatusCd() {
        return statusCd;
    }

    /**
     * Agreement status.
     * 
     */
    @JsonProperty("statusCd")
    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    /**
     * Reason for the Agreement status.
     * 
     */
    @JsonProperty("statusReasonCd")
    public String getStatusReasonCd() {
        return statusReasonCd;
    }

    /**
     * Reason for the Agreement status.
     * 
     */
    @JsonProperty("statusReasonCd")
    public void setStatusReasonCd(String statusReasonCd) {
        this.statusReasonCd = statusReasonCd;
    }

    /**
     * A code for the source of information for the agreement e.g. source system code.
     * 
     */
    @JsonProperty("sourceCd")
    public String getSourceCd() {
        return sourceCd;
    }

    /**
     * A code for the source of information for the agreement e.g. source system code.
     * 
     */
    @JsonProperty("sourceCd")
    public void setSourceCd(String sourceCd) {
        this.sourceCd = sourceCd;
    }

    /**
     * Associates the agreement with features that are specific to the agreement.
     * 
     */
    @JsonProperty("agreementToFeature")
    public List<AgreementToFeature_> getAgreementToFeature() {
        return agreementToFeature;
    }

    /**
     * Associates the agreement with features that are specific to the agreement.
     * 
     */
    @JsonProperty("agreementToFeature")
    public void setAgreementToFeature(List<AgreementToFeature_> agreementToFeature) {
        this.agreementToFeature = agreementToFeature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("altkey", altkey).append("financialInstitutionTypeCd", financialInstitutionTypeCd).append("openDttm", openDttm).append("statusCd", statusCd).append("statusReasonCd", statusReasonCd).append("sourceCd", sourceCd).append("agreementToFeature", agreementToFeature).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(agreementToFeature).append(statusReasonCd).append(openDttm).append(altkey).append(financialInstitutionTypeCd).append(statusCd).append(sourceCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Agreement_) == false) {
            return false;
        }
        Agreement_ rhs = ((Agreement_) other);
        return new EqualsBuilder().append(agreementToFeature, rhs.agreementToFeature).append(statusReasonCd, rhs.statusReasonCd).append(openDttm, rhs.openDttm).append(altkey, rhs.altkey).append(financialInstitutionTypeCd, rhs.financialInstitutionTypeCd).append(statusCd, rhs.statusCd).append(sourceCd, rhs.sourceCd).isEquals();
    }

}
