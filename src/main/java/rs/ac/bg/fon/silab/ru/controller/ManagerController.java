package rs.ac.bg.fon.silab.ru.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @RequestMapping(value = "/managers", method = RequestMethod.GET)
    public Response getAllManagers() {
        Response response;
        try {
            List<ManagerDTO> managers = managerService.getAllManagers();
            response = new Response("success", managers);
        } catch (Exception ex) {
            response = new Response("failure", null, "Greska prilikom ucitavanja rukovodioca!");
        }
        
        return response;
    }
    
    @RequestMapping(value = "/managers/{id}", method = RequestMethod.GET)
    public Response getManager(@PathVariable long id) {
        Response response;
        try {
            ManagerDTO manager = managerService.getManager(id);
            response = new Response("success", manager);
        } catch (Exception ex) {
            response = new Response("failure", null, "Greska prilikom ucitavanja rukovodioca ciji je id:" + id + "!");
        }
        
        return response;
    } 
    
    @RequestMapping(value = "/managers", method = RequestMethod.POST)
    public Response saveManager(@RequestBody ManagerDTO manager) {
        Response response;
        try {
            ManagerDTO createdManager = managerService.saveManager(manager); 
            response = new Response("success", createdManager);
        } catch (Exception ex) {
            response = new Response("failure", null, ex.getMessage());
        }
        
        return response;
    }
    
    @RequestMapping(value = "/managers/{id}", method = RequestMethod.PUT)
    public Response updateManager(@PathVariable long id, @RequestBody ManagerDTO manager) {
        Response response;
        try {
            manager.setManagerId(id);
            ManagerDTO updatedManager = managerService.updateManager(manager);
            response = new Response("success", updatedManager);
        } catch(Exception e) {
            response = new Response("failure", null, e.getMessage());
        }
        return response;
    } 
    
    @RequestMapping(value = "/managers/{id}", method = RequestMethod.DELETE)
    public Response deleteManager(@PathVariable long id) {
        Response response;
        try {
            managerService.deleteManager(id);

            response = new Response("success", null);
        } catch(Exception e) {
            response = new Response("failure", null, e.getMessage());
        }
        
        return response;
    } 
    
    
    
    @RequestMapping(value = "/managers/managerPositions", method = RequestMethod.GET)
    public Response getAllManagerPositions() {
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
