package rs.ac.bg.fon.silab.ru.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author user
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TitleDTO {
    private Long titleId;
    private String name;

    public TitleDTO() {
    }

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
