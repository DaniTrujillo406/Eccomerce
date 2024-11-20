package com.ecommerce.ecommerce_backend.model;

import jakarta.persistence.*;

@Entity // Indica que esta clase es una entidad JPA y se mapeará a una tabla de la base de datos
@Table(name = "products")

public class Product {
    @Id  // Define la clave primaria
    private Long id;

    @Column(nullable = false)  // Indica que este campo no puede ser nulo
    private String name;

    @Column(length = 500, nullable = true)  // Permite definir un tamaño máximo para la descripción
    private String description;

    @Column(nullable = false)  // Indica que el precio no puede ser nulo
    private Double price;

    @Column(nullable = true)  // No hay restricciones adicionales en este campo
    private String img;

    @Column(nullable = true)  // No hay restricciones adicionales en este campo
    private String category;

    @Column(nullable = false)  // Indica que este campo no puede ser nulo
    private Boolean state;

    // Constructor vacío (obligatorio para JPA)
    public Product() {}

    // Constructor con parámetros (opcional, útil para instanciar objetos)
    public Product(String name, String description, Double price, String img, String category, Boolean state) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
        this.category = category;
        this.state = state;
    }

    // Getters y Setters (obligatorios para acceder y modificar los campos)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
