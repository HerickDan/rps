package com.application.rps.api.controller;

import com.application.rps.commons.dto.RoomResponseDto;
import com.application.rps.services.impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game-room")
public class RoomController {
    @Autowired
    RoomService service;

    @PostMapping("/{player-name}")
    @ResponseStatus(HttpStatus.CREATED)
    public RoomResponseDto createRoom(@PathVariable String playerGame){
        return service.createRoom();
    }
}
