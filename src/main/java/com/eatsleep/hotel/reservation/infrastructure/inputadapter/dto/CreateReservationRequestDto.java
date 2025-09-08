package com.eatsleep.hotel.reservation.infrastructure.inputadapter.dto;

import com.eatsleep.hotel.reservation.application.usecases.CreateReservationDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class CreateReservationRequestDto {

    @NotBlank
    String startDate;
    @NotBlank
    String endDate;
    @NotNull
    UUID customerId;
    @NotNull
    UUID roomId;

    public CreateReservationDto toDtoCase(){
        return new CreateReservationDto(customerId, LocalDate.parse(startDate), LocalDate.parse(endDate), roomId);
    }
}
