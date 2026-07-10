package com.application.rps.commons.dto;

import com.application.rps.commons.enums.MovementEnum;

public class PlayGameDto {
    String playerName;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public MovementEnum getMovementEnum() {
        return movementEnum;
    }

    public void setMovementEnum(MovementEnum movementEnum) {
        this.movementEnum = movementEnum;
    }

    int roomNumber;
    MovementEnum movementEnum;
}
