package rs.ac.bg.fon.silab.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author user
 */
@Entity
@Table(name = "management_period")
@NamedQueries({
    @NamedQuery(name = "ManagementPeriod.findAll", query = "SELECT m FROM ManagementPeriod m"),
    @NamedQuery(name = "ManagementPeriod.findById", query = "SELECT m FROM ManagementPeriod m WHERE m.managingId = :managingId"),
    @NamedQuery(name = "ManagementPeriod.findByDateFrom", query = "SELECT m FROM ManagementPeriod m WHERE m.dateFrom = :dateFrom"),
    @NamedQuery(name = "ManagementPeriod.findByDateTo", query = "SELECT m FROM ManagementPeriod m WHERE m.dateTo = :dateTo")})
public class ManagementPeriod implements IDomain, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "managingId")
    private Long managingId;
    @Column(name = "dateFrom")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "dateTo")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @JoinColumn(name = "faculty_fk", referencedColumnName = "facultyId")
    @ManyToOne
    private Faculty faculty;
    @JoinColumn(name = "position_fk", referencedColumnName = "positionId")
    @ManyToOne
    private ManagerPosition position;
    @JoinColumn(name = "manager_f_fk", referencedColumnName = "managerId")
    @ManyToOne
    private Manager facultyManager;
    @JoinColumn(name = "manager_u_fk", referencedColumnName = "managerId")
    @ManyToOne
    private Manager universityManager;
    @JoinColumn(name = "university_fk", referencedColumnName = "universityId")
    @ManyToOne
    @JsonBackReference
    private University university;

    public ManagementPeriod() {
    }

    public ManagementPeriod(Long managingId) {
        this.managingId = managingId;
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
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public ManagerPosition getPosition() {
        return position;
    }

    public void setPosition(ManagerPosition position) {
        this.position = position;
    }
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Manager getFacultyManager() {
        return facultyManager;
    }

    public void setFacultyManager(Manager facultyManager) {
        this.facultyManager = facultyManager;
    }
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Manager getUniversityManager() {
        return universityManager;
    }

    public void setUniversityManager(Manager universityManager) {
        this.universityManager = universityManager;
    }
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (managingId != null ? managingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ManagementPeriod)) {
            return false;
        }
        ManagementPeriod other = (ManagementPeriod) object;
        /* moj dodatak */
        if(this.managingId == null && other.managingId == null) {
            return false;
        }
        /* */
        if ((this.managingId == null && other.managingId != null) || (this.managingId != null && !this.managingId.equals(other.managingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.domen.ManagementPeriod[ managingId=" + managingId + " ]";
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
