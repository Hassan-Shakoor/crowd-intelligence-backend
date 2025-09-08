package com.crowdintelligence.demo.controller;

import com.crowdintelligence.demo.model.Problem;
import com.crowdintelligence.demo.service.ProblemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/problems")
public class ProblemController {

    private final ProblemService problems;

    public ProblemController(ProblemService problems) {
        this.problems = problems;
    }

    @PostMapping
    public ResponseEntity<Problem> create(@RequestBody Problem body) {
        return ResponseEntity.ok(problems.create(body));
    }

    @GetMapping
    public ResponseEntity<List<Problem>> list() {
        return ResponseEntity.ok(problems.listForTenant());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Problem> get(@PathVariable String id) {
        return ResponseEntity.ok(problems.getForTenant(id));
    }
}
