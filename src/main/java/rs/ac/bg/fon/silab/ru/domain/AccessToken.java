package rs.ac.bg.fon.silab.ru.domain;

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
@Table(name = "access_token")
@NamedQueries({
    @NamedQuery(name = "AccessToken.findAll", query = "SELECT a FROM AccessToken a"),
    @NamedQuery(name = "AccessToken.findById", query = "SELECT a FROM AccessToken a WHERE a.id = :id"),
    @NamedQuery(name = "AccessToken.findByToken", query = "SELECT a FROM AccessToken a WHERE a.token = :token"),
    @NamedQuery(name = "AccessToken.findByExpire", query = "SELECT a FROM AccessToken a WHERE a.expire = :expire"),
    @NamedQuery(name = "AccessToken.findByUser", query = "SELECT a FROM AccessToken a WHERE a.user.id = :userId")})
public class AccessToken implements Serializable, IDomain{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "token")
    private String token;
    
    @Column(name = "expire")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expire;
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    public AccessToken() {
    }

    public AccessToken(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AccessToken)) {
            return false;
        }
        AccessToken other = (AccessToken) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.ru.AccessToken[ id=" + id + " ]";
    }

    @Override
    public Long returnPrimaryKeyValue() {
        return id;
    }

    @Override
    public String returnPrimaryKeyName() {
        return "id";
    }

    @Override
    public void setReferenceObjectId(Long id, String referenceObjectClassName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
