package com.alvaroserrano.price_service.infraestructure.dto;

import com.alvaroserrano.price_service.domain.model.PriceEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for Price response.
 * This class is used to transfer price data from the service layer to the controller layer.
 * It encapsulates the price details such as product ID, brand ID, price list ID, start date, end date, and price.
 * @param productId
 * @param brandId
 * @param priceList
 * @param startDate
 * @param endDate
 * @param price
 */
public record PriceResponse(
        Integer productId,
        Integer brandId,
        Integer priceList,
        LocalDateTime startDate,
        LocalDateTime endDate,
        BigDecimal price
) {

    /**
     * Converts a PriceEntity to a PriceResponse.
     * @param p the PriceEntity to convert
     * @return a PriceResponse containing the data from the PriceEntity
     */
    public static PriceResponse toDomain(PriceEntity p) {
        return new PriceResponse(
                p.getProductId(),
                p.getBrandId(),
                p.getPriceList(),
                p.getStartDate(),
                p.getEndDate(),
                p.getPrice()
        );
    }
}
