
package com.service.hotelService.reservation.infrastructure.inputadapter.mapper;

import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;
import com.service.hotelService.reservation.infrastructure.inputadapter.dto.ReservationRequestDto;
import com.service.hotelService.reservation.infrastructure.inputadapter.dto.ReservationResponseDto;

public class ReservationMapperRest {
    public static ReservationDomainEntity toDomain(ReservationRequestDto dto) {
        if (dto == null) return null;
        return ReservationDomainEntity.builder()
                .customerId(dto.getCustomerId())
                .roomId(dto.getRoomId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .state(dto.getState())
                .pricePerDay(dto.getPricePerDay())
                .maintenanceCostPerDay(dto.getMaintenanceCostPerDay())
                .discountPercentage(dto.getDiscountPercentage())
                .promotionId(dto.getPromotionId())
                .build();
    }

    public static ReservationResponseDto toResponse(ReservationDomainEntity d) {
        if (d == null) return null;
        return ReservationResponseDto.builder()
                .id(d.getId())
                .customerId(d.getCustomerId())
                .roomId(d.getRoomId())
                .startDate(d.getStartDate())
                .endDate(d.getEndDate())
                .state(d.getState())
                .pricePerDay(d.getPricePerDay())
                .maintenanceCostPerDay(d.getMaintenanceCostPerDay())
                .totalPrice(d.getTotalPrice())
                .discountPercentage(d.getDiscountPercentage())
                .promotionId(d.getPromotionId())
                .build();
    }
}
