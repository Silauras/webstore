package edu.sytoss.repositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractDao<PrimaryKey extends Serializable, T> {
    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistentClass = (Class<T>)((ParameterizedType)
                        this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @PersistenceContext
    EntityManager entityManager;

    protected EntityManager getEntityManager(){
        return this.entityManager;
    }

    protected T getByKey(PrimaryKey key){
        return (T) entityManager.find(persistentClass, key);
    }
    protected void persist(T entity){
        entityManager.persist(entity);
    }
    protected void update(T entity){
        entityManager.merge(entity);
    }

    protected void delete(T entity){
        entityManager.remove(entity);
    }
}
