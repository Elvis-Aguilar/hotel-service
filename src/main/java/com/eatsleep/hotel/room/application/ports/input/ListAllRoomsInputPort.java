package com.eatsleep.hotel.room.application.ports.input;

import com.eatsleep.hotel.room.domain.RoomDomainEntity;

import java.util.List;

public interface ListAllRoomsInputPort {
    List<RoomDomainEntity> listAllRooms();
}
