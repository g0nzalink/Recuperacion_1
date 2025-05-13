package org.example.eventsrecu.Entity;

import lombok.Data;

import java.util.List;

@Data
public class Order {
	private String id;
	private String email;
	private List<String> products;
}
