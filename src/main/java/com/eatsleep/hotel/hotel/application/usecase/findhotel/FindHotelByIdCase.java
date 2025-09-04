package com.eatsleep.hotel.hotel.application.usecase.findhotel;

import com.eatsleep.hotel.common.application.annotations.UseCase;
import com.eatsleep.hotel.hotel.application.factory.HotelFactory;
import com.eatsleep.hotel.hotel.application.ports.input.FindingHotelByIdInputPort;
import com.eatsleep.hotel.hotel.application.ports.output.FindingHotelByIdOutputPort;
import com.eatsleep.hotel.hotel.domain.model.HotelDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class FindHotelByIdCase implements FindingHotelByIdInputPort {

    private final HotelFactory factory;
    private final FindingHotelByIdOutputPort findingHotelByIdOutputPort;

    @Override
    public HotelDomainEntity findById(UUID id) {
        return factory.createHotelWithRoomCount(findingHotelByIdOutputPort.findingHotelById(id));
    }
}
