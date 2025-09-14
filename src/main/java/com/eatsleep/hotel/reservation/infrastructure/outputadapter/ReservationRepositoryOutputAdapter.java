package com.eatsleep.hotel.reservation.infrastructure.outputadapter;

import com.eatsleep.hotel.common.infrastructure.annotation.PersistenceAdapter;
import com.eatsleep.hotel.common.infrastructure.exception.BadRequestException;
import com.eatsleep.hotel.reservation.application.ports.output.*;
import com.eatsleep.hotel.reservation.domain.model.ReservationDomainEntity;
import com.eatsleep.hotel.reservation.infrastructure.outputadapter.persistence.entity.ReservationDBEntity;
import com.eatsleep.hotel.reservation.infrastructure.outputadapter.persistence.mapper.ReservationPersistenceMapper;
import com.eatsleep.hotel.reservation.infrastructure.outputadapter.persistence.repository.ReservationDBRepository;
import com.eatsleep.hotel.room.infrastructure.outputadapter.persistence.entity.RoomDBEntity;
import com.eatsleep.hotel.room.infrastructure.outputadapter.persistence.repository.RoomDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class ReservationRepositoryOutputAdapter implements StoringReservationOutputPort, FindingReservationRangeDateByRoomIdOutputPort,
        FindingReservationByIdOutputPort, FindingAllCurrentReservationByRoomIdOutputPort, FindingAllReservationByRoomIdOutputPort,
        FindingReservationByCustomerIdOutputPort, UpdateReservationStatusOutputPort{

    private final ReservationDBRepository reservationDBRepository;
    private final RoomDBRepository roomDBRepository;
    private final ReservationPersistenceMapper mapper;

    @Override
    @Transactional
    public void save(ReservationDomainEntity reservation) {
        // buscar room por id
        RoomDBEntity roomDBEntity = roomDBRepository.findById(reservation.getRoomId())
                .orElseThrow(() -> new BadRequestException("habitacion invalida para reservar"));

        // guardar reservacion
        ReservationDBEntity dbEntity = mapper.toDBEntity(reservation, roomDBEntity);

        reservationDBRepository.save(dbEntity);
    }

    @Override
    public boolean existRegistersRangeDate(UUID roomId, LocalDate startDate, LocalDate endDate) {
        return !reservationDBRepository.findAllByDateRangeAndRoomId(startDate, endDate, roomId).isEmpty();
    }

    @Override
    public ReservationDomainEntity findById(UUID id) {
        ReservationDBEntity entity = reservationDBRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Reservacion no encontrada"));
        return mapper.toDomainEntity(entity);
    }

    @Override
    public List<ReservationDomainEntity> findAllByRoomId(UUID roomId) {
        return reservationDBRepository.findAllByRoomId(roomId)
                .stream()
                .map(mapper::toDomainEntity)
                .toList();
    }

    @Override
    public List<ReservationDomainEntity> findAllCurrentByRoomId(UUID roomId) {
        return reservationDBRepository.findAllByRoomIdAndStartDateGreaterThanEqual(roomId, LocalDate.now())
                .stream()
                .map(mapper::toDomainEntity)
                .toList();
    }

    @Override
    public List<ReservationDomainEntity> findAllByCustomerId(UUID customerId) {
        return reservationDBRepository.findAllByCustomerId(customerId)
                .stream()
                .map(mapper::toDomainEntity)
                .toList();
    }

    @Override
    @Transactional
    public ReservationDomainEntity updateReservationStatus(UUID id, String status) {
        ReservationDBEntity dbUpdate = reservationDBRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Reservacion no encontrada"));

        dbUpdate.setState(status);

        return mapper.toDomainEntity(reservationDBRepository.save(dbUpdate));
    }
}
