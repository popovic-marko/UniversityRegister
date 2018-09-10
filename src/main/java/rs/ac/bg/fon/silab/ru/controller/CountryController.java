package rs.ac.bg.fon.silab.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.ru.Response;
import rs.ac.bg.fon.silab.ru.dto.CountryDTO;
import rs.ac.bg.fon.silab.ru.service.CountryService;

/**
 *
 * @author user
 */
@RestController
public class CountryController {
    @Autowired
    CountryService countryService;
    
    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public Response getCountryByCity(@RequestParam Long cityId) {
        Response response;
        try {
            CountryDTO country = countryService.getCountryByCityId(cityId);
            response = new Response("success", country);
        } catch (Exception ex) {
            response = new Response("failure", null, "Greska prilikom ucitavanja drzave!");
        }
        
        return response;
    }
}
