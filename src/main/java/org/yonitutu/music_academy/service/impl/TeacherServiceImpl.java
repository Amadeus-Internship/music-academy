package org.yonitutu.music_academy.service.impl;

import org.modelmapper.ModelMapper;
import org.yonitutu.music_academy.data.dao.api.InstrumentDao;
import org.yonitutu.music_academy.data.dao.api.TeacherDao;
import org.yonitutu.music_academy.data.entities.Instrument;
import org.yonitutu.music_academy.data.entities.Teacher;
import org.yonitutu.music_academy.service.api.TeacherService;
import org.yonitutu.music_academy.service.dto.TeacherDto;
import org.yonitutu.music_academy.service.dto.TeacherInstrumentDto;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherServiceImpl implements TeacherService {
    private final TeacherDao teacherDao;

    private final InstrumentDao instrumentDao;

    private final ModelMapper modelMapper;

    public TeacherServiceImpl(TeacherDao teacherDao, InstrumentDao instrumentDao, ModelMapper modelMapper) {
        this.teacherDao = teacherDao;
        this.instrumentDao = instrumentDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        return this.teacherDao
                .findAll()
                .stream()
                .map(i -> this.modelMapper.map(i, TeacherDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDto getTeacherById(Integer id) {
        Teacher teacherEntity = this.teacherDao.findById(id);

        return this.modelMapper.map(teacherEntity, TeacherDto.class);
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
        Teacher teacherToEdit = teacherDao.findById(id);
        Teacher newTeacherBase = modelMapper.map(newTeacher, Teacher.class);
        teacherToEdit.setInstruments(newTeacherBase.getInstruments());
        teacherToEdit.setName(newTeacherBase.getName());
        teacherToEdit.setAge(newTeacherBase.getAge());
        return modelMapper.map(teacherToEdit, TeacherDto.class);

    }

    @Override
    public TeacherDto deleteTeacher(Integer id) {
       Teacher teacherToDelete = this.teacherDao.findById(id);
       this.teacherDao.delete(teacherToDelete);
       return this.modelMapper.map(teacherToDelete, TeacherDto.class);
    }

    @Override
    public TeacherDto addInstrument(TeacherInstrumentDto teacherInstrumentDto) {
        String instrumentName = teacherInstrumentDto.getInstrumentName();
        String teacherName = teacherInstrumentDto.getTeacherName();
        Teacher teacherEntity = this.teacherDao.findByName(teacherName);
        Instrument instrumentEntity = this.instrumentDao.findByName(instrumentName);
        teacherEntity.getInstruments().add(instrumentEntity);
        return this.modelMapper.map(teacherEntity, TeacherDto.class);
    }
}
