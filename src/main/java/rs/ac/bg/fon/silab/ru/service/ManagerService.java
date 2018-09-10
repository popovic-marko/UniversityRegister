package rs.ac.bg.fon.silab.ru.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.ru.dao.GenericDAO;
import rs.ac.bg.fon.silab.ru.domain.IDomain;
import rs.ac.bg.fon.silab.ru.domain.Manager;
import rs.ac.bg.fon.silab.ru.domain.ManagerPosition;
import rs.ac.bg.fon.silab.ru.dto.ManagerDTO;
import rs.ac.bg.fon.silab.ru.dto.ManagerPositionDTO;
import rs.ac.bg.fon.silab.ru.mapper.ManagerMapper;
import rs.ac.bg.fon.silab.ru.mapper.ManagerPositionMapper;

/**
 *
 * @author user
 */
@Service
public class ManagerService {
    @Autowired
    GenericDAO genericDao;

    public List<ManagerPositionDTO> getAllManagerPositions() throws Exception{
        List<IDomain> result = genericDao.findAll(new ManagerPosition());
        List<ManagerPositionDTO> managerPositions = new LinkedList<>();
        for (IDomain item : result) {
            ManagerPosition managerPosition = (ManagerPosition) item;
            ManagerPositionDTO managerPositionDTO 
                    = ManagerPositionMapper.INSTANCE.managerPositionToManagerPositionDTO(managerPosition);
            managerPositions.add(managerPositionDTO);
        }
        
        return managerPositions;
    }

    public List<ManagerDTO> getManagersBySearchName(String searchTerm) throws Exception{
        String query = "SELECT tab.managerId, tab.firstName, tab.lastName FROM" +
                        " (SELECT managerId, firstName, lastName, CONCAT(firstName, ' ', lastName) AS first_last_name, CONCAT(lastName, ' ', firstName) AS last_first_name" +
                        " FROM manager) AS tab WHERE" +
                        " tab.first_last_name LIKE CONCAT('%', :term, '%') OR" +
                        " tab.last_first_name LIKE CONCAT('%', :term, '%')" + 
                        " ORDER BY tab.lastName, tab.firstName";
        Map<String, Object> params = new HashMap<>();
        params.put("term", searchTerm);
        
        List<Object[]> result = genericDao.findByQuery(query, params);
        List<ManagerDTO> managers = new LinkedList<>();

        for (Object[] item : result) {
            BigInteger bI = (BigInteger) item[0]; 
            Long managerId = bI.longValue();
            String firstName = (String) item[1];
            String lastName = (String) item[2];
            Manager manager = new Manager(managerId, firstName, lastName);
            
            ManagerDTO managerDTO = ManagerMapper.INSTANCE.managerToManagerDTO(manager);
            managers.add(managerDTO);
        }
        
        return managers;
    }
    
}
