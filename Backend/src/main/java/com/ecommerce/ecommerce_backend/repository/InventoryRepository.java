package com.ecommerce.ecommerce_backend.repository;

import com.ecommerce.ecommerce_backend.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Esta anotación le indica a Spring que esta clase es un repositorio.
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // Agregar métodos personalizados
}
