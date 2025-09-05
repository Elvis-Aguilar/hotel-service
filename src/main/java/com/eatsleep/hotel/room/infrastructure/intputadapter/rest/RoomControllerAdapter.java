package com.eatsleep.hotel.room.infrastructure.intputadapter.rest;

import com.eatsleep.hotel.common.infrastructure.annotation.WebAdapter;
import com.eatsleep.hotel.room.application.ports.input.FindingRoomByIdInputPort;
import com.eatsleep.hotel.room.application.ports.input.ListAllRoomsByHotelIdInputPort;
import com.eatsleep.hotel.room.infrastructure.intputadapter.dto.RoomResponseDto;
import com.eatsleep.hotel.room.infrastructure.intputadapter.mapper.RoomRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/rooms")
@WebAdapter
@RequiredArgsConstructor
public class RoomControllerAdapter {

    private final ListAllRoomsByHotelIdInputPort listAllRoomsByHotelIdInputPort;
    private final FindingRoomByIdInputPort  findingRoomByIdInputPort;
    private final RoomRestMapper mapper;


    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<RoomResponseDto>> findAllRoomsByHotelId(@PathVariable UUID hotelId) {
        List<RoomResponseDto> dtos = listAllRoomsByHotelIdInputPort.listAllRoomsByHotelId(hotelId)
                .stream()
                .map(mapper::toResponseDto).toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomResponseDto> findRoomById(@PathVariable UUID roomId) {
        RoomResponseDto dto = mapper.toResponseDto(findingRoomByIdInputPort.findById(roomId));
        return ResponseEntity.ok(dto);
    }

}
