package org.yonitutu.music_academy.service.dto;

import java.util.List;

public class MusicGroupDto extends BaseDto{

    private InstrumentDto instrument;

    private TeacherDto teacher;

    private String name;

    private List<StudentDto> studentParticipants;


    public MusicGroupDto(){
    }

    public InstrumentDto getInstrument() {
        return instrument;
    }

    public void setInstrument(InstrumentDto instrument) {
        this.instrument = instrument;
    }

    public TeacherDto getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDto teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentDto> getStudentParticipants() {
        return studentParticipants;
    }

    public void setStudentParticipants(List<StudentDto> studentParticipants) {
        this.studentParticipants = studentParticipants;
    }
}
