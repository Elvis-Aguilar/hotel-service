package com.eatsleep.hotel.room.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class RoomDomainEntity {

    private UUID id;
    private String roomNumber;
    private BigDecimal pricePerDay;
    private BigDecimal costMaintenancePerDay;
    private String description;
    private Integer capacity;
    private String state;

    public RoomDomainEntity(String state, Integer capacity, String description, BigDecimal costMaintenancePerDay, BigDecimal pricePerDay, String roomNumber, UUID id) {
        this.state = state;
        this.capacity = capacity;
        this.description = description;
        this.costMaintenancePerDay = costMaintenancePerDay;
        this.pricePerDay = pricePerDay;
        this.roomNumber = roomNumber;
        this.id = id;
    }

    public RoomDomainEntity(String state, Integer capacity, String description, BigDecimal costMaintenancePerDay, BigDecimal pricePerDay, String roomNumber) {
        this.state = state;
        this.capacity = capacity;
        this.description = description;
        this.costMaintenancePerDay = costMaintenancePerDay;
        this.pricePerDay = pricePerDay;
        this.roomNumber = roomNumber;
    }
}
