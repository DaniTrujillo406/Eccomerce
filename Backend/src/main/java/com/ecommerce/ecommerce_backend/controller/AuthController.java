package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.auth.AuthRequest;
import com.ecommerce.ecommerce_backend.model.Customer;
import com.ecommerce.ecommerce_backend.repository.CustomerRepository;
//import com.ecommerce.ecommerce_backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController //Indica que esta clase es un controlador y que las respuestas serán enviadas directamente como JSON.
@RequestMapping("/auth") //Define la ruta base para todas las rutas de este controlador
public class AuthController {
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private JwtService jwtService;
//
//    // Registro de usuarios
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody Customer customer) {
//        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
//            return new ResponseEntity<>("Email ya registrado", HttpStatus.BAD_REQUEST);
//        }
//        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//        customerRepository.save(customer);
//        return new ResponseEntity<>("Usuario registrado con éxito", HttpStatus.CREATED);
//    }
//
//    // Inicio de sesión
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
//        Customer customer = customerRepository.findByEmail(authRequest.getEmail())
//                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
//
//        if (!passwordEncoder.matches(authRequest.getPassword(), customer.getPassword())) {
//            return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.UNAUTHORIZED);
//        }
//
//        String token = jwtService.generateToken(customer);
//        return new ResponseEntity<>(token, HttpStatus.OK);
//    }
//    // Validar token (opcional)
//    @GetMapping("/validate")
//    public ResponseEntity<String> validateToken(@RequestParam String token) {
//        if (jwtService.isTokenValid(token)) {
//            return new ResponseEntity<>("Token válido", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Token inválido", HttpStatus.UNAUTHORIZED);
//        }
//    }

}
