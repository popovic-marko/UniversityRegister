package rs.ac.bg.fon.silab.ru.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import rs.ac.bg.fon.silab.ru.domain.ManagerPosition;
import rs.ac.bg.fon.silab.ru.dto.ManagerPositionDTO;

/**
 *
 * @author user
 */
@Mapper
public interface ManagerPositionMapper {
    ManagerPositionMapper INSTANCE = Mappers.getMapper(ManagerPositionMapper.class);
    
    ManagerPositionDTO managerPositionToManagerPositionDTO(ManagerPosition managerPosition);

    ManagerPosition managerPositionDTOToManagerPosition(ManagerPositionDTO managerPositionDTO);
}
