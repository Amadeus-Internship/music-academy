package org.yonitutu.music_academy.data.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "music_group_sessions")
public class MusicGroupSession extends BaseEntity {
    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "music_group_id", nullable = false)
    private MusicGroup musicGroup;

    public MusicGroupSession() {
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
}
