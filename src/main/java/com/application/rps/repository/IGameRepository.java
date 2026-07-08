package com.application.rps.repository;

import com.application.rps.repository.entity.GameEntity;
import com.application.rps.repository.entity.PlayerEntity;
import com.application.rps.repository.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameRepository extends JpaRepository<GameEntity, Integer> {
    GameEntity findByPlayerOneAndRoomNumber(PlayerEntity playerOne, RoomEntity room);
}
