package com.application.rps.services.impl;

import com.application.rps.services.interfaces.IGameService;
import com.application.rps.services.interfaces.IPlayerService;
import com.application.rps.services.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService implements IGameService {
    @Autowired
    IPlayerService playerService;
    @Autowired
    IRoomService roomService;
}
