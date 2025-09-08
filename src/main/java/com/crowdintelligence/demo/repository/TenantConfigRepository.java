package com.crowdintelligence.demo.repository;

import com.crowdintelligence.demo.model.TenantConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TenantConfigRepository extends MongoRepository<TenantConfig, String> {
}
