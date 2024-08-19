package com.codeitsuisse2023.javatemplate.controller;

import com.codeitsuisse2023.javatemplate.model.EvaluationRequest;
import com.codeitsuisse2023.javatemplate.model.EvaluationScore;
import com.codeitsuisse2023.javatemplate.service.EvaluationService;
import com.github.rjeschke.txtmark.Processor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

@RestController
class WebController {
    private final EvaluationService evaluationService;

    public WebController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping(value = "/README.md", produces = { "text/html" })
    public String instruction() throws IOException {
        return Processor.process(new FileReader("CHALLENGE_README.md"));
    }

    @PostMapping(value = "/evaluate", consumes = { "application/json" })
    public ResponseEntity<String> evaluate(@RequestBody EvaluationRequest evaluationRequest) {
        System.out.println(evaluationRequest.toString());
        evaluationService.evaluate(evaluationRequest);
        return ResponseEntity.noContent().build();
    }

    // can be used to test what is being sent to the coordinator by changing the callbackUrl to point to http://localhost:8080/evaluateScore
    @PostMapping(value = "/evaluateScore", consumes = { "application/json" })
    public ResponseEntity<String> evaluate(@RequestBody EvaluationScore evaluationScore){
        System.out.println(evaluationScore.toString());
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
