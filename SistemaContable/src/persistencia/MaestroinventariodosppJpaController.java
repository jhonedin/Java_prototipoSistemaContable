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
import modelo.Maestroinventariodospp;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Jhon
 */
public class MaestroinventariodosppJpaController implements Serializable {

    public MaestroinventariodosppJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Maestroinventariodospp maestroinventariodospp) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(maestroinventariodospp);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMaestroinventariodospp(maestroinventariodospp.getCodigo()) != null) {
                throw new PreexistingEntityException("Maestroinventariodospp " + maestroinventariodospp + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Maestroinventariodospp maestroinventariodospp) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            maestroinventariodospp = em.merge(maestroinventariodospp);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = maestroinventariodospp.getCodigo();
                if (findMaestroinventariodospp(id) == null) {
                    throw new NonexistentEntityException("The maestroinventariodospp with id " + id + " no longer exists.");
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
            Maestroinventariodospp maestroinventariodospp;
            try {
                maestroinventariodospp = em.getReference(Maestroinventariodospp.class, id);
                maestroinventariodospp.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The maestroinventariodospp with id " + id + " no longer exists.", enfe);
            }
            em.remove(maestroinventariodospp);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Maestroinventariodospp> findMaestroinventariodosppEntities() {
        return findMaestroinventariodosppEntities(true, -1, -1);
    }

    public List<Maestroinventariodospp> findMaestroinventariodosppEntities(int maxResults, int firstResult) {
        return findMaestroinventariodosppEntities(false, maxResults, firstResult);
    }

    private List<Maestroinventariodospp> findMaestroinventariodosppEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Maestroinventariodospp.class));
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

    public Maestroinventariodospp findMaestroinventariodospp(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Maestroinventariodospp.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaestroinventariodosppCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Maestroinventariodospp> rt = cq.from(Maestroinventariodospp.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
