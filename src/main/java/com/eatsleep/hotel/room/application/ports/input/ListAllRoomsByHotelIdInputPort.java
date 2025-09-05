package com.eatsleep.hotel.room.application.ports.input;

import com.eatsleep.hotel.room.domain.RoomDomainEntity;

import java.util.List;
import java.util.UUID;

public interface ListAllRoomsByHotelIdInputPort {
    List<RoomDomainEntity> listAllRoomsByHotelId(UUID hotelId);
}
