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
import modelo.Pucseiscostos;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Jhon
 */
public class PucseiscostosJpaController implements Serializable {

    public PucseiscostosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pucseiscostos pucseiscostos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pucseiscostos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPucseiscostos(pucseiscostos.getCodigo()) != null) {
                throw new PreexistingEntityException("Pucseiscostos " + pucseiscostos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pucseiscostos pucseiscostos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pucseiscostos = em.merge(pucseiscostos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pucseiscostos.getCodigo();
                if (findPucseiscostos(id) == null) {
                    throw new NonexistentEntityException("The pucseiscostos with id " + id + " no longer exists.");
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
            Pucseiscostos pucseiscostos;
            try {
                pucseiscostos = em.getReference(Pucseiscostos.class, id);
                pucseiscostos.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pucseiscostos with id " + id + " no longer exists.", enfe);
            }
            em.remove(pucseiscostos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pucseiscostos> findPucseiscostosEntities() {
        return findPucseiscostosEntities(true, -1, -1);
    }

    public List<Pucseiscostos> findPucseiscostosEntities(int maxResults, int firstResult) {
        return findPucseiscostosEntities(false, maxResults, firstResult);
    }

    private List<Pucseiscostos> findPucseiscostosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pucseiscostos.class));
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

    public Pucseiscostos findPucseiscostos(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pucseiscostos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPucseiscostosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pucseiscostos> rt = cq.from(Pucseiscostos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
