package com.crowdintelligence.demo.controller;

import com.crowdintelligence.demo.model.TenantConfig;
import com.crowdintelligence.demo.service.TenantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tenant")
public class TenantController {
    private final TenantService tenants;

    public TenantController(TenantService tenants) {
        this.tenants = tenants;
    }

    @GetMapping("/config")
    public ResponseEntity<Optional<TenantConfig>> getConfig() {
        return ResponseEntity.ok(tenants.currentTenantConfig());
    }

    @PostMapping("/config")
    public ResponseEntity<TenantConfig> saveConfig(@RequestBody TenantConfig cfg) {
        return ResponseEntity.ok(tenants.save(cfg));
    }
}
