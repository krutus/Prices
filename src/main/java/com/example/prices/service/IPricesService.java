package com.example.prices.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.prices.dto.PricesResponse;
import com.example.prices.entity.Prices;

public interface IPricesService {

	 public PricesResponse getPrice(int brandId, Long productId, LocalDateTime date);
	 
	 public List<Prices> getAllPrices();
}
