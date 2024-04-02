package com.example.prices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.prices.dto.PricesResponse;
import com.example.prices.dummy.PricesMapperDummy;
import com.example.prices.entity.Prices;

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
		Prices prices = new Prices(1L, 1, date, date, 99, 10L, 0, 99.99, "currency");
		
		PricesResponse response = new PricesResponse(10L, 1, date, date, 99.99);		
		PricesResponse ret = pricesMapper.pricesEntityToResponse(prices);
		
		assertEquals(response, ret);
	}
}
