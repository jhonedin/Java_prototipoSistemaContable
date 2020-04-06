/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Maestroinventariocompleto;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Jhon
 */
public class MaestroinventariocompletoJpaController implements Serializable {
    
    public MaestroinventariocompletoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("SistemaContablePU");
    }
    
    public MaestroinventariocompletoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Maestroinventariocompleto maestroinventariocompleto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(maestroinventariocompleto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMaestroinventariocompleto(maestroinventariocompleto.getCodigo()) != null) {
                throw new PreexistingEntityException("Maestroinventariocompleto " + maestroinventariocompleto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Maestroinventariocompleto maestroinventariocompleto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            maestroinventariocompleto = em.merge(maestroinventariocompleto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = maestroinventariocompleto.getCodigo();
                if (findMaestroinventariocompleto(id) == null) {
                    throw new NonexistentEntityException("The maestroinventariocompleto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Maestroinventariocompleto maestroinventariocompleto;
            try {
                maestroinventariocompleto = em.getReference(Maestroinventariocompleto.class, id);
                maestroinventariocompleto.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The maestroinventariocompleto with id " + id + " no longer exists.", enfe);
            }
            em.remove(maestroinventariocompleto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Maestroinventariocompleto> findMaestroinventariocompletoEntities() {
        return findMaestroinventariocompletoEntities(true, -1, -1);
    }

    public List<Maestroinventariocompleto> findMaestroinventariocompletoEntities(int maxResults, int firstResult) {
        return findMaestroinventariocompletoEntities(false, maxResults, firstResult);
    }

    private List<Maestroinventariocompleto> findMaestroinventariocompletoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Maestroinventariocompleto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Maestroinventariocompleto findMaestroinventariocompleto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Maestroinventariocompleto.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaestroinventariocompletoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Maestroinventariocompleto> rt = cq.from(Maestroinventariocompleto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
