package com.eatsleep.hotel.reservation.application.ports.input;

import com.eatsleep.hotel.reservation.application.usecases.RangeDateCaseDto;
import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;
import java.util.List;

public interface ReportReservationRangeDateInputPort {
    List<ReservationDomainEntity> reportRangeDate(RangeDateCaseDto rangeDateCaseDto);
}
