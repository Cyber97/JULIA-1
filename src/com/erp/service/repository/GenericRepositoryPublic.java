package com.erp.service.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public abstract class GenericRepositoryPublic<T> {
    @PersistenceContext
    public EntityManager entityManager;

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public void remove(T entity) {
        entity = this.entityManager.merge(entity);
        this.entityManager.remove(entity);
    }

    public T find(Class<T> aClass, Long id) {
        return entityManager.find(aClass, id);
    }

    public T findDate(Class<T> aClass, String date) {
        return entityManager.find(aClass, date);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public List<T> getAll(Class aClass) {
        try {
            return entityManager.createQuery("select entity from " + aClass.newInstance().getClass().getAnnotation(Entity.class).name() + " entity").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}