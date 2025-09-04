
package com.service.hotelService.reservation.application.usecase.delete;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.reservation.application.ports.input.DeleteReservationInputPort;
import com.service.hotelService.reservation.application.ports.output.DeleteReservationOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class DeleteReservationUseCase implements DeleteReservationInputPort {
    private final DeleteReservationOutputPort deleteReservationOutputPort;

    @Override
    public void delete(UUID id) {
        deleteReservationOutputPort.delete(id);
    }
}
