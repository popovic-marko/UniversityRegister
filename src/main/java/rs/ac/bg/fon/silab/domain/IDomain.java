package rs.ac.bg.fon.silab.domain;

/**
 *
 * @author user
 */
public interface IDomain {
    public Long returnPrimaryKeyValue();

    public String returnPrimaryKeyName();
    
    public void setReferenceObjectId(Long id, String referenceObjectClassName);
}
