package com.service.hotelService.hotel.infrastructure.inputadapter.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelRequestDto {
    private String name;
    private String address;
    private String phone;
}
