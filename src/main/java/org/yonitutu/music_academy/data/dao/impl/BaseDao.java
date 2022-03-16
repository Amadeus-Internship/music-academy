package org.yonitutu.music_academy.data.dao.impl;

import org.yonitutu.music_academy.data.common.QueryExecutor;
import org.yonitutu.music_academy.data.dao.api.Dao;
import javax.persistence.EntityManager;

public abstract class BaseDao {
    protected EntityManager entityManager;

    public BaseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    
    protected void executeTransactional(QueryExecutor executor){
        this.entityManager.getTransaction().begin();

        executor.execute();

        this.entityManager.flush();

        this.entityManager.getTransaction().commit();

    }

}
