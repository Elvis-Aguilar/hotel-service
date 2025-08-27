package com.eatsleep.hotel.hotel.application.usecase.listhotels;


import com.eatsleep.hotel.common.application.annotations.UseCase;
import com.eatsleep.hotel.hotel.application.factory.HotelFactory;
import com.eatsleep.hotel.hotel.application.ports.input.ListAllHotelInputPort;
import com.eatsleep.hotel.hotel.application.ports.output.FindingAllHotelsOutputPort;
import com.eatsleep.hotel.hotel.domain.model.HotelDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ListAllEmployeesUseCase implements ListAllHotelInputPort {

    private final HotelFactory factory;
    private final FindingAllHotelsOutputPort  findingAllHotelsOutputPort;

    @Override
    public List<HotelDomainEntity> ListAllHotel() {
        return findingAllHotelsOutputPort.findAllHotels().stream()
                .map(factory::createHotelWithRoomCount)
                .toList();
    }
}
