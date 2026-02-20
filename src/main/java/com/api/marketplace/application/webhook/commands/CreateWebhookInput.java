package com.api.marketplace.application.webhook.commands;

import java.util.List;
import java.util.UUID;

public record CreateWebhookInput(
        List<UUID> storeIds,
        String callbackUrl
) {
}
