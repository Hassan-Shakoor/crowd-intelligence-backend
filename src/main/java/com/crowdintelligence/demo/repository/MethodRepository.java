package com.crowdintelligence.demo.repository;


import com.crowdintelligence.demo.model.Method;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MethodRepository extends MongoRepository<Method, String> {
    List<Method> findByTenantIdAndActiveTrue(String tenantId);
}