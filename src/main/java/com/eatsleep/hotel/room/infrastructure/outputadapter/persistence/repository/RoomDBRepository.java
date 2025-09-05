package com.eatsleep.hotel.room.infrastructure.outputadapter.persistence.repository;

import com.eatsleep.hotel.room.infrastructure.outputadapter.persistence.entity.RoomDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoomDBRepository extends JpaRepository<RoomDBEntity, UUID> {

    int countByHotel_Id(UUID hotelId);

    List<RoomDBEntity> findByHotel_Id(UUID hotelId);
}
