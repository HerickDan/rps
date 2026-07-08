package com.application.rps.commons.dto;

public class CreatePlayerDto {
    String name;

    public String getName(){
        return this.name;
    };

    public void setName(String name){
        this.name = name;
    }
}
