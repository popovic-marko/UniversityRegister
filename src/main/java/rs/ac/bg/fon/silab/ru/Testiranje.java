package rs.ac.bg.fon.silab.ru;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testiranje {
    
    @RequestMapping(value = "/vratiObjekat", method = RequestMethod.GET)
    public Domen vratiObjekat() {
        Domen d = new Domen(1, "FirstName", "LastName");
        
        return d;
    }
}
