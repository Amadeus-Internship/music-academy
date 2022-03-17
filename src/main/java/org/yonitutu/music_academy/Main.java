package org.yonitutu.music_academy;

import org.modelmapper.ModelMapper;
import org.yonitutu.music_academy.data.dao.api.InstrumentDao;
import org.yonitutu.music_academy.data.dao.api.TeacherDao;
import org.yonitutu.music_academy.data.dao.impl.InstrumentDaoImpl;
import org.yonitutu.music_academy.data.dao.impl.TeacherDaoImpl;
import org.yonitutu.music_academy.data.entities.Instrument;
import org.yonitutu.music_academy.data.entities.Teacher;
import org.yonitutu.music_academy.service.dto.TeacherDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("musicacademy");
        EntityManager entityManager = entityManagerFactory.createEntityManager();



//        Teacher teacher = new Teacher();
//
//        teacher.setId(1);
//        teacher.setName("Prakash");
//        teacher.setAge(35);
//        List<Instrument> instruments = new ArrayList<>();
//        Instrument prakashInstrument = new Instrument();
//        prakashInstrument.setType("Duduk");
//        instruments.add(prakashInstrument);
//        teacher.setInstruments(instruments);
//
//        ModelMapper modelMapper = new ModelMapper();
//
//        TeacherDto teacherDto = modelMapper.map(teacher, TeacherDto.class);
//
//        System.out.println(teacherDto.getInstruments().stream().findFirst().orElse(null).getType());

    }
}

/*
     TODO: PLAN -> MUSIC ACADEMY
           .
           CREATE INSTRUMENT -> add-instrument|{type}
           EDIT INSTRUMENT -> edit-instrument|{id}|{type}
           DELETE INSTRUMENT -> delete-instrument|{id}
           FIND ALL INSTRUMENTS -> find-instruments
           FIND SPECIFIC INSTRUMENT -> find-instrument|{id}
           .
           CREATE TEACHER -> add-teacher|{name}|{age}
           EDIT TEACHER -> edit-teacher|{id}|{name}|{age}
           DELETE TEACHER -> delete-teacher|{id}
           FIND ALL TEACHERS -> find-teachers
           FIND SPECIFIC TEACHER -> find-teacher|{id}
           .
           CREATE STUDENT -> add-student|{name}|{age}
           EDIT STUDENT -> edit-student|{id}|{name}|{age}
           DELETE STUDENT -> delete-student|{id}
           FIND ALL STUDENTS -> find-students
           FIND SPECIFIC STUDENT -> find-student|{id}
           .
           CREATE MUSIC GROUP -> add-music-group|{name}|{instrumentName}|{teacherName}
           EDIT MUSIC GROUP -> edit-music-group|{id}|{name}|{instrumentName}|{teacherName}
           DELETE MUSIC GROUP -> delete-music-group|{id}
           FIND ALL MUSIC GROUPS -> find-music-groups
           FIND SPECIFIC MUSIC GROUP -> find-music-group|{id}
           .
           CREATE MUSIC GROUP SESSION -> add-music-group-session|{musicGroupName}|{startTime}|{endTime}
           EDIT MUSIC GROUP SESSION -> edit-music-group-session|{id}|{name}|{musicGroupName}|{startTime}|{endTime}
           DELETE MUSIC GROUP SESSION -> delete-music-group-session|{id}
           FIND ALL MUSIC GROUP SESSIONS -> find-music-group-sessions
           FIND SPECIFIC MUSIC GROUP SESSION -> find-music-group-session|{id}
           .
           RELATE TEACHER AND INSTRUMENT -> add-teacher-instrument|{teacherName}|{instrumentName}
           RELATE STUDENT AND INSTRUMENT -> add-student-instrument|{studentName}|{instrumentName}
           RELATE STUDENT AND MUSIC GROUP -> add-student-music-group|{studentName}|{musicGroupName}

 */
