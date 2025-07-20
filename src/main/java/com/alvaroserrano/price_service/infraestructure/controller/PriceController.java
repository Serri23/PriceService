package com.alvaroserrano.price_service.infraestructure.controller;

import com.alvaroserrano.price_service.infraestructure.dto.PriceResponse;
import com.alvaroserrano.price_service.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Controller for handling price-related requests.
 */
@RestController
@RequestMapping("/api/prices")
@AllArgsConstructor
public class PriceController {

    /**
     * Service for handling price-related operations.
     */
    private PriceService priceService;

    /**
     * Retrieves the price for a given application date, product ID, and brand ID.
     * @param applicationDate the date and time for which the price is requested
     * @param productId the ID of the product for which the price is requested
     * @param brandId the ID of the brand for which the price is requested
     * @return a ResponseEntity containing the PriceResponse if found, or a 404 Not Found status if not found
     */
    @GetMapping
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @RequestParam Integer productId,
            @RequestParam Integer brandId){

        return priceService.getPrice(applicationDate, productId, brandId)
                .map(price -> new ResponseEntity<>(price, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());
    }
}
