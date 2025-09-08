package com.eatsleep.hotel.reservation.application.ports.input;

import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;

import java.util.List;
import java.util.UUID;

public interface ListAllReservationByRoomIdInputPort {
    List<ReservationDomainEntity> findAllByRoomId(UUID roomId);
}
