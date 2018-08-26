package rs.ac.bg.fon.silab.ru.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import rs.ac.bg.fon.silab.ru.domain.Contact;
import rs.ac.bg.fon.silab.ru.dto.ContactDTO;

/**
 *
 * @author user
 */
@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);
    
    @Mapping(target = "faculty", ignore = true)
    ContactDTO contactToContactDTO(Contact contact);

    Contact contactDTOToContact(ContactDTO contactDTO);
}
