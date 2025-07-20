package com.alvaroserrano.price_service.service;

import com.alvaroserrano.price_service.domain.port.PriceRepository;
import com.alvaroserrano.price_service.infraestructure.dto.PriceResponse;
import com.alvaroserrano.price_service.infraestructure.exception.PriceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Service class for handling price-related operations.
 */
@Service
@AllArgsConstructor
public class PriceService {

    /**
     * Repository for accessing price data.
     */
    private final PriceRepository priceRepository;

    public PriceResponse getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return priceRepository.findApplicablePrice(applicationDate, productId, brandId)
                .map(PriceResponse::toDomain)
                .orElseThrow(() -> new PriceNotFoundException("Price not found for the given parameters."));
    }

}
