package org.example.eventsrecu.Entity;

import lombok.Data;

import java.util.List;

@Data

public class Stock {

    List<Product> products;

    public Stock(List<Product> products) {
        this.products = products;
    }
}
