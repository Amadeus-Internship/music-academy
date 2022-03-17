package org.yonitutu.music_academy.service.dto;

public class StudentInstrumentDto extends BaseDto{
    private String studentName;
    private String instrumentName;

    public StudentInstrumentDto() {

    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }
}
