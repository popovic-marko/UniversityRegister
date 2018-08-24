package rs.ac.bg.fon.silab.ru.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rs.ac.bg.fon.silab.ru.Response;
import rs.ac.bg.fon.silab.ru.domain.Faculty;
import rs.ac.bg.fon.silab.ru.service.FacultyService;

/**
 *
 * @author user
 */
@Controller
public class FacultyController {
    
    @RequestMapping(value = "/faculties", method = RequestMethod.GET)
    public Response getAllFaculties() {
        Response response;
        try {
            List<Faculty> faculties = FacultyService.getAllFaculties();
            response = new Response("success", faculties);
        } catch(Exception ex) {
            response = new Response("failure", null, "Greska prilikom ucitavanja fakulteta!");
        }
        return response;
    }
    
    @RequestMapping(value = "/faculties/{id}", method = RequestMethod.GET)
    public Response getFaculty(@PathVariable long id) {
        Response response;
        try {
            Faculty faculty = FacultyService.getFaculty(id);
            response = new Response("success", faculty);
        } catch(Exception ex) {
            response = new Response("failure", null, "Greska prilikom ucitavanja fakulteta ciji je id:" + id + "!");
        }
        
        return response;
    }
    
    @RequestMapping(value = "/faculties", method = RequestMethod.POST)
    public Response saveFaculty(@RequestBody Faculty faculty) {
        Response response;
        try {
            Faculty createdFaculty = FacultyService.saveFaculty(faculty);
            response = new Response("success", createdFaculty);
        } catch(Exception ex) {
            response = new Response("failure", ex.getMessage());
        }
                
        return response;
    }
    
    @RequestMapping(value = "/faculties/{id}", method = RequestMethod.PUT)
    public Response updateFaculty(@PathVariable long id, @RequestBody Faculty faculty) {
        Response response;
        try {
            faculty.setFacultyId(id);
            Faculty updatedFaculty = FacultyService.updateFaculty(faculty);
            response = new Response("success", updatedFaculty);
        } catch(Exception ex) {
            response = new Response("failure", null, ex.getMessage());
        }
        return response;
    }
    
    @RequestMapping(value = "/faculties/{id}", method = RequestMethod.DELETE)
    public Response deleteFaculty(@PathVariable long id) {
        Response response;
        try {
            Faculty faculty = FacultyService.getFaculty(id);
            FacultyService.deleteFaculty(faculty);
            
            response = new Response("success");
        } catch(Exception ex) {
            response = new Response("failure", null, ex.getMessage());
        }
        return response;
    }
}
