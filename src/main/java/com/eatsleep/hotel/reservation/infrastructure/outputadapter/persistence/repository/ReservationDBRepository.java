package com.eatsleep.hotel.reservation.infrastructure.outputadapter.persistence.repository;

import com.eatsleep.hotel.reservation.infrastructure.outputadapter.persistence.entity.ReservationDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationDBRepository extends JpaRepository<ReservationDBEntity, UUID> {

    @Query("""
        SELECT p
        FROM reservation p
        WHERE p.startDate <= :endDate
          AND p.endDate >= :startDate
          AND p.room.id = :roomId
    """)
    List<ReservationDBEntity> findAllByDateRangeAndRoomId(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("roomId") UUID roomId
    );

    List<ReservationDBEntity> findAllByRoomId(UUID roomId);

    List<ReservationDBEntity> findAllByRoomIdAndStartDateGreaterThanEqual(UUID roomId, LocalDate startDate);
}

