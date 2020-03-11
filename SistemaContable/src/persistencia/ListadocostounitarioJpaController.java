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
import modelo.Listadocostounitario;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Jhon
 */
public class ListadocostounitarioJpaController implements Serializable {

    public ListadocostounitarioJpaController() {
        this.emf = Persistence.createEntityManagerFactory("SistemaContablePU");
    }
    
    public ListadocostounitarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Listadocostounitario listadocostounitario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(listadocostounitario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findListadocostounitario(listadocostounitario.getCodigokardex()) != null) {
                throw new PreexistingEntityException("Listadocostounitario " + listadocostounitario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Listadocostounitario listadocostounitario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            listadocostounitario = em.merge(listadocostounitario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = listadocostounitario.getCodigokardex();
                if (findListadocostounitario(id) == null) {
                    throw new NonexistentEntityException("The listadocostounitario with id " + id + " no longer exists.");
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
            Listadocostounitario listadocostounitario;
            try {
                listadocostounitario = em.getReference(Listadocostounitario.class, id);
                listadocostounitario.getCodigokardex();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The listadocostounitario with id " + id + " no longer exists.", enfe);
            }
            em.remove(listadocostounitario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Listadocostounitario> findListadocostounitarioEntities() {
        return findListadocostounitarioEntities(true, -1, -1);
    }

    public List<Listadocostounitario> findListadocostounitarioEntities(int maxResults, int firstResult) {
        return findListadocostounitarioEntities(false, maxResults, firstResult);
    }

    private List<Listadocostounitario> findListadocostounitarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Listadocostounitario.class));
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

    public Listadocostounitario findListadocostounitario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Listadocostounitario.class, id);
        } finally {
            em.close();
        }
    }

    public int getListadocostounitarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Listadocostounitario> rt = cq.from(Listadocostounitario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
