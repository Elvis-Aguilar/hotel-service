package com.eatsleep.hotel.reservation.application.usecases;

import com.eatsleep.hotel.common.application.annotations.UseCase;
import com.eatsleep.hotel.reservation.application.ports.input.ListAllReservationByRoomIdInputPort;
import com.eatsleep.hotel.reservation.application.ports.input.ListAllReservationCurrentByRoomIdInputPort;
import com.eatsleep.hotel.reservation.application.ports.output.FindingAllCurrentReservationByRoomIdOutputPort;
import com.eatsleep.hotel.reservation.application.ports.output.FindingAllReservationByRoomIdOutputPort;
import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class ListAllReservationCase implements ListAllReservationByRoomIdInputPort,
        ListAllReservationCurrentByRoomIdInputPort {

    private final FindingAllCurrentReservationByRoomIdOutputPort outputPortCurrent;
    private final FindingAllReservationByRoomIdOutputPort outputPort;

    @Override
    public List<ReservationDomainEntity> findAllByRoomId(UUID roomId) {
        return outputPort.findAllByRoomId(roomId);
    }

    @Override
    public List<ReservationDomainEntity> findAllCurrentByRoomId(UUID roomId) {
        return outputPortCurrent.findAllCurrentByRoomId(roomId);
    }
}
