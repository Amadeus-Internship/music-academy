package org.yonitutu.music_academy.data.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends PersonEntity {
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "teachers_instruments",
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "instrument_id")}
    )
    private List<Instrument> instruments;

    public Teacher() {
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }
}
