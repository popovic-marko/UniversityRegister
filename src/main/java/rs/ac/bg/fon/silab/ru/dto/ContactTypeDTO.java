package rs.ac.bg.fon.silab.ru.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author user
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactTypeDTO {
    private Long contactTypeId;
    private String name;

    public ContactTypeDTO() {
    }

    public Long getContactTypeId() {
        return contactTypeId;
    }

    public void setContactTypeId(Long contactTypeId) {
        this.contactTypeId = contactTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
