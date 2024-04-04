package com.example.prices.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.prices.adapter.out.db.model.PricesEntity;
import com.example.prices.application.dto.PricesResponse;
import com.example.prices.domain.model.Prices;

@Component
public class PricesMapper {

	public PricesResponse pricesEntityToResponse(PricesEntity entity) {
		return new PricesResponse(entity.getProductId(), entity.getBrandId(), entity.getPriceList(), entity.getStartDate(),
				entity.getEndDate(), entity.getPrice());
	}

	
	public List<Prices> pricesEntityListToPricesList(List<PricesEntity> entities){
		List<Prices> prices = new ArrayList<>();
		for (PricesEntity pricesEntity : entities) {
			prices.add(pricesEntityToPrices(pricesEntity));
		}
		return prices;
	}
	
	public Prices pricesEntityToPrices(PricesEntity entity) {
		return new Prices(entity.getBrandId(), entity.getStartDate(), entity.getEndDate(), entity.getPriceList(),
				entity.getProductId(), entity.getPriority(), entity.getPrice(), entity.getCurrency());
	}
}
