package com.application.rps.websocket.controller;

import com.application.rps.commons.dto.JoinMatchDto;
import com.application.rps.commons.dto.PlayGameDto;
import com.application.rps.services.interfaces.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {
    @Autowired
    IMatchService gameService;
    @Autowired
    SimpMessagingTemplate template;

    @MessageMapping("/game-room")
    public void buildGameRoom(String playerOneName) {
        Integer roomNumber = gameService.createMatch(playerOneName);
        String message = "Match created, waiting for player two. Room number: " + roomNumber;
        template.convertAndSend("/room/" + roomNumber, message);
    }

    @MessageMapping("/game-room/join")
    public void joinMatch(JoinMatchDto dto) {
        String joinMatch = gameService.joinMatch(dto);
        template.convertAndSend("/room/" + dto.getRoom_number(), joinMatch);
    }

    @MessageMapping("/game-room/play")
    public void playGame(PlayGameDto dto) {
        String result = gameService.playGame(dto);
        template.convertAndSend("/room/" + dto.getRoomNumber(), result);
    }
}
