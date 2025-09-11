package com.service.hotelService.reservation.application.ports.output;

import com.service.hotelService.reservation.domain.model.CustomerDomainEntity;

import java.util.UUID;

public interface FindCustomerOutputPort {
    CustomerDomainEntity findById(UUID id);

}
