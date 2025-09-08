package com.crowdintelligence.demo.controller;

import com.crowdintelligence.demo.model.Problem;
import com.crowdintelligence.demo.service.ProblemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final ProblemService problems;

    public AdminController(ProblemService problems) {
        this.problems = problems;
    }

    @PostMapping("/problems/{id}/approve")
    public ResponseEntity<Problem> approve(@PathVariable String id) {
        return ResponseEntity.ok(problems.approve(id));
    }
}
