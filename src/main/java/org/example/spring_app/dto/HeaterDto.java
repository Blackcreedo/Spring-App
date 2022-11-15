package org.example.spring_app.dto;

import org.example.spring_app.model.Heater;
import org.example.spring_app.model.HeaterStatus;


public class HeaterDto {
    private Long id;
    private String name;
    private HeaterStatus heaterStatus;
    private Long power;
    private String roomName;
    private Long roomId;


    public HeaterDto() {
    }

    public HeaterDto(Heater heater) {
        this.id = heater.getId();
        this.name = heater.getName();
        this.heaterStatus = heater.getHeater_status();
        this.power = heater.getPower();
        this.roomName = heater.getRoom().getName();
        this.roomId = heater.getRoom().getId();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }


}
