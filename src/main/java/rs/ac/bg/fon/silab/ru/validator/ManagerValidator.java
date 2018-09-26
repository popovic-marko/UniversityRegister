package rs.ac.bg.fon.silab.ru.validator;

import rs.ac.bg.fon.silab.ru.dto.ManagerDTO;

/**
 *
 * @author user
 */
public class ManagerValidator implements Validator{
    private String message;
    
    @Override
    public boolean validate(Object entity) {
        if(entity == null) {
            message = "Morate uneti rukovodica.\n";
            return false;
        }
        
        message = "";
        ManagerDTO manager = (ManagerDTO) entity;
        
        if(manager.getFirstName() == null || manager.getFirstName().equals("")) {
            message += "Morate uneti ime rukovodioca.\n";
        } else if(manager.getFirstName().length() > 50) {
            message += "Ime rukovodioca ne sme biti duže od 50 karaktera.\n";
        }
        
        if(manager.getLastName() == null || manager.getLastName().equals("")) {
            message += "Morate uneti prezime rukovodioca.\n";
        } else if(manager.getLastName().length() > 50) {
            message += "Prezime rukovodioca ne sme biti duže od 50 karaktera.\n";
        }
        
        Validator rankValidator = ValidatorFactory.create("rank");
        boolean rankValRes = rankValidator.validate(manager.getRank()); 
        message += rankValRes ? "" : rankValidator.getErrorMessage();
        
        Validator titleValidator = ValidatorFactory.create("title");
        boolean titleValRes = titleValidator.validate(manager.getTitle()); 
        message += titleValRes ? "" : titleValidator.getErrorMessage();
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
