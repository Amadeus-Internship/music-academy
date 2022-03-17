package org.yonitutu.music_academy.service.dto;

public class StudentMusicGroupDto extends  BaseDto{
    private String musicGroupName;
    private String studentName;

    public StudentMusicGroupDto() {
    }

    public String getMusicGroupName() {
        return musicGroupName;
    }

    public void setMusicGroupName(String musicGroupName) {
        this.musicGroupName = musicGroupName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
