package com.example.prices.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prices.dto.PricesResponse;
import com.example.prices.entity.Prices;
import com.example.prices.exception.MessageErrorCode;
import com.example.prices.exception.PricesException;
import com.example.prices.mapper.PricesMapper;
import com.example.prices.ports.output.repository.IPricesRepository;
import com.example.prices.service.IPricesService;

@Service
public class PricesServiceImpl implements IPricesService {

	@Autowired
	private IPricesRepository priceRepository;
	
	@Autowired
	private PricesMapper pricesMapper;

	@Override
	public PricesResponse getPrice(int brandId, Long productId, LocalDateTime date) {
		Optional<Prices> priceOptional = priceRepository.findByParams(brandId, productId, date, date).stream()
				.findFirst();
		if (priceOptional.isPresent()) {
			return pricesMapper.pricesEntityToResponse(priceOptional.get());
		} else {
			throw new PricesException(MessageErrorCode.ERROR_PRICES_NOT_FOUND.getDescription());
		}
	}
	
	@Override
	public List<Prices> getAllPrices(){
		return priceRepository.findAll();
	}
}
