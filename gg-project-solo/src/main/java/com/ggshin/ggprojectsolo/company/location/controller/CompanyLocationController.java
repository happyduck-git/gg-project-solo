package com.ggshin.ggprojectsolo.company.location.controller;

import com.ggshin.ggprojectsolo.company.location.dto.CompanyLocationDto;
import com.ggshin.ggprojectsolo.company.location.entity.CompanyLocation;
import com.ggshin.ggprojectsolo.company.location.mapper.CompanyLocationMapper;
import com.ggshin.ggprojectsolo.company.location.service.CompanyLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/company-location")
public class CompanyLocationController {

    private CompanyLocationMapper companyLocationMapper;
    private CompanyLocationService companyLocationService;

    @Autowired
    public CompanyLocationController(CompanyLocationMapper companyLocationMapper, CompanyLocationService companyLocationService) {
        this.companyLocationMapper = companyLocationMapper;
        this.companyLocationService = companyLocationService;
    }

    @PostMapping
    public ResponseEntity postCompanyLocation(@RequestBody CompanyLocationDto.Post companyLocationPost) {

        //postDto to entity
        CompanyLocation companyLocation = companyLocationMapper.companyLocationPostDtoToCompanyLocation(companyLocationPost);

        System.out.println(companyLocation);
        //call service class
        CompanyLocation savedCompanyLocation = companyLocationService.createCompanyLocation(companyLocation);
        System.out.println(savedCompanyLocation);
        //entity to responseDto
        CompanyLocationDto.Response response = companyLocationMapper.companyLocationToCompanyLocationResponseDto(savedCompanyLocation);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }








}
