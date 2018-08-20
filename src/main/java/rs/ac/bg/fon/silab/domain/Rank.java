package rs.ac.bg.fon.silab.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "rank")
@NamedQueries({
/*    @NamedQuery(name = "Rank.findAll", query = "SELECT r FROM Rank r"),*/
    @NamedQuery(name = "Rank.findById", query = "SELECT r FROM Rank r WHERE r.rankId = :rankId"),
    @NamedQuery(name = "Rank.findByName", query = "SELECT r FROM Rank r WHERE r.name = :name")})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rank implements IDomain, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rankId")
    private Long rankId;
    @Size(max = 50)
    @Column(name = "name")
    private String name;

    public Rank() {
    }

    public Rank(Long rankId) {
        this.rankId = rankId;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
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
        hash += (rankId != null ? rankId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rank)) {
            return false;
        }
        Rank other = (Rank) object;
        if ((this.rankId == null && other.rankId != null) || (this.rankId != null && !this.rankId.equals(other.rankId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.domen.Rank[ rankId=" + rankId + " ]";
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
