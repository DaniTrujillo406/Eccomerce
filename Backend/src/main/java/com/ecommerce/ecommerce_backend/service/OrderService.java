package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.Order;
import com.ecommerce.ecommerce_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    // Crear o actualizar una orden
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Obtener todas las órdenes
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Obtener una orden por ID
    public Order getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    // Eliminar una orden
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
