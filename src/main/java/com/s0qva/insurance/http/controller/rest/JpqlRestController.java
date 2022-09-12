package com.s0qva.insurance.http.controller.rest;

import com.s0qva.insurance.service.JpqlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("insurance/api/v1/jpqls")
@RequiredArgsConstructor
public class JpqlRestController {
    private final JpqlService jpqlService;

    @PostMapping
    public ResponseEntity<Object> executeQuery(@RequestBody String query) {
        Object executionResult = jpqlService.executeQuery(query);

        return ResponseEntity.ok(executionResult);
    }
}
