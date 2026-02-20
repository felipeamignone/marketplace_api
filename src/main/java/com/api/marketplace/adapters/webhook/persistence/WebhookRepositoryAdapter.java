package com.api.marketplace.adapters.webhook.persistence;

import com.api.marketplace.domain.webhook.gateway.WebhookRepositoryGateway;
import com.api.marketplace.domain.webhook.model.Webhook;
import org.springframework.stereotype.Component;

@Component
public class WebhookRepositoryAdapter implements WebhookRepositoryGateway {
    WebhookRepository repository;
    WebhookMapper mapper;

    @Override
    public Webhook save(Webhook newWebhook) {
        WebhookJpaEntity entity = mapper.toJpa(newWebhook);

        WebhookJpaEntity savedWebhook = repository.save(entity);

        return mapper.toDomain(savedWebhook);
    }
}
