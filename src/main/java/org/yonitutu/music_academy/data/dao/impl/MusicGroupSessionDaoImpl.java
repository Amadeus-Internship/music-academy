package org.yonitutu.music_academy.data.dao.impl;

import org.yonitutu.music_academy.data.dao.api.MusicGroupSessionDao;
import org.yonitutu.music_academy.data.dao.impl.BaseDao;
import org.yonitutu.music_academy.data.entities.MusicGroup;
import org.yonitutu.music_academy.data.entities.MusicGroupSession;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MusicGroupSessionDaoImpl extends BaseDao implements MusicGroupSessionDao {
    protected MusicGroupSessionDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<MusicGroupSession> findAll() {
        Query query = this.entityManager.createNativeQuery("SELECT * FROM music_group_sessions", MusicGroupSession.class);

        return query.getResultList();
    }

    @Override
    public MusicGroupSession findById(Integer id) {
        Query query = this.entityManager.createNativeQuery(("SELECT * FROM music_group_sessions WHERE id = " + id), MusicGroupSession.class);

        return (MusicGroupSession) query.getSingleResult();
    }

    @Override
    public MusicGroupSession create(MusicGroupSession musicGroupSession) {
        this.executeTransactional(()-> entityManager.persist(musicGroupSession));

        return musicGroupSession;
    }

    @Override
    public MusicGroupSession edit(MusicGroupSession editedEntity) {
        this.executeTransactional(() -> entityManager.merge(editedEntity));

        return editedEntity;
    }

    @Override
    public MusicGroupSession delete(MusicGroupSession entityToDelete) {
        this.executeTransactional(() -> entityManager.remove(entityToDelete));

        return entityToDelete;
    }

    @Override
    public MusicGroupSession findByName(String name) {
        Query query = this.entityManager.createNativeQuery(("SELECT * FROM music_group_sessions WHERE name = " + name)
                , MusicGroupSession.class);

        return (MusicGroupSession) query.getSingleResult();
    }
}
