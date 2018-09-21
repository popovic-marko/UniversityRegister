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
@Table(name = "country")
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
    @NamedQuery(name = "Country.findById", query = "SELECT c FROM Country c WHERE c.countryId = :countryId"),
    @NamedQuery(name = "Country.findByFullName", query = "SELECT c FROM Country c WHERE c.fullName = :fullName"),
    @NamedQuery(name = "Country.findByAbbreviatedName", query = "SELECT c FROM Country c WHERE c.countryISO = :countryISO")})
public class Country implements IDomain, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "countryId")
    private Long countryId;
	
    @Size(max = 50)
    @Column(name = "fullName")
    private String fullName;
	
    @Size(max = 5)
    @Column(name = "countryIso")
    private String countryISO;

    public Country() {
    }

    public Country(Long countryId) {
        this.countryId = countryId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCountryISO() {
        return countryISO;
    }

    public void setCountryISO(String countryISO) {
        this.countryISO = countryISO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.domen.Country[ countryId=" + countryId + " ]";
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
