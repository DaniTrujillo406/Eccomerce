package com.ecommerce.ecommerce_backend.repository;

import com.ecommerce.ecommerce_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Esta anotación le indica a Spring que esta clase es un repositorio.
            // En este caso, estamos utilizando una interfaz, no una clase concreta.
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Metodo para obtener productos activos (state = true)
    List<Product> findByStateTrue();

    // Metodo para obtener los 5 productos más vendidos
//    @Query("SELECT p FROM products p" +      // Buscar en la tabla products
//            "ORDER BY" +                     // Ordenarlo por
//            "(SELECT SUM(od.quantity)" +     // La suma de la cantidad de cada order_detail
//            "FROM order_detail od" +         // De la tabla order_detail
//            "WHERE od.id_product = p.id)" +  // Donde el id_product sea igual que el id del producto actual (para cada producto, se buscan todas las órdenes en las que ese producto ha sido vendido)
//            "DESC " +                        // Ordenar de mayor a menor
//            "LIMIT 5"                        // Solo  5 productos
//    )
    @Query("SELECT p FROM Product p ORDER BY (SELECT SUM(od.quantity) FROM OrderDetail od WHERE od.product.id = p.id) DESC LIMIT 5")
    List<Product> findTop5ByOrderBySalesDesc();
}