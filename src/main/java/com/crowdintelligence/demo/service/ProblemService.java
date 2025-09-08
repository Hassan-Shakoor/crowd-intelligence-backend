package com.crowdintelligence.demo.service;

import com.crowdintelligence.demo.context.TenantContext;
import com.crowdintelligence.demo.model.Problem;
import com.crowdintelligence.demo.repository.ProblemRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ProblemService {
    private final ProblemRepository problems;

    public ProblemService(ProblemRepository problems) {
        this.problems = problems;
    }

    public Problem create(Problem p) {
        p.setTenantId(TenantContext.getTenantId());
        p.setStatus("SUBMITTED");
        p.setUpdatedAt(Instant.now());
        return problems.save(p);
    }

    public List<Problem> listForTenant() {
        return problems.findByTenantId(TenantContext.getTenantId());
    }

    public Problem getForTenant(String id) {
        return problems.findById(id)
                .filter(p -> TenantContext.getTenantId().equals(p.getTenantId()))
                .orElseThrow(() -> new IllegalArgumentException("Problem not found"));
    }

    public Problem approve(String id) {
        Problem p = getForTenant(id);
        p.setStatus("APPROVED");
        p.setUpdatedAt(Instant.now());
        return problems.save(p);
    }
}
