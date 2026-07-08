package com.application.rps.websocket.controller;

import com.application.rps.commons.dto.CreateGameRoom;
import com.application.rps.services.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {
    @Autowired
    IGameService gameService;

    @MessageMapping("/game-room")
    @SendTo("/game/room")
    public String buildGameRoom(CreateGameRoom message)throws Exception{
        return message;
    }
}
