package rs.ac.bg.fon.silab.ru.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import rs.ac.bg.fon.silab.ru.domain.Rank;
import rs.ac.bg.fon.silab.ru.dto.RankDTO;

/**
 *
 * @author user
 */
@Mapper
public interface RankMapper {
    RankMapper INSTANCE = Mappers.getMapper(RankMapper.class);
    
    RankDTO rankToRankDTO(Rank rank);

    Rank rankDTOToRank(RankDTO rankDTO);
}
