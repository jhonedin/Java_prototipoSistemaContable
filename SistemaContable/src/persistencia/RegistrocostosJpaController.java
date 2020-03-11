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
import modelo.Registrocostos;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Jhon
 */
public class RegistrocostosJpaController implements Serializable {

    public RegistrocostosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("SistemaContablePU");
    }
    
    public RegistrocostosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Registrocostos registrocostos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(registrocostos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Registrocostos registrocostos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            registrocostos = em.merge(registrocostos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = registrocostos.getNumregistro();
                if (findRegistrocostos(id) == null) {
                    throw new NonexistentEntityException("The registrocostos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Registrocostos registrocostos;
            try {
                registrocostos = em.getReference(Registrocostos.class, id);
                registrocostos.getNumregistro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registrocostos with id " + id + " no longer exists.", enfe);
            }
            em.remove(registrocostos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Registrocostos> findRegistrocostosEntities() {
        return findRegistrocostosEntities(true, -1, -1);
    }

    public List<Registrocostos> findRegistrocostosEntities(int maxResults, int firstResult) {
        return findRegistrocostosEntities(false, maxResults, firstResult);
    }

    private List<Registrocostos> findRegistrocostosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Registrocostos.class));
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

    public Registrocostos findRegistrocostos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Registrocostos.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistrocostosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Registrocostos> rt = cq.from(Registrocostos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
