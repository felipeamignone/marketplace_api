package com.api.marketplace.domain.webhook.gateway;

import com.api.marketplace.domain.webhook.model.Webhook;

public interface WebhookRepositoryGateway {
    Webhook save(Webhook newWebhook);
}
