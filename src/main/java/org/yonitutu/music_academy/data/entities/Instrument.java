package org.yonitutu.music_academy.data.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "instruments")
public class Instrument extends BaseEntity {
    private String type;

    public Instrument() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
