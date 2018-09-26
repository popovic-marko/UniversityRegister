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
            message = "Morate uneti zvanje.\n";
            return false;
        }
        
        message = "";
        RankDTO rank = (RankDTO) entity;
        
        if(rank.getName() == null || rank.getName().equals("")) {
            message += "Morate uneti naziv zvanja.\n";
        } else if(rank.getName().length() > 20) {
            message += "Naziv zvanja ne sme biti duži od 20 karaktera.\n";
        }
        
        return message.equals("");
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
    
}
