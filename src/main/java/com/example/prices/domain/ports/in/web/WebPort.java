package com.example.prices.domain.ports.in.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.prices.application.dto.PricesResponse;
import com.example.prices.domain.model.Prices;

public interface WebPort {

	@GetMapping(value = "/prices")
	public ResponseEntity<PricesResponse> getPrice(
			@RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
			@RequestParam(name = "productId") Long productId, @RequestParam(name = "brandId") int brandId);

	@GetMapping(value = "/prices/all")
	public ResponseEntity<List<Prices>> getAllPrice();
}
