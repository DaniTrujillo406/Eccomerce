package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.Customer;
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

//@Service
//public class JwtService {
//    private final String SECRET_KEY = "secret";  // Aquí recibo la contraseña
//
//    public String generateToken(Customer customer) {
//        return Jwts.builder()
//                .setSubject(customer.getEmail())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas
//                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public boolean isTokenValid(String token) {
//        try {
//            Jwts.parserBuilder()
//                    .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
//                    .build()
//                    .parseClaimsJws(token);
//            return true;
//        } catch (JwtException e) {
//            return false;
//        }
//    }
//
//    public String extractEmail(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//}
