package org.yonitutu.music_academy.data.dao.impl;

import org.yonitutu.music_academy.data.dao.api.functions.ExecuteTransactional;

import javax.persistence.EntityManager;

public abstract class BaseDao {
    protected EntityManager entityManager;

    protected BaseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    void executeTransactional(ExecuteTransactional ex){
        this.entityManager.getTransaction().begin();

        ex.execute();

        this.entityManager.flush();

        this.entityManager.getTransaction().commit();
    }
}
