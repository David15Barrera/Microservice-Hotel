
package com.service.hotelService.reservation.infrastructure.outputadapter.persistence.mapper;

import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;
import com.service.hotelService.reservation.infrastructure.outputadapter.persistence.entity.ReservationDBEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReservationMapper {
    public static ReservationDBEntity toDB(ReservationDomainEntity d) {
        if (d == null) return null;
        return ReservationDBEntity.builder()
                .id(d.getId() == null ? UUID.randomUUID() : d.getId())
                .customerId(d.getCustomerId())
                .roomId(d.getRoomId())
                .startDate(d.getStartDate())
                .endDate(d.getEndDate())
                .state(d.getState())
                .pricePerDay(d.getPricePerDay())
                .totalPrice(d.getTotalPrice())
                .maintenanceCostPerDay(d.getMaintenanceCostPerDay())
                .discountPercentage(d.getDiscountPercentage())
                .promotionId(d.getPromotionId())
                .createdAt(LocalDateTime.now())
                .updatedAt(null)
                .build();
    }

    public static ReservationDomainEntity toDomain(ReservationDBEntity e) {
        if (e == null) return null;
        return ReservationDomainEntity.builder()
                .id(e.getId())
                .customerId(e.getCustomerId())
                .roomId(e.getRoomId())
                .startDate(e.getStartDate())
                .endDate(e.getEndDate())
                .state(e.getState())
                .pricePerDay(e.getPricePerDay())
                .totalPrice(e.getTotalPrice())
                .maintenanceCostPerDay(e.getMaintenanceCostPerDay())
                .discountPercentage(e.getDiscountPercentage())
                .promotionId(e.getPromotionId())
                .build();
    }
}
