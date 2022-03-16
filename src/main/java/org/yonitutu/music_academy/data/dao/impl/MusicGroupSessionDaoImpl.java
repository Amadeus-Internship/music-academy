package org.yonitutu.music_academy.data.dao.impl;

import org.yonitutu.music_academy.data.dao.api.MusicGroupSessionDao;
import org.yonitutu.music_academy.data.entities.MusicGroupSession;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MusicGroupSessionDaoImpl extends BaseDao implements MusicGroupSessionDao {

    public MusicGroupSessionDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<MusicGroupSession> findAll() {
        Query query = this.entityManager.createNativeQuery("SELECT * FROM music_group_sessions", MusicGroupSession.class);

        return query.getResultList();
    }

    @Override
    public MusicGroupSession findById(Integer integer) {
        Query query = this.entityManager.createNativeQuery(("SELECT * FROM music_group_sessions WHERE id = " + integer), MusicGroupSession.class);

        return (MusicGroupSession) query.getSingleResult();
    }

    @Override
    public MusicGroupSession create(MusicGroupSession musicGroupSession) {
        this.executeTransactional(() -> this.entityManager.persist(musicGroupSession));
        return musicGroupSession;
    }

    @Override
    public MusicGroupSession edit(MusicGroupSession editedEntity) {
        this.executeTransactional(() -> this.entityManager.merge(editedEntity));
        return editedEntity;
    }

    @Override
    public MusicGroupSession delete(MusicGroupSession entityToDelete) {
        this.executeTransactional(() -> this.entityManager.remove(entityToDelete));
        return entityToDelete;
    }
}
