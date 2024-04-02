package com.example.prices.ports.output.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.prices.entity.Prices;

public interface IPricesRepository {

	public Optional<Prices> findByParams(int brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);
	
	public List<Prices> findAll();

}
