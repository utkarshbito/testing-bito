package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/** Liveness and readiness endpoints for the user service. */
@RestController
@RequestMapping("/api/health")
public class HealthController {

    @GetMapping("/live")
    public Map<String, String> liveness() {
        return Map.of("status", "UP");
    }

    @GetMapping("/ready")
    public Map<String, String> readiness() {
        return Map.of("status", "READY", "service", "user-service");
    }
}
