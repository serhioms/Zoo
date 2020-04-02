
package ca.mss.test.pojo.dest.complex;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "telephoneNum",
    "countryCodeNum",
    "areaCodeNum",
    "exchangeNum",
    "lineNum",
    "extensionNum"
})
public class TelephoneNumber {

    /**
     * Telephone Number. A set of digits that represent the entire telephone number. The number of digits varies by country. This could be derived from the individual attributes of the telephone number parts contained in this entity. The individual elements of a telephone number are split out in separate attributes. However, due to number portability the phone number elements are becoming less useful as the area code and exchange number elements of a ported number no longer identify an area or an exchange.
     * 
     */
    @JsonProperty("telephoneNum")
    @JsonPropertyDescription("Telephone Number. A set of digits that represent the entire telephone number. The number of digits varies by country. This could be derived from the individual attributes of the telephone number parts contained in this entity. The individual elements of a telephone number are split out in separate attributes. However, due to number portability the phone number elements are becoming less useful as the area code and exchange number elements of a ported number no longer identify an area or an exchange.")
    private String telephoneNum;
    /**
     * A set of digits in a telephone number that represent the country. The number of digits varies by country.
     * If present, then it MUST contain the parsed-out countryCodeNum.
     * 
     */
    @JsonProperty("countryCodeNum")
    @JsonPropertyDescription("A set of digits in a telephone number that represent the country. The number of digits varies by country.\r\nIf present, then it MUST contain the parsed-out countryCodeNum.")
    private String countryCodeNum;
    /**
     * A set of digits in a telephone number that represent the area code. The number of digits may vary by country. Due to number portability the phone number elements are becoming less useful as the area code and exchange number elements of a ported number no longer identify an area or an exchange.
     * If present, then it MUST contain the parsed-out areaCodeNum.
     * 
     */
    @JsonProperty("areaCodeNum")
    @JsonPropertyDescription("A set of digits in a telephone number that represent the area code. The number of digits may vary by country. Due to number portability the phone number elements are becoming less useful as the area code and exchange number elements of a ported number no longer identify an area or an exchange.\r\nIf present, then it MUST contain the parsed-out areaCodeNum.")
    private String areaCodeNum;
    /**
     * A set of digits in a telephone number that represent a central office exchange. The number of digits may vary by country. Due to number portability the phone number elements are becoming less useful as the area code and exchange number elements of a ported number no longer identify an area or an exchange.
     * If present, then it MUST contain the parsed-out exchangeNum.
     * 
     */
    @JsonProperty("exchangeNum")
    @JsonPropertyDescription("A set of digits in a telephone number that represent a central office exchange. The number of digits may vary by country. Due to number portability the phone number elements are becoming less useful as the area code and exchange number elements of a ported number no longer identify an area or an exchange.\r\nIf present, then it MUST contain the parsed-out exchangeNum.")
    private String exchangeNum;
    /**
     * A set of digits in a telephone number that represent the line number from the central office. The number of digits may vary by country.
     * If present, then it MUST contain the parsed-out lineNum.
     * 
     */
    @JsonProperty("lineNum")
    @JsonPropertyDescription("A set of digits in a telephone number that represent the line number from the central office. The number of digits may vary by country.\r\nIf present, then it MUST contain the parsed-out lineNum.")
    private String lineNum;
    /**
     * The extension for the phone. This may be null if no extension applies to this number.
     * If present, then it MUST contain the parsed-out extensionNum.
     * 
     */
    @JsonProperty("extensionNum")
    @JsonPropertyDescription("The extension for the phone. This may be null if no extension applies to this number.\r\nIf present, then it MUST contain the parsed-out extensionNum.")
    private String extensionNum;

    /**
     * Telephone Number. A set of digits that represent the entire telephone number. The number of digits varies by country. This could be derived from the individual attributes of the telephone number parts contained in this entity. The individual elements of a telephone number are split out in separate attributes. However, due to number portability the phone number elements are becoming less useful as the area code and exchange number elements of a ported number no longer identify an area or an exchange.
     * 
     */
    @JsonProperty("telephoneNum")
    public String getTelephoneNum() {
        return telephoneNum;
    }

    /**
     * Telephone Number. A set of digits that represent the entire telephone number. The number of digits varies by country. This could be derived from the individual attributes of the telephone number parts contained in this entity. The individual elements of a telephone number are split out in separate attributes. However, due to number portability the phone number elements are becoming less useful as the area code and exchange number elements of a ported number no longer identify an area or an exchange.
     * 
     */
    @JsonProperty("telephoneNum")
    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    /**
     * A set of digits in a telephone number that represent the country. The number of digits varies by country.
     * If present, then it MUST contain the parsed-out countryCodeNum.
     * 
     */
    @JsonProperty("countryCodeNum")
    public String getCountryCodeNum() {
        return countryCodeNum;
    }

    /**
     * A set of digits in a telephone number that represent the country. The number of digits varies by country.
     * If present, then it MUST contain the parsed-out countryCodeNum.
     * 
     */
    @JsonProperty("countryCodeNum")
    public void setCountryCodeNum(String countryCodeNum) {
        this.countryCodeNum = countryCodeNum;
    }

    /**
     * A set of digits in a telephone number that represent the area code. The number of digits may vary by country. Due to number portability the phone number elements are becoming less useful as the area code and exchange number elements of a ported number no longer identify an area or an exchange.
     * If present, then it MUST contain the parsed-out areaCodeNum.
     * 
     */
    @JsonProperty("areaCodeNum")
    public String getAreaCodeNum() {
        return areaCodeNum;
    }

    /**
     * A set of digits in a telephone number that represent the area code. The number of digits may vary by country. Due to number portability the phone number elements are becoming less useful as the area code and exchange number elements of a ported number no longer identify an area or an exchange.
     * If present, then it MUST contain the parsed-out areaCodeNum.
     * 
     */
    @JsonProperty("areaCodeNum")
    public void setAreaCodeNum(String areaCodeNum) {
        this.areaCodeNum = areaCodeNum;
    }

    /**
     * A set of digits in a telephone number that represent a central office exchange. The number of digits may vary by country. Due to number portability the phone number elements are becoming less useful as the area code and exchange number elements of a ported number no longer identify an area or an exchange.
     * If present, then it MUST contain the parsed-out exchangeNum.
     * 
     */
    @JsonProperty("exchangeNum")
    public String getExchangeNum() {
        return exchangeNum;
    }

    /**
     * A set of digits in a telephone number that represent a central office exchange. The number of digits may vary by country. Due to number portability the phone number elements are becoming less useful as the area code and exchange number elements of a ported number no longer identify an area or an exchange.
     * If present, then it MUST contain the parsed-out exchangeNum.
     * 
     */
    @JsonProperty("exchangeNum")
    public void setExchangeNum(String exchangeNum) {
        this.exchangeNum = exchangeNum;
    }

    /**
     * A set of digits in a telephone number that represent the line number from the central office. The number of digits may vary by country.
     * If present, then it MUST contain the parsed-out lineNum.
     * 
     */
    @JsonProperty("lineNum")
    public String getLineNum() {
        return lineNum;
    }

    /**
     * A set of digits in a telephone number that represent the line number from the central office. The number of digits may vary by country.
     * If present, then it MUST contain the parsed-out lineNum.
     * 
     */
    @JsonProperty("lineNum")
    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    /**
     * The extension for the phone. This may be null if no extension applies to this number.
     * If present, then it MUST contain the parsed-out extensionNum.
     * 
     */
    @JsonProperty("extensionNum")
    public String getExtensionNum() {
        return extensionNum;
    }

    /**
     * The extension for the phone. This may be null if no extension applies to this number.
     * If present, then it MUST contain the parsed-out extensionNum.
     * 
     */
    @JsonProperty("extensionNum")
    public void setExtensionNum(String extensionNum) {
        this.extensionNum = extensionNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("telephoneNum", telephoneNum).append("countryCodeNum", countryCodeNum).append("areaCodeNum", areaCodeNum).append("exchangeNum", exchangeNum).append("lineNum", lineNum).append("extensionNum", extensionNum).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(telephoneNum).append(areaCodeNum).append(countryCodeNum).append(exchangeNum).append(lineNum).append(extensionNum).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TelephoneNumber) == false) {
            return false;
        }
        TelephoneNumber rhs = ((TelephoneNumber) other);
        return new EqualsBuilder().append(telephoneNum, rhs.telephoneNum).append(areaCodeNum, rhs.areaCodeNum).append(countryCodeNum, rhs.countryCodeNum).append(exchangeNum, rhs.exchangeNum).append(lineNum, rhs.lineNum).append(extensionNum, rhs.extensionNum).isEquals();
    }

}
