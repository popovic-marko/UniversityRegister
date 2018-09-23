package rs.ac.bg.fon.silab.ru.validator;

import rs.ac.bg.fon.silab.ru.dto.ContactDTO;
import rs.ac.bg.fon.silab.ru.dto.ManagementPeriodDTO;
import rs.ac.bg.fon.silab.ru.dto.UniversityDTO;

/**
 *
 * @author user
 */
public class UniversityValidator implements Validator{
    private String message;
    
    @Override
    public boolean validate(Object entity) {
        if(entity == null) {
            message = "Morate uneti univerzitet.";
            return false;
        }
        
        message = "";
        UniversityDTO university = (UniversityDTO) entity;
        
        if(university.getName() == null || university.getName().equals("")) {
            message += "Morate uneti naziv univerziteta.";
        } else if(university.getName().length() > 250) {
            message += "Naziv univerziteta ne sme biti duži od 250 karaktera.";
        }
        
        if(university.getType() == null || university.getType().equals("")) {
            message += "Morate uneti tip univerziteta.";
        } else if(university.getName().length() > 250) {
            message += "Tip univerziteta ne sme biti duži od 50 karaktera.";
        }
        
        if(university.getDateOfEstablishment() == null) {
            message += "Morate uneti datum osnivanja univerziteta.";
        }
        
        Validator cityValidator = ValidatorFactory.create("city");
        boolean cityValRes = cityValidator.validate(university.getCity()); 
        message += cityValRes ? "" : cityValidator.getErrorMessage();
        
        Validator contactValidator = ValidatorFactory.create("contact");
        for (int i = 0; i < university.getContacts().size(); i++) {
            ContactDTO contact = university.getContacts().get(i);
            boolean contactValRes = contactValidator.validate(contact); 
            message += contactValRes ? "" : "\tKontakt " + (i+1) + ": " + contactValidator.getErrorMessage();
        }
        
        Validator manPeriodValidator = ValidatorFactory.create("management_period");
        for (int i = 0; i < university.getManagementPeriods().size(); i++) {
            ManagementPeriodDTO manPeriod = university.getManagementPeriods().get(i);
            boolean manPeriodValRes = manPeriodValidator.validate(manPeriod); 
            message += manPeriodValRes ? "" : "\tPeriod rukovođenja " + (i+1) + ": " + manPeriodValidator.getErrorMessage();
        }
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
