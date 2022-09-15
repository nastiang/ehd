package com.farzoom.lime.ehd.service;

import com.farzoom.common.persistence.es.model.Company;
import com.farzoom.common.persistence.es.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository esCompanyRepository;

    public Company getCompanyByPrincipalCompanyId(String principalCompanyId) {
       return esCompanyRepository.load(principalCompanyId);
    }
}
