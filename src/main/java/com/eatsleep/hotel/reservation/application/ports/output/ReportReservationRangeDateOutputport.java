package com.eatsleep.hotel.reservation.application.ports.output;

import com.eatsleep.hotel.reservation.application.usecases.RangeDateCaseDto;
import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;

import java.time.LocalDate;
import java.util.List;

public interface ReportReservationRangeDateOutputport {
    List<ReservationDomainEntity> reportRangeDate(LocalDate startDate, LocalDate endDate);
}
