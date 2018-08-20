package rs.ac.bg.fon.silab.ru.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class JPAEntityManagerFactory {
    private static final String PERSISTENCE_UNIT_NAME = "RegistarUniverzitetaPU";
    private static EntityManagerFactory factory;
    
    public static EntityManagerFactory getInstance() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }
    
    public void close() {
        if (factory != null) {
            factory.close();
            factory = null;
        }
    }
}
