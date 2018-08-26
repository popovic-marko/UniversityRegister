package rs.ac.bg.fon.silab.ru.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author user
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RankDTO {
    private Long rankId;
    private String name;

    public RankDTO() {
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
