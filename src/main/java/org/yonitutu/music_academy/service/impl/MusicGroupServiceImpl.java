package org.yonitutu.music_academy.service.impl;

import org.modelmapper.ModelMapper;
import org.yonitutu.music_academy.data.dao.api.MusicGroupDao;
import org.yonitutu.music_academy.data.entities.MusicGroup;
import org.yonitutu.music_academy.data.entities.Teacher;
import org.yonitutu.music_academy.service.api.MusicGroupService;
import org.yonitutu.music_academy.service.dto.MusicGroupDto;
import org.yonitutu.music_academy.service.dto.TeacherDto;

import java.util.ArrayList;
import java.util.List;

public class MusicGroupServiceImpl implements MusicGroupService {

    private final MusicGroupDao musicGroupDao;

    private final ModelMapper modelMapper;


    public MusicGroupServiceImpl(MusicGroupDao musicGroupDao, ModelMapper modelMapper) {
        this.musicGroupDao = musicGroupDao;
        this.modelMapper = modelMapper;
    }


    @Override
    public MusicGroupDto addMusicGroupDto(MusicGroupDto musicGroupDto) {
        return this.modelMapper.map(
                this.musicGroupDao.create(
                        this.modelMapper.map(musicGroupDto, MusicGroup.class))
                , MusicGroupDto.class);
    }

    @Override
    public MusicGroupDto editMusicGroup(Integer id, MusicGroupDto newMusicGroup) {
        MusicGroup musicGroup = musicGroupDao.findById(id);
        MusicGroup musicGroup1 = modelMapper.map(newMusicGroup, MusicGroup.class);
        musicGroup.setInstrument(musicGroup1.getInstrument());
        musicGroup.setName(musicGroup1.getName());
        musicGroup.setTeacher(musicGroup1.getTeacher());
        return modelMapper.map(musicGroup, MusicGroupDto.class);
    }

    @Override
    public MusicGroupDto deleteMusicGroup(Integer id) {
        MusicGroup musicGroup = musicGroupDao.findById(id);
        musicGroupDao.delete(musicGroup);
        return modelMapper.map(musicGroup, MusicGroupDto.class);
    }

    @Override
    public List<MusicGroupDto> getAllMusicGroups() {
        List<MusicGroup> musicGroups = musicGroupDao.findAll();
        List<MusicGroupDto> musicGroupDtoList = new ArrayList<>();

        for (MusicGroup musicGroup : musicGroups) {
            MusicGroupDto musicGroupDto = modelMapper.map(musicGroup, MusicGroupDto.class);
            musicGroupDtoList.add(musicGroupDto);
        }

        return musicGroupDtoList;
    }

    @Override
    public MusicGroupDto getMusicGroupById(Integer id) {
        MusicGroup musicGroup = musicGroupDao.findById(id);
        return modelMapper.map(musicGroup, MusicGroupDto.class);
    }
}
