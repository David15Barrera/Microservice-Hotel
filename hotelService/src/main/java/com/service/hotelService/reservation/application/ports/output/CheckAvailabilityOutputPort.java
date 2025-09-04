
package com.service.hotelService.reservation.application.ports.output;

import java.time.LocalDate;
import java.util.UUID;

public interface CheckAvailabilityOutputPort {
    boolean isAvailable(UUID roomId, LocalDate startDate, LocalDate endDate);
}
