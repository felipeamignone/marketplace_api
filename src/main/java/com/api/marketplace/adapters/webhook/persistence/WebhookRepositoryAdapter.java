package com.api.marketplace.adapters.webhook.persistence;

import com.api.marketplace.domain.webhook.gateway.WebhookRepositoryGateway;
import com.api.marketplace.domain.webhook.model.Webhook;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class WebhookRepositoryAdapter implements WebhookRepositoryGateway {
    private final WebhookRepository repository;
    private final WebhookMapper mapper;

    public WebhookRepositoryAdapter(WebhookRepository repository, WebhookMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Webhook save(Webhook newWebhook) {
        WebhookJpaEntity entity = mapper.toJpa(newWebhook);
        WebhookJpaEntity savedWebhook = repository.save(entity);
        return mapper.toDomain(savedWebhook);
    }

    @Override
    public List<Webhook> findByStoreId(UUID storeId) {
        return repository.findByStoreIdsContaining(storeId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
