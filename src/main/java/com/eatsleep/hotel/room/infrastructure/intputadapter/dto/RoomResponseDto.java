package com.eatsleep.hotel.room.infrastructure.intputadapter.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder(toBuilder = true)
public record RoomResponseDto(
        UUID id,
        String roomNumber,
        BigDecimal pricePerDay,
        BigDecimal costMaintenancePerDay,
        String description,
        Integer capacity,
        String state,
        String hotelName
) {
}
