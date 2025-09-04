package com.service.hotelService.hotel.domain.model;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public class HotelDomainEntity {
    private UUID id;
    private String name;
    private String address;
    private String phone;
    private Integer totalRoom;

    public HotelDomainEntity(UUID id, String name, String address, String phone, Integer totalRoom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.totalRoom = totalRoom;
        this.validate();
    }

    public HotelDomainEntity(String name, String address, String phone, Integer totalRoom) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.totalRoom = totalRoom;
        this.validate();
    }

    private void validate() {
        Objects.requireNonNull(name, "El nombre no puede ser nulo");
        Objects.requireNonNull(address, "La direccion no puede ser nula");
        Objects.requireNonNull(phone, "La phone no puede ser nulo");
    }
}
