package com.alvaroserrano.price_service.infraestructure.dto;

import com.alvaroserrano.price_service.domain.model.PriceEntity;
import io.swagger.v3.oas.annotations.media.Schema;

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
        @Schema(example = "35455", description = "Product ID")
        Integer productId,
        @Schema(example = "1", description = "Brand ID")
        Integer brandId,
        @Schema(example = "1", description = "Price List ID")
        Integer priceList,
        @Schema(example = "2020-06-14T10:00:00", description = "Start Date of the Price")
        LocalDateTime startDate,
        @Schema(example = "2020-12-31T23:59:59", description = "End Date of the Price")
        LocalDateTime endDate,
        @Schema(example = "35.50", description = "Price in Euros")
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
