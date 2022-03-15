package org.yonitutu.music_academy;

import org.yonitutu.music_academy.data.dao.api.InstrumentDao;
import org.yonitutu.music_academy.data.dao.api.TeacherDao;
import org.yonitutu.music_academy.data.dao.impl.InstrumentDaoImpl;
import org.yonitutu.music_academy.data.dao.impl.TeacherDaoImpl;
import org.yonitutu.music_academy.data.entities.Instrument;
import org.yonitutu.music_academy.data.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("musicacademy");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        InstrumentDao instrumentDao = new InstrumentDaoImpl(entityManager);
        TeacherDao teacherDao = new TeacherDaoImpl(entityManager);

        Teacher ivan = teacherDao.findById(6);

        teacherDao.delete(ivan);
    }
}
