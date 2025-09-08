package com.crowdintelligence.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document("tenant_config")
public class TenantConfig {
    @Id
    private String tenantId;
    private Map<String, String> branding;   // logo, themeColor
    private Map<String, Boolean> features;  // synthesis, aiRetrieval flags
    private String stateModelVersion;

    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
    public Map<String, String> getBranding() { return branding; }
    public void setBranding(Map<String, String> branding) { this.branding = branding; }
    public Map<String, Boolean> getFeatures() { return features; }
    public void setFeatures(Map<String, Boolean> features) { this.features = features; }
    public String getStateModelVersion() { return stateModelVersion; }
    public void setStateModelVersion(String stateModelVersion) { this.stateModelVersion = stateModelVersion; }
}
