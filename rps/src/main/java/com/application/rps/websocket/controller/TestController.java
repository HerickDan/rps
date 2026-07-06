package com.application.rps.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
    @MessageMapping("/build.room/{room}")
    @SendTo("/topic/room/{room}")
    public String hello(String message){
        return message;
    }
}
