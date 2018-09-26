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
            message = "Morate uneti fakultet.\n";
            return false;
        }
        
        message = "";
        FacultyDTO faculty = (FacultyDTO) entity;
        
        if(faculty.getName() == null || faculty.getName().equals("")) {
            message += "Morate uneti naziv fakulteta.\n";
        } else if(faculty.getName().length() > 100) {
            message += "Naziv fakulteta ne sme biti duži od 100 karaktera.\n";
        }
        
        if(faculty.getType() == null || faculty.getType().equals("")) {
            message += "Morate uneti tip fakulteta.\n";
        } else if(faculty.getType().length() > 20) {
            message += "Tip fakulteta ne sme biti duži od 20 karaktera.\n";
        }
        
        if(faculty.getTermsOfEnrollment() == null || faculty.getTermsOfEnrollment().equals("")) {
            message += "Morate uneti uslove upisa na fakultet.\n";
        } else if(faculty.getTermsOfEnrollment().length() > 250) {
            message += "Uslovi upisa ne smeju biti duži od 250 karaktera.\n";
        }
        
        if(faculty.getDurationOfStudies() == null || faculty.getDurationOfStudies().equals("")) {
            message += "Morate uneti trajanje studija.\n";
        } else if(faculty.getDurationOfStudies().length() > 50) {
            message += "Trajanje studija ne sme biti duže od 50 karaktera.\n";
        }
        
        if(faculty.getDateOfAccreditation() == null) {
            message += "Morate uneti datum akreditacije fakulteta.\n";
        }
        
        if(faculty.getCapacity() == null) {
            message += "Morate uneti kapacitet fakulteta.\n";
        } else if(String.valueOf(faculty.getCapacity()).length() > 10) {
            message += "Kapacitet fakulteta ne sme biti duži od 10 cifara.\n";
        }
        
        if (faculty.getContacts() != null) {
            Validator contactValidator = ValidatorFactory.create("contact");
            for (int i = 0; i < faculty.getContacts().size(); i++) {
                ContactDTO contact = faculty.getContacts().get(i);
                boolean contactValRes = contactValidator.validate(contact);
                message += contactValRes ? "" : "\tKontakt " + (i + 1) + ": " + contactValidator.getErrorMessage();
            }
        }

        if (faculty.getManagementPeriods() != null) {
            Validator manPeriodValidator = ValidatorFactory.create("management_period");
            for (int i = 0; i < faculty.getManagementPeriods().size(); i++) {
                ManagementPeriodDTO manPeriod = faculty.getManagementPeriods().get(i);
                boolean manPeriodValRes = manPeriodValidator.validate(manPeriod);
                message += manPeriodValRes ? "" : "\tPeriod rukovođenja " + (i + 1) + ": " + manPeriodValidator.getErrorMessage();
            }
        }
        
        if(faculty.getUniversity() == null || faculty.getUniversity().getUniversityId() == null) {
            message += "Morate uneti univerzitet kojem fakultet pripada.\n";
        }
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
