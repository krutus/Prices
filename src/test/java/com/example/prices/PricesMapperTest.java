package com.example.prices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.prices.adapter.out.db.model.PricesEntity;
import com.example.prices.application.dto.PricesResponse;
import com.example.prices.dummy.PricesMapperDummy;

@SpringBootTest
class PricesMapperTest {
	@InjectMocks
	private PricesMapperDummy pricesMapper;
	
	@BeforeEach
	void initialize() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testMapperOK() {
		LocalDateTime date = LocalDateTime.now();
		PricesEntity prices = new PricesEntity(1L, 1, date, date, 99, 10L, 0, 99.99, "currency");
		
		PricesResponse response = new PricesResponse(10L, 1, 99, date, date, 99.99);		
		PricesResponse ret = pricesMapper.pricesEntityToResponse(prices);
		
		assertEquals(response, ret);
	}
}
