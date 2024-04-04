package com.example.prices.application;

import java.time.LocalDateTime;
import java.util.List;

import com.example.prices.application.dto.PricesResponse;
import com.example.prices.domain.model.Prices;

public interface IPricesService {

	 public PricesResponse getPrice(int brandId, Long productId, LocalDateTime date);
	 
	 public List<Prices> getAllPrices();
}
