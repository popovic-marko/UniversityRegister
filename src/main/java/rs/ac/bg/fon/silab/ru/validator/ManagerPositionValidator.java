package rs.ac.bg.fon.silab.ru.validator;

import rs.ac.bg.fon.silab.ru.dto.ManagerPositionDTO;

/**
 *
 * @author user
 */
public class ManagerPositionValidator implements Validator{
    private String message;
    
    @Override
    public boolean validate(Object entity) {
        if(entity == null) {
            message = "Morate uneti poziciju rukovodioca.\n";
            return false;
        }
        
        message = "";
        ManagerPositionDTO managerPosition = (ManagerPositionDTO) entity;
        
        if(managerPosition.getName() == null || managerPosition.getName().equals("")) {
            message += "Morate uneti naziv pozicije.\n";
        } else if(managerPosition.getName().length() > 30) {
            message += "Naziv pozicije ne sme biti duži od 30 karaktera.\n";
        }
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
