package com.api.marketplace.adapters.order.controllers;

public record CreateOrderItemRequest(
        String name,
        Integer quantity
) {
}
