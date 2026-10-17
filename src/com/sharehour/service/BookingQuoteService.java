package com.sharehour.service;

import com.sharehour.model.BookingRequest;

public class BookingQuoteService {
    private final BookingValidator validator;
    private final RentalCostCalculator calculator;

    public BookingQuoteService(BookingValidator validator, RentalCostCalculator calculator) {
        this.validator = validator;
        this.calculator = calculator;
    }

    public double calculateQuote(BookingRequest request) {
        validator.validate(request);
        return calculator.calculate(request);
    }
}