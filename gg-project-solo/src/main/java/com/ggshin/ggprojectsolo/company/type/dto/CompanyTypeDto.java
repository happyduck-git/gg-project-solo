package com.ggshin.ggprojectsolo.company.type.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CompanyTypeDto {

    @AllArgsConstructor
    @Getter
    public static class Post {
        private String companyType;
        private String companyCode;
    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private long id;
        private String companyType;
        private String companyCode;
    }


}
