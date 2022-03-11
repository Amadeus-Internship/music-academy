package org.yonitutu.music_academy.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {
    @Column
    private String name;

    @Column
    private int age;

    @ManyToOne
    @JoinColumn(name = "music_group_id", nullable = false)
    private MusicGroup musicGroup;

    public Student() {
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

    public MusicGroup getMusicGroup() {
        return musicGroup;
    }

    public void setMusicGroup(MusicGroup musicGroup) {
        this.musicGroup = musicGroup;
    }
}
