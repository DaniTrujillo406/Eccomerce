package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.Customer;
import com.ecommerce.ecommerce_backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    // Crear o actualizar un cliente
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Obtener todos los clientes
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Obtener un cliente por ID
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    // Eliminar un cliente
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // Obtener los 5 clientes más frecuentes
    public List<Customer> getTopFrequentCustomers() {
        return customerRepository.findTop5ByOrderByOrderCountDesc();  // Llama al repositorio para obtener los clientes más frecuentes
    }
}
