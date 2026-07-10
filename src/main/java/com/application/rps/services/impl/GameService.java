package com.application.rps.services.impl;

import com.application.rps.commons.dto.JoinMatchDto;
import com.application.rps.commons.dto.PlayGameDto;
import com.application.rps.commons.dto.RoomResponseDto;
import com.application.rps.commons.enums.MovementEnum;
import com.application.rps.repository.IGameRepository;
import com.application.rps.repository.entity.GameEntity;
import com.application.rps.repository.entity.PlayerEntity;
import com.application.rps.repository.entity.RoomEntity;
import com.application.rps.services.interfaces.IGameService;
import com.application.rps.services.interfaces.IPlayerService;
import com.application.rps.services.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService implements IGameService {
    @Autowired
    IPlayerService playerService;
    @Autowired
    IRoomService roomService;
    @Autowired
    IGameRepository gameRepository;

    @Override
    public String createMatch(
            String playerName
    ){
        GameEntity entity = new GameEntity();
        RoomResponseDto room = roomService.createRoom(playerName);
        RoomEntity roomNumber = roomService.findByRoomNumber(room.getRoomNumber());
        entity.setRoom(roomNumber);
        PlayerEntity playerOne = playerService.findByPlayerName(playerName);
        entity.setPlayerOne(playerOne);
        gameRepository.save(entity);
        return "match created, waiting player two  \n this is the room number: " + room.getRoomNumber();
    }

    @Override
    public String joinMatch(JoinMatchDto dto){
        PlayerEntity playerTwo = playerService.findByPlayerName(dto.getPlayerName());
        RoomEntity room = roomService.findByRoomNumber(dto.getRoom_number());
        GameEntity gameMatch = gameRepository.findByRoom( room);
            gameMatch.setPlayerTwo(playerTwo);
            gameRepository.save(gameMatch);
            return "Created Match";
    }

    @Override
    public String playGame(PlayGameDto dto) {

        RoomEntity room = roomService.findByRoomNumber(dto.getRoomNumber());
        GameEntity match = gameRepository.findByRoom(room);

        boolean isPlayerOne = match.getPlayerOne().getPlayer_name().equals(dto.getPlayerName());

        if (isPlayerOne) {
            if (match.getP1movement() != null) {
                return "Player one already played";
            }
            match.setP1movement(dto.getMovementEnum());
        } else {
            if (match.getP2movement() != null) {
                return "Player two already played";
            }
            match.setP2movement(dto.getMovementEnum());
        }

        gameRepository.save(match);

        if (match.getP1movement() == null || match.getP2movement() == null) {
            return "Waiting for the other player...";
        }

        if (match.getP1movement() == match.getP2movement()) {
            return "Draw";
        }

        boolean playerOneWins = switch (match.getP1movement()) {
            case ROCK -> match.getP2movement() == MovementEnum.SCISSOR;
            case PAPER -> match.getP2movement() == MovementEnum.ROCK;
            case SCISSOR -> match.getP2movement() == MovementEnum.PAPER;
        };

        match.setWinner(playerOneWins ? match.getPlayerOne() : match.getPlayerTwo());
        gameRepository.save(match);

        return playerOneWins ? "Player One Wins" : "Player Two Wins";
    }
}
