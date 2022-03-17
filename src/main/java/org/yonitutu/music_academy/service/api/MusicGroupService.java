package org.yonitutu.music_academy.service.api;
// TODO:  CREATE MUSIC GROUP -> add-music-group|{name}|{instrumentName}|{teacherName}
//        EDIT MUSIC GROUP -> edit-music-group|{id}|{name}|{instrumentName}|{teacherName}
//        DELETE MUSIC GROUP -> delete-music-group|{id}
//        FIND ALL MUSIC GROUPS -> find-music-groups
//        FIND SPECIFIC MUSIC GROUP -> find-music-group|{id}


import org.yonitutu.music_academy.service.dto.MusicGroupDto;

import java.util.List;

public interface MusicGroupService {

    MusicGroupDto addMusicGroupDto(MusicGroupDto musicGroupDto);

    MusicGroupDto editMusicGroup(Integer id, MusicGroupDto newMusicGroup);

    MusicGroupDto deleteMusicGroup(Integer id);

    List<MusicGroupDto> getAllMusicGroups();

    MusicGroupDto getMusicGroupById(Integer id);
}
