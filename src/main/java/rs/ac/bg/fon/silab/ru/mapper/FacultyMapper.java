package rs.ac.bg.fon.silab.ru.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import rs.ac.bg.fon.silab.ru.domain.Contact;
import rs.ac.bg.fon.silab.ru.domain.Faculty;
import rs.ac.bg.fon.silab.ru.domain.ManagementPeriod;
import rs.ac.bg.fon.silab.ru.dto.ContactDTO;
import rs.ac.bg.fon.silab.ru.dto.FacultyDTO;
import rs.ac.bg.fon.silab.ru.dto.ManagementPeriodDTO;

/**
 *
 * @author user
 */
@Mapper
public interface FacultyMapper {
    FacultyMapper INSTANCE = Mappers.getMapper(FacultyMapper.class);
    
    FacultyDTO facultyToFacultyDTO(Faculty faculty);

    Faculty facultyDTOToFaculty(FacultyDTO facultyDTO);
    
    @Mapping(target = "faculty", ignore = true)
    @Mapping(target = "university", ignore = true)
    ContactDTO contactToContactDTO(Contact contact);
    
    @Mapping(target = "faculty", ignore = true)
    @Mapping(target = "university", ignore = true)
    @Mapping(target = "universityManager", ignore = true)
    ManagementPeriodDTO managementPeriodToManagementPeriodDTO(ManagementPeriod managementPeriod);
    
    @Mapping(target = "faculty", ignore = true)
    @Mapping(target = "university", ignore = true)
    Contact contactDTOToContact(ContactDTO contactDTO);
    
    @Mapping(target = "faculty", ignore = true)
    @Mapping(target = "university", ignore = true)
    @Mapping(target = "universityManager", ignore = true)
    ManagementPeriod managementPeriodDTOToManagementPeriod(ManagementPeriodDTO managementPeriodDTO);
}
