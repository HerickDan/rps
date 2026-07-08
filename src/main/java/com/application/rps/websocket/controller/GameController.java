package com.application.rps.websocket.controller;

import com.application.rps.commons.dto.CreateGameRoom;
import com.application.rps.services.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {
    @Autowired
    IGameService gameService;
    @Autowired
    SimpMessagingTemplate template;

    @MessageMapping("/game-room")
    @SendTo("/room")
    public void buildGameRoom(String message)throws Exception{
        System.out.println("CHEGOU");
        template.convertAndSend("/room", message);
    }
}
