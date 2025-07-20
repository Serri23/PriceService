package com.alvaroserrano.price_service.domain.port;

import com.alvaroserrano.price_service.domain.model.PriceEntity;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Domain interface (port) grants access to prices
 */
public interface PriceRepository {

    /**
     * Finds the applicable price for a given date, product ID, and brand ID.
     * @param applicationDate the date and time to check for applicable prices
     * @param productId the ID of the product for which to find the price
     * @param brandId the ID of the brand for which to find the price
     * @return an Optional containing the applicable Price if found, or empty if not found
     */
    Optional<PriceEntity> findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
