package com.api.marketplace.adapters.order.controllers;

import java.util.List;
import java.util.UUID;

public record CreateOrderRequest(
        UUID storeId,
        List<CreateOrderItemRequest> items
) {
}
