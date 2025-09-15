package com.eatsleep.hotel.reservation.application.usecases;

import com.eatsleep.hotel.common.application.annotations.UseCase;
import com.eatsleep.hotel.reservation.application.ports.input.ReportReservationRangeDateInputPort;
import com.eatsleep.hotel.reservation.application.ports.output.ReportReservationRangeDateOutputport;
import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@UseCase
@Validated
@RequiredArgsConstructor
public class ReportReservationRangeDateCase implements ReportReservationRangeDateInputPort {

    private final ReportReservationRangeDateOutputport reportReservationRangeDateOutputport;

    @Override
    public List<ReservationDomainEntity> reportRangeDate(RangeDateCaseDto rangeDateCaseDto) {
        return reportReservationRangeDateOutputport.reportRangeDate(rangeDateCaseDto.getStartDate(), rangeDateCaseDto.getEndDate());
    }
}
