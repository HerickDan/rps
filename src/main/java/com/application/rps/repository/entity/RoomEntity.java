package com.application.rps.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
public class RoomEntity {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String apiId = UUID.randomUUID().toString();
    int roomNumber = new Random().nextInt(1, 10000);
}
