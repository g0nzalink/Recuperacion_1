package org.example.eventsrecu.Controller;

import org.example.eventsrecu.Entity.Order;
import org.example.eventsrecu.Entity.Product;
import org.example.eventsrecu.OrderCreatedEvent;
import org.example.eventsrecu.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private InventoryService inventoryService;

	@PostMapping
	public String createOrder(@RequestBody Order order) {
		eventPublisher.publishEvent(new OrderCreatedEvent(this, order));
		// Reducir stock directamente también aquí si quieres (opcional)
		for (Product product : order.getProducts()) {
			inventoryService.reduceStock(product.getProductId(), product.getQuantity());
		}
		return "Pedido recibido: " + order.getId();
	}
}
