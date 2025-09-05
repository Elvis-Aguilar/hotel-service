package com.eatsleep.hotel.room.infrastructure.intputadapter.mapper;

import com.eatsleep.hotel.room.domain.RoomDomainEntity;
import com.eatsleep.hotel.room.infrastructure.intputadapter.dto.RoomResponseDto;
import org.springframework.stereotype.Component;

@Component
public class RoomRestMapper {

    public RoomResponseDto toResponseDto(RoomDomainEntity entity){
        if(entity == null){ return null;}

        return RoomResponseDto.builder()
                .id(entity.getId())
                .state(entity.getState())
                .description(entity.getDescription())
                .capacity(entity.getCapacity())
                .costMaintenancePerDay(entity.getCostMaintenancePerDay())
                .pricePerDay(entity.getPricePerDay())
                .roomNumber(entity.getRoomNumber())
                .build();

    }
}
