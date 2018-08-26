package rs.ac.bg.fon.silab.ru.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;

/**
 *
 * @author user
 */
public class ManagementPeriodDTO {
    private Long managingId;
    private Date dateFrom;
    private Date dateTo;
    @JsonBackReference(value = "faculty-managementPeriods")
    private FacultyDTO faculty;
    private ManagerPositionDTO position;
    private ManagerDTO facultyManager;
    private ManagerDTO universityManager;
    @JsonBackReference(value = "university-managementPeriods")
    private UniversityDTO university;

    public ManagementPeriodDTO() {
    }

    public Long getManagingId() {
        return managingId;
    }

    public void setManagingId(Long managingId) {
        this.managingId = managingId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

  @JsonInclude(JsonInclude.Include.NON_NULL)  
    public FacultyDTO getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyDTO faculty) {
        this.faculty = faculty;
    }   

    public ManagerPositionDTO getPosition() {
        return position;
    }

    public void setPosition(ManagerPositionDTO position) {
        this.position = position;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ManagerDTO getFacultyManager() {
        return facultyManager;
    }

    public void setFacultyManager(ManagerDTO facultyManager) {
        this.facultyManager = facultyManager;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ManagerDTO getUniversityManager() {
        return universityManager;
    }

    public void setUniversityManager(ManagerDTO universityManager) {
        this.universityManager = universityManager;
    }

  @JsonInclude(JsonInclude.Include.NON_NULL)  
    public UniversityDTO getUniversity() {
        return university;
    }

    public void setUniversity(UniversityDTO university) {
        this.university = university;
    }           
    
    
}
