package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.model.OrderDetail;
import com.ecommerce.ecommerce_backend.service.OrderDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController //Indica que esta clase es un controlador y que las respuestas serán enviadas directamente como JSON.
@RequestMapping("/api/order-detail") //Define la ruta base para todas las rutas de este controlador
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    // Obtener todos los detalles de orden
    @GetMapping
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

    // Obtener un detalle de orden por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable Long id) {
        OrderDetail orderDetail = orderDetailService.getOrderDetailById(id);
        if (orderDetail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderDetail);
    }

    // Crear o actualizar un detalle de orden
    @PostMapping
    public OrderDetail createOrUpdateOrderDetail(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.saveOrderDetail(orderDetail);
    }

    // Eliminar un detalle de orden por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long id) {
        orderDetailService.deleteOrderDetail(id);
        return ResponseEntity.noContent().build();
    }
}
