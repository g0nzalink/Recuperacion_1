package org.example.eventsrecu.service;

import org.example.eventsrecu.Entity.Product;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {
    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        products.add(new Product("P001", "Laptop", 1));
        products.add(new Product("P002", "Mouse", 2));
        products.add(new Product("P003", "Funda", 1));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void reduceStock(String productId, int quantity) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                p.setQuantity(p.getQuantity() - quantity);
                break;
            }
        }
    }
}