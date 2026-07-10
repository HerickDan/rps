package com.application.rps.repository.entity;

import com.application.rps.commons.enums.MovementEnum;
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
    MovementEnum p1movement;
    MovementEnum p2movement;

    public MovementEnum getP1movement() {
        return p1movement;
    }

    public void setP1movement(MovementEnum p1movement) {
        this.p1movement = p1movement;
    }

    public MovementEnum getP2movement() {
        return p2movement;
    }

    public void setP2movement(MovementEnum p2movement) {
        this.p2movement = p2movement;
    }

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
