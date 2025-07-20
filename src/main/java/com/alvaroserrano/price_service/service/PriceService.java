package com.alvaroserrano.price_service.service;

import com.alvaroserrano.price_service.domain.port.PriceRepository;
import com.alvaroserrano.price_service.infraestructure.dto.PriceResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Service class for handling price-related operations.
 */
@Service
public class PriceService {

    /**
     * Repository for accessing price data.
     */
    private final PriceRepository priceRepository;

    /**
     * Constructor for PriceService.
     * Initializes the service with the provided PriceRepository.
     * @param priceRepository the repository to use for price operations
     */
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<PriceResponse> getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return priceRepository.findApplicablePrice(applicationDate, productId, brandId)
                .map(PriceResponse::toDomain);
    }

}
