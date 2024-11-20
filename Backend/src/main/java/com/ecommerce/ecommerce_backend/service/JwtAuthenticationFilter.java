package com.ecommerce.ecommerce_backend.service;

//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

//@Component

//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    @Value("${jwt.secret}")
//    private String jwtSecret;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//        String authHeader = request.getHeader("Authorization");
//
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            String jwtToken = authHeader.substring(7);
//            try {
//                Claims claims = Jwts.parser()
//                        .setSigningKey(jwtSecret)
//                        .parseClaimsJws(jwtToken)
//                        .getBody();
//
//                String username = claims.getSubject();
//
//                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                            username, null, Collections.emptyList());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            } catch (SignatureException e) {
//                System.out.println("Invalid JWT signature: " + e.getMessage());
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
