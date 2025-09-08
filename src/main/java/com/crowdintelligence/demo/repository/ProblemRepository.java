package com.crowdintelligence.demo.repository;

import com.crowdintelligence.demo.model.Problem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProblemRepository extends MongoRepository<Problem, String> {
    List<Problem> findByTenantId(String tenantId);
}
