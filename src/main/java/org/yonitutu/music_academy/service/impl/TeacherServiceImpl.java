package org.yonitutu.music_academy.service.impl;

import org.modelmapper.ModelMapper;
import org.yonitutu.music_academy.data.dao.api.InstrumentDao;
import org.yonitutu.music_academy.data.dao.api.TeacherDao;
import org.yonitutu.music_academy.data.entities.Instrument;
import org.yonitutu.music_academy.data.entities.Teacher;
import org.yonitutu.music_academy.service.api.TeacherService;
import org.yonitutu.music_academy.service.dto.TeacherDto;
import org.yonitutu.music_academy.service.dto.TeacherInstrumentDto;

import java.util.ArrayList;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherDao teacherDao;

    private final ModelMapper modelMapper;

    private final InstrumentDao instrumentDao;

    public TeacherServiceImpl(TeacherDao teacherDao, ModelMapper modelMapper, InstrumentDao instrumentDao) {
        this.teacherDao = teacherDao;
        this.modelMapper = modelMapper;
        this.instrumentDao = instrumentDao;
    }


    @Override
    public List<TeacherDto> getAllTeachers() {

            List<Teacher> teachers = teacherDao.findAll();
            List<TeacherDto> teacherDtoList = new ArrayList<>();

        for (Teacher teacher : teachers) {
            TeacherDto teacherDto = modelMapper.map(teacher, TeacherDto.class);
            teacherDtoList.add(teacherDto);
        }

        return teacherDtoList;
    }

    @Override
    public TeacherDto getTeacherById(Integer id) {
        Teacher teacher = teacherDao.findById(id);
        return modelMapper.map(teacher, TeacherDto.class);
    }

    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto) {
        return this.modelMapper.map(
                this.teacherDao.create(
                        this.modelMapper.map(teacherDto, Teacher.class))
                , TeacherDto.class);
    }

    @Override
    public TeacherDto editTeacher(Integer id, TeacherDto newTeacher) {
       Teacher teacher = teacherDao.findById(id);
       Teacher teacher1 = modelMapper.map(newTeacher, Teacher.class);
       teacher.setInstruments(teacher1.getInstruments());
       teacher.setAge(teacher1.getAge());
       teacher.setName(teacher1.getName());
       return modelMapper.map(teacher, TeacherDto.class);
    }

    @Override
    public TeacherDto deleteTeacher(Integer id) {
        Teacher teacher = teacherDao.findById(id);
        teacherDao.delete(teacher);
        return modelMapper.map(teacher, TeacherDto.class);
    }

    @Override
    public TeacherDto addInstrument(TeacherInstrumentDto teacherInstrumentDto) {
        String instrumentName = teacherInstrumentDto.getInstrumentName();
        String teacherName = teacherInstrumentDto.getTeacherName();
        Teacher teacher = teacherDao.findByName(teacherName);
        Instrument instrument = instrumentDao.findByName(instrumentName);
        teacher.getInstruments().add(instrument);
        return modelMapper.map(teacher, TeacherDto.class);
    }
}
