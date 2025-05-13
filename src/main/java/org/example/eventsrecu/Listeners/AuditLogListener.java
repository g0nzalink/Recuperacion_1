package org.example.eventsrecu.Listeners;

import org.example.eventsrecu.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class AuditLogListener {
	private static final Logger logger = LogManager.getLogger(AuditLogListener.class);
	
	@EventListener
	@Async
	public void handleOrderCreated(OrderCreatedEvent event) {
		logger.info("Registrando pedido en auditoría: " + event.getOrder().getId());
	}
}