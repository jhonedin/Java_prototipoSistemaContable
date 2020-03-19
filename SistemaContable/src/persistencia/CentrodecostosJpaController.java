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
import modelo.Centrodecostos;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Jhon
 */
public class CentrodecostosJpaController implements Serializable {
    
    public CentrodecostosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("SistemaContablePU");
    }
    
    public CentrodecostosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Centrodecostos centrodecostos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(centrodecostos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCentrodecostos(centrodecostos.getCodigo()) != null) {
                throw new PreexistingEntityException("Centrodecostos " + centrodecostos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Centrodecostos centrodecostos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            centrodecostos = em.merge(centrodecostos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = centrodecostos.getCodigo();
                if (findCentrodecostos(id) == null) {
                    throw new NonexistentEntityException("The centrodecostos with id " + id + " no longer exists.");
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
            Centrodecostos centrodecostos;
            try {
                centrodecostos = em.getReference(Centrodecostos.class, id);
                centrodecostos.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The centrodecostos with id " + id + " no longer exists.", enfe);
            }
            em.remove(centrodecostos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Centrodecostos> findCentrodecostosEntities() {
        return findCentrodecostosEntities(true, -1, -1);
    }

    public List<Centrodecostos> findCentrodecostosEntities(int maxResults, int firstResult) {
        return findCentrodecostosEntities(false, maxResults, firstResult);
    }

    private List<Centrodecostos> findCentrodecostosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Centrodecostos.class));
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

    public Centrodecostos findCentrodecostos(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Centrodecostos.class, id);
        } finally {
            em.close();
        }
    }

    public int getCentrodecostosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Centrodecostos> rt = cq.from(Centrodecostos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
