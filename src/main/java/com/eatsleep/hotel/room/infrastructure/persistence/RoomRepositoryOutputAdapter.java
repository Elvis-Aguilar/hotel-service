package com.eatsleep.hotel.room.infrastructure.persistence;

import com.eatsleep.hotel.common.infrastructure.annotation.PersistenceAdapter;
import com.eatsleep.hotel.room.application.ports.output.CountingRoomByHotelOutputPort;
import com.eatsleep.hotel.room.infrastructure.persistence.repository.RoomDBRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class RoomRepositoryOutputAdapter implements CountingRoomByHotelOutputPort {

    private final RoomDBRepository roomDBRepository;

    @Override
    public int countRoomByHotel(UUID hotelId) {
        return roomDBRepository.countByHotel_Id(hotelId);
    }
}
