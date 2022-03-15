package org.yonitutu.music_academy.data.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class PersonEntity extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    public PersonEntity() {
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
}
