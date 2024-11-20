package com.ecommerce.ecommerce_backend.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Indica que esta clase es una entidad JPA y se mapeará a una tabla de la base de datos
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column // Mapea la columna "id" de la base de datos
    private Long id;

    @Column(nullable = false)  // Mapea la columna "quantity"
    private Integer quantity;

    @Column(nullable = false)  // Mapea la columna "date_last_inventory"
    private LocalDateTime date_last_inventory;  // Usamos LocalDateTime para representar fechas y horas con zona horaria

    @Column(nullable = false)  // Mapea la columna "name"
    private String name;

    @ManyToOne  // Relación muchos a uno con Product (muchos inventarios pueden tener el mismo producto)
    @JoinColumn(name = "product_id")  // La clave foránea que enlaza con la tabla "product"
    private Product product;  // El producto asociado con el inventario

    // Getters y Setters para cada propiedad

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateLastInventory() {
        return date_last_inventory;
    }

    public void setDateLastInventory(LocalDateTime date_last_inventory) {
        this.date_last_inventory = date_last_inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
