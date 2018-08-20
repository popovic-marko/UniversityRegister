package rs.ac.bg.fon.silab.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "faculty")
@NamedQueries({
    @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f"),
    @NamedQuery(name = "Faculty.findById", query = "SELECT f FROM Faculty f WHERE f.facultyId = :facultyId"),
    @NamedQuery(name = "Faculty.findByName", query = "SELECT f FROM Faculty f WHERE f.name = :name"),
    @NamedQuery(name = "Faculty.findByType", query = "SELECT f FROM Faculty f WHERE f.type = :type"),
    @NamedQuery(name = "Faculty.findByTermsOfEnrollment", query = "SELECT f FROM Faculty f WHERE f.termsOfEnrollment = :termsOfEnrollment"),
    @NamedQuery(name = "Faculty.findByDurationOfStudies", query = "SELECT f FROM Faculty f WHERE f.durationOfStudies = :durationOfStudies"),
    @NamedQuery(name = "Faculty.findByDateOfAccreditation", query = "SELECT f FROM Faculty f WHERE f.dateOfAccreditation = :dateOfAccreditation"),
    @NamedQuery(name = "Faculty.findByCapacity", query = "SELECT f FROM Faculty f WHERE f.capacity = :capacity")})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Faculty implements IDomain, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "facultyId")
    private Long facultyId;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 20)
    @Column(name = "type")
    private String type;
    @Size(max = 250)
    @Column(name = "termsOfEnrollment")
    private String termsOfEnrollment;
    @Size(max = 50)
    @Column(name = "durationOfStudies")
    private String durationOfStudies;
    @Column(name = "dateOfAccreditation")
    @Temporal(TemporalType.DATE)
    private Date dateOfAccreditation;
    @Column(name = "capacity")
    private Integer capacity;
    @OneToMany(mappedBy = "faculty")
    private List<Contact> contacts;
    @OneToMany(mappedBy = "faculty")
    private List<ManagementPeriod> managementPeriods;
    @JoinColumn(name = "university_fk", referencedColumnName = "universityId")
    @ManyToOne
    private University university;

    public Faculty() {
    }

    public Faculty(Long facultyId) {
        this.facultyId = facultyId;
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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facultyId != null ? facultyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faculty)) {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.facultyId == null && other.facultyId != null) || (this.facultyId != null && !this.facultyId.equals(other.facultyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.domen.Faculty[ facultyId=" + facultyId + " ]";
    }

    @Override
    public Long returnPrimaryKeyValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnPrimaryKeyName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setReferenceObjectId(Long id, String referenceObjectClassName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
