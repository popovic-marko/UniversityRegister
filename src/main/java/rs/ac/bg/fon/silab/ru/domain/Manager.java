package rs.ac.bg.fon.silab.ru.domain;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "manager")
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "SELECT m FROM Manager m ORDER BY m.lastName, m.firstName"),
    @NamedQuery(name = "Manager.findById", query = "SELECT m FROM Manager m WHERE m.managerId = :managerId"),
    @NamedQuery(name = "Manager.findByFirstName", query = "SELECT m FROM Manager m WHERE m.firstName = :firstName"),
    @NamedQuery(name = "Manager.findByLastName", query = "SELECT m FROM Manager m WHERE m.lastName = :lastName"),
    @NamedQuery(name = "Manager.findBySearchCriteria", query = "SELECT m FROM Manager m WHERE m.lastName LIKE " + 
            "CONCAT('%', :term, '%') OR m.firstName LIKE CONCAT('%', :term, '%') OR m.title.name LIKE " +
            "CONCAT('%', :term, '%') OR m.rank.name LIKE CONCAT('%', :term, '%') ORDER BY m.lastName, m.firstName")})
public class Manager implements IDomain, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "managerId")
    private Long managerId;
	
    @Size(max = 50)
    @Column(name = "firstName")
    private String firstName;
	
    @Size(max = 50)
    @Column(name = "lastName")
    private String lastName;
	
    @JoinColumn(name = "rank_fk", referencedColumnName = "rankId")
    @ManyToOne
    private Rank rank;
	
    @JoinColumn(name = "title_fk", referencedColumnName = "titleId")
    @ManyToOne
    private Title title;

    public Manager() {
    }

    public Manager(Long managerId) {
        this.managerId = managerId;
    }

    public Manager(Long managerId, String firstName, String lastName) {
        this.managerId = managerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (managerId != null ? managerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.managerId == null && other.managerId != null) || (this.managerId != null && !this.managerId.equals(other.managerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.domen.Manager[ managerId=" + managerId + " ]";
    }

    @Override
    public Long returnPrimaryKeyValue() {
        return managerId;
    }

    @Override
    public String returnPrimaryKeyName() {
        return "managerId";
    }

    @Override
    public void setReferenceObjectId(Long id, String referenceObjectClassName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
