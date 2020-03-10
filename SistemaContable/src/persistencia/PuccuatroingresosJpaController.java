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
import modelo.Puccuatroingresos;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Jhon
 */
public class PuccuatroingresosJpaController implements Serializable {

    public PuccuatroingresosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Puccuatroingresos puccuatroingresos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(puccuatroingresos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPuccuatroingresos(puccuatroingresos.getCodigo()) != null) {
                throw new PreexistingEntityException("Puccuatroingresos " + puccuatroingresos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Puccuatroingresos puccuatroingresos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            puccuatroingresos = em.merge(puccuatroingresos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = puccuatroingresos.getCodigo();
                if (findPuccuatroingresos(id) == null) {
                    throw new NonexistentEntityException("The puccuatroingresos with id " + id + " no longer exists.");
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
            Puccuatroingresos puccuatroingresos;
            try {
                puccuatroingresos = em.getReference(Puccuatroingresos.class, id);
                puccuatroingresos.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The puccuatroingresos with id " + id + " no longer exists.", enfe);
            }
            em.remove(puccuatroingresos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Puccuatroingresos> findPuccuatroingresosEntities() {
        return findPuccuatroingresosEntities(true, -1, -1);
    }

    public List<Puccuatroingresos> findPuccuatroingresosEntities(int maxResults, int firstResult) {
        return findPuccuatroingresosEntities(false, maxResults, firstResult);
    }

    private List<Puccuatroingresos> findPuccuatroingresosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Puccuatroingresos.class));
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

    public Puccuatroingresos findPuccuatroingresos(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Puccuatroingresos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPuccuatroingresosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Puccuatroingresos> rt = cq.from(Puccuatroingresos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
