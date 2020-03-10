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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Maestroinventariounomi;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Jhon
 */
public class MaestroinventariounomiJpaController implements Serializable {

    public MaestroinventariounomiJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Maestroinventariounomi maestroinventariounomi) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(maestroinventariounomi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMaestroinventariounomi(maestroinventariounomi.getCodigo()) != null) {
                throw new PreexistingEntityException("Maestroinventariounomi " + maestroinventariounomi + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Maestroinventariounomi maestroinventariounomi) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            maestroinventariounomi = em.merge(maestroinventariounomi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = maestroinventariounomi.getCodigo();
                if (findMaestroinventariounomi(id) == null) {
                    throw new NonexistentEntityException("The maestroinventariounomi with id " + id + " no longer exists.");
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
            Maestroinventariounomi maestroinventariounomi;
            try {
                maestroinventariounomi = em.getReference(Maestroinventariounomi.class, id);
                maestroinventariounomi.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The maestroinventariounomi with id " + id + " no longer exists.", enfe);
            }
            em.remove(maestroinventariounomi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Maestroinventariounomi> findMaestroinventariounomiEntities() {
        return findMaestroinventariounomiEntities(true, -1, -1);
    }

    public List<Maestroinventariounomi> findMaestroinventariounomiEntities(int maxResults, int firstResult) {
        return findMaestroinventariounomiEntities(false, maxResults, firstResult);
    }

    private List<Maestroinventariounomi> findMaestroinventariounomiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Maestroinventariounomi.class));
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

    public Maestroinventariounomi findMaestroinventariounomi(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Maestroinventariounomi.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaestroinventariounomiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Maestroinventariounomi> rt = cq.from(Maestroinventariounomi.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
