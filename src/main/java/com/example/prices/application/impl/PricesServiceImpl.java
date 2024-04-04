package com.example.prices.application.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prices.adapter.out.db.model.PricesEntity;
import com.example.prices.application.IPricesService;
import com.example.prices.application.dto.PricesResponse;
import com.example.prices.domain.model.Prices;
import com.example.prices.domain.ports.out.repository.DbPort;
import com.example.prices.exceptions.MessageErrorCode;
import com.example.prices.exceptions.PricesException;
import com.example.prices.mapper.PricesMapper;

@Service
public class PricesServiceImpl implements IPricesService {

	@Autowired
	private DbPort dbPort;
	
	@Autowired
	private PricesMapper pricesMapper;

	@Override
	public PricesResponse getPrice(int brandId, Long productId, LocalDateTime date) {
		Optional<PricesEntity> priceOptional = dbPort.findByParams(brandId, productId, date, date).stream()
				.findFirst();
		if (priceOptional.isPresent()) {
			return pricesMapper.pricesEntityToResponse(priceOptional.get());
		} else {
			throw new PricesException(MessageErrorCode.ERROR_PRICES_NOT_FOUND.getDescription());
		}
	}
	
	@Override
	public List<Prices> getAllPrices(){
		return dbPort.findAll();
	}
}
