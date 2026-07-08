package com.application.rps.services.interfaces;


import com.application.rps.commons.dto.CreatePlayerDto;
import com.application.rps.repository.entity.PlayerEntity;

public interface IPlayerService {
    void createPlayer(CreatePlayerDto dto);
    PlayerEntity findByPlayerByName(String name);
}
