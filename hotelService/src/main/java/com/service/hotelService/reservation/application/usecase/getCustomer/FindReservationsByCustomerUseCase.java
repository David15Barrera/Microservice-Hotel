package com.service.hotelService.reservation.application.usecase.getCustomer;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.reservation.application.ports.input.FindReservationsByCustomerInputPort;
import com.service.hotelService.reservation.application.ports.output.FindReservationsByCustomerOutputPort;
import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;


@UseCase
@RequiredArgsConstructor
public class FindReservationsByCustomerUseCase implements FindReservationsByCustomerInputPort {

    private final FindReservationsByCustomerOutputPort outputPort;

    @Override
    public List<ReservationDomainEntity> findByCustomerId(UUID customerId) {
        return outputPort.findByCustomerId(customerId);
    }
}
