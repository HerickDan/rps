package com.application.rps.services.interfaces;

import com.application.rps.commons.enums.MovementEnum;
import com.application.rps.repository.entity.GameEntity;

public interface IGameRuleService {
    boolean isPlayerOneWinner(GameEntity match);
    String definePlayer(Boolean isPlayerOne, GameEntity match, MovementEnum movementEnum);
}
