package com.service.hotelService.reservation.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CustomerDomainEntity {
    private UUID id;
    private String fullName;
    private String cui;
    private String phone;
    private String email;
    private String address;
    private Integer loyaltyPoints;

}
