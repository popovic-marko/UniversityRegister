package rs.ac.bg.fon.silab.ru.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import rs.ac.bg.fon.silab.ru.domain.Manager;
import rs.ac.bg.fon.silab.ru.dto.ManagerDTO;

/**
 *
 * @author user
 */
@Mapper
public interface ManagerMapper {
    ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);
    
    ManagerDTO managerToManagerDTO(Manager manager);

    Manager managerDTOToManager(ManagerDTO managerDTO);
}
