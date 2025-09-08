package com.crowdintelligence.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Document("workflow_runs")
public class WorkflowRun {
    @Id
    private String id;
    private String tenantId;
    private String problemId;
    private String stateModelId;
    private String currentState;
    private List<StateEntry> history = new ArrayList<>();
    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();

    public static class StateEntry {
        private String state;
        private Instant at;

        public StateEntry() {}
        public StateEntry(String state, Instant at) {
            this.state = state; this.at = at;
        }
        public String getState() { return state; }
        public void setState(String state) { this.state = state; }
        public Instant getAt() { return at; }
        public void setAt(Instant at) { this.at = at; }
    }

    // Getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
    public String getProblemId() { return problemId; }
    public void setProblemId(String problemId) { this.problemId = problemId; }
    public String getStateModelId() { return stateModelId; }
    public void setStateModelId(String stateModelId) { this.stateModelId = stateModelId; }
    public String getCurrentState() { return currentState; }
    public void setCurrentState(String currentState) { this.currentState = currentState; }
    public List<StateEntry> getHistory() { return history; }
    public void setHistory(List<StateEntry> history) { this.history = history; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
