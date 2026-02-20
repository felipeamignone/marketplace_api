package com.api.marketplace.domain.webhook.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Webhook {
    private final UUID id;
    private String callbackUrl;
    private final List<UUID> storeIds = new ArrayList<>();

    public Webhook(UUID id, String callbackUrl) {
        this.id = id;
        this.callbackUrl = callbackUrl;
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

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public void addStoreId(UUID newStoreId) throws IllegalArgumentException {
        if(storeIds.stream().anyMatch(id -> id.equals(newStoreId))){
            throw new IllegalArgumentException("StoreId already added");
        }
        this.storeIds.add(newStoreId);
    }

    public void removeStoreId(UUID storeIdToRemove) throws IllegalArgumentException {
        if(storeIds.stream().noneMatch(id -> id.equals(storeIdToRemove))){
            throw new IllegalArgumentException("StoreId not found");
        }
        this.storeIds.remove(storeIdToRemove);
    }
}
