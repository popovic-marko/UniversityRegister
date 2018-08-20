package rs.ac.bg.fon.silab.ru.dao;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import rs.ac.bg.fon.silab.ru.persistence.JPAEntityManagerFactory;
import rs.ac.bg.fon.silab.ru.domain.IDomain;

/**
 *
 * @author user
 */
public class GenericDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public GenericDAO() {
        emf = JPAEntityManagerFactory.getInstance();
    }

    public IDomain insert(IDomain entity) throws Exception {
        IDomain entityFound;
        try{
            entityFound = findById(entity);
        } catch(Exception e) {
            // entity doesn't exisist
            entityFound = null;
        }
        if (entityFound == null) {
            try {
                em = emf.createEntityManager();
                em.getTransaction().begin();
                em.persist(entity);
                /*for (IDomain iEntity : otherEntityList) {
                    String iEntityClassName = iEntity.getClass().getName();
                    iEntity.setReferenceObjectId(entity.returnPrimaryKeyValue(), iEntityClassName);
                    em.persist(iEntity);
                }*/
                em.getTransaction().commit();
                em.close();

                return entity;
            } catch (Exception e) {
                if(em != null) {
                    em.getTransaction().rollback();
                    em.close();
                }
                throw new Exception("Greska prilikom cuvanja!");
            }
        } else {
            throw new Exception("Dati objekat vec postoji");
        }
    }

    public IDomain update(IDomain entity) throws Exception {
        IDomain entityFound;
        try {
            entityFound = findById(entity);
        } catch (Exception ex) {
            throw new Exception("Dati objekat ne postoji!");
        }
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            IDomain updatedEntity = em.merge(entity);
            em.getTransaction().commit();
            em.close();
            
            return updatedEntity;
        } catch(Exception ex) {
            if(em != null) {
                em.getTransaction().rollback();
                em.close();
            }
            throw new Exception("Greska prilikom azuriranja objekta");
        }
    }  

    public void delete(IDomain entity) throws Exception {
        IDomain entityFound;
        try {
            entityFound = findById(entity);
        } catch (Exception ex) {
            throw new Exception("Dati objekat ne postoji!");
        }
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            entityFound = em.merge(entityFound);
            em.remove(entityFound);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if(em != null) {
                em.getTransaction().rollback();
                em.close();
            }
            System.out.println("============ GRESKA =========================");
            System.out.println(e.getMessage());
            System.out.println("============ GRESKA =========================");
            throw new Exception("Greska prilikom brisanja objekta!");
        }
            
    } 

    public List<IDomain> findAll(IDomain entity) throws Exception {
        String className = entity.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = className + ".findAll";
        List<IDomain> result = new LinkedList<>();

        try {
            em = emf.createEntityManager();
            Query q = em.createNamedQuery(query);
            
            List<IDomain> entities = q.getResultList();
            em.close();
            
            for (IDomain ido : entities) {
                if(!result.contains(ido)) {
                    result.add(ido);
                }
            }
            
            return result;
        } catch (Exception e) {
            if(em != null) {
                em.close();
            }
            System.out.println("============== generic =======================");
            System.out.println("================ " + e.getMessage() + "======");
            System.out.println("=============================================");
            throw new Exception("Greska prilikom ucitavanja");
        }
    }

    public IDomain findById(IDomain entity) throws Exception {
        try {
            String className = entity.getClass().getName();
            className = className.substring(className.lastIndexOf(".") + 1);
            String query = className + ".findById";

            em = emf.createEntityManager();
            Query q = em.createNamedQuery(query);
            q.setParameter(entity.returnPrimaryKeyName(), entity.returnPrimaryKeyValue());

            IDomain result = (IDomain) q.getSingleResult();
            em.close();
            
            return result;
        } catch(Exception e) {
            if(em != null) {
                em.close();
            }
            System.out.println("================ generic ====================");
            System.out.println("================ " + e.getMessage() + "======");
            System.out.println("=============================================");
            throw new Exception("Greska prilikom ucitavanja!");
        }

    }

    public void findByQuery() {
    }

}
