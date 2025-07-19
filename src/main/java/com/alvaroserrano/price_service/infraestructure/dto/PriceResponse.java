package com.alvaroserrano.price_service.infraestructure.dto;

import com.alvaroserrano.price_service.domain.model.PriceEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceResponse(
        Integer productId,
        Integer brandId,
        Integer priceListId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        BigDecimal price
) {

    public static PriceResponse from(PriceEntity p) {
        return new PriceResponse(
                p.getProductId(),
                p.getBrandId(),
                p.getPriceListId(),
                p.getStartDate(),
                p.getEndDate(),
                p.getPrice()
        );
    }
}
