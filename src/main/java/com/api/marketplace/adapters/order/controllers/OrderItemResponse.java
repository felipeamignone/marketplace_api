package com.api.marketplace.adapters.order.controllers;

import java.math.BigDecimal;

public record OrderItemResponse(
        String name,
        Integer quantity,
        BigDecimal unitPrice
) {
}
