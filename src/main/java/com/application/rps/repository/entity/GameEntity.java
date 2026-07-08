package com.application.rps.repository.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Controller;

@Entity
@Table(name = "game")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name = "id")
    @Column(name = "player_one")
    PlayerEntity playerOne;
    @ManyToOne
    @JoinColumn(name = "id")
    @Column(name = "player_two")
    PlayerEntity playerTwo;
    @ManyToOne
    @JoinColumn(name = "id")
    PlayerEntity winner;
    @ManyToOne
    @JoinColumn(name = "room_number")
    @Column(name = "game_room")
    RoomEntity gameRoom;

    public PlayerEntity getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(PlayerEntity playerOne) {
        this.playerOne = playerOne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerEntity getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(PlayerEntity playerTwo) {
        this.playerTwo = playerTwo;
    }

    public PlayerEntity getWinner() {
        return winner;
    }

    public void setWinner(PlayerEntity winner) {
        this.winner = winner;
    }

    public RoomEntity getGameRoom() {
        return gameRoom;
    }

    public void setGameRoom(RoomEntity gameRoom) {
        this.gameRoom = gameRoom;
    }
}
