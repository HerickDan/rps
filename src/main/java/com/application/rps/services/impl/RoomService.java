package com.application.rps.services.impl;

import com.application.rps.commons.dto.RoomResponseDto;
import com.application.rps.repository.IRoomRepository;
import com.application.rps.repository.entity.RoomEntity;
import com.application.rps.services.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements IRoomService {
    @Autowired
    IRoomRepository roomRepository;

    @Override
    public RoomResponseDto createRoom() {
        RoomEntity entity = new RoomEntity();
        RoomEntity savedRoom = roomRepository.save(entity);
        RoomResponseDto dto = new RoomResponseDto();
        dto.setRoomNumber(savedRoom.getRoomNumber());
        return dto;
    }
}
