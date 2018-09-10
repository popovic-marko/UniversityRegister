package rs.ac.bg.fon.silab.ru.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.ru.dao.GenericDAO;
import rs.ac.bg.fon.silab.ru.domain.City;
import rs.ac.bg.fon.silab.ru.domain.Country;
import rs.ac.bg.fon.silab.ru.domain.IDomain;
import rs.ac.bg.fon.silab.ru.dto.CountryDTO;
import rs.ac.bg.fon.silab.ru.mapper.CountryMapper;

/**
 *
 * @author user
 */
@Service
public class CountryService {
    @Autowired
    GenericDAO genericDao;
    
    public CountryDTO getCountryByCityId(Long cityId) throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("cityId", cityId);
        
        List<IDomain> result = genericDao.findByQueryName("City.findById", params);
        if(!result.isEmpty()) {
            City city = (City) result.get(0);
            Country country = city.getCountry();
            
            return CountryMapper.INSTANCE.countryToCountryDTO(country);
        } else {
            return new CountryDTO();
        }
    }
    
}
