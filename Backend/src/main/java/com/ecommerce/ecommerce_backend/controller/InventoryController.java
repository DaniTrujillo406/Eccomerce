package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.model.Inventory;
import com.ecommerce.ecommerce_backend.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController //Indica que esta clase es un controlador y que las respuestas serán enviadas directamente como JSON.
@RequestMapping("/api/inventory") //Define la ruta base para todas las rutas de este controlador
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // Crear o actualizar un inventario
    @PostMapping
    public ResponseEntity<Inventory> createOrUpdateInventory(@RequestBody Inventory inventory) {
        Inventory savedInventory = inventoryService.saveInventory(inventory);
        return new ResponseEntity<>(savedInventory, HttpStatus.CREATED);
    }

    // Obtener todos los inventarios
    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventories() {
        List<Inventory> inventories = inventoryService.getAllInventories();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    // Obtener inventario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id) {
        Inventory inventory = inventoryService.getInventoryById(id);
        if (inventory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    // Eliminar un inventario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
