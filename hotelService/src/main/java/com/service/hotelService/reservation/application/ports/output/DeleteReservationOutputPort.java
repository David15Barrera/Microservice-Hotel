
package com.service.hotelService.reservation.application.ports.output;

import java.util.UUID;

public interface DeleteReservationOutputPort {
    void delete(UUID id);
}
