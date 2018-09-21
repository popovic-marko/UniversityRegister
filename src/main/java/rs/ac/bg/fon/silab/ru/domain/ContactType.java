package rs.ac.bg.fon.silab.ru.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "contact_type")
@NamedQueries({
    @NamedQuery(name = "ContactType.findAll", query = "SELECT c FROM ContactType c ORDER BY c.name"),
    @NamedQuery(name = "ContactType.findById", query = "SELECT c FROM ContactType c WHERE c.contactTypeId = :contactTypeId"),
    @NamedQuery(name = "ContactType.findByName", query = "SELECT c FROM ContactType c WHERE c.name = :name")})
public class ContactType implements IDomain, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contactTypeId")
    private Long contactTypeId;
	
    @Size(max = 20)
    @Column(name = "name")
    private String name;

    public ContactType() {
    }

    public ContactType(Long contactTypeId) {
        this.contactTypeId = contactTypeId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactTypeId != null ? contactTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactType)) {
            return false;
        }
        ContactType other = (ContactType) object;
        if ((this.contactTypeId == null && other.contactTypeId != null) || (this.contactTypeId != null && !this.contactTypeId.equals(other.contactTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.domen.ContactType[ contactTypeId=" + contactTypeId + " ]";
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
