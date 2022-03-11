package org.yonitutu.music_academy.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {
    @Column
    private String name;

    @Column
    private int age;

    @ManyToOne
    @JoinColumn(name = "instrument_id", nullable = false)
    private Instrument instrument;

    public Teacher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
