package com.api.marketplace.adapters.webhook.controllers;

import com.api.marketplace.application.webhook.commands.WebhookOutput;

public class WebhookMapper {

    static WebhookResponse toResponse(WebhookOutput output) {
        return new WebhookResponse(
                output.id(),
                output.callbackUrl(),
                output.storeIds()
        );
    }
}
