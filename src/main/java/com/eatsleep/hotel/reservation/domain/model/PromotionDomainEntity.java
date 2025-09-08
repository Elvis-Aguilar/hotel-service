package com.eatsleep.hotel.reservation.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class PromotionDomainEntity {
    private UUID id;
    private BigDecimal discountPercentage;
    private boolean active;

    public PromotionDomainEntity(UUID id, BigDecimal discountPercentage, boolean active) {
        this.id = id;
        this.discountPercentage = discountPercentage;
        this.active = active;
    }
}
