package com.example.prices;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.prices.dto.PricesResponse;
import com.example.prices.dummy.PricesControllerDummy;
import com.example.prices.service.IPricesService;

@SpringBootTest
class PricesControllerTest {

	@InjectMocks
	private PricesControllerDummy pricesController;
	
	@Mock
	private IPricesService pricesService;
	
	@BeforeEach
	void initialize() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testControllerOK() {
		LocalDateTime date = LocalDateTime.now();
		ResponseEntity<PricesResponse> result = pricesController.getPrice(date, 10L, 1);
		PricesResponse response = new PricesResponse(10L, 1, date, date, 99.99);
		
		when(pricesService.getPrice(1, 10L, date)).thenReturn(response);
		Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());		
	}
}
