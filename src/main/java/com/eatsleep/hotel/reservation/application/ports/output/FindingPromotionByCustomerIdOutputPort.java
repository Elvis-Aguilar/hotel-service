package com.eatsleep.hotel.reservation.application.ports.output;

import com.eatsleep.hotel.reservation.domain.model.PromotionDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindingPromotionByCustomerIdOutputPort {
    List<PromotionDomainEntity> getPromotionByCustomerId(UUID id);

}
