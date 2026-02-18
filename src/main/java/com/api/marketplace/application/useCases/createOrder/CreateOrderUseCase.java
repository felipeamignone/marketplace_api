package com.api.marketplace.application.useCases.createOrder;

import com.api.marketplace.domain.order.gateway.OrderRepositoryGateway;
import com.api.marketplace.domain.order.model.Order;
import com.api.marketplace.domain.order.model.OrderItem;

import java.util.List;

public class CreateOrderUseCase {
    private final OrderRepositoryGateway orderRepository;

    public CreateOrderUseCase(OrderRepositoryGateway orderRepository) {
        this.orderRepository = orderRepository;
    }

    public CreateOrderOutput execute(CreateOrderInput input) {
        List<OrderItem> items = input.items().stream().map(item -> new OrderItem(
                item.name(),
                item.unitPrice(),
                item.quantity()
        )).toList();

        Order newOrder = new Order(null, null, input.storeId(), null, items);
        Order savedOrder = orderRepository.save(newOrder);

        List<OrderItemOutput> itemOutputList = savedOrder.getItems().stream()
                .map(item -> new OrderItemOutput(
                        item.quantity(),
                        item.unitPrice(),
                        item.calculateTotalPrice(),
                        item.name()
                )).toList();

        return new CreateOrderOutput(
                savedOrder.getExternalId(),
                savedOrder.getStoreExternalId(),
                savedOrder.calculateTotalPrice(),
                itemOutputList
        );
    }
}
