package com.application.rps.services.interfaces;

import com.application.rps.commons.dto.JoinMatchDto;

public interface IGameService {
    String createMatch(String playerName);
    String joinMatch(JoinMatchDto dto);
}
