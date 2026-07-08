package com.application.rps.services.interfaces;


import com.application.rps.commons.dto.RoomResponseDto;
import com.application.rps.repository.entity.RoomEntity;

public interface IRoomService {
    RoomResponseDto createRoom(String playerName);
    RoomEntity findByRoomNumber(int roomNumber);
}
