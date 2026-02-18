package com.api.marketplace.application.useCases.updateOrderStatus;

import com.api.marketplace.domain.order.gateway.OrderRepositoryGateway;
import com.api.marketplace.domain.order.model.Order;

import java.util.UUID;

public class UpdateOrderStatusToPaidUseCase {
    private final OrderRepositoryGateway orderRepositoryGateway;

    public UpdateOrderStatusToPaidUseCase(OrderRepositoryGateway orderRepositoryGateway) {
        this.orderRepositoryGateway = orderRepositoryGateway;
    }

    public void execute (UUID orderId) {
        Order foundedOrder = orderRepositoryGateway.findById(orderId);
        foundedOrder.updateToPaid();

        this.orderRepositoryGateway.save(foundedOrder);
    }
}
