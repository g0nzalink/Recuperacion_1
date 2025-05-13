package org.example.eventsrecu.Controller;

import org.example.eventsrecu.Entity.Order;
import org.example.eventsrecu.OrderCreatedEvent;
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
	
	@PostMapping
	public String createOrder(@RequestBody Order order) {
		eventPublisher.publishEvent(new OrderCreatedEvent(this, order));
		return "Pedido recibido: " + order.getId();
	}
}
