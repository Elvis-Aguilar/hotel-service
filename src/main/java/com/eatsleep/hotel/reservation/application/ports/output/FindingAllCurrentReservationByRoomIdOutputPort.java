package com.eatsleep.hotel.reservation.application.ports.output;

import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindingAllCurrentReservationByRoomIdOutputPort {
    List<ReservationDomainEntity> findAllCurrentByRoomId(UUID roomId);
}
