package com.crowdintelligence.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Document("state_models")
public class StateModel {
    @Id
    private String id;
    private String tenantId;
    private String name;
    // Simplified: compiled graph; in MVP, just store as maps/lists
    private List<Map<String, Object>> states;
    private List<Map<String, Object>> transitions;
    private String version;
    private boolean active;
    private String uploadedBy;
    private Instant createdAt = Instant.now();

    // Getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Map<String, Object>> getStates() { return states; }
    public void setStates(List<Map<String, Object>> states) { this.states = states; }
    public List<Map<String, Object>> getTransitions() { return transitions; }
    public void setTransitions(List<Map<String, Object>> transitions) { this.transitions = transitions; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public String getUploadedBy() { return uploadedBy; }
    public void setUploadedBy(String uploadedBy) { this.uploadedBy = uploadedBy; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
