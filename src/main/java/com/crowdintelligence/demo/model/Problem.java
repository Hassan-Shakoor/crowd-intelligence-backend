package com.crowdintelligence.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document("problems")
public class Problem {
    @Id
    private String id;
    private String tenantId;
    private String seekerId;
    private String title;
    private String narrative;
    private String status = "SUBMITTED"; // SUBMITTED | APPROVED | IN_PROGRESS | COMPLETED
    private List<String> relatedDocs;
    private String workflowRunId;
    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();

    // Getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
    public String getSeekerId() { return seekerId; }
    public void setSeekerId(String seekerId) { this.seekerId = seekerId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getNarrative() { return narrative; }
    public void setNarrative(String narrative) { this.narrative = narrative; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<String> getRelatedDocs() { return relatedDocs; }
    public void setRelatedDocs(List<String> relatedDocs) { this.relatedDocs = relatedDocs; }
    public String getWorkflowRunId() { return workflowRunId; }
    public void setWorkflowRunId(String workflowRunId) { this.workflowRunId = workflowRunId; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
