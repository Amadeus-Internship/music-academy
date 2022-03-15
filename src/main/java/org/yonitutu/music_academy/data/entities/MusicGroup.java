package org.yonitutu.music_academy.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "music_groups")
public class MusicGroup extends BaseEntity {
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "instrument_id", nullable = false)
    private Instrument instrument;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    public MusicGroup() {
    }

    public MusicGroup(String name, Instrument instrument, Teacher teacher) {
        this.name = name;
        this.instrument = instrument;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
