package rs.ac.bg.fon.silab.ru.validator;

import rs.ac.bg.fon.silab.ru.domain.IDomain;

/**
 *
 * @author user
 */
public interface Validator {
    boolean validate(Object entity);
    
    public String getErrorMessage();
}
