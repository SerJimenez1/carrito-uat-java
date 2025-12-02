package com.ejemplo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void CA01_debeAgregarUnProductoAlCarrito() {
        ShoppingCart cart = new ShoppingCart();
        Product productA = new Product("A", "Producto A", 10.0);

        cart.addProduct(productA, 1);

        assertEquals(1, cart.getTotalItems());
        assertEquals(10.0, cart.getTotalAmount(), 0.001);
        assertFalse(cart.isEmpty());
    }

    @Test
    void CA02_debeActualizarCantidadDeUnProducto() {
        ShoppingCart cart = new ShoppingCart();
        Product productA = new Product("A", "Producto A", 10.0);
        cart.addProduct(productA, 1);

        cart.updateQuantity("A", 3);

        assertEquals(3, cart.getTotalItems());
        assertEquals(30.0, cart.getTotalAmount(), 0.001);
    }

    @Test
    void CA03_debeEliminarProductoDelCarrito() {
        ShoppingCart cart = new ShoppingCart();
        Product productA = new Product("A", "Producto A", 10.0);
        cart.addProduct(productA, 1);

        cart.removeProduct("A");

        assertTrue(cart.isEmpty());
        assertEquals(0, cart.getTotalItems());
        assertEquals(0.0, cart.getTotalAmount(), 0.001);
    }

    @Test
    void CA05_debeLanzarErrorAlEliminarProductoInexistente() {
        ShoppingCart cart = new ShoppingCart();

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> cart.removeProduct("X"));

        assertTrue(exception.getMessage().contains("no está en el carrito"));
    }
}
