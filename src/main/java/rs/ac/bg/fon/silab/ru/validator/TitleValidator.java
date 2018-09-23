package rs.ac.bg.fon.silab.ru.validator;

import rs.ac.bg.fon.silab.ru.dto.TitleDTO;

/**
 *
 * @author user
 */
public class TitleValidator implements Validator{
    private String message;
    
    @Override
    public boolean validate(Object entity) {
        if(entity == null) {
            message = "Morate uneti titulu.";
            return false;
        }
        
        message = "";
        TitleDTO title = (TitleDTO) entity;
        
        if(title.getName() == null || title.getName().equals("")) {
            message += "Morate uneti naziv titule.";
        } else if(title.getName().length() > 50) {
            message += "Naziv titule ne sme biti duži od 50 karaktera.";
        }
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
