package com.service.hotelService.hotel.infrastructure.inputadapter.rest;

import com.service.hotelService.common.infrastructure.annotation.WebAdapter;
import com.service.hotelService.hotel.application.ports.input.*;
import com.service.hotelService.hotel.domain.model.HotelDomainEntity;
import com.service.hotelService.hotel.infrastructure.inputadapter.dto.HotelRequestDto;
import com.service.hotelService.hotel.infrastructure.inputadapter.dto.HotelResponseDto;
import com.service.hotelService.hotel.infrastructure.inputadapter.mapper.HotelMapperRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@WebAdapter
@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
public class HotelControllerAdapter {

    private final CreateHotelInputPort createHotelInputPort;
    private final ListAllHotelInputPort listAllHotelInputPort;
    private final GetHotelByIdInputPort getHotelByIdInputPort;
    private final UpdateHotelInputPort updateHotelInputPort;
    private final DeleteHotelInputPort deleteHotelInputPort;
    private final HotelMapperRest hotelMapperRest;

    @PostMapping
    public ResponseEntity<HotelResponseDto> create(@RequestBody HotelRequestDto dto) {
        HotelDomainEntity domain = hotelMapperRest.toDomain(dto);
        HotelDomainEntity created = createHotelInputPort.create(domain);
        return ResponseEntity.ok(hotelMapperRest.toResponseDto(created));
    }

    @GetMapping
    public ResponseEntity<List<HotelResponseDto>> listAll() {
        List<HotelResponseDto> hotels = listAllHotelInputPort.ListAllHotel().stream().map(hotelMapperRest::toResponseDto).toList();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponseDto> getById(@PathVariable UUID id) {
        HotelDomainEntity h = getHotelByIdInputPort.getById(id);
        return ResponseEntity.ok(hotelMapperRest.toResponseDto(h));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelResponseDto> update(@PathVariable UUID id, @RequestBody HotelRequestDto dto) {
        HotelDomainEntity domain = hotelMapperRest.toDomain(dto);
        HotelDomainEntity updated = updateHotelInputPort.update(id, domain);
        return ResponseEntity.ok(hotelMapperRest.toResponseDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteHotelInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
