package com.s0qva.insurance.service;

import com.s0qva.insurance.dto.InsuranceCompanyCreateEditDto;
import com.s0qva.insurance.dto.InsuranceCompanyReadDto;
import com.s0qva.insurance.exception.InsuranceCompanyCreationException;
import com.s0qva.insurance.exception.NoSuchInsuranceCompanyException;
import com.s0qva.insurance.handler.GlobalExceptionHandler;
import com.s0qva.insurance.mapper.InsuranceCompanyCreateEditMapper;
import com.s0qva.insurance.mapper.InsuranceCompanyReadMapper;
import com.s0qva.insurance.repository.InsuranceCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class InsuranceCompanyService {
    private final InsuranceCompanyRepository insuranceCompanyRepository;
    private final InsuranceCompanyReadMapper insuranceCompanyReadMapper;
    private final InsuranceCompanyCreateEditMapper insuranceCompanyCreateEditMapper;

    @Autowired
    public InsuranceCompanyService(InsuranceCompanyRepository insuranceCompanyRepository,
                                   InsuranceCompanyReadMapper insuranceCompanyReadMapper,
                                   InsuranceCompanyCreateEditMapper insuranceCompanyCreateEditMapper) {
        this.insuranceCompanyRepository = insuranceCompanyRepository;
        this.insuranceCompanyReadMapper = insuranceCompanyReadMapper;
        this.insuranceCompanyCreateEditMapper = insuranceCompanyCreateEditMapper;
    }

    public List<InsuranceCompanyReadDto> getAll() {
        return insuranceCompanyRepository.findAll()
                .stream()
                .map(insuranceCompanyReadMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public InsuranceCompanyReadDto getById(Long id) {
        return insuranceCompanyRepository.findById(id)
                .map(insuranceCompanyReadMapper::mapToDto)
                .orElseThrow(() -> new NoSuchInsuranceCompanyException(id));
    }

    @Transactional
    public InsuranceCompanyReadDto create(InsuranceCompanyCreateEditDto insuranceCompanyDto) {
        return Optional.of(insuranceCompanyDto)
                .map(insuranceCompanyCreateEditMapper::mapToEntity)
                .map(insuranceCompanyRepository::save)
                .map(insuranceCompanyReadMapper::mapToDto)
                .orElseThrow(InsuranceCompanyCreationException::new);
    }
}
