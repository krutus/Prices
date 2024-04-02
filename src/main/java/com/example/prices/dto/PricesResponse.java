package com.example.prices.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PricesResponse {
    private Long productId;
    private int brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double price;

}
