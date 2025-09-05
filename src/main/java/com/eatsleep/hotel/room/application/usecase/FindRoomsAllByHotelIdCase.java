package com.eatsleep.hotel.room.application.usecase;

import com.eatsleep.hotel.common.application.annotations.UseCase;
import com.eatsleep.hotel.room.application.ports.input.ListAllRoomsByHotelIdInputPort;
import com.eatsleep.hotel.room.application.ports.output.FindingAllRoomsByHotelIdOutputPort;
import com.eatsleep.hotel.room.domain.RoomDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class FindRoomsAllByHotelIdCase implements ListAllRoomsByHotelIdInputPort {

    private final FindingAllRoomsByHotelIdOutputPort findingAllRoomsByHotelIdOutputPort;

    @Override
    public List<RoomDomainEntity> listAllRoomsByHotelId(UUID hotelId) {
        return findingAllRoomsByHotelIdOutputPort.findAllByHotelId(hotelId);
    }

}
