package org.yonitutu.music_academy.service.api;

import org.yonitutu.music_academy.service.dto.*;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Integer id);

    StudentDto addStudent(StudentDto studentDto);

    StudentDto editStudent(Integer id, StudentDto newStudent);

    StudentDto deleteStudent(Integer id);

    StudentDto addInstrument(StudentInstrumentDto studentInstrumentDto);

    StudentDto addMusicGroup(StudentMusicGroupDto studentMusicGroupDto);
}
