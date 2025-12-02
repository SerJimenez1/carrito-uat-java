package com.ejemplo.model;

public class Product {
    private final String id;
    private final String name;
    private final double price; // En un sistema real usarías BigDecimal

    public Product(String id, String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
