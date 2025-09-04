
package com.service.hotelService.reservation.infrastructure.outputadapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "reservation", schema = "reservation")
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class ReservationDBEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "room_id", nullable = false)
    private UUID roomId;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "state")
    private String state;

    @Column(name = "price_per_day", nullable = false)
    private BigDecimal pricePerDay;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "maintenance_cost_per_day", nullable = false)
    private BigDecimal maintenanceCostPerDay;

    @Column(name = "discount_percentage")
    private BigDecimal discountPercentage;

    @Column(name = "promotion_id")
    private UUID promotionId;

    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;
}
