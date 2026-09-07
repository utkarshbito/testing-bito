package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

/** Added 130038 to give the incremental path a real diff. */
@RestController
@RequestMapping("/api/audit")
public class AuditController {
    @GetMapping("/{id}")
    public Map<String, Object> auditFor(@PathVariable Long id) {
        return Map.of("id", id, "checked", true, "run", "130038");
    }
}
