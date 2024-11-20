package com.ecommerce.ecommerce_backend.repository;

import com.ecommerce.ecommerce_backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Método para obtener los 5 clientes más frecuentes
//    @Query("SELECT c FROM customer c " +     // Buscar en la tabla customer
//            "ORDER BY " +                    // Ordenar por
//            "(SELECT COUNT(o) " +            // Contar las órdenes realizadas por cada cliente
//            "FROM orders o " +                // De la tabla order_detail
//            "WHERE o.customer_id = c.id) " + // donde el customer_id es igual al id del cliente actual en la consulta (esta contando cuántas órdenes ha hecho el cliente)
//            "DESC " +                        // Ordenar de mayor a menor
//            "LIMIT 5"                        // Solo  5 clientes
//    )
    @Query("SELECT c FROM Customer c ORDER BY (SELECT COUNT(o) FROM Order o WHERE o.customer.id = c.id) DESC LIMIT 5")
    List<Customer> findTop5ByOrderByOrderCountDesc();

    // Buscar por email
    Optional<Customer> findByEmail(String email);
}
