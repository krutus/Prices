package com.example.prices.service.dataaccess.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prices.entity.Prices;

@Repository
public interface PricesJpaRepository extends JpaRepository<Prices, UUID> {

	Optional<Prices> findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
            LocalDateTime startDate,
            LocalDateTime endDate,
            Long productId,
            int brandId);
}
