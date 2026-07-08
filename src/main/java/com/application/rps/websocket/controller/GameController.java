package com.application.rps.websocket.controller;

import com.application.rps.commons.dto.JoinMatchDto;
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
    public void buildGameRoom(String playerOneName)throws Exception{
        String creatingMatch = gameService.createMatch(playerOneName);
        template.convertAndSend("/room", creatingMatch);
    }

    @MessageMapping("/join-match")
    @SendTo("/room/join-match")
    public void joinMatch(JoinMatchDto dto)throws Exception{
        String joinMatch = gameService.joinMatch(dto);
        template.convertAndSend("/room/join-match", joinMatch);
    }
}
