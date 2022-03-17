package org.yonitutu.music_academy.service.impl;

import org.modelmapper.ModelMapper;
import org.yonitutu.music_academy.data.dao.api.StudentDao;
import org.yonitutu.music_academy.data.entities.Student;
import org.yonitutu.music_academy.service.api.StudentService;
import org.yonitutu.music_academy.service.dto.*;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentDao studentDao, ModelMapper modelMapper) {
        this.studentDao = studentDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return this.studentDao
                .findAll()
                .stream()
                .map(i -> this.modelMapper.map(i, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(Integer id) {
        Student studentEntity = this.studentDao.findById(id);
        return this.modelMapper.map(studentEntity, StudentDto.class);
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        return this.modelMapper.map(
                this.studentDao.create(
                        this.modelMapper.map(studentDto, Student.class))
                , StudentDto.class);
    }

    @Override
    public StudentDto editStudent(Integer id, StudentDto newStudent) {
        Student studentToEdit = this.studentDao.findById(id);
        Student newStudentBase = modelMapper.map(newStudent, Student.class);
        studentToEdit.setName(newStudentBase.getName());
        studentToEdit.setAge(newStudentBase.getAge());
        return modelMapper.map(studentToEdit, StudentDto.class);
    }

    @Override
    public StudentDto deleteStudent(Integer id) {
        Student studentToDelete = this.studentDao.findById(id);
        this.studentDao.delete(studentToDelete);
        return this.modelMapper.map(studentToDelete, StudentDto.class);
    }

    @Override
    public StudentDto addInstrument(StudentInstrumentDto studentInstrumentDto) {
        return null;
    }

    @Override
    public StudentDto addMusicGroup(MusicGroupDto musicGroupDto) {
        return null;
    }
}
