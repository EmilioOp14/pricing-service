package org.vedruna.pricing.domain.exception;

public class PriceNotFoundException extends RuntimeException{
public PriceNotFoundException(Integer id) {
        super("Price not found with id: " + id);
    }
}
