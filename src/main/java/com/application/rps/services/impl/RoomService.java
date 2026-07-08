package com.application.rps.services.impl;

import com.application.rps.commons.dto.RoomResponseDto;
import com.application.rps.repository.IRoomRepository;
import com.application.rps.repository.entity.PlayerEntity;
import com.application.rps.repository.entity.RoomEntity;
import com.application.rps.services.interfaces.IPlayerService;
import com.application.rps.services.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements IRoomService {
    @Autowired
    IRoomRepository roomRepository;
    @Autowired
    IPlayerService playerService;

    @Override
    public RoomResponseDto createRoom(String playerName) {
        RoomEntity entity = new RoomEntity();
        entity.setPlayer(findPlayerByName(playerName));
        RoomEntity savedRoom = roomRepository.save(entity);
        RoomResponseDto dto = new RoomResponseDto();
        dto.setRoomNumber(savedRoom.getRoomNumber());
        return dto;
    }

    @Override
    public RoomEntity findByRoomNumber(int roomNumber){
        return roomRepository.findByRoomNumber(roomNumber);
    }

    private PlayerEntity findPlayerByName(String playerName){
        return playerService.findByPlayerName(playerName);
    }
}

