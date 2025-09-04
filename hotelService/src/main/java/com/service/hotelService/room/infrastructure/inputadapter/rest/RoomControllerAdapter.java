package com.service.hotelService.room.infrastructure.inputadapter.rest;

import com.service.hotelService.common.infrastructure.annotation.WebAdapter;
import com.service.hotelService.reservation.application.ports.input.CheckRoomAvailabilityInputPort;
import com.service.hotelService.room.application.ports.input.*;
import com.service.hotelService.room.domain.model.RoomDomainEntity;
import com.service.hotelService.room.infrastructure.inputadapter.dto.*;
import com.service.hotelService.room.infrastructure.inputadapter.mapper.RoomMapperRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@WebAdapter
@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomControllerAdapter {

    private final CreateRoomInputPort createRoomInputPort;
    private final ListRoomInputPort listRoomInputPort;
    private final GetRoomByIdInputPort getRoomByIdInputPort;
    private final UpdateRoomInputPort updateRoomInputPort;
    private final DeleteRoomInputPort deleteRoomInputPort;
    private final CheckRoomAvailabilityInputPort checkRoomAvailabilityInputPort;

    @PostMapping
    public ResponseEntity<RoomResponseDto> create(@RequestBody RoomRequestDto dto) {
        RoomDomainEntity saved = createRoomInputPort.create(RoomMapperRest.toDomain(dto));
        return ResponseEntity.ok(RoomMapperRest.toResponse(saved));
    }

    @GetMapping
    public ResponseEntity<List<RoomResponseDto>> listAll() {
        List<RoomResponseDto> list = listRoomInputPort.listAll().stream().map(RoomMapperRest::toResponse).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponseDto> getById(@PathVariable UUID id) {
        RoomDomainEntity r = getRoomByIdInputPort.getById(id);
        return ResponseEntity.ok(RoomMapperRest.toResponse(r));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomResponseDto> update(@PathVariable UUID id, @RequestBody RoomRequestDto dto) {
        RoomDomainEntity updated = updateRoomInputPort.update(id, RoomMapperRest.toDomain(dto));
        return ResponseEntity.ok(RoomMapperRest.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteRoomInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/cost")
    public ResponseEntity<java.math.BigDecimal> cost(@PathVariable UUID id, @RequestParam int days) {
        RoomDomainEntity r = getRoomByIdInputPort.getById(id);
        java.math.BigDecimal daysBd = java.math.BigDecimal.valueOf(days);
        java.math.BigDecimal price = r.getPricePerDay().multiply(daysBd);
        java.math.BigDecimal maintenance = r.getMaintenanceCostPerDay().multiply(daysBd);
        java.math.BigDecimal total = price.add(maintenance);
        return ResponseEntity.ok(total);
    }

    @GetMapping("/{id}/availability")
    public ResponseEntity<Boolean> availability(@PathVariable UUID id,
                                                @RequestParam LocalDate startDate,
                                                @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(checkRoomAvailabilityInputPort.isAvailable(id, startDate, endDate));
    }
}
