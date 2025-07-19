package com.alvaroserrano.price_service.infraestructure.adapter.repository;

import com.alvaroserrano.price_service.domain.model.PriceEntity;
import com.alvaroserrano.price_service.domain.port.PriceRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public class PriceRepositoryImpl implements PriceRepository {

    JpaPriceRepository jpaPriceRepository;

    public PriceRepositoryImpl(JpaPriceRepository jpaPriceRepository) {
        this.jpaPriceRepository = jpaPriceRepository;
    }

    @Override
    public Optional<PriceEntity> findApplicablePrice(LocalDateTime date, Integer productId, Integer brandId) {
        return jpaPriceRepository.findApplicablePrice(date, productId, brandId);
    }
}
