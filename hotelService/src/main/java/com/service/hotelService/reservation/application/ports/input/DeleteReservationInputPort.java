
package com.service.hotelService.reservation.application.ports.input;

import java.util.UUID;

public interface DeleteReservationInputPort {
    void delete(UUID id);
}
