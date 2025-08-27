package com.eatsleep.hotel.hotel.infrastructure.inputadapter.mapper;

import com.eatsleep.hotel.hotel.domain.model.HotelDomainEntity;
import com.eatsleep.hotel.hotel.infrastructure.inputadapter.dto.HotelResponseDto;
import org.springframework.stereotype.Component;

@Component
public class HotelMapperRest {

    public HotelResponseDto toResponseDto(HotelDomainEntity hotelDomainEntity) {
        if (hotelDomainEntity == null) return null;

        return new HotelResponseDto(hotelDomainEntity.getId(),
                hotelDomainEntity.getName(),
                hotelDomainEntity.getAddress(),
                hotelDomainEntity.getPhone(),
                hotelDomainEntity.getTotalRoom());

    }

}
