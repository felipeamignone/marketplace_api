package com.api.marketplace.adapters.webhook.controllers;

import java.util.List;
import java.util.UUID;

public record WebhookResponse(
        UUID id,
        String callbackUrl,
        List<UUID> storeIds
) {
}
