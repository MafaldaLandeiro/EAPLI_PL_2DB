/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.JPA;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Classe para guardar em persistencia
 *
 * @autor 1110186 & 1110590
 */

public abstract class Jpa<T, PK extends Serializable> {

    static private EntityManagerFactory emf=Persistence.createEntityManagerFactory("eapli.expensemanagerPU");
    protected Class<T> entityClass;
    protected EntityManager entityManager;
    
    
    public Jpa(){
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }
    
        public T create(T t) {
        this.entityManager.persist(t);
        return t;
    }

        public T read(PK id) {
       return this.entityManager.find(entityClass, id);
    }
    
    public T findById(PK id){
        return read(id);
    }

        public T update(T t) {
        return this.entityManager.merge(t);
    }

        public void delete(T t) {
       t = this.entityManager.merge(t);
       this.entityManager.remove(t);
    }

    public long size(){
        return getCount();
    }
    
    public long getCount(){
        return (Long) getEntityManager().createQuery("SELECT COUNT(*) FROM "+entityClass.getSimpleName()).getSingleResult();
    }
    
    public Collection<T> findAll(){
        return getEntityManager().createQuery("SELECT e FROM "+entityClass.getSimpleName()+ " e").getResultList();
    }
    
    
    void save(T entity) {
        if(entity==null){
            throw new IllegalArgumentException();
        }
        EntityManager em=getEntityManager();
        assert em !=null;
        try{
            EntityTransaction tx=em.getTransaction();
            try{
                tx.begin();
                em.persist(entity);
                tx.commit();
            }catch(PersistenceException ex){
                tx=em.getTransaction();
                tx.begin();
                entity=em.merge(entity);
                tx.commit();
            }
        }finally{
            em.close();
        }
    }
    
    public List<T>all(){
        return match("1=1");
    }
    
    public List<T>match(String where){
        EntityManager em=getEntityManager();
        assert em!=null;
        String tableName=entityClass.getSimpleName();
        Query q=em.createQuery("SELECT it FROM " + tableName+" it WHERE "+where);
        List<T> some=q.getResultList();
        return some;
    }
    
    protected EntityManager getEntityManager(){
        if(entityManager ==null || !entityManager.isOpen()){
            entityManager=emf.createEntityManager();
        }
        return entityManager;
    }
    

    
}
