package com.application.rps.services.interfaces;

import com.application.rps.commons.dto.JoinMatchDto;
import com.application.rps.commons.dto.PlayGameDto;

public interface IMatchService {
    Integer createMatch(String playerName);
    String joinMatch(JoinMatchDto dto);
    String playGame(PlayGameDto dto);
}
