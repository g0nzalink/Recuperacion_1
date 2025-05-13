package org.example.eventsrecu.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {
	private String id;
	private String email;
	private List<Product> products;
}
