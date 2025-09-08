package com.crowdintelligence.demo.repository;

import com.crowdintelligence.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByTenantIdAndEmail(String tenantId, String email);
}
