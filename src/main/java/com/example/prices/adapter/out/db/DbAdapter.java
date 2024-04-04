package com.example.prices.adapter.out.db;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prices.adapter.out.db.model.PricesEntity;
import com.example.prices.adapter.out.db.repository.DbRepository;
import com.example.prices.domain.model.Prices;
import com.example.prices.domain.ports.out.repository.DbPort;
import com.example.prices.mapper.PricesMapper;

@Service
public class DbAdapter implements DbPort {

	@Autowired
	private DbRepository dbRepository;

	@Autowired
	private PricesMapper mapper;

	@Override
	public Optional<PricesEntity> findByParams(int brandId, Long productId, LocalDateTime startDate,
			LocalDateTime endDate) {
		return dbRepository
				.findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
						startDate, endDate, productId, brandId);
	}

	@Override
	public List<Prices> findAll() {
		return mapper.pricesEntityListToPricesList(dbRepository.findAll());
	}

}
