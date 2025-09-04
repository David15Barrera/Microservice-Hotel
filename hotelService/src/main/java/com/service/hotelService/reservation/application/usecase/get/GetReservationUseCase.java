
package com.service.hotelService.reservation.application.usecase.get;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.reservation.application.ports.input.CheckRoomAvailabilityInputPort;
import com.service.hotelService.reservation.application.ports.input.FindAllReservationsInputPort;
import com.service.hotelService.reservation.application.ports.input.GetReservationByIdInputPort;
import com.service.hotelService.reservation.application.ports.input.ListReservationsByRoomInputPort;
import com.service.hotelService.reservation.application.ports.output.CheckAvailabilityOutputPort;
import com.service.hotelService.reservation.application.ports.output.FindAllReservationsOutputPort;
import com.service.hotelService.reservation.application.ports.output.FindReservationByIdOutputPort;
import com.service.hotelService.reservation.application.ports.output.FindReservationsByRoomOutputPort;
import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class GetReservationUseCase implements GetReservationByIdInputPort, ListReservationsByRoomInputPort, CheckRoomAvailabilityInputPort, FindAllReservationsInputPort {
    private final FindReservationByIdOutputPort findReservationByIdOutputPort;
    private final FindReservationsByRoomOutputPort findReservationsByRoomOutputPort;
    private final CheckAvailabilityOutputPort checkAvailabilityOutputPort;
    private final FindAllReservationsOutputPort findAllReservationsOutputPort;

    @Override
    public ReservationDomainEntity getById(UUID id) {
        return findReservationByIdOutputPort.findById(id);
    }

    @Override
    public List<ReservationDomainEntity> listByRoom(UUID roomId) {
        return findReservationsByRoomOutputPort.findByRoom(roomId);
    }

    @Override
    public boolean isAvailable(UUID roomId, LocalDate startDate, LocalDate endDate) {
        return checkAvailabilityOutputPort.isAvailable(roomId, startDate, endDate);
    }

    @Override
    public List<ReservationDomainEntity> findAll() {
        return findAllReservationsOutputPort.findAll();
    }
}
