package com.eatsleep.hotel.hotel.application.ports.input;

import com.eatsleep.hotel.hotel.domain.model.HotelDomainEntity;

import java.util.UUID;

public interface FindingHotelByIdInputPort {
    HotelDomainEntity findById(UUID id);
}
