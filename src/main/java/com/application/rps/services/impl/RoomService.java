package com.application.rps.services.impl;

import com.application.rps.commons.dto.RoomResponseDto;
import com.application.rps.repository.IRoomRepository;
import com.application.rps.repository.entity.PlayerEntity;
import com.application.rps.repository.entity.RoomEntity;
import com.application.rps.services.interfaces.IPlayerService;
import com.application.rps.services.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomService implements IRoomService {
    @Autowired
    IRoomRepository roomRepository;
    @Autowired
    IPlayerService playerService;

    @Transactional
    @Override
    public RoomResponseDto createRoom(String playerName) {
        PlayerEntity player = findPlayerByName(playerName);
        if (player == null) {
            throw new IllegalArgumentException("Player not found: " + playerName);
        }
        RoomEntity entity = new RoomEntity();
        entity.setPlayer(player);
        RoomEntity savedRoom = roomRepository.save(entity);
        RoomResponseDto dto = new RoomResponseDto();
        dto.setRoomNumber(savedRoom.getRoomNumber());
        return dto;
    }

    @Transactional(readOnly = true)
    @Override
    public RoomEntity findByRoomNumber(int roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    private PlayerEntity findPlayerByName(String playerName) {
        return playerService.findByPlayerName(playerName);
    }
}
