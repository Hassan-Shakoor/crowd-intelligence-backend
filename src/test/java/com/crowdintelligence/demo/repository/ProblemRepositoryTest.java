package com.crowdintelligence.demo.repository;

import com.crowdintelligence.demo.model.Problem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
class ProblemRepositoryTest {

    @Autowired
    private ProblemRepository problemRepository;

    @Test
    void testSaveAndFindByTenantId() {
        Problem problem = new Problem();
        problem.setTenantId("companyA");
        problem.setSeekerId("usr_1");
        problem.setTitle("Conveyor issue");
        problem.setNarrative("Keeps jamming under high load");

        problemRepository.save(problem);

        List<Problem> results = problemRepository.findByTenantId("companyA");

        assertThat(results).isNotEmpty();
        assertThat(results.get(0).getTitle()).isEqualTo("Conveyor issue");
    }
}
