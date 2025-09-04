
package com.service.hotelService.reservation.application.usecase.update;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.reservation.application.ports.input.UpdateReservationInputPort;
import com.service.hotelService.reservation.application.ports.output.UpdateReservationOutputPort;
import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class UpdateReservationUseCase implements UpdateReservationInputPort {
    private final UpdateReservationOutputPort updateReservationOutputPort;

    @Override
    public ReservationDomainEntity update(UUID id, ReservationDomainEntity reservation) {
        reservation.recalculateTotalPrice();
        return updateReservationOutputPort.update(id, reservation);
    }
}
