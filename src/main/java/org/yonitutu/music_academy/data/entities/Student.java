package org.yonitutu.music_academy.data.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student extends PersonEntity {
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_music_groups",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "music_group_id")}
    )
    private List<MusicGroup> musicGroups;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_instruments",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "instrument_id")}
    )
    private List<Instrument> instruments;

    public Student() {
    }
}
