package com.ggshin.ggprojectsolo.company.type.service;

import com.ggshin.ggprojectsolo.company.type.entity.CompanyType;
import com.ggshin.ggprojectsolo.company.type.repository.CompanyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyTypeService {

    private CompanyTypeRepository companyTypeRepository;

    @Autowired
    public CompanyTypeService(CompanyTypeRepository companyTypeRepository) {
        this.companyTypeRepository = companyTypeRepository;
    }

    public CompanyType createCompanyType(CompanyType companyType) {
        return companyTypeRepository.save(companyType);
    }

}
