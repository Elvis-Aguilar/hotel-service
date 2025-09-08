package com.eatsleep.hotel.reservation.infrastructure.outputadapter.persistence.mapper;

import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;
import com.eatsleep.hotel.reservation.infrastructure.outputadapter.persistence.entity.ReservationDBEntity;
import com.eatsleep.hotel.room.infrastructure.outputadapter.persistence.entity.RoomDBEntity;
import org.springframework.stereotype.Component;

@Component
public class ReservationPersistenceMapper {

    public ReservationDBEntity toDBEntity(ReservationDomainEntity entity, RoomDBEntity roomDBEntity) {
        return ReservationDBEntity.builder()
                .customerId(entity.getCustomerId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .state(entity.getState())
                .pricePerDay(entity.getPricePerDay())
                .totalPrice(entity.getTotalPrice())
                .maintenanceCostPerDay(entity.getMaintenanceCostPerDay())
                .totalCost(entity.getTotalCost())
                .promotionId(entity.getPromotionId())
                .discountPercentage(entity.getDiscountPercentage())
                .room(roomDBEntity)
                .build();
    }

    public ReservationDomainEntity toDomainEntity(ReservationDBEntity entity) {
        return new ReservationDomainEntity(entity.getId(),
                entity.getCustomerId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getState(),
                entity.getPricePerDay(),
                entity.getTotalPrice(),
                entity.getMaintenanceCostPerDay(),
                entity.getTotalCost(),
                entity.getDiscountPercentage(),
                entity.getRoom().getId(),
                entity.getPromotionId());
    }
}
