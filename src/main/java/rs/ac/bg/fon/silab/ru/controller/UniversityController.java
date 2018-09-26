package rs.ac.bg.fon.silab.ru.controller;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.ru.Response;
import rs.ac.bg.fon.silab.ru.dto.FacultyDTO;
import rs.ac.bg.fon.silab.ru.dto.UniversityDTO;
import rs.ac.bg.fon.silab.ru.service.UniversityService;

/**
 *
 * @author user
 */
@RestController
public class UniversityController {
    @Autowired
    UniversityService universityService;
    
    @RequestMapping(value = "/universities", method = RequestMethod.GET)
    public Response getAllUniversities() {
        Response response;
        try {
            List<UniversityDTO> universities = universityService.getAllUniversities();
            response = new Response("success", universities);
        } catch (Exception ex) {
            response = new Response("failure", null, "Greska prilikom ucitavanja univerziteta!");
        }
        
        return response;
    } 
    
    @RequestMapping(value = "/universities/{id}", method = RequestMethod.GET)
    public Response getUniversity(@PathVariable long id) {
        Response response;
        try {
            UniversityDTO university = universityService.getUniversity(id);
            response = new Response("success", university);
        } catch (Exception ex) {
            response = new Response("failure", null, "Greska prilikom ucitavanja univerziteta ciji je id:" + id + "!");
        }
        
        return response;
    } 
    
    @RequestMapping(value = "/universities/{id}/faculties", method = RequestMethod.GET)
    public Response getAllFacultyByUniversity(@PathVariable long id) {
        Response response;
        try {
            List<FacultyDTO> faculties = universityService.getAllFacultyByUniversity(id);
            response = new Response("success", faculties);
        } catch (Exception ex) {
            response = new Response("failure", null, "Greska prilikom ucitavanja univerziteta ciji je id:" + id + "!");
        }
        
        return response;
    }
    
    @RequestMapping(value = "/universities", method = RequestMethod.POST)
    public Response saveUniversity(@RequestBody UniversityDTO university) {
        Response response;
        try {
            UniversityDTO createdUniversity = universityService.saveUniversity(university); 
            response = new Response("success", createdUniversity);
        } catch (Exception ex) {
            response = new Response("failure", null, ex.getMessage());
        }
        
        return response;
    }
    
    @RequestMapping(value = "/universities/{id}", method = RequestMethod.PUT)
    public Response updateUniversity(@PathVariable long id, @RequestBody UniversityDTO university) {
        Response response;
        try {
            university.setUniversityId(id);
            UniversityDTO updatedUniversity = universityService.updateUniversity(university);
            response = new Response("success", updatedUniversity);
        } catch(Exception e) {
            response = new Response("failure", null, e.getMessage());
        }
        return response;
    } 
   
    @RequestMapping(value = "/universities/{id}", method = RequestMethod.DELETE)
    public Response deleteUniversity(@PathVariable long id) {
        Response response;
        try {
            universityService.deleteUniversity(id);

            response = new Response("success", null);
        } catch(Exception e) {
            response = new Response("failure", null, e.getMessage());
        }
        
        return response;
    } 
    
    @RequestMapping(value = "/universities/search", method = RequestMethod.GET)
    public Response getUniversitiesBySearchName(@RequestParam String searchTerm) {
        Response response;
        try {
            List<UniversityDTO> universities = universityService.getUniversitiesBySearchName(searchTerm);
            response = new Response("success", universities);
        } catch (Exception ex) {
            response = new Response("failure", null, "Greska prilikom ucitavanja univerziteta!");
        }
        
        return response;
    }
}
