package com.api.marketplace.domain.order.gateway;

import com.api.marketplace.domain.order.model.Order;

import java.util.UUID;

public interface OrderRepositoryGateway {
    Order findByExternalId(UUID externalId);
    Order save(Order newOrder);
}
