package com.eatsleep.hotel.room.application.ports.output;

import com.eatsleep.hotel.room.domain.RoomDomainEntity;

import java.util.List;

public interface FindingRoomsOutputPort {
    List<RoomDomainEntity> findAllRooms();
}
