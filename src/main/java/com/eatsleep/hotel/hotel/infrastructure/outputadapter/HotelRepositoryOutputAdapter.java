package com.eatsleep.hotel.hotel.infrastructure.outputadapter;

import com.eatsleep.hotel.common.infrastructure.annotation.PersistenceAdapter;
import com.eatsleep.hotel.common.infrastructure.exception.BadRequestException;
import com.eatsleep.hotel.hotel.application.ports.output.FindingAllHotelsOutputPort;
import com.eatsleep.hotel.hotel.application.ports.output.FindingHotelByIdOutputPort;
import com.eatsleep.hotel.hotel.domain.model.HotelDomainEntity;
import com.eatsleep.hotel.hotel.infrastructure.outputadapter.persistence.entity.HotelDBEntity;
import com.eatsleep.hotel.hotel.infrastructure.outputadapter.persistence.mapper.HotelMapper;
import com.eatsleep.hotel.hotel.infrastructure.outputadapter.persistence.repository.HotelDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class HotelRepositoryOutputAdapter implements FindingAllHotelsOutputPort, FindingHotelByIdOutputPort {

    private final HotelDBRepository hotelDBRepository;
    private final HotelMapper hotelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<HotelDomainEntity> findAllHotels() {
        return hotelDBRepository.findAll().stream()
                .map(hotelMapper::toDomain).toList();
    }

    @Override
    public HotelDomainEntity findingHotelById(UUID id) {
        HotelDBEntity hotelDBEntity = hotelDBRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Hotel con id " + id + " no encontrado"));

        return hotelMapper.toDomain(hotelDBEntity);

    }
}
