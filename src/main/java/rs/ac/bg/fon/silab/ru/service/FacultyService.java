package rs.ac.bg.fon.silab.ru.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.ru.dao.GenericDAO;
import rs.ac.bg.fon.silab.ru.domain.Contact;
import rs.ac.bg.fon.silab.ru.domain.Faculty;
import rs.ac.bg.fon.silab.ru.domain.IDomain;
import rs.ac.bg.fon.silab.ru.domain.ManagementPeriod;
import rs.ac.bg.fon.silab.ru.domain.University;
import rs.ac.bg.fon.silab.ru.dto.FacultyDTO;
import rs.ac.bg.fon.silab.ru.mapper.FacultyMapper;

/**
 *
 * @author user
 */
@Service
public class FacultyService {
    @Autowired
    GenericDAO genericDao;
    
    public List<FacultyDTO> getAllFaculties() throws Exception {
        List<IDomain> result = genericDao.findAll(new Faculty());
        List<FacultyDTO> faculties = new LinkedList<>();
        for (IDomain item : result) {
            Faculty faculty = (Faculty) item;
            FacultyDTO facultyDTO = FacultyMapper.INSTANCE.facultyToFacultyDTO(faculty);
            faculties.add(facultyDTO);
        }
        
        return faculties;
    }

    public FacultyDTO getFaculty(long id) throws Exception {
        Faculty f = new Faculty(id);
        
        Faculty loadedFaculty = (Faculty) genericDao.findById(f);
        FacultyDTO loadedFacultyDTO = FacultyMapper.INSTANCE.facultyToFacultyDTO(loadedFaculty);
        
        return loadedFacultyDTO;
    }

    public FacultyDTO saveFaculty(FacultyDTO facultyDTO) throws Exception {
        Faculty faculty = FacultyMapper.INSTANCE.facultyDTOToFaculty(facultyDTO);
        for (Contact contact : faculty.getContacts()) {
            contact.setFaculty(faculty);
        }
        for (ManagementPeriod managementPeriod : faculty.getManagementPeriods()) {
            managementPeriod.setFaculty(faculty);
        }
        
        Faculty savedFaculty = (Faculty) genericDao.insert(faculty);
        FacultyDTO savedFacultyDTO = FacultyMapper.INSTANCE.facultyToFacultyDTO(savedFaculty);
        
        return savedFacultyDTO;
    }

    public FacultyDTO updateFaculty(FacultyDTO facultyDTO) throws Exception {
        Faculty faculty = FacultyMapper.INSTANCE.facultyDTOToFaculty(facultyDTO);
        for (Contact contact : faculty.getContacts()) {
            contact.setFaculty(faculty);
        }
        for (ManagementPeriod managementPeriod : faculty.getManagementPeriods()) {
            managementPeriod.setFaculty(faculty);
        }
        
        Faculty updatedFaculty = (Faculty) genericDao.update(faculty);
        FacultyDTO updatedFacultyDTO = FacultyMapper.INSTANCE.facultyToFacultyDTO(updatedFaculty);

        return updatedFacultyDTO;
    }

    public void deleteFaculty(FacultyDTO facultyDTO) throws Exception {
        Faculty faculty = FacultyMapper.INSTANCE.facultyDTOToFaculty(facultyDTO);
        
        genericDao.delete(faculty);
    }
}
