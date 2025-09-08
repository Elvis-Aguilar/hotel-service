package com.eatsleep.hotel.reservation.application.ports.input;

import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;

import java.util.UUID;

public interface FindingReservationByIdInputPort {

    ReservationDomainEntity findById(UUID id);
}
