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
public class UniversityDTO {
    private Long universityId;
    private String name;
    private String type;
    private Date dateOfEstablishment;
    private Integer numberOfFaculty;
    private CityDTO city;
    @JsonManagedReference(value = "university-contacts")
    private List<ContactDTO> contacts;
    @JsonManagedReference(value = "university-managementPeriods")
    private List<ManagementPeriodDTO> managementPeriods;

    public UniversityDTO() {
    }
    
    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
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

    public Date getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setDateOfEstablishment(Date dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public Integer getNumberOfFaculty() {
        return numberOfFaculty;
    }

    public void setNumberOfFaculty(Integer numberOfFaculty) {
        this.numberOfFaculty = numberOfFaculty;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
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
    
    
}
