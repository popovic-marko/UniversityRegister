package rs.ac.bg.fon.silab.ru.validator;

import rs.ac.bg.fon.silab.ru.dto.RankDTO;

/**
 *
 * @author user
 */
public class RankValidator implements Validator{
    private String message;
    
    @Override
    public boolean validate(Object entity) {
        if(entity == null) {
            message = "Morate uneti zvanje.";
            return false;
        }
        
        message = "";
        RankDTO rank = (RankDTO) entity;
        
        if(rank.getName() == null || rank.getName().equals("")) {
            message += "Morate uneti naziv zvanja.";
        } else if(rank.getName().length() > 20) {
            message += "Naziv zvanja ne sme biti duži od 20 karaktera.";
        }
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
