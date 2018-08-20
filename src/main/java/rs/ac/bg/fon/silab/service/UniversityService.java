package rs.ac.bg.fon.silab.service;

import java.util.LinkedList;
import java.util.List;
import rs.ac.bg.fon.silab.dao.GenericDAO;
import rs.ac.bg.fon.silab.domain.Contact;
import rs.ac.bg.fon.silab.domain.IDomain;
import rs.ac.bg.fon.silab.domain.ManagementPeriod;
import rs.ac.bg.fon.silab.domain.University;

/**
 *
 * @author user
 */
public class UniversityService {

    public static List<University> getAllUniversities() throws Exception {
        GenericDAO g = new GenericDAO();
        List<IDomain> result = g.findAll(new University());
        List<University> universities = new LinkedList<>();
        for (IDomain item : result) {
            universities.add((University) item);
        }
        
        return universities;
    }

    public static University getUniversity(long id) throws Exception {
        GenericDAO g = new GenericDAO();
        University u = new University(id);
        University loadedUniversity = (University) g.findById(u);

        return loadedUniversity;
    }

    public static University saveUniversity(University university) throws Exception {        
        GenericDAO g = new GenericDAO();      
        University savedUniversity = (University) g.insert(university);
        
        return savedUniversity;
    }

    public static University updateUniversity(University u) throws Exception {
        GenericDAO g = new GenericDAO();
        University updatedUniversity = (University) g.update(u);

        return updatedUniversity;
    }

    public static void deleteUniversity(University u) throws Exception{
        GenericDAO g = new GenericDAO();
        g.delete(u);
    }

}
