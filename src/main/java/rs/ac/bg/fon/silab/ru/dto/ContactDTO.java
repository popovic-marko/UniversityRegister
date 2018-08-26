package rs.ac.bg.fon.silab.ru.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author user
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactDTO {
    private Long contactId;
    private String value;
    private ContactTypeDTO contactType;
    @JsonBackReference(value = "faculty-contacts")
    private FacultyDTO faculty; 
    @JsonBackReference(value = "university-contacts")
    private UniversityDTO university;

    public ContactDTO() {
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ContactTypeDTO getContactType() {
        return contactType;
    }

    public void setContactType(ContactTypeDTO contactType) {
        this.contactType = contactType;
    }

    public FacultyDTO getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyDTO faculty) {
        this.faculty = faculty;
    }           

    public UniversityDTO getUniversity() {
        return university;
    }

    public void setUniversity(UniversityDTO university) {
        this.university = university;
    }       
    
    
}
