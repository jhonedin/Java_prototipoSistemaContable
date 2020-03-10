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
import modelo.Registroingresos;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Jhon
 */
public class RegistroingresosJpaController implements Serializable {

    public RegistroingresosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("SistemaContablePU");
    }
        
    public RegistroingresosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Registroingresos registroingresos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(registroingresos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Registroingresos registroingresos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            registroingresos = em.merge(registroingresos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = registroingresos.getNumregistro();
                if (findRegistroingresos(id) == null) {
                    throw new NonexistentEntityException("The registroingresos with id " + id + " no longer exists.");
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
            Registroingresos registroingresos;
            try {
                registroingresos = em.getReference(Registroingresos.class, id);
                registroingresos.getNumregistro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registroingresos with id " + id + " no longer exists.", enfe);
            }
            em.remove(registroingresos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Registroingresos> findRegistroingresosEntities() {
        return findRegistroingresosEntities(true, -1, -1);
    }

    public List<Registroingresos> findRegistroingresosEntities(int maxResults, int firstResult) {
        return findRegistroingresosEntities(false, maxResults, firstResult);
    }

    private List<Registroingresos> findRegistroingresosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Registroingresos.class));
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

    public Registroingresos findRegistroingresos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Registroingresos.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistroingresosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Registroingresos> rt = cq.from(Registroingresos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
