package rs.ac.bg.fon.silab.ru.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FacultyDTO {
    private Long facultyId;
    private String name;
    private String type;
    private String termsOfEnrollment;
    private String durationOfStudies;
    private Date dateOfAccreditation;
    private Integer capacity;
    @JsonManagedReference(value = "faculty-contacts")
    private List<ContactDTO> contacts;
    @JsonManagedReference(value = "faculty-managementPeriods")
    private List<ManagementPeriodDTO> managementPeriods;
    private UniversityDTO university;

    public FacultyDTO() {
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTermsOfEnrollment() {
        return termsOfEnrollment;
    }

    public void setTermsOfEnrollment(String termsOfEnrollment) {
        this.termsOfEnrollment = termsOfEnrollment;
    }

    public String getDurationOfStudies() {
        return durationOfStudies;
    }

    public void setDurationOfStudies(String durationOfStudies) {
        this.durationOfStudies = durationOfStudies;
    }

    public Date getDateOfAccreditation() {
        return dateOfAccreditation;
    }

    public void setDateOfAccreditation(Date dateOfAccreditation) {
        this.dateOfAccreditation = dateOfAccreditation;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }

    public List<ManagementPeriodDTO> getManagementPeriods() {
        return managementPeriods;
    }

    public void setManagementPeriods(List<ManagementPeriodDTO> managementPeriods) {
        this.managementPeriods = managementPeriods;
    }

    public UniversityDTO getUniversity() {
        return university;
    }

    public void setUniversity(UniversityDTO university) {
        this.university = university;
    }

    
}
