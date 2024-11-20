package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.Inventory;
import com.ecommerce.ecommerce_backend.model.Product;
import com.ecommerce.ecommerce_backend.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    // Crear o actualizar un inventario
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Obtener todos los inventarios
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    // Obtener inventario por ID
    public Inventory getInventoryById(Long id) {
        Optional<Inventory> inventory = inventoryRepository.findById(id);
        return inventory.orElse(null);
    }

    // Eliminar un inventario
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}
