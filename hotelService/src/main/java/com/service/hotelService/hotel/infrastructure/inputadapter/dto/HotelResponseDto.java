package com.service.hotelService.hotel.infrastructure.inputadapter.dto;

import lombok.Value;

import java.util.UUID;

@Value
public class HotelResponseDto {

    UUID id;
    String name;
    String address;
    String phone;
    int totalRooms;



}
