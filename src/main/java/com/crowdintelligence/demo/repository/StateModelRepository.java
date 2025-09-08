package com.crowdintelligence.demo.repository;

import com.crowdintelligence.demo.model.StateModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StateModelRepository extends MongoRepository<StateModel, String> {
    List<StateModel> findByTenantId(String tenantId);
}
