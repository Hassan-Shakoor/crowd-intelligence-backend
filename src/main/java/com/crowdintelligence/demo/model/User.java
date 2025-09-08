package com.crowdintelligence.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document("users")
public class User {
    @Id
    private String id;
    private String tenantId;
    private String email;
    private String passwordHash;
    private String role; // SEEKER | MASTER | COACH | ADMIN

    private Profile profile = new Profile();
    private String status = "ACTIVE";
    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();

    public static class Profile {
        private String name;
        private List<String> skills;
        private String bio;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public List<String> getSkills() { return skills; }
        public void setSkills(List<String> skills) { this.skills = skills; }
        public String getBio() { return bio; }
        public void setBio(String bio) { this.bio = bio; }
    }

    // Getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

}
