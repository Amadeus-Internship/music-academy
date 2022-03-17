package org.yonitutu.music_academy.service.impl;

import org.modelmapper.ModelMapper;
import org.yonitutu.music_academy.data.dao.api.InstrumentDao;
import org.yonitutu.music_academy.data.entities.Instrument;
import org.yonitutu.music_academy.service.api.InstrumentService;
import org.yonitutu.music_academy.service.dto.InstrumentDto;
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
          return this.instrumentDao
                  .findAll()
                  .stream()
                  .map(i -> this.modelMapper.map(i, InstrumentDto.class))
                  .collect(Collectors.toList());
    }

    @Override
    public InstrumentDto getInstrumentById(Integer id) {
        Instrument instrumentEntity = this.instrumentDao.findById(id);

        return this.modelMapper.map(instrumentEntity, InstrumentDto.class);
    }

    @Override
    public InstrumentDto addInstrument(InstrumentDto instrumentDto) {
       return this.modelMapper.map(
               this.instrumentDao.create(
                       this.modelMapper.map(instrumentDto, Instrument.class))
               , InstrumentDto.class);
    }

    @Override
    public InstrumentDto editInstrument(Integer id, InstrumentDto newInstrument) {
        Instrument instrumentToEdit = instrumentDao.findById(id);
        Instrument newInstrumentBase = modelMapper.map(newInstrument, Instrument.class);
        instrumentToEdit.setType(newInstrumentBase.getType());
        return modelMapper.map(instrumentToEdit, InstrumentDto.class);
    }

    @Override
    public InstrumentDto deleteInstrument(Integer id) {
        Instrument instrumentToDelete = this.instrumentDao.findById(id);
        this.instrumentDao.delete(instrumentToDelete);
        return this.modelMapper.map(instrumentToDelete, InstrumentDto.class);
    }
}
