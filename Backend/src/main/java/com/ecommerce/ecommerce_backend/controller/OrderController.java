package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.model.Order;
import com.ecommerce.ecommerce_backend.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController //Indica que esta clase es un controlador y que las respuestas serán enviadas directamente como JSON.
@RequestMapping("/api/orders") //Define la ruta base para todas las rutas de este controlador
public class OrderController {
    @Autowired
    private OrderService orderService;

    // Crear o actualizar una orden
    @PostMapping
    public ResponseEntity<Order> createOrUpdateOrder(@RequestBody Order order) {
        Order savedOrder = orderService.saveOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    // Obtener todas las ordenes
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Obtener una orden por ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    // Eliminar una orden por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
