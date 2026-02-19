package com.api.marketplace.adapters.order.controllers;

import com.api.marketplace.domain.order.model.OrderStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderResponse(
        UUID orderId,
        UUID storeId,
        OrderStatus status,
        List<OrderItemResponse> items,
        BigDecimal totalPrice
) {
}
