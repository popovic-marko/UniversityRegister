package rs.ac.bg.fon.silab.ru.validator;

import rs.ac.bg.fon.silab.ru.dto.ContactDTO;
import rs.ac.bg.fon.silab.ru.dto.FacultyDTO;
import rs.ac.bg.fon.silab.ru.dto.ManagementPeriodDTO;

/**
 *
 * @author user
 */
public class FacultyValidator implements Validator{
    private String message;
    
    @Override
    public boolean validate(Object entity) {
        if(entity == null) {
            message = "Morate uneti fakultet.";
            return false;
        }
        
        message = "";
        FacultyDTO faculty = (FacultyDTO) entity;
        
        if(faculty.getName() == null || faculty.getName().equals("")) {
            message += "Morate uneti naziv fakulteta.";
        } else if(faculty.getName().length() > 100) {
            message += "Naziv fakulteta ne sme biti duži od 100 karaktera.";
        }
        
        if(faculty.getType() == null || faculty.getType().equals("")) {
            message += "Morate uneti tip fakulteta.";
        } else if(faculty.getName().length() > 20) {
            message += "Tip fakulteta ne sme biti duži od 20 karaktera.";
        }
        
        if(faculty.getTermsOfEnrollment() == null || faculty.getTermsOfEnrollment().equals("")) {
            message += "Morate uneti uslove upisa na fakultet.";
        } else if(faculty.getTermsOfEnrollment().length() > 250) {
            message += "Uslovi upisa ne smeju biti duži od 250 karaktera.";
        }
        
        if(faculty.getDurationOfStudies() == null || faculty.getDurationOfStudies().equals("")) {
            message += "Morate uneti trajanje studija.";
        } else if(faculty.getDurationOfStudies().length() > 50) {
            message += "Trajanje studija ne sme biti duže od 50 karaktera.";
        }
        
        if(faculty.getDateOfAccreditation() == null) {
            message += "Morate uneti datum akreditacije fakulteta.";
        }
        
        if(faculty.getCapacity() == null) {
            message += "Morate uneti kapacitet fakulteta.";
        } else if(String.valueOf(faculty.getCapacity()).length() > 10) {
            message += "Kapacitet fakulteta ne sme biti duži od 10 cifara.";
        }
        
        Validator contactValidator = ValidatorFactory.create("contact");
        for (int i = 0; i < faculty.getContacts().size(); i++) {
            ContactDTO contact = faculty.getContacts().get(i);
            boolean contactValRes = contactValidator.validate(contact); 
            message += contactValRes ? "" : "\tKontakt " + (i+1) + ": " + contactValidator.getErrorMessage();
        }
        
        Validator manPeriodValidator = ValidatorFactory.create("management_period");
        for (int i = 0; i < faculty.getManagementPeriods().size(); i++) {
            ManagementPeriodDTO manPeriod = faculty.getManagementPeriods().get(i);
            boolean manPeriodValRes = manPeriodValidator.validate(manPeriod); 
            message += manPeriodValRes ? "" : "\tPeriod rukovođenja " + (i+1) + ": " + manPeriodValidator.getErrorMessage();
        }
        
        if(faculty.getUniversity() == null || faculty.getUniversity().getUniversityId() == null) {
            message += "Morate uneti univerzitet kojem fakultet pripada.";
        }
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
