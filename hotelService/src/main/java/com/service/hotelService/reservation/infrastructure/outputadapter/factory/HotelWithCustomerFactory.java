package com.service.hotelService.reservation.infrastructure.outputadapter.factory;

import com.service.hotelService.common.application.exception.CustomerNotFoundException;
import com.service.hotelService.reservation.application.ports.output.FindCustomerOutputPort;
import com.service.hotelService.reservation.domain.model.CustomerDomainEntity;
import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;
import com.service.hotelService.reservation.infrastructure.inputadapter.dto.ReservationResponseDto;
import com.service.hotelService.reservation.infrastructure.outputadapter.feign.dto.CustomerResponse;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class HotelWithCustomerFactory {
    private final FindCustomerOutputPort findCustomerOutputPort;

    public HotelWithCustomerFactory( FindCustomerOutputPort findCustomerOutputPort){
        this.findCustomerOutputPort = findCustomerOutputPort;
    }

    public ReservationResponseDto fromDomin(ReservationDomainEntity reservas){
        if(reservas == null) return null;

        ReservationResponseDto dto = new ReservationResponseDto();

        dto.setId(reservas.getId());
        dto.setCustomerId(reservas.getCustomerId());
        dto.setRoomId(reservas.getRoomId());
        dto.setStartDate(reservas.getStartDate());
        dto.setEndDate(reservas.getEndDate());
        dto.setState(reservas.getState());
        dto.setPricePerDay(reservas.getPricePerDay());
        dto.setMaintenanceCostPerDay(reservas.getMaintenanceCostPerDay());
        dto.setTotalPrice(reservas.getTotalPrice());
        dto.setDiscountPercentage(reservas.getDiscountPercentage());
        dto.setPromotionId(reservas.getPromotionId());

        if (reservas.getCustomerId() != null) {
            try {
                findCustomerOutputPort.findById(reservas.getCustomerId());
            } catch (Exception e) {
                throw new CustomerNotFoundException(reservas.getCustomerId());
            }
        }

        return dto;
    }
    public List<ReservationResponseDto> fromDomainList(List<ReservationDomainEntity> reservas) {
        return reservas.stream().map(this::fromDomin).toList();
    }

}
