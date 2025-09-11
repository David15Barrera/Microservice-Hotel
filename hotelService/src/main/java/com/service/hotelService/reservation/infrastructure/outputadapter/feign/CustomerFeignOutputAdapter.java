package com.service.hotelService.reservation.infrastructure.outputadapter.feign;

import com.service.hotelService.reservation.application.ports.output.FindCustomerOutputPort;
import com.service.hotelService.reservation.domain.model.CustomerDomainEntity;
import com.service.hotelService.reservation.infrastructure.outputadapter.feign.customerFeign.CustomerFeignClient;
import com.service.hotelService.reservation.infrastructure.outputadapter.feign.dto.CustomerResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class CustomerFeignOutputAdapter implements FindCustomerOutputPort {

    private final CustomerFeignClient client;

    public CustomerFeignOutputAdapter(CustomerFeignClient client) {
        this.client = client;
    }
    @Override
    public CustomerDomainEntity findById(UUID id) {
        CustomerResponse response = client.getCustomerById(String.valueOf(id));

        CustomerDomainEntity domain = new CustomerDomainEntity();
        domain.setId(UUID.fromString(response.id));
        domain.setFullName(response.fullName);
        domain.setCui(response.cui);
        domain.setPhone(response.phone);
        domain.setEmail(response.email);
        domain.setAddress(response.address);
        domain.setLoyaltyPoints(response.loyaltyPoints);

        return domain;
    }
}
