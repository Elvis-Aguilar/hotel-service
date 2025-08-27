package com.eatsleep.hotel.hotel.application.ports.output;

import com.eatsleep.hotel.hotel.domain.model.HotelDomainEntity;

import java.util.List;

public interface FindingAllHotelsOutputPort {

    List<HotelDomainEntity> findAllHotels();
}
