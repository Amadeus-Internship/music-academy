package org.yonitutu.music_academy.service.api;

import org.yonitutu.music_academy.service.dto.MusicGroupDto;
import org.yonitutu.music_academy.service.dto.MusicGroupSessionDto;

import java.util.List;

public interface MusicGroupSessionService {

    MusicGroupSessionDto addMusicGroupSession(MusicGroupSessionDto musicGroupSessionDto);

    MusicGroupSessionDto editMusicGroupSession(Integer id, MusicGroupSessionDto newMusicGroupSession);

    MusicGroupSessionDto deleteMusicGroupSession(Integer id);

    List<MusicGroupSessionDto> getAllMusicGroupSessions();

    MusicGroupSessionDto getMusicGroupSessionById(Integer id);



}
