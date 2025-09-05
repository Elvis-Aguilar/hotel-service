package com.eatsleep.hotel.room.infrastructure.outputadapter.persistence.mapper;

import com.eatsleep.hotel.room.domain.RoomDomainEntity;
import com.eatsleep.hotel.room.infrastructure.outputadapter.persistence.entity.RoomDBEntity;
import org.springframework.stereotype.Component;

@Component
public class RoomPersistenceMapper {

    public RoomDomainEntity toDomain(RoomDBEntity roomDBEntity) {
        if (roomDBEntity == null) { return null; }

        return new RoomDomainEntity(roomDBEntity.getState(),
                roomDBEntity.getCapacity(),
                roomDBEntity.getDescription(),
                roomDBEntity.getCostMaintenancePerDay(),
                roomDBEntity.getPricePerDay(),
                roomDBEntity.getRoomNumber(),
                roomDBEntity.getId());
    }
}
