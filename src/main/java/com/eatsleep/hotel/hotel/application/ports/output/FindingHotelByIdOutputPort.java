package com.eatsleep.hotel.hotel.application.ports.output;

import com.eatsleep.hotel.hotel.domain.model.HotelDomainEntity;

import java.util.UUID;

public interface FindingHotelByIdOutputPort {
    HotelDomainEntity findingHotelById(UUID id);
}
