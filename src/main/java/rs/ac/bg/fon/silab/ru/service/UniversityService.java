package rs.ac.bg.fon.silab.ru.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.ru.dao.GenericDAO;
import rs.ac.bg.fon.silab.ru.domain.Contact;
import rs.ac.bg.fon.silab.ru.domain.IDomain;
import rs.ac.bg.fon.silab.ru.domain.ManagementPeriod;
import rs.ac.bg.fon.silab.ru.domain.University;
import rs.ac.bg.fon.silab.ru.dto.UniversityDTO;
import rs.ac.bg.fon.silab.ru.mapper.UniversityMapper;

/**
 *
 * @author user
 */
@Service
public class UniversityService {
    @Autowired
    GenericDAO genericDao;

    public List<UniversityDTO> getAllUniversities() throws Exception {
        List<IDomain> result = genericDao.findAll(new University());
        List<UniversityDTO> universities = new LinkedList<>();
        for (IDomain item : result) {
            University university = (University) item;
            UniversityDTO universityDTO = UniversityMapper.INSTANCE.universityToUniversityDTO(university);
            universities.add(universityDTO);
        }
        
        return universities;
    }

    public UniversityDTO getUniversity(long id) throws Exception {
        University university = new University(id);

        University loadedUniversity = (University) genericDao.findById(university);
        UniversityDTO loadedUniversityDTO = UniversityMapper.INSTANCE.universityToUniversityDTO(loadedUniversity);
        
        return loadedUniversityDTO;
    }

    public UniversityDTO saveUniversity(UniversityDTO universityDTO) throws Exception {        
        University university = UniversityMapper.INSTANCE.universityDTOToUniversity(universityDTO);
        for (Contact contact : university.getContacts()) {
            contact.setUniversity(university);
        }
        for (ManagementPeriod managementPeriod : university.getManagementPeriods()) {
            managementPeriod.setUniversity(university);
        }
        
        University savedUniversity = (University) genericDao.insert(university);
        UniversityDTO savedUniversityDTO = UniversityMapper.INSTANCE.universityToUniversityDTO(savedUniversity);
        
        return savedUniversityDTO;
    }

    public UniversityDTO updateUniversity(UniversityDTO universityDTO) throws Exception {
        University university = UniversityMapper.INSTANCE.universityDTOToUniversity(universityDTO);
        for (Contact contact : university.getContacts()) {
            contact.setUniversity(university);
        }
        for (ManagementPeriod managementPeriod : university.getManagementPeriods()) {
            managementPeriod.setUniversity(university);
        }
        
        University updatedUniversity = (University) genericDao.update(university);
        UniversityDTO updatedUniversityDTO = UniversityMapper.INSTANCE.universityToUniversityDTO(updatedUniversity);
        
        return updatedUniversityDTO;
    }

    public void deleteUniversity(/*UniversityDTO universityDTO*/ Long universityId) throws Exception{
        University university = new University(universityId);
        genericDao.delete(university);
    } 

}
