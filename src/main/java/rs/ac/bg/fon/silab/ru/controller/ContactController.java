package rs.ac.bg.fon.silab.ru.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.ru.Response;
import rs.ac.bg.fon.silab.ru.dto.ContactTypeDTO;
import rs.ac.bg.fon.silab.ru.service.ContactService;

/**
 *
 * @author user
 */
@RestController
public class ContactController {
    @Autowired
    ContactService contactService;
    
    @RequestMapping(value = "/contacts/types", method = RequestMethod.GET)
    public Response getAllContactTypes() {
        Response response;
        try {
            List<ContactTypeDTO> contactTypes = contactService.getAllContactTypes();
            response = new Response("success", contactTypes);
        } catch (Exception ex) {
            System.out.println("======================== " + ex.getMessage() + " ==============");
            response = new Response("failure", null, "Greska prilikom ucitavanja tipova kontakata!");
        }
        
        return response;
    }
}
