package com.eatsleep.hotel.room.application.ports.input;

import com.eatsleep.hotel.room.domain.RoomDomainEntity;

import java.util.UUID;

public interface FindingRoomByIdInputPort {
    RoomDomainEntity findById(UUID id);
}
