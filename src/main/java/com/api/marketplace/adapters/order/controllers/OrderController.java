package com.api.marketplace.adapters.order.controllers;

import com.api.marketplace.application.order.commands.CreateOrderInput;
import com.api.marketplace.application.order.commands.CreateOrderOutput;
import com.api.marketplace.application.order.useCases.CreateOrderUseCase;
import com.api.marketplace.application.order.commands.OrderItemInput;
import com.api.marketplace.application.order.useCases.UpdateOrderStatusUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;

    public OrderController(
            CreateOrderUseCase createOrderUseCase,
            UpdateOrderStatusUseCase updateOrderStatusUseCase
    ) {
        this.createOrderUseCase = createOrderUseCase;
        this.updateOrderStatusUseCase = updateOrderStatusUseCase;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody CreateOrderRequest body) {
        List<OrderItemInput> items = body.items().stream()
                .map(item -> new OrderItemInput(
                        item.quantity(),
                        item.name()
                ))
                .toList();

        CreateOrderInput input = new CreateOrderInput(
                body.storeId(),
                items
        );

        CreateOrderOutput result = createOrderUseCase.execute(input);

        List<OrderItemResponse> itemsResponse = result.items().stream()
                .map(item -> new OrderItemResponse(
                        item.name(),
                        item.quantity(),
                        item.unitPrice()
                ))
                .toList();

        OrderResponse response = new OrderResponse(
                result.id(),
                result.storeId(),
                result.status(),
                itemsResponse,
                result.totalPrice()
        );

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{orderId}/status")
    public ResponseEntity<Boolean> updateStatus (@PathVariable UUID orderId, @RequestBody UpdateOrderStatusRequest body) {
        this.updateOrderStatusUseCase.execute(orderId, body.status());

        return ResponseEntity.ok(true);
    }


}
