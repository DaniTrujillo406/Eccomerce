package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.Product;
import com.ecommerce.ecommerce_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Marca esta clase como un servicio para que Spring la gestione como un componente.
        // Los servicios contienen la lógica de negocio.
public class ProductService {
    @Autowired //Inyecta automáticamente una instancia de ProductRepository en el servicio para que puedas utilizar sus métodos.
    private ProductRepository productRepository;

    // Crear o actualizar un producto
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Obtener todos los productos
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Obtener un producto por su ID
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null); // Si no se encuentra, retorna el null
    }

    // Eliminar un producto por su ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Obtener productos activos
    public List<Product> getActiveProducts() {
        // Devuelve los productos cuyo estado sea 'activo' (state = true)
        return productRepository.findByStateTrue();  // Llama al repositorio para obtener los productos activos
    }

    // Obtener 5 productos más vendidos
    public List<Product> getTopSoldProducts() {
        return productRepository.findTop5ByOrderBySalesDesc();  // Llama al repositorio para obtener los productos más vendidos
    }
}
