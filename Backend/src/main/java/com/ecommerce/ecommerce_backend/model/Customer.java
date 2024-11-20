package com.ecommerce.ecommerce_backend.model;

import jakarta.persistence.*;

@Entity // Indica que esta clase es una entidad JPA y se mapeará a una tabla de la base de datos
@Table(name = "customer")
public class Customer {
    @Id
    @Column
    private Long id;  // id será de tipo bigint en la base de datos

    @Column(nullable = false, length = 255)
    private String name;  // sombre

    @Column(nullable = false, unique = true, length = 255)
    private String email;  // email

    @Column(nullable = true, length = 20)
    private String phone;  // teléfono

    @Column(nullable = false)
    private String password;  // contraseña

    // Constructor vacío
    public Customer() {}

    // Getters y Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
