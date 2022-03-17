package org.yonitutu.music_academy.service.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MusicGroupSessionDto extends BaseDto{
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private MusicGroupDto musicGroup;

    private List<StudentDto> studentParticipants;

    public MusicGroupSessionDto(){

    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public MusicGroupDto getMusicGroup() {
        return musicGroup;
    }

    public void setMusicGroup(MusicGroupDto musicGroup) {
        this.musicGroup = musicGroup;
    }

    public List<StudentDto> getStudentParticipants() {
        return studentParticipants;
    }

    public void setStudentParticipants(List<StudentDto> studentParticipants) {
        this.studentParticipants = studentParticipants;
    }
}
