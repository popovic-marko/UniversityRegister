package rs.ac.bg.fon.silab.ru.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import rs.ac.bg.fon.silab.ru.domain.ManagementPeriod;
import rs.ac.bg.fon.silab.ru.dto.ManagementPeriodDTO;

/**
 *
 * @author user
 */
@Mapper
public interface ManagementPeriodMapper {
    ManagementPeriodMapper INSTANCE = Mappers.getMapper(ManagementPeriodMapper.class);
    
    ManagementPeriodDTO managementPeriodToManagementPeriodDTO(ManagementPeriod managementPeriod);

    ManagementPeriod managementPeriodDTOToManagementPeriod(ManagementPeriodDTO managementPeriodDTO);
}
