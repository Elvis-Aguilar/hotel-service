package com.eatsleep.hotel.room.application.usecase;

import com.eatsleep.hotel.common.application.annotations.UseCase;
import com.eatsleep.hotel.room.application.ports.input.FindingRoomByIdInputPort;
import com.eatsleep.hotel.room.application.ports.output.FindingRoomByHotelIdOutputPort;
import com.eatsleep.hotel.room.domain.RoomDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class FindRoomByIdCase implements FindingRoomByIdInputPort {

    private final FindingRoomByHotelIdOutputPort findingRoomByHotelIdOutputPort;

    @Override
    public RoomDomainEntity findById(UUID id) {
        return findingRoomByHotelIdOutputPort.findById(id);
    }
}
