package com.eatsleep.hotel.reservation.infrastructure.inputadapter.rest;

import com.eatsleep.hotel.common.infrastructure.annotation.WebAdapter;
import com.eatsleep.hotel.reservation.application.ports.input.*;
import com.eatsleep.hotel.reservation.application.usecases.CreateReservationDto;
import com.eatsleep.hotel.reservation.application.usecases.RangeDateCaseDto;
import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;
import com.eatsleep.hotel.reservation.infrastructure.inputadapter.dto.CreateReservationRequestDto;
import com.eatsleep.hotel.reservation.infrastructure.inputadapter.dto.RangeDateRequestDto;
import com.eatsleep.hotel.reservation.infrastructure.inputadapter.dto.ReservationResponseDto;
import com.eatsleep.hotel.reservation.infrastructure.inputadapter.mapper.ReservationRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/reservations")
@WebAdapter
@RequiredArgsConstructor
public class ReservationControllerAdapter {

    private final ReservationRestMapper mapper;
    private final CreatingReservationInputPort creatingReservationInputPort;
    private final FindingReservationByIdInputPort findingReservationByIdInputPort;
    private final ListAllReservationByRoomIdInputPort listAllReservationByRoomIdInputPort;
    private final ListAllReservationCurrentByRoomIdInputPort listAllReservationCurrentByRoomIdInputPort;
    private final ListAllReservationByCustomerIdInputPort listAllReservationByCustomerIdInputPort;
    private final ChangeReservationStatusInputPort changeReservationStatusInputPort;
    private final ReportReservationRangeDateInputPort  reportReservationRangeDateInputPort;

    @PostMapping
    public ResponseEntity<Void> createReservation(@RequestBody @Valid CreateReservationRequestDto dto) {
        CreateReservationDto dtoCase = dto.toDtoCase();
        creatingReservationInputPort.createReservation(dtoCase);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<ReservationResponseDto> payReservation(@PathVariable UUID id) {
        ReservationResponseDto dto = mapper.
                toResponseDto(changeReservationStatusInputPort.changeReservationStatus(id, "Pagado"));

        return ResponseEntity.ok(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ReservationResponseDto> findByRoomId(@PathVariable UUID id) {
        ReservationResponseDto dto = mapper.toResponseDto(findingReservationByIdInputPort.findById(id));

        return ResponseEntity.ok(dto);
    }


    @GetMapping("/rooms/{roomId}")
    public ResponseEntity<List<ReservationResponseDto>> findAllByRoomId(@PathVariable UUID roomId) {
        List<ReservationResponseDto> list = listAllReservationByRoomIdInputPort.findAllByRoomId(roomId)
                .stream()
                .map(mapper::toResponseDto)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/rooms/current/{roomId}")
    public ResponseEntity<List<ReservationResponseDto>> findAllCurrentByRoomId(@PathVariable UUID roomId) {
        List<ReservationResponseDto> list = listAllReservationCurrentByRoomIdInputPort.findAllCurrentByRoomId(roomId)
                .stream()
                .map(mapper::toResponseDto)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<ReservationResponseDto>> findAllByCustomerId(@PathVariable UUID customerId) {
        List<ReservationResponseDto> list = listAllReservationByCustomerIdInputPort.findAllByCustomerId(customerId)
                .stream()
                .map(mapper::toResponseDto)
                .toList();

        return ResponseEntity.ok(list);
    }

    @PostMapping("/report")
    public ResponseEntity<List<ReservationResponseDto>> findAllByReportRangeDate(@RequestBody @Valid RangeDateRequestDto dto) {
        RangeDateCaseDto dtoCase = dto.toCase();

        List<ReservationResponseDto> list = reportReservationRangeDateInputPort.reportRangeDate(dtoCase)
                .stream()
                .map(mapper::toResponseDto)
                .toList();

        return ResponseEntity.ok(list);
    }

}
