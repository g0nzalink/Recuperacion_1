package org.example.eventsrecu.service;

import org.example.eventsrecu.Entity.Product;
import org.example.eventsrecu.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        // Solo inicializar si está vacío
        if (productRepository.count() == 0) {
            productRepository.save(new Product("P001", "Laptop", 1));
            productRepository.save(new Product("P002", "Mouse", 2));
            productRepository.save(new Product("P003", "Funda", 1));
        }
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void reduceStock(String productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }
}