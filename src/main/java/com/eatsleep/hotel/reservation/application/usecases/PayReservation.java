package com.eatsleep.hotel.reservation.application.usecases;

import com.eatsleep.hotel.common.application.annotations.UseCase;
import com.eatsleep.hotel.common.infrastructure.exception.BadRequestException;
import com.eatsleep.hotel.reservation.application.ports.input.ChangeReservationStatusInputPort;
import com.eatsleep.hotel.reservation.application.ports.output.FindingReservationByIdOutputPort;
import com.eatsleep.hotel.reservation.application.ports.output.UpdateReservationStatusOutputPort;
import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@UseCase
@Validated
@RequiredArgsConstructor
public class PayReservation implements ChangeReservationStatusInputPort {

    private final UpdateReservationStatusOutputPort outputPort;
    private final FindingReservationByIdOutputPort outputPortFind;

    @Override
    @Transactional
    public ReservationDomainEntity changeReservationStatus(UUID id, String status) {
        String statusPay = "Pagado";
        if (!status.equalsIgnoreCase(statusPay)) {
            throw new BadRequestException("Estado no permitida");
        }

        ReservationDomainEntity entity = outputPortFind.findById(id);

        if (entity.getState().equals(status)) throw new BadRequestException("Reservacion ya Pagada");


        return outputPort.updateReservationStatus(id, status);
    }
}
