package com.eatsleep.hotel.hotel.infrastructure.outputadapter.persistence.mapper;

import com.eatsleep.hotel.hotel.domain.model.HotelDomainEntity;
import com.eatsleep.hotel.hotel.infrastructure.outputadapter.persistence.entity.HotelDBEntity;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public HotelDomainEntity toDomain(HotelDBEntity hotelDBEntity) {
        if (hotelDBEntity == null) { return null; }

        return new HotelDomainEntity(hotelDBEntity.getId(),
                hotelDBEntity.getName(),
                hotelDBEntity.getAddress(),
                hotelDBEntity.getPhone(),
                0);
    }
}
