package com.api.marketplace.adapters.webhook.controllers;

import com.api.marketplace.application.webhook.commands.CreateWebhookInput;
import com.api.marketplace.application.webhook.commands.WebhookOutput;
import com.api.marketplace.application.webhook.useCases.CreateWebhookUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/webhooks")
public class WebhookController {
    private final CreateWebhookUseCase createWebhookUseCase;

    public WebhookController(CreateWebhookUseCase createWebhookUseCase) {
        this.createWebhookUseCase = createWebhookUseCase;
    }

    @PostMapping
    public ResponseEntity<WebhookResponse> create(@RequestBody CreateWebhookRequest body) {
        CreateWebhookInput input = new CreateWebhookInput(
                body.storeIds(),
                body.callbackUrl()
        );
        WebhookOutput result = createWebhookUseCase.execute(input);
        WebhookResponse response = WebhookMapper.toResponse(result);
        return ResponseEntity.created().body(response);
    }
}
