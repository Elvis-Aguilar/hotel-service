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
    private String hotelName;

    public RoomDomainEntity(String state, Integer capacity, String description, BigDecimal costMaintenancePerDay, BigDecimal pricePerDay, String roomNumber, UUID id, String hotelName) {
        this.state = state;
        this.capacity = capacity;
        this.description = description;
        this.costMaintenancePerDay = costMaintenancePerDay;
        this.pricePerDay = pricePerDay;
        this.roomNumber = roomNumber;
        this.id = id;
        this.hotelName = hotelName;
    }

    public RoomDomainEntity(String state, Integer capacity, String description, BigDecimal costMaintenancePerDay, BigDecimal pricePerDay, String roomNumber, String hotelName) {
        this.state = state;
        this.capacity = capacity;
        this.description = description;
        this.costMaintenancePerDay = costMaintenancePerDay;
        this.pricePerDay = pricePerDay;
        this.roomNumber = roomNumber;
        this.hotelName = hotelName;
    }
}
