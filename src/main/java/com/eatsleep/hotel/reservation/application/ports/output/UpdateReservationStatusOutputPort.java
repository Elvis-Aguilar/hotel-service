package com.eatsleep.hotel.reservation.application.ports.output;

import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;

import java.util.UUID;

public interface UpdateReservationStatusOutputPort {
    ReservationDomainEntity updateReservationStatus(UUID id, String status);
}
