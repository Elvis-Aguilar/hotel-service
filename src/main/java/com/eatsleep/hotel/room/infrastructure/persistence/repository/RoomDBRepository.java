package com.eatsleep.hotel.room.infrastructure.persistence.repository;

import com.eatsleep.hotel.room.infrastructure.persistence.entity.RoomDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomDBRepository extends JpaRepository<RoomDBEntity, UUID> {

    int countByHotel_Id(UUID hotelId);
}
