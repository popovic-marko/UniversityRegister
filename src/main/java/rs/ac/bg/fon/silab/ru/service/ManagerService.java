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
import rs.ac.bg.fon.silab.ru.domain.Rank;
import rs.ac.bg.fon.silab.ru.domain.Title;
import rs.ac.bg.fon.silab.ru.dto.ManagerDTO;
import rs.ac.bg.fon.silab.ru.dto.ManagerPositionDTO;
import rs.ac.bg.fon.silab.ru.dto.RankDTO;
import rs.ac.bg.fon.silab.ru.dto.TitleDTO;
import rs.ac.bg.fon.silab.ru.mapper.ManagerMapper;
import rs.ac.bg.fon.silab.ru.mapper.ManagerPositionMapper;
import rs.ac.bg.fon.silab.ru.mapper.RankMapper;
import rs.ac.bg.fon.silab.ru.mapper.TitleMapper;
import rs.ac.bg.fon.silab.ru.validator.Validator;
import rs.ac.bg.fon.silab.ru.validator.ValidatorFactory;

/**
 *
 * @author user
 */
@Service
public class ManagerService {
    @Autowired
    GenericDAO genericDao;

    public List<ManagerDTO> getAllManagers() throws Exception{
        List<IDomain> result = genericDao.findAll(new Manager());
        List<ManagerDTO> managers = new LinkedList<>();
        for (IDomain item : result) {
            Manager manager = (Manager) item;
            ManagerDTO managerDTO = ManagerMapper.INSTANCE.managerToManagerDTO(manager);
            managers.add(managerDTO);
        }
        
        return managers;
    }
    
    public ManagerDTO getManager(long id) throws Exception{
        Manager manager = new Manager(id);

        Manager loadedManager = (Manager) genericDao.findById(manager);
        ManagerDTO loadedManagerDTO = ManagerMapper.INSTANCE.managerToManagerDTO(loadedManager);
        
        return loadedManagerDTO;
    }
    
    public ManagerDTO saveManager(ManagerDTO managerDTO) throws Exception {
        Validator managerValidator = ValidatorFactory.create("manager");
        if(!managerValidator.validate(managerDTO)) {
            throw new Exception(managerValidator.getErrorMessage());
        }
        
        Manager manager = ManagerMapper.INSTANCE.managerDTOToManager(managerDTO);
        
        Manager savedManager = (Manager) genericDao.insert(manager);
        ManagerDTO savedManagerDTO = ManagerMapper.INSTANCE.managerToManagerDTO(savedManager);
        
        return savedManagerDTO;
    }
    
    public ManagerDTO updateManager(ManagerDTO managerDTO) throws Exception {
        Manager manager = ManagerMapper.INSTANCE.managerDTOToManager(managerDTO);

        Manager updatedManager = (Manager) genericDao.update(manager);
        ManagerDTO updatedManagerDTO = ManagerMapper.INSTANCE.managerToManagerDTO(updatedManager);
        
        return updatedManagerDTO;
    }
    
    public void deleteManager(long id) throws Exception {
        Manager manager = new Manager(id);
        genericDao.delete(manager);
    }
    
    
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

    public List<TitleDTO> getAllManagerTitles() throws Exception {
        List<IDomain> result = genericDao.findAll(new Title());
        List<TitleDTO> titles = new LinkedList<>();
        for (IDomain item : result) {
            Title title = (Title) item;
            TitleDTO titleDTO = TitleMapper.INSTANCE.titleToTitleDTO(title);
            titles.add(titleDTO);
        }
        
        return titles;
    }

    public List<RankDTO> getAllManagerRanks() throws Exception{
        List<IDomain> result = genericDao.findAll(new Rank());
        List<RankDTO> ranks = new LinkedList<>();
        for (IDomain item : result) {
            Rank rank = (Rank) item;
            RankDTO rankDTO = RankMapper.INSTANCE.rankToRankDTO(rank);
            ranks.add(rankDTO);
        }
        
        return ranks;
    }

    public List<ManagerDTO> getManagersByCriteria(String criteria) throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("term", criteria);
        
        List<IDomain> result = genericDao.findByQueryName("Manager.findBySearchCriteria", params);
        List<ManagerDTO> managers = new LinkedList<>();

        for (IDomain item : result) {
            Manager manager = (Manager) item;
            ManagerDTO managerDTO = ManagerMapper.INSTANCE.managerToManagerDTO(manager);
            managers.add(managerDTO);
        }
        
        return managers;
    }

}
