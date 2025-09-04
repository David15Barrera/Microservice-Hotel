
package com.service.hotelService.reservation.infrastructure.inputadapter.rest;

import com.service.hotelService.common.infrastructure.annotation.WebAdapter;
import com.service.hotelService.reservation.application.ports.input.*;
import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;
import com.service.hotelService.reservation.infrastructure.inputadapter.dto.*;
import com.service.hotelService.reservation.infrastructure.inputadapter.mapper.ReservationMapperRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@WebAdapter
@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationControllerAdapter {
    private final CreateReservationInputPort createReservationInputPort;
    private final UpdateReservationInputPort updateReservationInputPort;
    private final DeleteReservationInputPort deleteReservationInputPort;
    private final GetReservationByIdInputPort getReservationByIdInputPort;
    private final ListReservationsByRoomInputPort listReservationsByRoomInputPort;
    private final CheckRoomAvailabilityInputPort checkRoomAvailabilityInputPort;
    private final FindReservationsByCustomerInputPort findReservationsByCustomerInputPort;
    private final FindAllReservationsInputPort findAllReservationsInputPort;
    @PostMapping
    public ResponseEntity<ReservationResponseDto> create(@RequestBody ReservationRequestDto dto) {
        ReservationDomainEntity created = createReservationInputPort.create(ReservationMapperRest.toDomain(dto));
        return ResponseEntity.ok(ReservationMapperRest.toResponse(created));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<ReservationResponseDto> update(@PathVariable UUID id, @RequestBody ReservationRequestDto dto) {
        ReservationDomainEntity updated = updateReservationInputPort.update(id, ReservationMapperRest.toDomain(dto));
        return ResponseEntity.ok(ReservationMapperRest.toResponse(updated));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteReservationInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ReservationResponseDto> get(@PathVariable UUID id) {
        return ResponseEntity.ok(ReservationMapperRest.toResponse(getReservationByIdInputPort.getById(id)));
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<ReservationResponseDto>> listByRoom(@PathVariable UUID roomId) {
        List<ReservationDomainEntity> list = listReservationsByRoomInputPort.listByRoom(roomId);
        return ResponseEntity.ok(list.stream().map(ReservationMapperRest::toResponse).toList());
    }

    @GetMapping("/availability")
    public ResponseEntity<Boolean> availability(@RequestParam UUID roomId,
                                                @RequestParam LocalDate startDate,
                                                @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(checkRoomAvailabilityInputPort.isAvailable(roomId, startDate, endDate));
    }
    @GetMapping("/by-customer/{customerId}")
    public ResponseEntity<List<ReservationResponseDto>> getReservationsByCustomer(@PathVariable UUID customerId) {
        List<ReservationDomainEntity> reservations = findReservationsByCustomerInputPort.findByCustomerId(customerId);
        List<ReservationResponseDto> response = reservations.stream()
                .map(ReservationMapperRest::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponseDto>> getAllReservations() {
        var reservations = findAllReservationsInputPort.findAll()
                .stream()
                .map(ReservationMapperRest::toResponse)
                .toList();
        return ResponseEntity.ok(reservations);
    }
}
