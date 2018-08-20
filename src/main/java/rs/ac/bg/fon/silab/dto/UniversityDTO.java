package rs.ac.bg.fon.silab.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import java.util.List;
import rs.ac.bg.fon.silab.domain.City;
import rs.ac.bg.fon.silab.domain.Contact;
import rs.ac.bg.fon.silab.domain.ManagementPeriod;


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
    private City city;
    private List<Contact> contacts;
    private List<ManagementPeriod> managementPeriods;

    public UniversityDTO(Long universityId, String name, String type, Date dateOfEstablishment, Integer numberOfFaculty, City city) {
        this.universityId = universityId;
        this.name = name;
        this.type = type;
        this.dateOfEstablishment = dateOfEstablishment;
        this.numberOfFaculty = numberOfFaculty;
        this.city = city;
    }
    
    public UniversityDTO(Long universityId, String name, String type, Date dateOfEstablishment, Integer numberOfFaculty, City city, List<Contact> contacts, List<ManagementPeriod> managementPeriods) {
        this.universityId = universityId;
        this.name = name;
        this.type = type;
        this.dateOfEstablishment = dateOfEstablishment;
        this.numberOfFaculty = numberOfFaculty;
        this.city = city;
        this.contacts = contacts;
        this.managementPeriods = managementPeriods;
    }

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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<ManagementPeriod> getManagementPeriods() {
        return managementPeriods;
    }

    public void setManagementPeriods(List<ManagementPeriod> managementPeriods) {
        this.managementPeriods = managementPeriods;
    }
    
    
}
