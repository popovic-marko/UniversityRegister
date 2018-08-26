package rs.ac.bg.fon.silab.ru.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import rs.ac.bg.fon.silab.ru.domain.Country;
import rs.ac.bg.fon.silab.ru.dto.CountryDTO;

/**
 *
 * @author user
 */
@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
    
    CountryDTO countryToCountryDTO(Country country);

    Country countryDTOToCountry(CountryDTO countryDTO);
}
