package com.api.marketplace.adapters.webhook.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

public interface WebhookRepository extends JpaRepository<WebhookJpaEntity, UUID> {
}
