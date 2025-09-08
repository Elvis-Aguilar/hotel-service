package com.eatsleep.hotel.reservation.application.ports.output;

import java.time.LocalDate;
import java.util.UUID;

public interface FindingReservationRangeDateByRoomIdOutputPort {
    boolean existRegistersRangeDate(UUID roomId, LocalDate startDate, LocalDate endDate);
}
