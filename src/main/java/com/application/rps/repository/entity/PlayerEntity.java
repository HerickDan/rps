package com.application.rps.repository.entity;


import jakarta.persistence.*;
import lombok.Builder;

import java.util.UUID;

@Table(name = "player")
@Entity
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String apiId = UUID.randomUUID().toString();
    @Column(name = "player_name")
    String playerName;

    public PlayerEntity( String player_name) {
        this.playerName = player_name;
    }

    public PlayerEntity() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApiId() {
        return apiId;
    }
    public String getPlayer_name() {
        return playerName;
    }

    public void setPlayer_name(String player_name) {
        this.playerName = player_name;
    }
}
