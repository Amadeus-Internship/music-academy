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
        return this.instrumentDao.findAll()
                .stream()
                .map(instrumentEntity -> {
                    InstrumentDto instrumentDto = new InstrumentDto();

                    instrumentDto.setId(instrumentEntity.getId());
                    instrumentDto.setType(instrumentEntity.getType());

                    return instrumentDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public InstrumentDto getInstrumentById(Integer id) {
        Instrument instrumentEntity = this.instrumentDao.findById(id);
        InstrumentDto instrumentDto = new InstrumentDto();

        instrumentDto.setId(instrumentEntity.getId());
        instrumentDto.setType(instrumentEntity.getType());

        return instrumentDto;
    }

    @Override
    public InstrumentDto addInstrument(InstrumentDto instrumentDto) {
        Instrument instrumentEntity = new Instrument();

        instrumentEntity.setType(instrumentDto.getType());

        instrumentEntity = this.instrumentDao.create(instrumentEntity);

        InstrumentDto resultDto = new InstrumentDto();

        resultDto.setType(instrumentEntity.getType());
        resultDto.setId(instrumentEntity.getId());

        return resultDto;
    }

    @Override
    public InstrumentDto editInstrument(Integer id, InstrumentDto newInstrument) {
        Instrument instrumentEntityToEdit = this.instrumentDao.findById(id);

        instrumentEntityToEdit.setType(newInstrument.getType());

        instrumentEntityToEdit = this.instrumentDao.edit(instrumentEntityToEdit);

        InstrumentDto resultDto = new InstrumentDto();

        resultDto.setType(instrumentEntityToEdit.getType());
        resultDto.setId(instrumentEntityToEdit.getId());

        return resultDto;
    }

    @Override
    public InstrumentDto deleteInstrument(Integer id) {
        Instrument instrumentEntityToDelete = this.instrumentDao.findById(id);
        this.instrumentDao.delete(instrumentEntityToDelete);

        InstrumentDto resultDto = new InstrumentDto();

        resultDto.setType(instrumentEntityToDelete.getType());
        resultDto.setId(instrumentEntityToDelete.getId());

        return resultDto;
    }
}
