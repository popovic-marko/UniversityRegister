package rs.ac.bg.fon.silab.ru.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "university")
@NamedQueries({
    @NamedQuery(name = "University.findAllShort", query = "SELECT u FROM University u"),
    @NamedQuery(name = "University.findByIdShort", query = "SELECT u FROM University u WHERE u.universityId = :universityId"),
    @NamedQuery(name = "University.findByName", query = "SELECT u FROM University u WHERE u.name = :name"),
    @NamedQuery(name = "University.findByType", query = "SELECT u FROM University u WHERE u.type = :type"),
    @NamedQuery(name = "University.findByDateOfEstablishment", query = "SELECT u FROM University u WHERE u.dateOfEstablishment = :dateOfEstablishment"),
    @NamedQuery(name = "University.findByNumberOfFaculty", query = "SELECT u FROM University u WHERE u.numberOfFaculty = :numberOfFaculty"),
    @NamedQuery(name = "University.findById", query = "SELECT u FROM University u LEFT OUTER JOIN FETCH u.contacts c LEFT OUTER JOIN FETCH u.managementPeriods mp WHERE u.universityId = :universityId"),
    @NamedQuery(name = "University.findAll", query = "SELECT u FROM University u LEFT OUTER JOIN FETCH u.contacts c LEFT OUTER JOIN FETCH u.managementPeriods mp ORDER BY u.universityId")})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class University implements IDomain, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "universityId")
    private Long universityId;
    @Size(max = 250)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "type")
    private String type;
    @Column(name = "dateOfEstablishment")
    @Temporal(TemporalType.DATE)
    private Date dateOfEstablishment;
    @Column(name = "numberOfFaculty")
    private Integer numberOfFaculty;
    @JoinColumn(name = "city_fk", referencedColumnName = "cityId")
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Contact> contacts;
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ManagementPeriod> managementPeriods;

    public University() {
    }

    public University(Long universityId) {
        this.universityId = universityId;
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

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<ManagementPeriod> getManagementPeriods() {
        return managementPeriods;
    }

    public void setManagementPeriods(Set<ManagementPeriod> managementPeriods) {
        this.managementPeriods = managementPeriods;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (universityId != null ? universityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof University)) {
            return false;
        }
        University other = (University) object;
        if ((this.universityId == null && other.universityId != null) || (this.universityId != null && !this.universityId.equals(other.universityId))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.domen.University[ universityId=" + universityId + " ]";
    }

    @Override
    public Long returnPrimaryKeyValue() {
        return universityId;
    }

    @Override
    public String returnPrimaryKeyName() {
        return "universityId";
    }

    @Override
    public void setReferenceObjectId(Long id, String referenceObjectClassName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
