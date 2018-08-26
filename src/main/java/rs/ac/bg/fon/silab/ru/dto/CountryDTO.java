package rs.ac.bg.fon.silab.ru.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author user
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryDTO {
    private Long countryId;
    private String fullName;
    private String countryISO;

    public CountryDTO() {
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCountryISO() {
        return countryISO;
    }

    public void setCountryISO(String countryISO) {
        this.countryISO = countryISO;
    }

    

    
}
