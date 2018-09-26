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
            message = "Morate uneti univerzitet.\n";
            return false;
        }
        
        message = "";
        UniversityDTO university = (UniversityDTO) entity;
        
        if(university.getName() == null || university.getName().equals("")) {
            message += "Morate uneti naziv univerziteta.\n";
        } else if(university.getName().length() > 250) {
            message += "Naziv univerziteta ne sme biti duži od 250 karaktera.\n";
        }
        
        if(university.getType() == null || university.getType().equals("")) {
            message += "Morate uneti tip univerziteta.\n";
        } else if(university.getType().length() > 50) {
            message += "Tip univerziteta ne sme biti duži od 50 karaktera.\n";
        }
        
        if(university.getDateOfEstablishment() == null) {
            message += "Morate uneti datum osnivanja univerziteta.\n";
        }
        
        if(university.getCity() == null) {
            message += "Morate uneti naziv grada.\n";
        } else {
            if(university.getCity().getCityId() == null) {
                message += "Morate izabrati grad.\n";
            } else if(String.valueOf(university.getCity().getCityId()).length() > 20) {
                message += "Id grada ne sme biti duži od 20 cifara.\n";
            }
            
            if(university.getCity().getCountry() == null) {
                message += "Morate izabrati državu kojoj grad pripada.\n";
            } else if(String.valueOf(university.getCity().getCountry().getCountryId()).length() > 20) {
                message += "Id države ne sme biti duži od 20 cifara.\n";
            }
        }

        if (university.getContacts() != null) {
            Validator contactValidator = ValidatorFactory.create("contact");
            for (int i = 0; i < university.getContacts().size(); i++) {
                ContactDTO contact = university.getContacts().get(i);
                boolean contactValRes = contactValidator.validate(contact);
                message += contactValRes ? "" : "\tKontakt " + (i + 1) + ": " + contactValidator.getErrorMessage();
            }
        }

        if (university.getManagementPeriods() != null) {
            Validator manPeriodValidator = ValidatorFactory.create("management_period");
            for (int i = 0; i < university.getManagementPeriods().size(); i++) {
                ManagementPeriodDTO manPeriod = university.getManagementPeriods().get(i);
                boolean manPeriodValRes = manPeriodValidator.validate(manPeriod);
                message += manPeriodValRes ? "" : "\tPeriod rukovođenja " + (i + 1) + ": " + manPeriodValidator.getErrorMessage();
            }
        }
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
