package rs.ac.bg.fon.silab.ru.validator;

import rs.ac.bg.fon.silab.ru.dto.CountryDTO;

/**
 *
 * @author user
 */
public class CountryValidator implements Validator{
    private String message;
    
    @Override
    public boolean validate(Object entity) {
        if(entity == null) {
            message = "Morate uneti državu.\n";
            return false;
        }
        
        message = "";
        CountryDTO country = (CountryDTO) entity;
        
        if(country.getFullName() == null || country.getFullName().equals("")) {
            message += "Morate uneti naziv države.\n";
        } else if(country.getFullName().length() > 50) {
            message += "Naziv države ne sme biti duži od 50 karaktera.\n";
        }
        
        if(country.getCountryISO() == null || country.getCountryISO().equals("")) {
            message += "Morate uneti skraćeni naziv države.\n";
        } else if(country.getCountryISO().length() > 5) {
            message += "Skraćeni naziv države ne sme biti duzi od 5 karaktera.\n";
        }
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
