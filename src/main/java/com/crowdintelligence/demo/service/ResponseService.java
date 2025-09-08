package com.crowdintelligence.demo.service;

import com.crowdintelligence.demo.context.TenantContext;
import com.crowdintelligence.demo.model.Response;
import com.crowdintelligence.demo.repository.ResponseRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ResponseService {
    private final ResponseRepository responses;

    public ResponseService(ResponseRepository responses) {
        this.responses = responses;
    }

    public Response submit(Response r) {
        r.setTenantId(TenantContext.getTenantId());
        r.setSubmittedAt(Instant.now());
        return responses.save(r);
    }

    public List<Response> listForProblem(String problemId) {
        return responses.findByTenantIdAndProblemId(TenantContext.getTenantId(), problemId);
    }
}
