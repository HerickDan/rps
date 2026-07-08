package com.application.rps.api.controller;

import com.application.rps.commons.dto.CreatePlayerDto;
import com.application.rps.services.interfaces.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    IPlayerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlayer(
            @RequestBody CreatePlayerDto dto
    ) {
        service.createPlayer(dto);
    }
}
