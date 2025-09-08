package com.crowdintelligence.demo.service;

import com.crowdintelligence.demo.context.TenantContext;
import com.crowdintelligence.demo.model.TenantConfig;
import com.crowdintelligence.demo.repository.TenantConfigRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TenantService {
    private final TenantConfigRepository tenantConfigs;

    public TenantService(TenantConfigRepository tenantConfigs) {
        this.tenantConfigs = tenantConfigs;
    }

    public Optional<TenantConfig> currentTenantConfig() {
        return tenantConfigs.findById(TenantContext.getTenantId());
    }

    public TenantConfig save(TenantConfig cfg) {
        // ensure id matches tenant context for safety
        cfg.setTenantId(TenantContext.getTenantId());
        return tenantConfigs.save(cfg);
    }
}
