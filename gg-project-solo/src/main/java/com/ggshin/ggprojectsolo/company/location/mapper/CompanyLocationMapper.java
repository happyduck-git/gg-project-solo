package com.ggshin.ggprojectsolo.company.location.mapper;

import com.ggshin.ggprojectsolo.company.location.dto.CompanyLocationDto;
import com.ggshin.ggprojectsolo.company.location.entity.CompanyLocation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyLocationMapper {

    CompanyLocation companyLocationPostDtoToCompanyLocation(CompanyLocationDto.Post companyLocationPost);
    CompanyLocationDto.Response companyLocationToCompanyLocationResponseDto(CompanyLocation companyLocation);

}
