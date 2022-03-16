package org.yonitutu.music_academy.service.api;

import org.yonitutu.music_academy.service.dto.InstrumentDto;

import java.util.List;

public interface InstrumentService {
    List<InstrumentDto> getAllInstruments();

    InstrumentDto getInstrumentById(Integer id);

    InstrumentDto addInstrument(InstrumentDto instrumentDto);

    InstrumentDto editInstrument(Integer id, InstrumentDto newInstrument);

    InstrumentDto deleteInstrument(Integer id);
}
