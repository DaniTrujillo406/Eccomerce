package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.OrderDetail;
import com.ecommerce.ecommerce_backend.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    // Método para obtener todos los detalles de orden
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    // Método para obtener un detalle de orden por ID
    public OrderDetail getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    // Método para crear o actualizar un detalle de orden
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    // Método para eliminar un detalle de orden por ID
    public void deleteOrderDetail(Long id) {
        orderDetailRepository.deleteById(id);
    }
}
