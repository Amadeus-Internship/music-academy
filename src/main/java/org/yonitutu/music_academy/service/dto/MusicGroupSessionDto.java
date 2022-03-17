package org.yonitutu.music_academy.service.dto;

import org.yonitutu.music_academy.data.entities.MusicGroup;
import org.yonitutu.music_academy.data.entities.Student;

import java.time.LocalDateTime;
import java.util.List;

public class MusicGroupSessionDto extends BaseDto{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private MusicGroup musicGroup;
    private List<Student> participants;

    public MusicGroupSessionDto() {
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

    public MusicGroup getMusicGroup() {
        return musicGroup;
    }

    public void setMusicGroup(MusicGroup musicGroup) {
        this.musicGroup = musicGroup;
    }

    public List<Student> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Student> participants) {
        this.participants = participants;
    }
}
