package com.alvaroserrano.price_service.infraestructure.adapter.repository;

import com.alvaroserrano.price_service.domain.model.PriceEntity;
import com.alvaroserrano.price_service.domain.port.PriceRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Repository implementation for PriceRepository.
 */
@Repository
public class PriceRepositoryImpl implements PriceRepository {

    /**
     * JpaPriceRepository is an interface that extends JpaRepository to provide CRUD operations
     */
    JpaPriceRepository jpaPriceRepository;

    /**
     * Constructor for PriceRepositoryImpl.
     * @param jpaPriceRepository the JpaPriceRepository to use for database operations
     */
    public PriceRepositoryImpl(JpaPriceRepository jpaPriceRepository) {
        this.jpaPriceRepository = jpaPriceRepository;
    }

    /**
     * Finds the applicable price for a given date, product ID, and brand ID.
     * @param applicationDate the date and time to check for applicable prices
     * @param productId the ID of the product for which to find the price
     * @param brandId the ID of the brand for which to find the price
     * @return an Optional containing the applicable Price if found, or empty if not found
     */
    @Override
    public Optional<PriceEntity> findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return jpaPriceRepository.findTopApplicablePrice(applicationDate, productId, brandId, PageRequest.of(0, 1))
                .stream().findFirst();
    }
}
