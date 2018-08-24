package rs.ac.bg.fon.silab.ru.service;

import java.util.LinkedList;
import java.util.List;
import rs.ac.bg.fon.silab.ru.dao.GenericDAO;
import rs.ac.bg.fon.silab.ru.domain.Faculty;
import rs.ac.bg.fon.silab.ru.domain.IDomain;

/**
 *
 * @author user
 */
public class FacultyService {

    public static List<Faculty> getAllFaculties() throws Exception {
        GenericDAO g = new GenericDAO();
        List<IDomain> result = g.findAll(new Faculty());
        List<Faculty> faculties = new LinkedList<>();
        for (IDomain item : result) {
            faculties.add((Faculty) item);
        }
        
        return faculties;
    }

    public static Faculty getFaculty(long id) throws Exception {
        GenericDAO g = new GenericDAO();
        Faculty f = new Faculty(id);
        Faculty loadedFaculty = (Faculty) g.findById(f);

        return loadedFaculty;
    }

    public static Faculty saveFaculty(Faculty faculty) throws Exception {
        GenericDAO g = new GenericDAO();      
        Faculty savedFaculty = (Faculty) g.insert(faculty);
        
        return savedFaculty;
    }

    public static Faculty updateFaculty(Faculty faculty) throws Exception {
        GenericDAO g = new GenericDAO();
        Faculty updatedFaculty = (Faculty) g.update(faculty);

        return updatedFaculty;
    }

    public static void deleteFaculty(Faculty faculty) throws Exception {
        GenericDAO g = new GenericDAO();
        g.delete(faculty);
    }
}
