
package com.service.hotelService.reservation.infrastructure.inputadapter.dto;

import com.service.hotelService.reservation.infrastructure.outputadapter.feign.dto.CustomerResponse;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ReservationResponseDto {

    private UUID id;
    private UUID customerId;
    private UUID roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String state;
    private BigDecimal pricePerDay;
    private BigDecimal maintenanceCostPerDay;
    private BigDecimal totalPrice;
    private BigDecimal discountPercentage;
    private UUID promotionId;
}
