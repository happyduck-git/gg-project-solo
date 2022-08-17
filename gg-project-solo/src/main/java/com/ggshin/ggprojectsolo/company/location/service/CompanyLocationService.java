package com.ggshin.ggprojectsolo.company.location.service;

import com.ggshin.ggprojectsolo.company.location.repository.CompanyLocationRepository;
import com.ggshin.ggprojectsolo.company.location.entity.CompanyLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyLocationService {

    private CompanyLocationRepository companyLocationRepository;

    @Autowired
    public CompanyLocationService(CompanyLocationRepository companyLocationRepository) {
        this.companyLocationRepository = companyLocationRepository;
    }

    public CompanyLocation createCompanyLocation(CompanyLocation companyLocation) {
        return companyLocationRepository.save(companyLocation);
    }
}
