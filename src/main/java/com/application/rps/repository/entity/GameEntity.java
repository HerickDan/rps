package com.application.rps.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name = "player_one", referencedColumnName = "id")
    PlayerEntity playerOne;
    @ManyToOne
    @JoinColumn(name = "player_two", referencedColumnName = "id")
    PlayerEntity playerTwo;
    @ManyToOne
    @JoinColumn(name = "winner", referencedColumnName = "id")
    PlayerEntity winner;
    @ManyToOne
    @JoinColumn(name = "game_room", referencedColumnName = "room_number")
    RoomEntity room;

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

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }
}
