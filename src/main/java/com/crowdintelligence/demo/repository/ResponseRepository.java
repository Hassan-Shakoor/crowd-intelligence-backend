package com.crowdintelligence.demo.repository;

import com.crowdintelligence.demo.model.Response;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResponseRepository extends MongoRepository<Response, String> {
    List<Response> findByTenantIdAndProblemId(String tenantId, String problemId);
}
