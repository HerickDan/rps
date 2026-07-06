package com.application.rps.repository;

import com.application.rps.repository.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity,Integer> {}
