package com.ggshin.ggprojectsolo.member.dto;

import com.ggshin.ggprojectsolo.company.CompanyLocation;
import com.ggshin.ggprojectsolo.company.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

public class MemberDto {

    @AllArgsConstructor
    @Getter
    public static class Response {
        private long memberId;
        private String name;
        private String sex;
        private String companyName;
        private CompanyType companyType;
        private CompanyLocation companyLocation;

        public String getCompanyType() {
            return companyType.getCompanyCode();
        }

        public String getCompanyLocation() {
            return companyLocation.getLocationCode();
        }
    }

}
