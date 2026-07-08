package com.application.rps.services.interfaces;


import com.application.rps.commons.dto.CreatePlayerDto;

public interface IPlayerService {
    public default void createPlayer(CreatePlayerDto dto){}
}
