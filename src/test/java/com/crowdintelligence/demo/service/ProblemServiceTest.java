package com.crowdintelligence.demo.service;

import com.crowdintelligence.demo.context.TenantContext;
import com.crowdintelligence.demo.model.Problem;
import com.crowdintelligence.demo.repository.ProblemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ProblemServiceTest {

    private ProblemRepository problemRepository;
    private ProblemService problemService;

    @BeforeEach
    void setUp() {
        problemRepository = Mockito.mock(ProblemRepository.class);
        problemService = new ProblemService(problemRepository);

        TenantContext.setTenantId("companyA");
    }

    @Test
    void testCreateProblem() {
        Problem problem = new Problem();
        problem.setTitle("Conveyor jam");

        when(problemRepository.save(any(Problem.class))).thenAnswer(i -> i.getArguments()[0]);

        Problem saved = problemService.create(problem);

        assertThat(saved.getTenantId()).isEqualTo("companyA");
        assertThat(saved.getStatus()).isEqualTo("SUBMITTED");
    }

    @Test
    void testListForTenant() {
        when(problemRepository.findByTenantId("companyA"))
                .thenReturn(Collections.singletonList(new Problem()));

        assertThat(problemService.listForTenant()).hasSize(1);
    }
}