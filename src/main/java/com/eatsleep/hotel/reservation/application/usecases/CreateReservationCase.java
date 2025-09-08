package com.eatsleep.hotel.reservation.application.usecases;

import com.eatsleep.hotel.common.application.annotations.UseCase;
import com.eatsleep.hotel.common.application.exception.EntityAlreadyExistsException;
import com.eatsleep.hotel.common.infrastructure.exception.BadRequestException;
import com.eatsleep.hotel.reservation.application.ports.input.CreatingReservationInputPort;
import com.eatsleep.hotel.reservation.application.ports.output.FindingPromotionByCustomerIdOutputPort;
import com.eatsleep.hotel.reservation.application.ports.output.FindingPromotionByRoomIdOutputPort;
import com.eatsleep.hotel.reservation.application.ports.output.FindingReservationRangeDateByRoomIdOutputPort;
import com.eatsleep.hotel.reservation.application.ports.output.StoringReservationOutputPort;
import com.eatsleep.hotel.reservation.domain.model.PromotionDomainEntity;
import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;
import com.eatsleep.hotel.room.application.ports.input.FindingRoomByIdInputPort;
import com.eatsleep.hotel.room.domain.RoomDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@UseCase
@Validated
@RequiredArgsConstructor
public class CreateReservationCase implements CreatingReservationInputPort {

    private final StoringReservationOutputPort storingReservationOutputPort;
    private final FindingReservationRangeDateByRoomIdOutputPort findingReservationRangeDateByRoomIdOutputPort;
    private final FindingPromotionByRoomIdOutputPort findingPromotionByRoomIdOutputPort;
    private final FindingPromotionByCustomerIdOutputPort findingPromotionByCustomerIdOutputPort;
    private final FindingRoomByIdInputPort findingRoomByIdInputPort;

    @Override
    @Transactional
    public void createReservation(CreateReservationDto createReservationDto) {

        LocalDate today = LocalDate.now();

        // Validar que la fecha de inicio no sea anterior a hoy
        if (createReservationDto.getStartDate().isBefore(today)) {
            throw new BadRequestException("La fecha de inicio no puede ser menor a la fecha actual.");
        }

        // Validar que la fecha de inicio sea <= a la fecha fin
        if (createReservationDto.getStartDate().isAfter(createReservationDto.getEndDate())) {
            throw new BadRequestException("La fecha de inicio debe ser menor o igual a la fecha de fin.");
        }

        // validar que las fechas no coincidand con otras reservaciones de esa habitacion
        if(findingReservationRangeDateByRoomIdOutputPort.existRegistersRangeDate(createReservationDto.getRoomId(), createReservationDto.getStartDate(), createReservationDto.getEndDate())) {
            throw new EntityAlreadyExistsException("En estas fechas ya existen reservaciones en la habitacion, por favor revisar");
        }

        // obtener los datos de la promocion si aplica
        List<PromotionDomainEntity> promotionRoom = findingPromotionByRoomIdOutputPort.getPromotionByRoomId(createReservationDto.getRoomId());
        List<PromotionDomainEntity> promotionCustomer = findingPromotionByCustomerIdOutputPort.getPromotionByCustomerId(createReservationDto.getCustomerId());

        BigDecimal discountPercentage = BigDecimal.ZERO;

        if((!promotionRoom.isEmpty()) && promotionRoom.get(0).isActive()) {
            discountPercentage = discountPercentage.add(promotionRoom.get(0).getDiscountPercentage());
        }

        if((!promotionCustomer.isEmpty()) && promotionCustomer.get(0).isActive()) {
            discountPercentage = discountPercentage.add(promotionCustomer.get(0).getDiscountPercentage());
        }

        RoomDomainEntity roomDomainEntity = findingRoomByIdInputPort.findById(createReservationDto.getRoomId());

        //realizar calulos, totals, descuentos..
        long days = ChronoUnit.DAYS.between(
                createReservationDto.getStartDate(),
                createReservationDto.getEndDate()
        ) + 1;

        // Precio base sin descuento
        BigDecimal basePrice = roomDomainEntity.getPricePerDay()
                        .multiply(BigDecimal.valueOf(days));

        // Monto de descuento
        BigDecimal discountAmount = basePrice
                        .multiply(discountPercentage.divide(BigDecimal.valueOf(100)));

        // Total aplicando descuento
        BigDecimal totalPrice = basePrice.subtract(discountAmount);

        BigDecimal totalCost = roomDomainEntity.getCostMaintenancePerDay().multiply(BigDecimal.valueOf(days));

        // guardar la resevacion
        ReservationDomainEntity revation = new ReservationDomainEntity(createReservationDto.getCustomerId(),
                createReservationDto.getStartDate(),
                createReservationDto.getEndDate(),
                "Reservado",
                roomDomainEntity.getPricePerDay(),
                totalPrice,
                roomDomainEntity.getCostMaintenancePerDay(),
                totalCost,
                discountPercentage,
                createReservationDto.getRoomId(),
                null);

        storingReservationOutputPort.save(revation);

    }
}
