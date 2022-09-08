package com.s0qva.insurance.controller;

import com.s0qva.insurance.dto.InsuranceCompanyCreateEditDto;
import com.s0qva.insurance.dto.InsuranceCompanyFilter;
import com.s0qva.insurance.dto.InsuranceCompanyReadDto;
import com.s0qva.insurance.service.InsuranceCompanyService;
import com.s0qva.insurance.util.WebResourceLocationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("insurance/api/v1/insurance-companies")
@RequiredArgsConstructor
public class InsuranceCompanyController {
    private final InsuranceCompanyService insuranceCompanyService;

    @GetMapping
    public ResponseEntity<List<InsuranceCompanyReadDto>> getAll(InsuranceCompanyFilter filter) {
        List<InsuranceCompanyReadDto> insuranceCompanyReadDtos = insuranceCompanyService.getAll(filter);

        return ResponseEntity.ok(insuranceCompanyReadDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsuranceCompanyReadDto> getById(@PathVariable("id") Long id) {
        InsuranceCompanyReadDto insuranceCompanyReadDto = insuranceCompanyService.getById(id);

        return ResponseEntity.ok(insuranceCompanyReadDto);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody InsuranceCompanyCreateEditDto insuranceCompanyDto) {
        InsuranceCompanyReadDto insuranceCompanyReadDto = insuranceCompanyService.create(insuranceCompanyDto);
        URI location = WebResourceLocationUtil.buildWebResourceLocation("/{id}", insuranceCompanyReadDto.getId());

        return ResponseEntity.created(location).build();
    }
}
