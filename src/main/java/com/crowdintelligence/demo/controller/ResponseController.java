package com.crowdintelligence.demo.controller;

import com.crowdintelligence.demo.model.Response;
import com.crowdintelligence.demo.service.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/responses")
public class ResponseController {
    private final ResponseService responses;

    public ResponseController(ResponseService responses) {
        this.responses = responses;
    }

    @PostMapping
    public ResponseEntity<Response> submit(@RequestBody Response body) {
        return ResponseEntity.ok(responses.submit(body));
    }

    @GetMapping("/problem/{problemId}")
    public ResponseEntity<List<Response>> listForProblem(@PathVariable String problemId) {
        return ResponseEntity.ok(responses.listForProblem(problemId));
    }
}
