package com.crowdintelligence.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("responses")
public class Response {
    @Id
    private String id;
    private String tenantId;
    private String problemId;
    private String masterId;
    private String content;
    private Instant submittedAt = Instant.now();

    // Getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
    public String getProblemId() { return problemId; }
    public void setProblemId(String problemId) { this.problemId = problemId; }
    public String getMasterId() { return masterId; }
    public void setMasterId(String masterId) { this.masterId = masterId; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Instant getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(Instant submittedAt) { this.submittedAt = submittedAt; }
}
