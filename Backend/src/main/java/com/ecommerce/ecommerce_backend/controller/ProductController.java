package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.model.Product;
import com.ecommerce.ecommerce_backend.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController //Indica que esta clase es un controlador y que las respuestas serán enviadas directamente como JSON.
@RequestMapping("/api/product") //Define la ruta base para todas las rutas de este controlador
@CrossOrigin(origins = "http://localhost:3000") // Permitir solicitudes desde el frontend
public class ProductController {
    @Autowired
    private ProductService productService;

    // Crear o actualizar un producto
    @PostMapping
    public ResponseEntity<Product> createUpdateProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Productos activos
    @GetMapping("/active")
    public List<Product> getActiveProducts() {
        return productService.getActiveProducts();
    }

    // Top 5 más vendidos
    @GetMapping("/top-sold")
    public List<Product> getTopSoldProducts() {
        return productService.getTopSoldProducts();
    }
}
