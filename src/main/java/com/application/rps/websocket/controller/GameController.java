package com.application.rps.websocket.controller;

import com.application.rps.commons.dto.JoinMatchDto;
import com.application.rps.commons.dto.PlayGameDto;
import com.application.rps.services.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
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
        String room = gameService.createMatch(playerOneName);
        template.convertAndSend(
                "/room/" + room,
                room
        );
    }

    @MessageMapping("/game-room/join")
    public void joinMatch(JoinMatchDto dto)throws Exception{
        String joinMatch = gameService.joinMatch(dto);
        template.convertAndSend("/room/" + dto.getRoom_number(), joinMatch);
    }

    @MessageMapping("/game-room/play")
    public void playGame(PlayGameDto dto)throws Exception{
        String joinMatch = gameService.playGame(dto);
        template.convertAndSend("/room/" + dto.getRoomNumber(), joinMatch);
    }
}
