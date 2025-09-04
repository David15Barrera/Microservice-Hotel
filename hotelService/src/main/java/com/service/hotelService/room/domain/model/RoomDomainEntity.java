package com.service.hotelService.room.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class RoomDomainEntity {
    private UUID id;
    private UUID hotelId;
    private String roomNumber;
    private BigDecimal pricePerDay;
    private BigDecimal maintenanceCostPerDay;
    private String description;
    private Integer capacity;
    private String state;
}
