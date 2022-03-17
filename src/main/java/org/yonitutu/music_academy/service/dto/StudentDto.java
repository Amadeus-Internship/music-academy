package org.yonitutu.music_academy.service.dto;

import java.util.List;

public class StudentDto extends PersonDto{
    private List<InstrumentDto> instruments;

    private List<MusicGroupDto> musicGroups;

    public StudentDto() {
    }

    public List<InstrumentDto> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<InstrumentDto> instruments) {
        this.instruments = instruments;
    }

    public List<MusicGroupDto> getMusicGroups() {
        return musicGroups;
    }

    public void setMusicGroups(List<MusicGroupDto> musicGroups) {
        this.musicGroups = musicGroups;
    }
}
