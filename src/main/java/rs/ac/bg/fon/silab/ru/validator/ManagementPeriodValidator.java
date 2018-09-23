package rs.ac.bg.fon.silab.ru.validator;

import rs.ac.bg.fon.silab.ru.dto.ManagementPeriodDTO;

/**
 *
 * @author user
 */
public class ManagementPeriodValidator implements Validator{
    private String message;
    
    @Override
    public boolean validate(Object entity) {
        if(entity == null) {
            message = "Morate uneti period rukovođenja.";
            return false;
        }
        
        message = "";
        ManagementPeriodDTO manPeriod = (ManagementPeriodDTO) entity;
        
        if(manPeriod.getDateFrom() == null) {
            message += "Morate uneti datum početka perioda rukovođenja.";
        }
        
        if(manPeriod.getDateTo() == null) {
            message += "Morate uneti datum završetka perioda rukovođenja.";
        }
        
        if((manPeriod.getDateFrom() != null) && (manPeriod.getDateTo() != null) 
                && ( manPeriod.getDateFrom().after(manPeriod.getDateTo()) )) {
            message += "Datum početka rukovođenja ne može biti posle datuma završetka rukovođenja.";
        }
        
        Validator manPositionValidator = ValidatorFactory.create("manager_position");
        boolean manPositionValRes = manPositionValidator.validate(manPeriod.getPosition()); 
        message += manPositionValRes ? "" : manPositionValidator.getErrorMessage();
        
        if(manPeriod.getFaculty() == null && manPeriod.getUniversity() == null) {
            message += "Morate uneti rukovodica fakulteta/univerziteta za perioda rukovođenja.";
        } else {
            if(manPeriod.getFaculty() != null && manPeriod.getFaculty().getFacultyId() == null) {
                message += "Morate uneti podatke fakulteta perioda rukovođenja.";
            }
            
            if(manPeriod.getUniversity()!= null && manPeriod.getUniversity().getUniversityId() == null) {
                message += "Morate uneti podatke univerziteta perioda rukovođenja.";
            }
        }
        
        if(manPeriod.getFacultyManager()== null && manPeriod.getUniversityManager()== null) {
            message += "Morate uneti rukovodica fakulteta/univerziteta perioda rukovođenja.";
        } else {
            if(manPeriod.getFacultyManager() != null && manPeriod.getFacultyManager().getManagerId() == null) {
                message += "Morate uneti podatke rukovodioca fakulteta perioda rukovođenja.";
            }
            
            if(manPeriod.getUniversityManager()!= null && manPeriod.getUniversityManager().getManagerId() == null) {
                message += "Morate uneti podatke rukovodioca univerziteta perioda rukovođenja.";
            }
        }
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
