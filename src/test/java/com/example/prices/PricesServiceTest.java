package com.example.prices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.prices.adapter.out.db.model.PricesEntity;
import com.example.prices.application.dto.PricesResponse;
import com.example.prices.domain.ports.out.repository.DbPort;
import com.example.prices.dummy.PricesServiceDummy;
import com.example.prices.exceptions.PricesException;
import com.example.prices.mapper.PricesMapper;

@SpringBootTest
class PricesServiceTest {

	@InjectMocks
	private PricesServiceDummy pricesService;

	@Mock
	private DbPort priceRepository;
	
	@Mock
	private PricesMapper pricesMapper;
	
	@BeforeEach
	void initialize() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testServiceOK() throws Exception {
		LocalDateTime date = LocalDateTime.now();
		PricesEntity prices = new PricesEntity(1L, 1, date, date, 99, 10L, 0, 99.99, "currency");
		Optional<PricesEntity> opt = Optional.of(prices);
		PricesResponse response = new PricesResponse(10L, 1, 1, date, date, 99.99);
		when(priceRepository.findByParams(ArgumentMatchers.anyInt(), ArgumentMatchers.<Long>any(),
				ArgumentMatchers.<LocalDateTime>any(), ArgumentMatchers.<LocalDateTime>any())).thenReturn(opt);
		when(pricesMapper.pricesEntityToResponse(prices)).thenReturn(response);
		
		PricesResponse ret = pricesService.getPrice(1, 10L, date);
		
		assertEquals(response, ret);

	}
	
	@Test
	void testServiceException() throws Exception {
		LocalDateTime date = LocalDateTime.now();
		Optional<PricesEntity> opt = Optional.empty();
		when(priceRepository.findByParams(ArgumentMatchers.anyInt(), ArgumentMatchers.<Long>any(),
				ArgumentMatchers.<LocalDateTime>any(), ArgumentMatchers.<LocalDateTime>any())).thenReturn(opt);

		assertThrows(PricesException.class, () -> pricesService.getPrice(1, 10L, date));

	}
	
	@Test
	void testMapper() throws Exception {
		
	}

}