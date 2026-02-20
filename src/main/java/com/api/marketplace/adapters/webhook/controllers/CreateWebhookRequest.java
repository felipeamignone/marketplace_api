package com.api.marketplace.adapters.webhook.controllers;

import java.util.List;
import java.util.UUID;

public record CreateWebhookRequest(
        List<UUID> storeIds,
        String callbackUrl
) {
}
