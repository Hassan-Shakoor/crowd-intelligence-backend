package com.crowdintelligence.demo.repository;

import com.crowdintelligence.demo.model.WorkflowRun;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WorkflowRunRepository extends MongoRepository<WorkflowRun, String> {
    List<WorkflowRun> findByTenantIdAndProblemId(String tenantId, String problemId);
}
