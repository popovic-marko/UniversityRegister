package rs.ac.bg.fon.silab.ru.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.ru.Response;
import rs.ac.bg.fon.silab.ru.dto.CityDTO;
import rs.ac.bg.fon.silab.ru.service.CityService;

/**
 *
 * @author user
 */
@RestController
public class CityController {
    @Autowired
    CityService cityService;
    
    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public Response getCitiesBySearchName(@RequestParam String searchTerm) {
        Response response;
        try {
            List<CityDTO> cities = cityService.getCitiesBySearchName(searchTerm);
            response = new Response("success", cities);
        } catch (Exception ex) {
            response = new Response("failure", null, "Greska prilikom ucitavanja gradova!");
        }
        
        return response;
    }
}
