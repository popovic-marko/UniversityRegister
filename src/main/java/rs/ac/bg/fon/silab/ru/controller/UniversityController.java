package rs.ac.bg.fon.silab.ru.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rs.ac.bg.fon.silab.domain.Contact;
import rs.ac.bg.fon.silab.domain.ManagementPeriod;
import rs.ac.bg.fon.silab.domain.University;
import rs.ac.bg.fon.silab.ru.Response;
import rs.ac.bg.fon.silab.service.UniversityService;

/**
 *
 * @author user
 */
@Controller
public class UniversityController {
    
    @RequestMapping(value = "/universities", method = RequestMethod.GET)
    public Response getAllUniversities() {
        Response response;
        try {
            List<University> universities = UniversityService.getAllUniversities();
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
            University university = UniversityService.getUniversity(id);
            response = new Response("success", university);
        } catch (Exception ex) {
            response = new Response("failure", null, "Greska prilikom ucitavanja univerziteta ciji je id:" + id + "!");
        }
        
        return response;
    } 
    
    @RequestMapping(value = "/universities", method = RequestMethod.POST)
    public Response saveUniversity(/*@RequestBody University university*/ @RequestBody University university) {
 /*       University createdUniversity = UniversityService.saveUniversity(university);
        Response response = new Response("success", createdUniversity);
        
        return response;*/
        System.out.println("======================== ISPIS ==================");
        System.out.println("==== Kontakti ===================================");
        System.out.println("== Velicina:" + university.getContacts().size());
        for (Contact c : university.getContacts()) {
            System.out.println(c.getValue());
        }
        System.out.println("==== Periodi ===================================");
        System.out.println("== Velicina:" + university.getContacts().size());
        for (ManagementPeriod mp : university.getManagementPeriods()) {
            System.out.println(mp.getDateFrom());
        }
        System.out.println("======================== ISPIS ==================");
        
        Response response;
        try {
            University createdUniversity = UniversityService.saveUniversity(university);
            response = new Response("success", createdUniversity);
        } catch (Exception ex) {
            response = new Response("failure", null, ex.getMessage());
        }
        
        return response;
    }
    
    @RequestMapping(value = "/universities/{id}", method = RequestMethod.PUT)
    public Response updateUniversity(@PathVariable long id, @RequestBody University university) {
        /*University updatedUniversity = UniversityService.updateUniversity(university);
        Response response = new Response("success", updatedUniversity);
        
        return response;*/
        Response response;
        try {
            System.out.println("================= ISPIS =====================");
            System.out.println("=== Kontakti, velicina: " + university.getContacts().size());
            for (Contact c : university.getContacts()) {
                System.out.println("== " + c.getValue());
            }
            System.out.println("=== Periodi, velicina: " + university.getContacts().size());
            for (ManagementPeriod mp : university.getManagementPeriods()) {
                System.out.println("== " + mp.getManagingId());
            }
            System.out.println("================= ISPIS =====================");
            
            university.setUniversityId(id);
            University updatedUniversity = UniversityService.updateUniversity(university);
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
            University university = UniversityService.getUniversity(id);
            UniversityService.deleteUniversity(university);
        
            response = new Response("success");
        } catch(Exception e) {
            response = new Response("failure", null, e.getMessage());
        }
        
        return response;
    } 
}
