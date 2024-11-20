package com.ecommerce.ecommerce_backend.model;

import jakarta.persistence.*;

@Entity // Indica que esta clase es una entidad JPA y se mapeará a una tabla de la base de datos
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    private Long id; // Identificador único del detalle de la orden

    @Column(nullable = false)
    private Long quantity; // Cantidad del producto

    @Column(nullable = false)
    private Double unitPrice; // Precio unitario del producto

    @ManyToOne // Relación muchos a uno con Order
    @JoinColumn(name = "id_orders", nullable = false) // Clave foránea hacia la tabla orders
    private Order order; // La orden a la que pertenece este detalle

    @ManyToOne // Relación muchos a uno con Product
    @JoinColumn(name = "id_product", nullable = false) // Clave foránea hacia la tabla products
    private Product product; // El producto que se detalla en este registro

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
