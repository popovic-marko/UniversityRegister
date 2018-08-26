package rs.ac.bg.fon.silab.ru.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import rs.ac.bg.fon.silab.ru.domain.Contact;
import rs.ac.bg.fon.silab.ru.domain.ContactType;
import rs.ac.bg.fon.silab.ru.domain.ManagementPeriod;
import rs.ac.bg.fon.silab.ru.domain.Manager;
import rs.ac.bg.fon.silab.ru.domain.ManagerPosition;
import rs.ac.bg.fon.silab.ru.domain.University;
import rs.ac.bg.fon.silab.ru.dto.ContactDTO;
import rs.ac.bg.fon.silab.ru.dto.ContactTypeDTO;
import rs.ac.bg.fon.silab.ru.dto.ManagementPeriodDTO;
import rs.ac.bg.fon.silab.ru.dto.ManagerDTO;
import rs.ac.bg.fon.silab.ru.dto.ManagerPositionDTO;
import rs.ac.bg.fon.silab.ru.dto.UniversityDTO;

/**
 *
 * @author user
 */
@Mapper
public interface UniversityMapper {
    UniversityMapper INSTANCE = Mappers.getMapper(UniversityMapper.class);
    
    UniversityDTO universityToUniversityDTO(University university);

    University universityDTOToUniversity(UniversityDTO universityDTO);

    @Mapping(target = "university", ignore = true)
    @Mapping(target = "faculty", ignore = true)
    ContactDTO contactToContactDTO(Contact contact);
    
    @Mapping(target = "university", ignore = true)
    @Mapping(target = "faculty", ignore = true)
    @Mapping(target = "facultyManager", ignore = true)
    ManagementPeriodDTO managementPeriodToManagementPeriodDTO(ManagementPeriod managementPeriod);
    
    ContactType contactTypeDTOToContactType(ContactTypeDTO contactTypeDTO);
    
    ManagerPosition managerPositionDTOToManagerPosition(ManagerPositionDTO managerPositionDTO);
    
    Manager managerDTOToManager(ManagerDTO managerDTO);
    
    default Contact contactDTOToContact(ContactDTO contactDTO) {
        if ( contactDTO == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setContactId( contactDTO.getContactId() );
        contact.setValue( contactDTO.getValue() );
        contact.setContactType( contactTypeDTOToContactType( contactDTO.getContactType() ) );
        contact.setUniversity(new University(contactDTO.getUniversity().getUniversityId()));
        
        return contact;
    }
    
    default ManagementPeriod managementPeriodDTOToManagementPeriod(ManagementPeriodDTO managementPeriodDTO) {
        if ( managementPeriodDTO == null ) {
            return null;
        }

        ManagementPeriod managementPeriod = new ManagementPeriod();

        managementPeriod.setManagingId( managementPeriodDTO.getManagingId() );
        managementPeriod.setDateFrom( managementPeriodDTO.getDateFrom() );
        managementPeriod.setDateTo( managementPeriodDTO.getDateTo() );
        managementPeriod.setPosition( managerPositionDTOToManagerPosition( managementPeriodDTO.getPosition() ) );
        managementPeriod.setUniversityManager( managerDTOToManager( managementPeriodDTO.getUniversityManager() ) );
        managementPeriod.setUniversity(new University(managementPeriodDTO.getUniversity().getUniversityId()));
        
        return managementPeriod;
    }
}
