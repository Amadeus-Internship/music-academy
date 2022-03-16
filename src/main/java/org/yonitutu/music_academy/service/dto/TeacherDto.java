package org.yonitutu.music_academy.service.dto;

import java.util.List;

public class TeacherDto extends PersonDto {
    private List<InstrumentDto> instruments;

    public TeacherDto() {
    }

    public List<InstrumentDto> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<InstrumentDto> instruments) {
        this.instruments = instruments;
    }
}
