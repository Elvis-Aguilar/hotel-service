package com.eatsleep.hotel.reservation.infrastructure.outputadapter.client.mapper;

import com.eatsleep.hotel.reservation.domain.model.PromotionDomainEntity;
import com.eatsleep.hotel.reservation.infrastructure.outputadapter.client.dto.PromotionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class PromotionClientMapper {

    public PromotionDomainEntity toDomainEntity(PromotionResponseDto dto){
        return new PromotionDomainEntity(dto.id(), dto.discountPercentage(), dto.active());
    }
}
