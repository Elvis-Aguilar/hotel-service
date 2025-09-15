package com.eatsleep.hotel.reservation.application.usecases;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

@Value
@AllArgsConstructor
public class RangeDateCaseDto {
    LocalDate startDate;
    LocalDate endDate;
}
