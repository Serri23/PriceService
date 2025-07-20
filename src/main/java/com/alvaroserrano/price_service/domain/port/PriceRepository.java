package com.alvaroserrano.price_service.domain.port;

import com.alvaroserrano.price_service.domain.model.PriceEntity;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Domain interface (port) grants access to prices
 */
public interface PriceRepository {

    Optional<PriceEntity> findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
