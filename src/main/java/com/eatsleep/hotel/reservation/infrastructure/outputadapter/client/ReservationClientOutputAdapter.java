package com.eatsleep.hotel.reservation.infrastructure.outputadapter.client;

import com.eatsleep.hotel.common.infrastructure.exception.ExternalServiceException;
import com.eatsleep.hotel.reservation.application.ports.output.FindingPromotionByCustomerIdOutputPort;
import com.eatsleep.hotel.reservation.application.ports.output.FindingPromotionByRoomIdOutputPort;
import com.eatsleep.hotel.reservation.domain.model.PromotionDomainEntity;
import com.eatsleep.hotel.reservation.infrastructure.outputadapter.client.mapper.PromotionClientMapper;
import com.eatsleep.hotel.reservation.infrastructure.outputadapter.client.rest.PromotionRestClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationClientOutputAdapter implements FindingPromotionByRoomIdOutputPort, FindingPromotionByCustomerIdOutputPort {

    private final PromotionRestClient promotionRestClient;
    private final PromotionClientMapper mapper;

    @Override
    public List<PromotionDomainEntity> getPromotionByRoomId(UUID id) {
        try {
            return promotionRestClient.getAllPromotionFindByRoomId(id)
                    .stream()
                    .map(mapper::toDomainEntity)
                    .toList();
        }catch (FeignException e) {
            e.getStackTrace();
            throw new ExternalServiceException("No se pudo obtener la lista de promociones de habitaciones.");
        }
    }

    @Override
    public List<PromotionDomainEntity> getPromotionByCustomerId(UUID id) {
        try {
            return promotionRestClient.getAllPromotionFindByCustomerId(id)
                    .stream()
                    .map(mapper::toDomainEntity)
                    .toList();
        }catch (FeignException e) {
            throw new ExternalServiceException("No se pudo obtener la lista de promociones de clientes.");
        }
    }
}
