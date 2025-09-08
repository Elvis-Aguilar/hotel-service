package com.eatsleep.hotel.reservation.application.usecases;

import com.eatsleep.hotel.common.application.annotations.UseCase;
import com.eatsleep.hotel.reservation.application.ports.input.FindingReservationByIdInputPort;
import com.eatsleep.hotel.reservation.application.ports.output.FindingReservationByIdOutputPort;
import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class FindReservationByIdCase implements FindingReservationByIdInputPort {

    private final FindingReservationByIdOutputPort findingReservationByIdOutputPort;

    @Override
    public ReservationDomainEntity findById(UUID id) {
        return findingReservationByIdOutputPort.findById(id);
    }

}
