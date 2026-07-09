package com.application.rps.services.impl;

import com.application.rps.commons.dto.JoinMatchDto;
import com.application.rps.commons.dto.RoomResponseDto;
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
}
