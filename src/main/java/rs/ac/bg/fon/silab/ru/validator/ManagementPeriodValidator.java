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
            message = "Morate uneti period rukovođenja.\n";
            return false;
        }
        
        message = "";
        ManagementPeriodDTO manPeriod = (ManagementPeriodDTO) entity;
        
        if(manPeriod.getDateFrom() == null) {
            message += "Morate uneti datum početka perioda rukovođenja.\n";
        }
        
        if((manPeriod.getDateFrom() != null) && (manPeriod.getDateTo() != null) 
                && ( manPeriod.getDateFrom().after(manPeriod.getDateTo()) )) {
            message += "Datum početka rukovođenja ne može biti posle datuma završetka rukovođenja.\n";
        }
        
        Validator manPositionValidator = ValidatorFactory.create("manager_position");
        boolean manPositionValRes = manPositionValidator.validate(manPeriod.getPosition()); 
        message += manPositionValRes ? "" : manPositionValidator.getErrorMessage();
        
        if(manPeriod.getFacultyManager() == null && manPeriod.getUniversityManager() == null) {
            message += "Morate uneti rukovodica fakulteta/univerziteta perioda rukovođenja.\n";
        } else {
            if(manPeriod.getFacultyManager() != null && manPeriod.getFacultyManager().getManagerId() == null) {
                message += "Morate uneti podatke rukovodioca fakulteta perioda rukovođenja.\n";
            }
            
            if(manPeriod.getUniversityManager()!= null && manPeriod.getUniversityManager().getManagerId() == null) {
                message += "Morate uneti podatke rukovodioca univerziteta perioda rukovođenja.\n";
            }
        }
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
