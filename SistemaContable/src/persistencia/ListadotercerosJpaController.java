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
import modelo.Listadoterceros;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Jhon
 */
public class ListadotercerosJpaController implements Serializable {

    public ListadotercerosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Listadoterceros listadoterceros) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(listadoterceros);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Listadoterceros listadoterceros) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            listadoterceros = em.merge(listadoterceros);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = listadoterceros.getId();
                if (findListadoterceros(id) == null) {
                    throw new NonexistentEntityException("The listadoterceros with id " + id + " no longer exists.");
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
            Listadoterceros listadoterceros;
            try {
                listadoterceros = em.getReference(Listadoterceros.class, id);
                listadoterceros.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The listadoterceros with id " + id + " no longer exists.", enfe);
            }
            em.remove(listadoterceros);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Listadoterceros> findListadotercerosEntities() {
        return findListadotercerosEntities(true, -1, -1);
    }

    public List<Listadoterceros> findListadotercerosEntities(int maxResults, int firstResult) {
        return findListadotercerosEntities(false, maxResults, firstResult);
    }

    private List<Listadoterceros> findListadotercerosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Listadoterceros.class));
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

    public Listadoterceros findListadoterceros(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Listadoterceros.class, id);
        } finally {
            em.close();
        }
    }

    public int getListadotercerosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Listadoterceros> rt = cq.from(Listadoterceros.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
