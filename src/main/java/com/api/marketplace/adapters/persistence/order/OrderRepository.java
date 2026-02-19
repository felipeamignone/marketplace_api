package com.api.marketplace.adapters.persistence.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderJpaEntity, UUID> {
}
