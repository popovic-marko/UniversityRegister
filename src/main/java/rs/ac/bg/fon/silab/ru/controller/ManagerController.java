package rs.ac.bg.fon.silab.ru.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.ru.Response;
import rs.ac.bg.fon.silab.ru.dto.ManagerDTO;
import rs.ac.bg.fon.silab.ru.dto.ManagerPositionDTO;
import rs.ac.bg.fon.silab.ru.service.ManagerService;

/**
 *
 * @author user
 */
@RestController
public class ManagerController {
    @Autowired
    ManagerService managerService;
    
    @RequestMapping(value = "/managers/managerPositions", method = RequestMethod.GET)
    public Response getAllContactTypes() {
        Response response;
        try {
            List<ManagerPositionDTO> managerPositions = managerService.getAllManagerPositions();
            response = new Response("success", managerPositions);
        } catch (Exception ex) {
            System.out.println("======================== " + ex.getMessage() + " ==============");
            response = new Response("failure", null, "Greska prilikom ucitavanja pozicija rukovodilaca!");
        }
        
        return response;
    }
    
    @RequestMapping(value = "/managers", method = RequestMethod.GET)
    public Response getManagersBySearchName(@RequestParam String searchTerm) {
        Response response;
        try {
            List<ManagerDTO> managers = managerService.getManagersBySearchName(searchTerm);
            response = new Response("success", managers);
        } catch (Exception ex) {
            response = new Response("failure", null, "Greska prilikom ucitavanja rukovodilaca!");
        }
        
        return response;
    }
}
