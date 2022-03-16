package org.yonitutu.music_academy.service.impl;

import org.modelmapper.ModelMapper;
import org.yonitutu.music_academy.data.dao.api.InstrumentDao;
import org.yonitutu.music_academy.data.entities.Instrument;
import org.yonitutu.music_academy.service.api.InstrumentService;
import org.yonitutu.music_academy.service.dto.InstrumentDto;

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
        List<Instrument> instrumentList = this.instrumentDao.findAll();
        List<InstrumentDto> returnList = new ArrayList<>();
        for (Instrument instrument : instrumentList) {
           InstrumentDto currentInstrument = modelMapper.map(instrument, InstrumentDto.class);
            returnList.add(currentInstrument);
        }
        return returnList;
    }

    @Override
    public InstrumentDto getInstrumentById(Integer id) {
        Instrument instrumentEntity = this.instrumentDao.findById(id);

        return modelMapper.map(instrumentEntity, InstrumentDto.class);
    }

    @Override
    public InstrumentDto addInstrument(InstrumentDto instrumentDto) {
        Instrument instrumentEntity = new Instrument();

        instrumentEntity.setType(instrumentDto.getType());

        instrumentEntity = this.instrumentDao.create(instrumentEntity);

        return modelMapper.map(instrumentEntity, InstrumentDto.class);

    }

    @Override
    public InstrumentDto editInstrument(Integer id, InstrumentDto newInstrument) {
        Instrument instrumentEntityToEdit = this.instrumentDao.findById(id);

        instrumentEntityToEdit.setType(newInstrument.getType());

        instrumentEntityToEdit = this.instrumentDao.edit(instrumentEntityToEdit);

        return modelMapper.map(instrumentEntityToEdit, InstrumentDto.class);
    }

    @Override
    public InstrumentDto deleteInstrument(Integer id) {
        Instrument instrumentEntityToDelete = this.instrumentDao.findById(id);
        this.instrumentDao.delete(instrumentEntityToDelete);

        return modelMapper.map(instrumentEntityToDelete, InstrumentDto.class);
    }
}
