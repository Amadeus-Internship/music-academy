package org.yonitutu.music_academy.service.impl;

import org.modelmapper.ModelMapper;
import org.yonitutu.music_academy.data.dao.api.MusicGroupSessionDao;
import org.yonitutu.music_academy.data.entities.Instrument;
import org.yonitutu.music_academy.data.entities.MusicGroup;
import org.yonitutu.music_academy.data.entities.MusicGroupSession;
import org.yonitutu.music_academy.data.entities.Teacher;
import org.yonitutu.music_academy.service.api.MusicGroupSessionService;
import org.yonitutu.music_academy.service.dto.MusicGroupDto;
import org.yonitutu.music_academy.service.dto.MusicGroupSessionDto;
import org.yonitutu.music_academy.service.dto.TeacherDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MusicGroupSessionServiceImpl implements MusicGroupSessionService {

    private final ModelMapper modelMapper;

    private final MusicGroupSessionDao musicGroupSessionDao;

    public MusicGroupSessionServiceImpl(ModelMapper modelMapper, MusicGroupSessionDao musicGroupSessionDao) {
        this.modelMapper = modelMapper;
        this.musicGroupSessionDao = musicGroupSessionDao;
    }

    @Override
    public MusicGroupSessionDto addMusicGroupSession(MusicGroupSessionDto musicGroupSessionDto) {
        return this.modelMapper.map(
                this.musicGroupSessionDao.create(
                        this.modelMapper.map(musicGroupSessionDto, MusicGroupSession.class))
                , MusicGroupSessionDto.class);
    }

    @Override
    public MusicGroupSessionDto editMusicGroupSession(Integer id, MusicGroupSessionDto newMusicGroupSession) {
        MusicGroupSession musicGroupSession = musicGroupSessionDao.findById(id);
        MusicGroupSession musicGroupSession1 = modelMapper.map(newMusicGroupSession, MusicGroupSession.class);
        musicGroupSession.setMusicGroup(musicGroupSession1.getMusicGroup());
        musicGroupSession.setStartTime(musicGroupSession1.getStartTime());
        musicGroupSession.setEndTime(musicGroupSession.getEndTime());
        return modelMapper.map(musicGroupSession, MusicGroupSessionDto.class);
    }

    @Override
    public MusicGroupSessionDto deleteMusicGroupSession(Integer id) {
        MusicGroupSession musicGroupSession = musicGroupSessionDao.findById(id);
        musicGroupSessionDao.delete(musicGroupSession);
        return modelMapper.map(musicGroupSession, MusicGroupSessionDto.class);
    }

    @Override
    public List<MusicGroupSessionDto> getAllMusicGroupSessions() {
        List<MusicGroupSession> musicGroupSessions = musicGroupSessionDao.findAll();
        List<MusicGroupSessionDto> musicGroupSessionDtoList = new ArrayList<>();

        for (MusicGroupSession musicGroupSession : musicGroupSessions) {
            MusicGroupSessionDto musicGroupSessionDto = modelMapper.map(musicGroupSession, MusicGroupSessionDto.class);
            musicGroupSessionDtoList.add(musicGroupSessionDto);
        }

        return musicGroupSessionDtoList;
    }

    @Override
    public MusicGroupSessionDto getMusicGroupSessionById(Integer id) {
        MusicGroupSession musicGroupSession = musicGroupSessionDao.findById(id);
        return modelMapper.map(musicGroupSession, MusicGroupSessionDto.class);
    }
}
