
package com.service.hotelService.reservation.infrastructure.inputadapter.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ReservationRequestDto {
    private UUID customerId;
    private UUID roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String state;
    private BigDecimal pricePerDay;
    private BigDecimal maintenanceCostPerDay;
    private BigDecimal discountPercentage; // nullable
    private UUID promotionId; // nullable
}
