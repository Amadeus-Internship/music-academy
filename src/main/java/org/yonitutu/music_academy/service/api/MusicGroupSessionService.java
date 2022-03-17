package org.yonitutu.music_academy.service.api;

import org.yonitutu.music_academy.service.dto.MusicGroupSessionDto;

import java.util.List;

public interface MusicGroupSessionService {

    MusicGroupSessionDto getMusicGroupSessionById(Integer id);

    List<MusicGroupSessionDto> getAllMusicGroupSessions();

    MusicGroupSessionDto addMusicGroupSession(MusicGroupSessionDto musicGroupSessionDto);

    MusicGroupSessionDto editMusicGroupSession(Integer id, MusicGroupSessionDto newMusicGroupSession);

    MusicGroupSessionDto deleteMusicGroupSession(Integer id);

}
