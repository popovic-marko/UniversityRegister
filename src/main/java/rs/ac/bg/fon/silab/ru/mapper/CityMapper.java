package rs.ac.bg.fon.silab.ru.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import rs.ac.bg.fon.silab.ru.domain.City;
import rs.ac.bg.fon.silab.ru.dto.CityDTO;

/**
 *
 * @author user
 */
@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
    
    CityDTO cityToCityDTO(City city);

    City cityDTOToCity(CityDTO cityDTO);
}
