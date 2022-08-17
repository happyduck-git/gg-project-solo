package com.ggshin.ggprojectsolo.company.type.controller;

import com.ggshin.ggprojectsolo.company.type.dto.CompanyTypeDto;
import com.ggshin.ggprojectsolo.company.type.entity.CompanyType;
import com.ggshin.ggprojectsolo.company.type.mapper.CompanyTypeMapper;
import com.ggshin.ggprojectsolo.company.type.service.CompanyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/company-type")
public class CompanyTypeController {

    private CompanyTypeMapper companyTypeMapper;
    private CompanyTypeService companyTypeService;

    @Autowired
    public CompanyTypeController(CompanyTypeMapper companyTypeMapper, CompanyTypeService companyTypeService) {
        this.companyTypeMapper = companyTypeMapper;
        this.companyTypeService = companyTypeService;
    }

    @PostMapping
    public ResponseEntity postCompanyType(@RequestBody CompanyTypeDto.Post companyTypePostDto) {
        //post dto to entity
        CompanyType companyType = companyTypeMapper.companyTypePostToCompanyType(companyTypePostDto);

        //Make service to save the entity
        CompanyType savedCompanyType = companyTypeService.createCompanyType(companyType);

        //entity to response dto
        CompanyTypeDto.Response response = companyTypeMapper.companyTypeToCompanyTypeResponse(savedCompanyType);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
