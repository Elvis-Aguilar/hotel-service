package com.eatsleep.hotel.reservation.application.ports.input;

import com.eatsleep.hotel.reservation.application.usecases.CreateReservationDto;
import jakarta.validation.Valid;

public interface CreatingReservationInputPort {
    void createReservation(@Valid CreateReservationDto createReservationDto);
}
