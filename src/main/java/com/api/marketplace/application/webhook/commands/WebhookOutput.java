package com.api.marketplace.application.webhook.commands;

import java.util.List;
import java.util.UUID;

public record WebhookOutput(
        UUID id,
        String callbackUrl,
        List<UUID> storeIds
) {
}
