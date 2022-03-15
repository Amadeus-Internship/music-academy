package org.yonitutu.music_academy.data.dao.impl;

import org.yonitutu.music_academy.data.dao.api.InstrumentDao;
import org.yonitutu.music_academy.data.entities.Instrument;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class InstrumentDaoImpl extends BaseDao implements InstrumentDao {
    public InstrumentDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<Instrument> findAll() {
        Query query = this.entityManager.createNativeQuery("SELECT * FROM instruments", Instrument.class);

        return query.getResultList();
    }

    @Override
    public Instrument findById(Integer integer) {
        Query query = this.entityManager.createNativeQuery(("SELECT * FROM instruments WHERE id = " + integer), Instrument.class);

        return (Instrument) query.getSingleResult();
    }

    @Override
    public Instrument create(Instrument instrument) {

        return this.execute("create", instrument);
    }

    @Override
    public Instrument edit(Instrument editedEntity) {

        return this.execute("edit", editedEntity);
    }

    @Override
    public Instrument delete(Instrument entityToDelete) {

        return  this.execute("delete", entityToDelete);
    }
}
