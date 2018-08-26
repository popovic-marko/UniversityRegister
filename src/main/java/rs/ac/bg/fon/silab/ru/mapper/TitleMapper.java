package rs.ac.bg.fon.silab.ru.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import rs.ac.bg.fon.silab.ru.domain.Title;
import rs.ac.bg.fon.silab.ru.dto.TitleDTO;

/**
 *
 * @author user
 */
@Mapper
public interface TitleMapper {
    TitleMapper INSTANCE = Mappers.getMapper(TitleMapper.class);
    
    TitleDTO titleToTitleDTO(Title title);

    Title titleDTOToTitle(TitleDTO titleDTO);
}
