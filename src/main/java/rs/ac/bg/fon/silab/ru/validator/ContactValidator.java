package rs.ac.bg.fon.silab.ru.validator;

import rs.ac.bg.fon.silab.ru.dto.ContactDTO;

/**
 *
 * @author user
 */
public class ContactValidator implements Validator{
    private String message;
    
    @Override
    public boolean validate(Object entity) {
        if(entity == null) {
            message = "Morate uneti kontakt.";
            return false;
        }
        
        message = "";
        ContactDTO contact = (ContactDTO) entity;
        
        if(contact.getValue() == null || contact.getValue().equals("")) {
            message += "Morate uneti vrednost kontakta.";
        } else if(contact.getValue().length() > 50) {
            message += "Vrednost kontakta ne sme biti duža od 50 karaktera.";
        }
        
        Validator contactTypeValidator = ValidatorFactory.create("contact_type");
        boolean contactTypeValRes = contactTypeValidator.validate(contact.getContactType()); 
        message += contactTypeValRes ? "" : contactTypeValidator.getErrorMessage();
        
        return message.equals("");
                
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
