package com.example.prices.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.prices.dto.PricesResponse;
import com.example.prices.entity.Prices;
import com.example.prices.exception.GlobalExceptionHandler;
import com.example.prices.service.IPricesService;

@RestController
public class PricesController {

	@Autowired
	private IPricesService priceService;
	
	/** The constant logger for logging purposes. */
	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@GetMapping(value="/prices")
	public ResponseEntity<PricesResponse> getPrice(
			@RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
			@RequestParam(name = "productId") Long productId, @RequestParam(name = "brandId") int brandId) {
		LOG.info("Getting price for date: {}, productId: {} and brandId: {}", date, productId, brandId);
		PricesResponse price = priceService.getPrice(brandId, productId, date);
		return new ResponseEntity<>(price, HttpStatus.OK);
	}
	
	@GetMapping(value="/prices/all")
	public ResponseEntity<List<Prices>> getAllPrice() {
		LOG.info("Getting all prices list");
		List<Prices> prices = priceService.getAllPrices();
		return new ResponseEntity<>(prices, HttpStatus.OK);
	}
}
