package org.example.eventsrecu.Listeners;

import org.example.eventsrecu.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class InventoryUpdateListener {
	private static final Logger logger = LogManager.getLogger(InventoryUpdateListener.class);
	
	@EventListener
	@Async
	public void handleOrderCreated(OrderCreatedEvent event) {
		logger.info("Reduciendo stock para productos: " + event.getOrder().getProducts());
	}
}
