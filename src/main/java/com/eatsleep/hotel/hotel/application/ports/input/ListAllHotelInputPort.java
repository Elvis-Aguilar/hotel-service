package com.eatsleep.hotel.hotel.application.ports.input;

import com.eatsleep.hotel.hotel.domain.model.HotelDomainEntity;

import java.util.List;

public interface ListAllHotelInputPort {
    List<HotelDomainEntity> ListAllHotel();
}
