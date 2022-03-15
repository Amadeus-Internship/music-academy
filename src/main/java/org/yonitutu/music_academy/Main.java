package org.yonitutu.music_academy;

import org.yonitutu.music_academy.data.dao.api.*;
import org.yonitutu.music_academy.data.dao.impl.*;
import org.yonitutu.music_academy.data.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("musicacademy");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

       // Demo(entityManager);

    }




    private static void Demo(EntityManager entityManager) {
        InstrumentDao instrumentDao = new InstrumentDaoImpl(entityManager);
        TeacherDao teacherDao = new TeacherDaoImpl(entityManager);
        StudentDao studentDao = new StudentDaoImpl(entityManager);
        MusicGroupDao musicGroupDao = new MusicGroupDaoImpl(entityManager);
        MusicGroupSessionDao musicGroupSessionDao = new MusicGroupSessionDaoImpl(entityManager);

        Instrument duduk = instrumentDao.create(new Instrument("duduk"));
        Instrument kaval = instrumentDao.create(new Instrument("kaval"));
        Instrument trompet = instrumentDao.create(new Instrument("trompet"));

        Teacher ivo = teacherDao.create(new Teacher("Ivo", 55));

        ivo.setInstruments(trompet);

        Student kasandra = studentDao.create(new Student("Kasandra", 33));

        kasandra.getInstruments().add(duduk);

        MusicGroup dudukIdol = musicGroupDao.create(new MusicGroup("DudukIdol", duduk, ivo));

        kasandra.getMusicGroups().add(dudukIdol);

        MusicGroupSession musicGroupSession = musicGroupSessionDao.create(new MusicGroupSession(LocalDateTime.now(), LocalDateTime.now(), dudukIdol));
        musicGroupSession.getParticipants().add(kasandra);

        studentDao.edit(kasandra);

        instrumentDao.findAll().stream().map(instrument -> instrument.getType()).forEach(System.out::println);
        musicGroupDao.findAll().stream().map(musicGroup -> musicGroup.getName()).forEach(System.out::println);
    }
}
