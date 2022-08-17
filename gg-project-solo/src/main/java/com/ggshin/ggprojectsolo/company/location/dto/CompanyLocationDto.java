package com.ggshin.ggprojectsolo.company.location.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class CompanyLocationDto {

    @AllArgsConstructor
    @Getter
    public static class Post {

        private String location;
        private String locationCode;

    }


    @AllArgsConstructor
    @Getter
    public static class Response {
        private long id;
        private String location;
        private String locationCode;
    }
}
