package com.eatsleep.hotel.room.infrastructure.outputadapter.persistence;

import com.eatsleep.hotel.common.infrastructure.annotation.PersistenceAdapter;
import com.eatsleep.hotel.common.infrastructure.exception.BadRequestException;
import com.eatsleep.hotel.room.application.ports.output.CountingRoomByHotelOutputPort;
import com.eatsleep.hotel.room.application.ports.output.FindingAllRoomsByHotelIdOutputPort;
import com.eatsleep.hotel.room.application.ports.output.FindingRoomByHotelIdOutputPort;
import com.eatsleep.hotel.room.domain.RoomDomainEntity;
import com.eatsleep.hotel.room.infrastructure.outputadapter.persistence.entity.RoomDBEntity;
import com.eatsleep.hotel.room.infrastructure.outputadapter.persistence.mapper.RoomPersistenceMapper;
import com.eatsleep.hotel.room.infrastructure.outputadapter.persistence.repository.RoomDBRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class RoomRepositoryOutputAdapter implements CountingRoomByHotelOutputPort, FindingRoomByHotelIdOutputPort,
        FindingAllRoomsByHotelIdOutputPort {

    private final RoomDBRepository roomDBRepository;
    private final RoomPersistenceMapper mapper;

    @Override
    public int countRoomByHotel(UUID hotelId) {
        return roomDBRepository.countByHotel_Id(hotelId);
    }

    @Override
    public List<RoomDomainEntity> findAllByHotelId(UUID id) {
        return roomDBRepository.findByHotel_Id(id).stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public RoomDomainEntity findById(UUID id) {
        RoomDBEntity entity =  roomDBRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Room no encontrado"));

        return mapper.toDomain(entity);
    }
}
