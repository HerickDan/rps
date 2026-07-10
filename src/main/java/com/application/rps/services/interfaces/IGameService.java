package com.application.rps.services.interfaces;

import com.application.rps.commons.dto.JoinMatchDto;
import com.application.rps.commons.dto.PlayGameDto;

public interface IGameService {
    String createMatch(String playerName);
    String joinMatch(JoinMatchDto dto);
    String playGame(PlayGameDto dto);
}
