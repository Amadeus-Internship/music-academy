package org.yonitutu.music_academy.service.impl;

import org.modelmapper.ModelMapper;
import org.yonitutu.music_academy.data.dao.api.InstrumentDao;
import org.yonitutu.music_academy.data.dao.api.MusicGroupDao;
import org.yonitutu.music_academy.data.dao.api.StudentDao;
import org.yonitutu.music_academy.data.entities.Instrument;
import org.yonitutu.music_academy.data.entities.MusicGroup;
import org.yonitutu.music_academy.data.entities.Student;
import org.yonitutu.music_academy.service.api.StudentService;
import org.yonitutu.music_academy.service.dto.StudentDto;
import org.yonitutu.music_academy.service.dto.StudentInstrumentDto;
import org.yonitutu.music_academy.service.dto.StudentMusicGroupDto;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;
    private final ModelMapper modelMapper;
    private final InstrumentDao instrumentDao;
    private final MusicGroupDao musicGroupDao;

    public StudentServiceImpl(StudentDao studentDao, ModelMapper modelMapper, InstrumentDao instrumentDao, MusicGroupDao musicGroupDao) {
        this.studentDao = studentDao;
        this.modelMapper = modelMapper;
        this.instrumentDao = instrumentDao;
        this.musicGroupDao = musicGroupDao;
    }


    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentDao.findAll();
        List<StudentDto> studentsToReturn = new ArrayList<>();
        for (Student student : students) {
            StudentDto studentDto = modelMapper.map(student, StudentDto.class);
            studentsToReturn.add(studentDto);
        }
        return studentsToReturn;
    }

    @Override
    public StudentDto getStudentById(Integer id) {
        Student student = studentDao.findById(id);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        return modelMapper.map(studentDao.create(modelMapper.map(studentDto, Student.class)),StudentDto.class);
    }

    @Override
    public StudentDto editStudent(Integer id, StudentDto newStudent) {
        Student student = studentDao.findById(id);
        Student student1 = modelMapper.map(newStudent, Student.class);
        student.setAge(student1.getAge());
        student.setName(student1.getName());
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto deleteStudent(Integer id) {
        Student student = studentDao.findById(id);
        studentDao.delete(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto addInstrument(StudentInstrumentDto studentInstrumentDto) {
        String instrumentName = studentInstrumentDto.getInstrumentName();
        String studentName = studentInstrumentDto.getStudentName();
        Student student = studentDao.findByName(studentName);
        Instrument instrument = instrumentDao.findByName(instrumentName);
        student.getInstruments().add(instrument);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto addMusicGroup(StudentMusicGroupDto studentMusicGroupDto) {
        String musicGroupName = studentMusicGroupDto.getMusicGroupName();
        String studentName = studentMusicGroupDto.getStudentName();
        Student student = studentDao.findByName(studentName);
        MusicGroup musicGroup = musicGroupDao.findByName(musicGroupName);
        student.getMusicGroups().add(musicGroup);
        return modelMapper.map(student, StudentDto.class);
    }
}
