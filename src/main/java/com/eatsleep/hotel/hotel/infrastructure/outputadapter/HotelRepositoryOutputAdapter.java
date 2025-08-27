package com.eatsleep.hotel.hotel.infrastructure.outputadapter;

import com.eatsleep.hotel.common.infrastructure.annotation.PersistenceAdapter;
import com.eatsleep.hotel.hotel.application.ports.output.FindingAllHotelsOutputPort;
import com.eatsleep.hotel.hotel.domain.model.HotelDomainEntity;
import com.eatsleep.hotel.hotel.infrastructure.outputadapter.persistence.mapper.HotelMapper;
import com.eatsleep.hotel.hotel.infrastructure.outputadapter.persistence.repository.HotelDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class HotelRepositoryOutputAdapter implements FindingAllHotelsOutputPort {

    private final HotelDBRepository hotelDBRepository;
    private final HotelMapper hotelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<HotelDomainEntity> findAllHotels() {
        return hotelDBRepository.findAll().stream()
                .map(hotelMapper::toDomain).toList();
    }
}
