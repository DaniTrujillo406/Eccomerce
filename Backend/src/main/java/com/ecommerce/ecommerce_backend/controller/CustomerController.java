package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.model.Customer;
import com.ecommerce.ecommerce_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Indica que esta clase es un controlador y que las respuestas serán enviadas directamente como JSON.
@RequestMapping("/api/customer") //Define la ruta base para todas las rutas de este controlador
public class CustomerController {
    @Autowired
    private CustomerService customerService;  // Inyectamos el servicio que interactúa con la base de datos

    // Metodo para obtener todos los clientes
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();  // Llama al servicio para obtener todos los clientes
    }

    // Metodo para obtener un cliente por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // Metodo para crear un nuevo cliente
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.saveCustomer(customer);  // Llama al servicio para guardar el cliente
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);  // Retorna el cliente creado con un estado 201
    }

    // M3todo para eliminar un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Top 5 clientes frecuentes
    @GetMapping("/top-frequent")
    public List<Customer> getTopFrequentCustomers() {
        return customerService.getTopFrequentCustomers();  // Llama al servicio para obtener los clientes frecuentes
    }
}
