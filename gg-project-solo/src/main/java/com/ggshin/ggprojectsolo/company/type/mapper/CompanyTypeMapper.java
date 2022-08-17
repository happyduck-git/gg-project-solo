package com.ggshin.ggprojectsolo.company.type.mapper;

import com.ggshin.ggprojectsolo.company.type.dto.CompanyTypeDto;
import com.ggshin.ggprojectsolo.company.type.entity.CompanyType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyTypeMapper {

    CompanyType companyTypePostToCompanyType(CompanyTypeDto.Post companyTypePostDto);
    CompanyTypeDto.Response companyTypeToCompanyTypeResponse(CompanyType companyType);

}
