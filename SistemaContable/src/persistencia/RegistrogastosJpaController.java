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
import modelo.Registrogastos;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Jhon
 */
public class RegistrogastosJpaController implements Serializable {

    public RegistrogastosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("SistemaContablePU");
    }
        
    public RegistrogastosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Registrogastos registrogastos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(registrogastos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Registrogastos registrogastos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            registrogastos = em.merge(registrogastos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = registrogastos.getNumregistro();
                if (findRegistrogastos(id) == null) {
                    throw new NonexistentEntityException("The registrogastos with id " + id + " no longer exists.");
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
            Registrogastos registrogastos;
            try {
                registrogastos = em.getReference(Registrogastos.class, id);
                registrogastos.getNumregistro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registrogastos with id " + id + " no longer exists.", enfe);
            }
            em.remove(registrogastos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Registrogastos> findRegistrogastosEntities() {
        return findRegistrogastosEntities(true, -1, -1);
    }

    public List<Registrogastos> findRegistrogastosEntities(int maxResults, int firstResult) {
        return findRegistrogastosEntities(false, maxResults, firstResult);
    }

    private List<Registrogastos> findRegistrogastosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Registrogastos.class));
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

    public Registrogastos findRegistrogastos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Registrogastos.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistrogastosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Registrogastos> rt = cq.from(Registrogastos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
