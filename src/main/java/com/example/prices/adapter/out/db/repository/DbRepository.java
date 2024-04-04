package com.example.prices.adapter.out.db.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prices.adapter.out.db.model.PricesEntity;

@Repository
public interface DbRepository extends JpaRepository<PricesEntity, UUID>{
	Optional<PricesEntity> findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
            LocalDateTime startDate,
            LocalDateTime endDate,
            Long productId,
            int brandId);
}
