package rs.ac.bg.fon.silab.ru.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.ru.dao.GenericDAO;
import rs.ac.bg.fon.silab.ru.domain.City;
import rs.ac.bg.fon.silab.ru.domain.IDomain;
import rs.ac.bg.fon.silab.ru.dto.CityDTO;
import rs.ac.bg.fon.silab.ru.mapper.CityMapper;

/**
 *
 * @author user
 */
@Service
public class CityService {
    @Autowired
    GenericDAO genericDao;
    
    public List<CityDTO> getCitiesBySearchName(String searchTerm) throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("name", searchTerm);
        
        List<IDomain> result = genericDao.findByQueryName("City.findByNameOnlyIdAndName", params);
        List<CityDTO> cities = new LinkedList<>();

        for (Object item : result) {
            Object[] array = (Object[]) item; 
            Long cityId = (Long) array[0];
            String name = (String) array[1];
            
            City city = new City(cityId, name);
            CityDTO cityDTO = CityMapper.INSTANCE.cityToCityDTO(city);
            cities.add(cityDTO);
        }
        
        return cities;
    }
    
}
