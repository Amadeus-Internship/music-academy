package org.yonitutu.music_academy.data.dao.impl;

import org.yonitutu.music_academy.data.dao.api.MusicGroupDao;
import org.yonitutu.music_academy.data.entities.MusicGroup;
import org.yonitutu.music_academy.data.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MusicGroupDaoImpl extends BaseDao implements MusicGroupDao {
    protected MusicGroupDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<MusicGroup> findAll() {
        Query query = this.entityManager.createNativeQuery("SELECT * FROM music_groups", MusicGroup.class);

        return query.getResultList();
    }

    @Override
    public MusicGroup findById(Integer integer) {
        Query query = this.entityManager.createNativeQuery(("SELECT * FROM music_groups WHERE id = " + integer), MusicGroup.class);

        return (MusicGroup) query.getSingleResult();
    }

    @Override
    public MusicGroup create(MusicGroup musicGroup) {
        this.executeTransactional(()-> entityManager.persist(musicGroup));

        return musicGroup;
    }

    @Override
    public MusicGroup edit(MusicGroup editedEntity) {
        this.executeTransactional(() -> entityManager.merge(editedEntity));

        return editedEntity;
    }

    @Override
    public MusicGroup delete(MusicGroup entityToDelete) {
        this.executeTransactional(() -> entityManager.remove(entityToDelete));

        return entityToDelete;
    }
}
