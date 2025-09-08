package com.eatsleep.hotel.reservation.infrastructure.outputadapter.client.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder(toBuilder = true)
public record PromotionResponseDto(
        UUID id,
        String name,
        String description,
        BigDecimal discountPercentage,
        boolean active
) {
}