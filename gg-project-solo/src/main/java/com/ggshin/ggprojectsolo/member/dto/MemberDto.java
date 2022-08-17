package com.ggshin.ggprojectsolo.member.dto;

import com.ggshin.ggprojectsolo.company.CompanyLocation;
import com.ggshin.ggprojectsolo.company.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MemberDto {

    @AllArgsConstructor
    @Getter
    public static class Post {
        private String name;
        private String password;
        private String sex;
        private String companyName;
        private String companyCode;
        private String locationCode;

        public CompanyType getCompanyType() {
            CompanyType companyType = new CompanyType();
            companyType.setCompanyCode(companyCode);
            return companyType;
        }

        public CompanyLocation getCompanyLocation() {
            CompanyLocation companyLocation = new CompanyLocation();
            companyLocation.setLocationCode(locationCode);
            return companyLocation;
        }

        @Override
        public String toString() {
            return "Post{" +
                    "name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    ", sex='" + sex + '\'' +
                    ", companyName='" + companyName + '\'' +
                    ", companyCode='" + companyCode + '\'' +
                    ", locationCode='" + locationCode + '\'' +
                    '}';
        }
    }

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
