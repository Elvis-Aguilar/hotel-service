package com.eatsleep.hotel.hotel.infrastructure.inputadapter.rest;


import com.eatsleep.hotel.common.infrastructure.annotation.WebAdapter;
import com.eatsleep.hotel.hotel.application.ports.input.FindingHotelByIdInputPort;
import com.eatsleep.hotel.hotel.application.ports.input.ListAllHotelInputPort;
import com.eatsleep.hotel.hotel.infrastructure.inputadapter.dto.HotelResponseDto;
import com.eatsleep.hotel.hotel.infrastructure.inputadapter.mapper.HotelMapperRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/hotels")
@WebAdapter
@RequiredArgsConstructor
public class HotelControllerAdapter {

    private final ListAllHotelInputPort listAllHotelInputPort;
    private final HotelMapperRest  hotelMapperRest;
    private final FindingHotelByIdInputPort findingHotelByIdInputPort;

    @GetMapping
    public ResponseEntity<List<HotelResponseDto>> listAllHotels() {
        List<HotelResponseDto> hotels = listAllHotelInputPort.ListAllHotel().
                stream()
                .map(hotelMapperRest::toResponseDto)
                .toList();

        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelResponseDto> findById(@PathVariable UUID hotelId) {
        HotelResponseDto dto = hotelMapperRest.toResponseDto(findingHotelByIdInputPort.findById(hotelId));
        return ResponseEntity.ok(dto);
    }
}
