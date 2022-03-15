package org.yonitutu.music_academy.data.dao.impl;

import javax.persistence.EntityManager;

public abstract class BaseDao {
    protected EntityManager entityManager;

    protected BaseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
