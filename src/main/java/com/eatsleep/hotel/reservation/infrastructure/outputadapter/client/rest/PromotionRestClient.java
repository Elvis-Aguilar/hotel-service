package com.eatsleep.hotel.reservation.infrastructure.outputadapter.client.rest;

import com.eatsleep.hotel.reservation.infrastructure.outputadapter.client.dto.PromotionResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "promotion", url = "${client.services.promotion}/api/promotion")
public interface PromotionRestClient {

    @GetMapping("/v1/promotions/room/{roomId}")
    List<PromotionResponseDto> getAllPromotionFindByRoomId(@PathVariable UUID roomId);

    @GetMapping("/v1/promotions/customer/{customerId}")
    List<PromotionResponseDto> getAllPromotionFindByCustomerId(@PathVariable UUID customerId);
}
