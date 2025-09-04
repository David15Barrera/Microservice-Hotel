package com.service.hotelService.room.infrastructure.inputadapter.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor @Builder
public class RoomRequestDto {
    private UUID hotelId;
    private String roomNumber;
    private BigDecimal pricePerDay;
    private BigDecimal maintenanceCostPerDay;
    private String description;
    private Integer capacity;
    private String state;
}
