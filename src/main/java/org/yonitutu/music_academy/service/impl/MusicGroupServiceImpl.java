package org.yonitutu.music_academy.service.impl;

import org.modelmapper.ModelMapper;
import org.yonitutu.music_academy.data.dao.api.MusicGroupDao;
import org.yonitutu.music_academy.data.entities.MusicGroup;
import org.yonitutu.music_academy.service.api.MusicGroupService;
import org.yonitutu.music_academy.service.dto.MusicGroupDto;
import java.util.List;
import java.util.stream.Collectors;

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
        MusicGroup musicGroupToEdit = this.musicGroupDao.findById(id);
        MusicGroup newMusicGroupBase = this.modelMapper.map(newMusicGroup, MusicGroup.class);
        musicGroupToEdit.setTeacher(newMusicGroupBase.getTeacher());
        musicGroupToEdit.setInstrument(newMusicGroupBase.getInstrument());
        musicGroupToEdit.setName(newMusicGroupBase.getName());
        return this.modelMapper.map(musicGroupToEdit, MusicGroupDto.class);
    }

    @Override
    public MusicGroupDto deleteMusicGroup(Integer id) {
        MusicGroup musicGroupToDelete = this.musicGroupDao.findById(id);
        this.musicGroupDao.delete(musicGroupToDelete);
        return this.modelMapper.map(musicGroupToDelete, MusicGroupDto.class);
    }

    @Override
    public List<MusicGroupDto> getAllMusicGroups() {
        return this.musicGroupDao
                .findAll()
                .stream()
                .map(i -> this.modelMapper.map(i, MusicGroupDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MusicGroupDto getMusicGroupById(Integer id) {
        MusicGroup musicGroup = this.musicGroupDao.findById(id);
        return this.modelMapper.map(musicGroup, MusicGroupDto.class);
    }
}
