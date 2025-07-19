package com.alvaroserrano.price_service.infraestructure.controller;

import com.alvaroserrano.price_service.infraestructure.dto.PriceResponse;
import com.alvaroserrano.price_service.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
@AllArgsConstructor
public class PriceController {

    private PriceService priceService;

    @GetMapping
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam LocalDateTime applicationDate,
            @RequestParam Integer productId,
            @RequestParam Integer brandId){

        return priceService.getPrice(applicationDate, productId, brandId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
