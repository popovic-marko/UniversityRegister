package rs.ac.bg.fon.silab.ru.validator;

import rs.ac.bg.fon.silab.ru.dto.ContactTypeDTO;

/**
 *
 * @author user
 */
public class ContactTypeValidator implements Validator{
    private String message;
    
    @Override
    public boolean validate(Object entity) {
        if(entity == null) {
            message = "Morate uneti tip kontakta.\n";
            return false;
        }
        
        message = "";
        ContactTypeDTO contactType = (ContactTypeDTO) entity;
        
        if(contactType.getName() == null || contactType.getName().equals("")) {
            message += "Morate uneti naziv tipa kontakta.\n";
        } else if(contactType.getName().length() > 20) {
            message += "Naziv tipa kontakta ne sme biti duži od 20 karaktera.\n";
        }
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
