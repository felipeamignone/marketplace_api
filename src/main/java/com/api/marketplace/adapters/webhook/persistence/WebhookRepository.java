package com.api.marketplace.adapters.webhook.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WebhookRepository extends JpaRepository<WebhookJpaEntity, UUID> {

    List<WebhookJpaEntity> findByStoreIdsContaining(UUID storeId);
}
