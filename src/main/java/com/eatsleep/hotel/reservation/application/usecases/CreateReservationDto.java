package com.eatsleep.hotel.reservation.application.usecases;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
@AllArgsConstructor
public class CreateReservationDto {
    UUID customerId;
    LocalDate startDate;
    LocalDate endDate;
    UUID roomId;
}
