package com.eatsleep.hotel.room.application.ports.output;

import com.eatsleep.hotel.room.domain.RoomDomainEntity;

import java.util.UUID;

public interface FindingRoomByHotelIdOutputPort {
    RoomDomainEntity findById(UUID id);
}
