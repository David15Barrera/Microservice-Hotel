
package com.service.hotelService.reservation.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDomainEntity {
    private UUID id;
    private UUID customerId;
    private UUID roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String state; // confirmed, cancelled, checked_in, checked_out
    private BigDecimal pricePerDay;
    private BigDecimal maintenanceCostPerDay;
    private BigDecimal totalPrice;
    private BigDecimal discountPercentage; // nullable
    private UUID promotionId; // external microservice UUID

    public void recalculateTotalPrice() {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        if (days < 1) {
            throw new IllegalArgumentException("El mínimo es 1 noche");
        }

        BigDecimal baseCost = pricePerDay.add(maintenanceCostPerDay)
                .multiply(BigDecimal.valueOf(days));

        BigDecimal discount = baseCost.multiply(discountPercentage.divide(BigDecimal.valueOf(100)));
        this.totalPrice = baseCost.subtract(discount);
    }
}
