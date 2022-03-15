package org.yonitutu.music_academy.data.dao.impl;

import javax.persistence.EntityManager;

public abstract class BaseDao {
    protected EntityManager entityManager;

    protected BaseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


      protected <TEntity> TEntity execute(String command, TEntity entity){
          this.entityManager.getTransaction().begin();

          switch (command){
              case "create":
                  this.entityManager.persist(entity);
                  break;
              case "edit":
                  this.entityManager.merge(entity);
                  break;
              case "delete":
                  this.entityManager.remove(entity);
                  break;
          }

          this.entityManager.flush();

          this.entityManager.getTransaction().commit();

          return entity;
      }
}
