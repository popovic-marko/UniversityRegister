package rs.ac.bg.fon.silab.ru.validator;

import rs.ac.bg.fon.silab.ru.dto.CityDTO;

/**
 *
 * @author user
 */
public class CityValidator implements Validator{
    private String message;
    
    @Override
    public boolean validate(Object entity) {
        if(entity == null) {
            message = "Morate uneti grad.";
            return false;
        }
        
        message = "";
        CityDTO city = (CityDTO) entity;
        
        if(city.getName() == null || city.getName().equals("")) {
            message += "Morate uneti naziv grada.";
        } else if(city.getName().length() > 100) {
            message += "Naziv grada ne sme biti duži od 100 karaktera.";
        }
        
        if(city.getCode() == null) {
            message += "Morate uneti poštanski broj grada.";
        } else if(String.valueOf(city.getCode()).length() > 10) {
            message += "Poštanski broj grada ne sme biti duži od 10 cifara.";
        }
        
        Validator countryValidator = ValidatorFactory.create("country");
        boolean countryValRes = countryValidator.validate(city.getCountry()); 
        message += countryValRes ? "" : countryValidator.getErrorMessage();
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
