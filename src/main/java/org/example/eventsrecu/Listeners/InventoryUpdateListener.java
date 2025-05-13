package org.example.eventsrecu.Listeners;

import org.example.eventsrecu.OrderCreatedEvent;
import org.example.eventsrecu.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class InventoryUpdateListener {
	private static final Logger logger = LogManager.getLogger(InventoryUpdateListener.class);

	@Autowired
	private InventoryService inventoryService;

	@EventListener
	@Async
	public void handleOrderCreated(OrderCreatedEvent event) {
		logger.info("Reduciendo stock para productos del pedido: " + event.getOrder().getProducts());

		logger.info("Stock actual después del pedido:");
		inventoryService.getProducts().forEach(product ->
				logger.info(product.getProductId() + " - " + product.getName() + ": " + product.getQuantity())
		);
	}
}
