package com.example.prices.mapper;

import org.springframework.stereotype.Component;

import com.example.prices.dto.PricesResponse;
import com.example.prices.entity.Prices;

@Component
public class PricesMapper{
	
	public PricesResponse pricesEntityToResponse(Prices entity) {
		return new PricesResponse(entity.getProductId(), entity.getBrandId(),
				entity.getStartDate(), entity.getEndDate(), entity.getPrice());
	}
}
