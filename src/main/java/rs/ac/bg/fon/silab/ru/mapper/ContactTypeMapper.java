package rs.ac.bg.fon.silab.ru.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import rs.ac.bg.fon.silab.ru.domain.ContactType;
import rs.ac.bg.fon.silab.ru.dto.ContactTypeDTO;

/**
 *
 * @author user
 */
@Mapper
public interface ContactTypeMapper {
    ContactTypeMapper INSTANCE = Mappers.getMapper(ContactTypeMapper.class);
    
    ContactTypeDTO contactTypeToContactTypeDTO(ContactType contactType);

    ContactType contactTypeDTOToContactType(ContactTypeDTO contactTypeDTO);
}
