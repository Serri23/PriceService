package com.alvaroserrano.price_service.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a price entity in the system.
 * This class maps to the 'prices' table in the database.
 */
@Entity
@Table(name = "prices")
@Getter
@Setter
public class PriceEntity {

    /**
     * Unique identifier for the price record.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Identifier for the brand associated with the price.
     */
    private Integer brandId;

    /**
     * Start date and time for the price validity.
     */
    private LocalDateTime startDate;

    /**
     * End date and time for the price validity.
     */
    private LocalDateTime endDate;

    /**
     * Identifier for the price list.
     */
    private Integer priceListId;

    /**
     * Identifier for the product associated with the price.
     */
    private Integer productId;

    /**
     * Priority of the price in case of multiple prices for the same product.
     */
    private Integer priority;

    /**
     * Price amount for the product.
     */
    private BigDecimal price;

    /**
     * Currency in which the price is denominated.
     */
    private String currency;
}
