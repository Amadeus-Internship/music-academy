package org.yonitutu.music_academy.service.dto;

public class TeacherInstrumentDto extends BaseDto{
    private String teacherName;

    private String instrumentName;

    public TeacherInstrumentDto() {
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }
}
