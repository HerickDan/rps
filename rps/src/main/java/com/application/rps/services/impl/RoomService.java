package com.application.rps.services.impl;

import com.application.rps.services.interfaces.IRoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements IRoomService {
    private final IRoomService roomInterface;

    public RoomService(IRoomService roomInter) {
        this.roomInterface = roomInter;
    }

    @Override
    public void createRoom(){

    }
}
