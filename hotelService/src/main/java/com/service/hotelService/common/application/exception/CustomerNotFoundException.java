package com.service.hotelService.common.application.exception;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(UUID customerId) {
        super("No se encontró el cliente con id: " + customerId);
    }
}
