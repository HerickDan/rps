package com.application.rps.services.impl;

import com.application.rps.commons.dto.CreatePlayerDto;
import com.application.rps.repository.IPlayerRepository;
import com.application.rps.repository.entity.PlayerEntity;
import com.application.rps.services.interfaces.IPlayerService;
import com.application.rps.services.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    IPlayerRepository repository;

    @Override
    public void createPlayer(CreatePlayerDto dto){
        PlayerEntity entity = new PlayerEntity();
        entity.setPlayer_name(dto.getName());
        repository.save(entity);
    }

    @Override
    public PlayerEntity findByPlayerName(String playerName){
        return repository.findByPlayerName(playerName);
    }

}
