
package com.service.hotelService.reservation.application.usecase.create;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.reservation.application.ports.input.CreateReservationInputPort;
import com.service.hotelService.reservation.application.ports.output.CheckAvailabilityOutputPort;
import com.service.hotelService.reservation.application.ports.output.SaveReservationOutputPort;
import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

@UseCase
@RequiredArgsConstructor
public class CreateReservationUseCase implements CreateReservationInputPort {
    private final SaveReservationOutputPort saveReservationOutputPort;
    private final CheckAvailabilityOutputPort checkAvailabilityOutputPort;

    @Override
    public ReservationDomainEntity create(ReservationDomainEntity reservation) {
        validateDates(reservation.getStartDate(), reservation.getEndDate());
        boolean available = checkAvailabilityOutputPort.isAvailable(
                reservation.getRoomId(), reservation.getStartDate(), reservation.getEndDate());
        if (!available) {
            throw new IllegalStateException("La habitación no está disponible en el rango de fechas");
        }
        // calcular total
        BigDecimal days = BigDecimal.valueOf(Duration.between(
                reservation.getStartDate().atStartOfDay(),
                reservation.getEndDate().atStartOfDay()).toDays());
        if (days.compareTo(BigDecimal.ONE) < 0) {
            throw new IllegalArgumentException("El mínimo es 1 noche");
        }
        BigDecimal price = reservation.getPricePerDay().multiply(days);
        BigDecimal maintenance = reservation.getMaintenanceCostPerDay().multiply(days);
        BigDecimal discountPct = reservation.getDiscountPercentage() == null ? BigDecimal.ZERO : reservation.getDiscountPercentage();
        BigDecimal discount = price.multiply(discountPct).divide(BigDecimal.valueOf(100));
        reservation.setTotalPrice(price.add(maintenance).subtract(discount));
        return saveReservationOutputPort.save(reservation);
    }

    private void validateDates(LocalDate start, LocalDate end) {
        if (start == null || end == null || end.isBefore(start)) {
            throw new IllegalArgumentException("Fechas inválidas");
        }
    }
}
