package com.api.marketplace.adapters.order.controllers;

import com.api.marketplace.domain.order.model.OrderStatus;

public record UpdateOrderStatusRequest(
        OrderStatus status
) {
}
