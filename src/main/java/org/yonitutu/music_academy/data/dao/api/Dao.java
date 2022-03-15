package org.yonitutu.music_academy.data.dao.api;

import java.util.List;

public interface Dao<TEntity, TId> {
    List<TEntity> findAll();

    TEntity findById(TId id);

    TEntity create(TEntity entity);

    TEntity edit(TEntity editedEntity);

    TEntity delete(TEntity entityToDelete);
}
