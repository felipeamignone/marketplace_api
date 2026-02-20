package com.api.marketplace.application.webhook.useCases;

import com.api.marketplace.application.webhook.commands.CreateWebhookInput;
import com.api.marketplace.application.webhook.commands.WebhookOutput;
import com.api.marketplace.domain.webhook.gateway.WebhookRepositoryGateway;
import com.api.marketplace.domain.webhook.model.Webhook;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CreateWebhookUseCase {
    private final WebhookRepositoryGateway webhookRepositoryGateway;

    public CreateWebhookUseCase(WebhookRepositoryGateway webhookRepositoryGateway) {
        this.webhookRepositoryGateway = webhookRepositoryGateway;
    }

    public WebhookOutput execute(CreateWebhookInput input) {
        Webhook webhook = new Webhook(null, input.callbackUrl());
        for (UUID storeId : input.storeIds()) {
            webhook.addStoreId(storeId);
        }
        Webhook saved = webhookRepositoryGateway.save(webhook);
        return new WebhookOutput(
                saved.getId(),
                saved.getCallbackUrl(),
                List.copyOf(saved.getStoreIds())
        );
    }
}
