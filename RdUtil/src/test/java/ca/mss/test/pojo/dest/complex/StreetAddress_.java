
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
    "addressLine1",
    "addressLine2",
    "addressLine3",
    "city",
    "territory",
    "postalCode",
    "country",
    "countryCd"
})
public class StreetAddress_ {

    /**
     * The first line of text containing all or part of a physical site address.
     * This line typically contains additional recipient information.
     * 
     */
    @JsonProperty("addressLine1")
    @JsonPropertyDescription("The first line of text containing all or part of a physical site address.\r\nThis line typically contains additional recipient information.")
    private String addressLine1;
    /**
     * The second line of text containing all or part of a physical site address.
     * This line typically contains street numbers and street names.
     * 
     */
    @JsonProperty("addressLine2")
    @JsonPropertyDescription("The second line of text containing all or part of a physical site address.\r\nThis line typically contains street numbers and street names.")
    private String addressLine2;
    /**
     * The third line of text containing all or part of a physical site address.
     * This line typically contains additional location numbers.
     * 
     */
    @JsonProperty("addressLine3")
    @JsonPropertyDescription("The third line of text containing all or part of a physical site address.\r\nThis line typically contains additional location numbers.")
    private String addressLine3;
    /**
     * Name of the City.
     * 
     */
    @JsonProperty("city")
    @JsonPropertyDescription("Name of the City.")
    private String city;
    /**
     * Province, State or territory name.
     * 
     */
    @JsonProperty("territory")
    @JsonPropertyDescription("Province, State or territory name.")
    private String territory;
    /**
     * token represents tokenized strings. The ·value space· of token is the set of strings that do not contain the carriage return (#xD), line feed (#xA) nor tab (#x9) characters, that have no leading or trailing spaces (#x20) and that have no internal sequences of two or more spaces. The ·lexical space· of token is the set of strings that do not contain the carriage return (#xD), line feed (#xA) nor tab (#x9) characters, that have no leading or trailing spaces (#x20) and that have no internal sequences of two or more spaces. The ·base type· of token is normalizedString.
     * 
     */
    @JsonProperty("postalCode")
    @JsonPropertyDescription("token represents tokenized strings. The \u00b7value space\u00b7 of token is the set of strings that do not contain the carriage return (#xD), line feed (#xA) nor tab (#x9) characters, that have no leading or trailing spaces (#x20) and that have no internal sequences of two or more spaces. The \u00b7lexical space\u00b7 of token is the set of strings that do not contain the carriage return (#xD), line feed (#xA) nor tab (#x9) characters, that have no leading or trailing spaces (#x20) and that have no internal sequences of two or more spaces. The \u00b7base type\u00b7 of token is normalizedString.")
    private Object postalCode;
    /**
     * Country Name.
     * 
     */
    @JsonProperty("country")
    @JsonPropertyDescription("Country Name.")
    private String country;
    /**
     * A code indicating a country.
     * 
     */
    @JsonProperty("countryCd")
    @JsonPropertyDescription("A code indicating a country.")
    private String countryCd;

    /**
     * The first line of text containing all or part of a physical site address.
     * This line typically contains additional recipient information.
     * 
     */
    @JsonProperty("addressLine1")
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * The first line of text containing all or part of a physical site address.
     * This line typically contains additional recipient information.
     * 
     */
    @JsonProperty("addressLine1")
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * The second line of text containing all or part of a physical site address.
     * This line typically contains street numbers and street names.
     * 
     */
    @JsonProperty("addressLine2")
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * The second line of text containing all or part of a physical site address.
     * This line typically contains street numbers and street names.
     * 
     */
    @JsonProperty("addressLine2")
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * The third line of text containing all or part of a physical site address.
     * This line typically contains additional location numbers.
     * 
     */
    @JsonProperty("addressLine3")
    public String getAddressLine3() {
        return addressLine3;
    }

    /**
     * The third line of text containing all or part of a physical site address.
     * This line typically contains additional location numbers.
     * 
     */
    @JsonProperty("addressLine3")
    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    /**
     * Name of the City.
     * 
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * Name of the City.
     * 
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Province, State or territory name.
     * 
     */
    @JsonProperty("territory")
    public String getTerritory() {
        return territory;
    }

    /**
     * Province, State or territory name.
     * 
     */
    @JsonProperty("territory")
    public void setTerritory(String territory) {
        this.territory = territory;
    }

    /**
     * token represents tokenized strings. The ·value space· of token is the set of strings that do not contain the carriage return (#xD), line feed (#xA) nor tab (#x9) characters, that have no leading or trailing spaces (#x20) and that have no internal sequences of two or more spaces. The ·lexical space· of token is the set of strings that do not contain the carriage return (#xD), line feed (#xA) nor tab (#x9) characters, that have no leading or trailing spaces (#x20) and that have no internal sequences of two or more spaces. The ·base type· of token is normalizedString.
     * 
     */
    @JsonProperty("postalCode")
    public Object getPostalCode() {
        return postalCode;
    }

    /**
     * token represents tokenized strings. The ·value space· of token is the set of strings that do not contain the carriage return (#xD), line feed (#xA) nor tab (#x9) characters, that have no leading or trailing spaces (#x20) and that have no internal sequences of two or more spaces. The ·lexical space· of token is the set of strings that do not contain the carriage return (#xD), line feed (#xA) nor tab (#x9) characters, that have no leading or trailing spaces (#x20) and that have no internal sequences of two or more spaces. The ·base type· of token is normalizedString.
     * 
     */
    @JsonProperty("postalCode")
    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Country Name.
     * 
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * Country Name.
     * 
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * A code indicating a country.
     * 
     */
    @JsonProperty("countryCd")
    public String getCountryCd() {
        return countryCd;
    }

    /**
     * A code indicating a country.
     * 
     */
    @JsonProperty("countryCd")
    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("addressLine1", addressLine1).append("addressLine2", addressLine2).append("addressLine3", addressLine3).append("city", city).append("territory", territory).append("postalCode", postalCode).append("country", country).append("countryCd", countryCd).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(country).append(city).append(postalCode).append(countryCd).append(addressLine1).append(addressLine2).append(addressLine3).append(territory).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StreetAddress_) == false) {
            return false;
        }
        StreetAddress_ rhs = ((StreetAddress_) other);
        return new EqualsBuilder().append(country, rhs.country).append(city, rhs.city).append(postalCode, rhs.postalCode).append(countryCd, rhs.countryCd).append(addressLine1, rhs.addressLine1).append(addressLine2, rhs.addressLine2).append(addressLine3, rhs.addressLine3).append(territory, rhs.territory).isEquals();
    }

}
