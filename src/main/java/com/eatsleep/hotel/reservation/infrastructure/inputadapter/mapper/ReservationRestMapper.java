package com.eatsleep.hotel.reservation.infrastructure.inputadapter.mapper;

import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;
import com.eatsleep.hotel.reservation.infrastructure.inputadapter.dto.ReservationResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationRestMapper {

    public ReservationResponseDto toResponseDto(ReservationDomainEntity domainEntity) {
        return ReservationResponseDto.builder()
                .id(domainEntity.getId())
                .customerId(domainEntity.getCustomerId())
                .startDate(domainEntity.getStartDate())
                .endDate(domainEntity.getEndDate())
                .pricePerDay(domainEntity.getPricePerDay())
                .totalPrice(domainEntity.getTotalPrice())
                .maintenanceCostPerDay(domainEntity.getMaintenanceCostPerDay())
                .totalCost(domainEntity.getTotalCost())
                .discountPercentage(domainEntity.getDiscountPercentage())
                .state(domainEntity.getState())
                .roomId(domainEntity.getRoomId())
                .build();

    }
}
