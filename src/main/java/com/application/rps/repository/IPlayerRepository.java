package com.application.rps.repository;

import com.application.rps.repository.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerRepository extends JpaRepository<PlayerEntity, Integer> {}
