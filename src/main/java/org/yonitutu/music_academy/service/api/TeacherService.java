package org.yonitutu.music_academy.service.api;

import org.yonitutu.music_academy.service.dto.TeacherDto;
import org.yonitutu.music_academy.service.dto.TeacherInstrumentDto;

import java.util.List;

public interface TeacherService {
    List<TeacherDto> getAllTeachers();

    TeacherDto getTeacherById(Integer id);

    TeacherDto addTeacher(TeacherDto teacherDto);

    TeacherDto editTeacher(Integer id, TeacherDto newTeacher);

    TeacherDto deleteTeacher(Integer id);

    TeacherDto addInstrument(TeacherInstrumentDto teacherInstrumentDto);
}
