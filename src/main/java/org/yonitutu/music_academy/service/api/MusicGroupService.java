package org.yonitutu.music_academy.service.api;

import org.yonitutu.music_academy.service.dto.MusicGroupDto;

import java.util.List;

public interface MusicGroupService {
    MusicGroupDto addMusicGroupDto(MusicGroupDto musicGroupDto);

    MusicGroupDto editMusicGroup(Integer id, MusicGroupDto newMusicGroup);

    MusicGroupDto deleteMusicGroup(Integer id);

    List<MusicGroupDto> getAllMusicGroups();

    MusicGroupDto getMusicGroupById(Integer id);
}
