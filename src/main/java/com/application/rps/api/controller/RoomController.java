package com.application.rps.api.controller;

import com.application.rps.services.interfaces.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game-room")
public class RoomController {
    @Autowired
    IMatchService matchService;

    @PostMapping("/{player-name}")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createMatch(@PathVariable String playerName) {
        return matchService.createMatch(playerName);
    }
}
