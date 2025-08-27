package com.eatsleep.hotel.hotel.application.factory;

import com.eatsleep.hotel.hotel.domain.model.HotelDomainEntity;
import com.eatsleep.hotel.room.application.ports.output.CountingRoomByHotelOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HotelFactory {

    private final CountingRoomByHotelOutputPort  countingRoomByHotelOutputPort;

    public HotelDomainEntity createHotelWithRoomCount(HotelDomainEntity hotel) {
        int count = countingRoomByHotelOutputPort.countRoomByHotel(hotel.getId());
        return new HotelDomainEntity(hotel.getId(), hotel.getName(), hotel.getAddress(), hotel.getPhone(), count);
    }


}
