package com.eatsleep.hotel.reservation.application.ports.output;

import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;

public interface StoringReservationOutputPort {
    void save(ReservationDomainEntity reservation);
}
