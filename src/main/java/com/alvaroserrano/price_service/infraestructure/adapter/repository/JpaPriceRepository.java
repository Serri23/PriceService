package com.alvaroserrano.price_service.infraestructure.adapter.repository;

import com.alvaroserrano.price_service.domain.model.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * JpaPriceRepository is an interface that extends JpaRepository to provide CRUD operations
 * for the Price entity.
 * It allows for easy interaction with the database without needing to implement
 */
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {

    /**
     * Finds the applicable price for a given date, product ID, and brand ID.
     * @param date the date and time to check for applicable prices
     * @param productId the ID of the product for which to find the price
     * @param brandId the ID of the brand for which to find the price
     * @return an Optional containing the applicable Price if found, or empty if not found
     */
    Optional<PriceEntity> findApplicablePrice(LocalDateTime date, Integer productId, Integer brandId);
}
