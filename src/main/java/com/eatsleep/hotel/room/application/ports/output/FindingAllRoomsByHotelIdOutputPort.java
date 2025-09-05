package com.eatsleep.hotel.room.application.ports.output;

import com.eatsleep.hotel.room.domain.RoomDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindingAllRoomsByHotelIdOutputPort {
    List<RoomDomainEntity> findAllByHotelId(UUID id);
}
