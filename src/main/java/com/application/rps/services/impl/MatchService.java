package com.application.rps.services.impl;

import com.application.rps.commons.dto.JoinMatchDto;
import com.application.rps.commons.dto.PlayGameDto;
import com.application.rps.commons.dto.RoomResponseDto;
import com.application.rps.repository.IGameRepository;
import com.application.rps.repository.entity.GameEntity;
import com.application.rps.repository.entity.PlayerEntity;
import com.application.rps.repository.entity.RoomEntity;
import com.application.rps.services.interfaces.IGameRuleService;
import com.application.rps.services.interfaces.IMatchService;
import com.application.rps.services.interfaces.IPlayerService;
import com.application.rps.services.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatchService implements IMatchService {
    @Autowired
    IPlayerService playerService;
    @Autowired
    IRoomService roomService;
    @Autowired
    IGameRepository gameRepository;
    @Autowired
    IGameRuleService gameRuleService;

    @Transactional
    @Override
    public Integer createMatch(String playerName) {
        PlayerEntity playerOne = playerService.findByPlayerName(playerName);
        if (playerOne == null) {
            throw new IllegalArgumentException("Player not found: " + playerName);
        }
        GameEntity entity = new GameEntity();
        RoomResponseDto room = roomService.createRoom(playerName);
        RoomEntity roomEntity = roomService.findByRoomNumber(room.getRoomNumber());
        entity.setRoom(roomEntity);
        entity.setPlayerOne(playerOne);
        gameRepository.save(entity);
        return room.getRoomNumber();
    }

    @Transactional
    @Override
    public String joinMatch(JoinMatchDto dto) {
        PlayerEntity playerTwo = playerService.findByPlayerName(dto.getPlayerName());
        if (playerTwo == null) {
            throw new IllegalArgumentException("Player not found: " + dto.getPlayerName());
        }
        RoomEntity room = roomService.findByRoomNumber(dto.getRoom_number());
        if (room == null) {
            throw new IllegalArgumentException("Room not found: " + dto.getRoom_number());
        }
        GameEntity gameMatch = gameRepository.findByRoom(room);
        if (gameMatch == null) {
            throw new IllegalStateException("No match found for room: " + dto.getRoom_number());
        }
        gameMatch.setPlayerTwo(playerTwo);
        gameRepository.save(gameMatch);
        return "Match joined successfully";
    }

    @Transactional
    @Override
    public String playGame(PlayGameDto dto) {
        RoomEntity room = roomService.findByRoomNumber(dto.getRoomNumber());
        if (room == null) {
            throw new IllegalArgumentException("Room not found: " + dto.getRoomNumber());
        }
        GameEntity match = gameRepository.findByRoom(room);
        if (match == null) {
            throw new IllegalStateException("No match found for room: " + dto.getRoomNumber());
        }
        if (match.getPlayerTwo() == null) {
            throw new IllegalStateException("Waiting for player two to join");
        }

        boolean isPlayerOne = match.getPlayerOne().getPlayer_name().equals(dto.getPlayerName());
        String result = gameRuleService.definePlayer(isPlayerOne, match, dto.getMovementEnum());

        if ("Draw".equals(result)) {
            gameRepository.save(match);
            return "Draw";
        }
        if (result.contains("already played")) {
            return result;
        }
        if ("Waiting for the other player...".equals(result)) {
            return result;
        }

        boolean playerOneWins = gameRuleService.isPlayerOneWinner(match);
        match.setWinner(playerOneWins ? match.getPlayerOne() : match.getPlayerTwo());
        gameRepository.save(match);
        return playerOneWins ? "Player One Wins" : "Player Two Wins";
    }
}
