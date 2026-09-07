package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/** Request counters for the user service. */
@RestController
@RequestMapping("/api/metrics")
public class MetricsController {

    private final AtomicLong requests = new AtomicLong();

    @GetMapping("/requests")
    public Map<String, Long> requestCount() {
        return Map.of("total", requests.incrementAndGet());
    }

    @GetMapping("/uptime")
    public Map<String, Long> uptime() {
        return Map.of("startedAtMillis", System.currentTimeMillis());
    }
}
