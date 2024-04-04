package com.example.prices.domain.ports.out.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.prices.adapter.out.db.model.PricesEntity;
import com.example.prices.domain.model.Prices;

public interface DbPort {

	public Optional<PricesEntity> findByParams(int brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);
	
	public List<Prices> findAll();

}
