package com.security.security_p3_jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerController {

    // 1. Public Endpoint
    @GetMapping("/public")
    public Map<String, String> publicEndpoint() {
        return Map.of("message", "Ye public endpoint hai, bina kisi JWT ke access hoga.");
    }

    // 2. Coarse-grained Role Check: hasRole('ADMIN')
    @GetMapping("/admin-zone")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Object> adminOnly(Authentication authentication) {
        return Map.of(
                "message", "Welcome VIP Admin!",
                "user", authentication.getName(),
                "authorities", authentication.getAuthorities()
        );
    }

    // 3. Fine-grained Authority Check: hasAuthority('CUSTOMER_READ')
    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('CUSTOMER_READ')")
    public Map<String, Object> getAllCustomers(Authentication authentication) {
        return Map.of(
                "message", "Customer list fetch ho gayi",
                "requestedBy", authentication.getName()
        );
    }

    // 4. Fine-grained Authority Check: hasAuthority('CUSTOMER_DELETE')
    @DeleteMapping("/customers/{id}")
    @PreAuthorize("hasAuthority('CUSTOMER_DELETE')")
    public Map<String, String> deleteCustomer(@PathVariable Long id, Authentication authentication) {
        return Map.of(
                "message", "Customer with ID " + id + " delete ho gaya!",
                "deletedBy", authentication.getName()
        );
    }
}