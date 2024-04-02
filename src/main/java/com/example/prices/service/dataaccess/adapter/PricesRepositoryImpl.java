package com.example.prices.service.dataaccess.adapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.prices.entity.Prices;
import com.example.prices.ports.output.repository.IPricesRepository;
import com.example.prices.service.dataaccess.repository.PricesJpaRepository;

@Component
public class PricesRepositoryImpl implements IPricesRepository {
	private final PricesJpaRepository priceJpaRepository;

	public PricesRepositoryImpl(PricesJpaRepository priceJpaRepository) {
		this.priceJpaRepository = priceJpaRepository;
	}

	@Override
	public Optional<Prices> findByParams(int brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate) {
		return this.priceJpaRepository
				.findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
						startDate, endDate, productId, brandId);
	}

	@Override
	public List<Prices> findAll() {
		return this.priceJpaRepository.findAll();
	}

}