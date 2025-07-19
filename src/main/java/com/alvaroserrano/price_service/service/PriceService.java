package com.alvaroserrano.price_service.service;

import com.alvaroserrano.price_service.domain.port.PriceRepository;
import com.alvaroserrano.price_service.infraestructure.dto.PriceResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceService {

    private final PriceRepository priceRepository;


    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


    public Optional<PriceResponse> getPrice(LocalDateTime date, Integer productId, Integer brandId) {
        return Optional.ofNullable(priceRepository.findApplicablePrice(date, productId, brandId)
                .map(PriceResponse::from)
                .orElseThrow(() -> new RuntimeException("Price not found for the given parameters: " +
                        "date=" + date + ", productId=" + productId + ", brandId=" + brandId)));
    }

}
