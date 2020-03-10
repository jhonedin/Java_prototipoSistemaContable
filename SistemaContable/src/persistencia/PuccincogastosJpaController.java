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
import modelo.Puccincogastos;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Jhon
 */
public class PuccincogastosJpaController implements Serializable {

    public PuccincogastosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Puccincogastos puccincogastos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(puccincogastos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPuccincogastos(puccincogastos.getCodigo()) != null) {
                throw new PreexistingEntityException("Puccincogastos " + puccincogastos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Puccincogastos puccincogastos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            puccincogastos = em.merge(puccincogastos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = puccincogastos.getCodigo();
                if (findPuccincogastos(id) == null) {
                    throw new NonexistentEntityException("The puccincogastos with id " + id + " no longer exists.");
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
            Puccincogastos puccincogastos;
            try {
                puccincogastos = em.getReference(Puccincogastos.class, id);
                puccincogastos.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The puccincogastos with id " + id + " no longer exists.", enfe);
            }
            em.remove(puccincogastos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Puccincogastos> findPuccincogastosEntities() {
        return findPuccincogastosEntities(true, -1, -1);
    }

    public List<Puccincogastos> findPuccincogastosEntities(int maxResults, int firstResult) {
        return findPuccincogastosEntities(false, maxResults, firstResult);
    }

    private List<Puccincogastos> findPuccincogastosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Puccincogastos.class));
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

    public Puccincogastos findPuccincogastos(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Puccincogastos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPuccincogastosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Puccincogastos> rt = cq.from(Puccincogastos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
