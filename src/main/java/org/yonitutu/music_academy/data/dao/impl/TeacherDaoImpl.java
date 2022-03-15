package org.yonitutu.music_academy.data.dao.impl;

import org.yonitutu.music_academy.data.dao.api.TeacherDao;
import org.yonitutu.music_academy.data.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {
    public TeacherDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public List<Teacher> findAll() {
        Query query = this.entityManager.createNativeQuery("SELECT * FROM teachers", Teacher.class);

        return query.getResultList();
    }

    @Override
    public Teacher findById(Integer integer) {
        Query query = this.entityManager.createNativeQuery(("SELECT * FROM teachers WHERE id = " + integer), Teacher.class);

        return (Teacher) query.getSingleResult();
    }

    @Override
    public Teacher create(Teacher teacher) {

       return this.execute("create", teacher);
    }

    @Override
    public Teacher edit(Teacher editedEntity) {

           return this.execute("edit", editedEntity);

    }

    @Override
    public Teacher delete(Teacher entityToDelete) {

          return  this.execute("delete", entityToDelete);

    }
}
