package com.application.rps.services.impl;

import com.application.rps.commons.enums.MovementEnum;
import com.application.rps.repository.entity.GameEntity;
import com.application.rps.services.interfaces.IGameRuleService;
import org.springframework.stereotype.Service;

@Service
public class GameRuleService implements IGameRuleService {

    @Override
    public String definePlayer(Boolean isPlayerOne, GameEntity match, MovementEnum movementEnum) {
        if (isPlayerOne) {
            if (match.getP1movement() != null) {
                return match.getPlayerOne().getPlayer_name() + " already played";
            }
            match.setP1movement(movementEnum);
        } else {
            if (match.getP2movement() != null) {
                return match.getPlayerTwo().getPlayer_name() + " already played";
            }
            match.setP2movement(movementEnum);
        }

        if (match.getP1movement() == null || match.getP2movement() == null) {
            return "Waiting for the other player...";
        } else if (match.getP1movement() == match.getP2movement()) {
            return "Draw";
        }
        return "";
    }

    @Override
    public boolean isPlayerOneWinner(GameEntity match) {
        return switch (match.getP1movement()) {
            case ROCK -> match.getP2movement() == MovementEnum.SCISSOR;
            case PAPER -> match.getP2movement() == MovementEnum.ROCK;
            case SCISSOR -> match.getP2movement() == MovementEnum.PAPER;
        };
    }
}
