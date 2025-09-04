
package com.service.hotelService.reservation.application.ports.input;

import java.time.LocalDate;
import java.util.UUID;

public interface CheckRoomAvailabilityInputPort {
    boolean isAvailable(UUID roomId, LocalDate startDate, LocalDate endDate);
}
