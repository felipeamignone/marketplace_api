package com.api.marketplace.adapters.webhook.persistence;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "webhooks")
public class WebhookJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String callbackUrl;

    @ElementCollection
    @CollectionTable(
            name = "webhook_store_ids",
            joinColumns = @JoinColumn(name = "webhook_id")
    )
    private List<UUID> storeIds = new ArrayList<>();

    protected WebhookJpaEntity() {
    }

    public WebhookJpaEntity(UUID id, String callbackUrl, List<UUID> storeIds) {
        this.id = id;
        this.callbackUrl = callbackUrl;
        this.storeIds = storeIds;
    }

    public UUID getId() {
        return id;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public List<UUID> getStoreIds() {
        return storeIds;
    }
}
