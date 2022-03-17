package org.yonitutu.music_academy.service.impl;

import org.modelmapper.ModelMapper;
import org.yonitutu.music_academy.data.dao.api.InstrumentDao;
import org.yonitutu.music_academy.data.entities.Instrument;
import org.yonitutu.music_academy.data.entities.Instrument;
import org.yonitutu.music_academy.service.api.InstrumentService;
import org.yonitutu.music_academy.service.dto.InstrumentDto;
import org.yonitutu.music_academy.service.dto.TeacherDto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InstrumentServiceImpl implements InstrumentService {
    private final InstrumentDao instrumentDao;

    private final ModelMapper modelMapper;

    public InstrumentServiceImpl(InstrumentDao instrumentDao, ModelMapper modelMapper) {
        this.instrumentDao = instrumentDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<InstrumentDto> getAllInstruments() {
        List<Instrument> instruments = instrumentDao.findAll();
        List<InstrumentDto> instrumentsToReturn = new ArrayList<>();
        for (Instrument instrument : instruments) {
            InstrumentDto instrumentDto = modelMapper.map(instrument, InstrumentDto.class);
            instrumentsToReturn.add(instrumentDto);
        }
        return instrumentsToReturn;
    }

    @Override
    public InstrumentDto getInstrumentById(Integer id) {
        Instrument instrument = instrumentDao.findById(id);
        return modelMapper.map(instrument, InstrumentDto.class);
    }

    @Override
    public InstrumentDto addInstrument(InstrumentDto instrumentDto) {
        return modelMapper.map(instrumentDao.create(modelMapper.map(instrumentDto, Instrument.class)) ,InstrumentDto.class);
    }

    @Override
    public InstrumentDto editInstrument(Integer id, InstrumentDto newInstrument) {
        Instrument instrument = instrumentDao.findById(id);
        Instrument instrument1 = modelMapper.map(newInstrument, Instrument.class);
        instrument.setType(instrument1.getType());
        return modelMapper.map(instrument, InstrumentDto.class);
    }

    @Override
    public InstrumentDto deleteInstrument(Integer id) {
        Instrument instrumentToDelete = instrumentDao.findById(id);
        instrumentDao.delete(instrumentToDelete);
        return modelMapper.map(instrumentToDelete, InstrumentDto.class);
    }
}
