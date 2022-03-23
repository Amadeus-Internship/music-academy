package org.yonitutu.music_academy.service.impl;

import org.modelmapper.ModelMapper;
import org.yonitutu.music_academy.data.dao.api.MusicGroupSessionDao;
import org.yonitutu.music_academy.data.entities.MusicGroupSession;
import org.yonitutu.music_academy.service.api.MusicGroupSessionService;
import org.yonitutu.music_academy.service.dto.MusicGroupSessionDto;

import java.util.List;
import java.util.stream.Collectors;

public class MusicGroupSessionServiceImpl implements MusicGroupSessionService {
    private final MusicGroupSessionDao musicGroupSessionDao;

    private final ModelMapper modelMapper;

    public MusicGroupSessionServiceImpl(MusicGroupSessionDao musicGroupSessionDao, ModelMapper modelMapper) {
        this.musicGroupSessionDao = musicGroupSessionDao;
        this.modelMapper = modelMapper;
    }


    @Override
    public MusicGroupSessionDto getMusicGroupSessionById(Integer id) {
        MusicGroupSession musicGroupSession = this.musicGroupSessionDao.findById(id);
        return this.modelMapper.map(musicGroupSession, MusicGroupSessionDto.class);
    }

    @Override
    public List<MusicGroupSessionDto> getAllMusicGroupSessions() {
        return this.musicGroupSessionDao
                .findAll()
                .stream()
                .map(ms -> this.modelMapper.map(ms, MusicGroupSessionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MusicGroupSessionDto addMusicGroupSession(MusicGroupSessionDto musicGroupSessionDto) {
        return modelMapper.map(
                musicGroupSessionDao.create(
                        modelMapper.map(musicGroupSessionDto, MusicGroupSession.class))
                , MusicGroupSessionDto.class);
    }

    @Override
    public MusicGroupSessionDto editMusicGroupSession(Integer id, MusicGroupSessionDto newMusicGroupSession) {
        MusicGroupSession musicGroupSessionToEdit = musicGroupSessionDao.findById(id);
        MusicGroupSession newMusicGroupSessionBase = modelMapper.map(newMusicGroupSession, MusicGroupSession.class);
        musicGroupSessionToEdit.setMusicGroup(newMusicGroupSessionBase.getMusicGroup());
        musicGroupSessionToEdit.setStartTime(newMusicGroupSessionBase.getStartTime());
        musicGroupSessionToEdit.setEndTime(newMusicGroupSessionBase.getEndTime());
        return modelMapper.map(musicGroupSessionToEdit, MusicGroupSessionDto.class);
    }
    @Override
    public MusicGroupSessionDto deleteMusicGroupSession(Integer id) {
        MusicGroupSession musicGroupSessionToDelete = musicGroupSessionDao.findById(id);
        musicGroupSessionDao.delete(musicGroupSessionToDelete);
        return modelMapper.map(musicGroupSessionToDelete, MusicGroupSessionDto.class);
    }
}
