package com.eatsleep.hotel.room.application.usecase;

import com.eatsleep.hotel.common.application.annotations.UseCase;
import com.eatsleep.hotel.room.application.ports.input.ListAllRoomsInputPort;
import com.eatsleep.hotel.room.application.ports.output.FindingRoomsOutputPort;
import com.eatsleep.hotel.room.domain.RoomDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllRoomsCase implements ListAllRoomsInputPort {

    private final FindingRoomsOutputPort findingRoomsOutputPort;

    @Override
    public List<RoomDomainEntity> listAllRooms() {
        return findingRoomsOutputPort.findAllRooms();
    }
}
