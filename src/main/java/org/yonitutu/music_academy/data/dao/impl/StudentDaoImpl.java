package org.yonitutu.music_academy.data.dao.impl;

import org.yonitutu.music_academy.data.dao.api.StudentDao;
import org.yonitutu.music_academy.data.entities.Instrument;
import org.yonitutu.music_academy.data.entities.Student;
import org.yonitutu.music_academy.data.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    protected StudentDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<Student> findAll() {
        Query query = this.entityManager.createNativeQuery("SELECT * FROM students", Student.class);

        return query.getResultList();
    }

    @Override
    public Student findById(Integer integer) {
        Query query = this.entityManager.createNativeQuery(("SELECT * FROM students WHERE id = " + integer), Student.class);

        return (Student) query.getSingleResult();
    }

    @Override
    public Student findByName(String name) {
            Query query = this.entityManager.createNativeQuery("SELECT * FROM students WHERE name = " + name);
            return (Student) query.getSingleResult();
    }

    @Override
    public Student create(Student student) {
        this.executeTransactional(()-> entityManager.persist(student));

        return student;
    }

    @Override
    public Student edit(Student editedEntity) {
        this.executeTransactional(() -> entityManager.merge(editedEntity));

        return editedEntity;
    }

    @Override
    public Student delete(Student entityToDelete) {
        this.executeTransactional(() -> entityManager.remove(entityToDelete));

        return entityToDelete;
    }
}
