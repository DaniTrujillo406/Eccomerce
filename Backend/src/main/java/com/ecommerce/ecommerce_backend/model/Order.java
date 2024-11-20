package com.ecommerce.ecommerce_backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity // Indica que esta clase es una entidad JPA y se mapeará a una tabla de la base de datos
@Table(name = "orders")
public class Order {
    @Id
    private Long id;

    @Column
    private LocalDateTime order_date; // Usamos LocalDateTime para almacenar la fecha y hora con zona horaria

    @Column
    private Double total_price; // Almacenará el precio total de la orden

    @Column
    private String state; // Estado de la orden (puede ser 'activa', 'pendiente', 'cancelada', 'completada', etc.)

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false) // Relación con la tabla Customer
    private Customer customer; // Cliente que realizó la orden

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return order_date;
    }

    public void setOrderDate(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public Double getTotalPrice() {
        return total_price;
    }

    public void setTotalPrice(Double total_price) {
        this.total_price = total_price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}