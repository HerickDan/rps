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
    String player_name;

    public PlayerEntity( String player_name) {
        this.player_name = player_name;
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
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }
}
