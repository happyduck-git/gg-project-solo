package com.ggshin.ggprojectsolo.company.type.entity;

import com.ggshin.ggprojectsolo.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter/*mapping 시에 꼭 필요!*/
@Entity
public class CompanyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String companyType;
    private String companyCode;

    @Builder
    public CompanyType(String companyType, String companyCode) {
        this.companyType = companyType;
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
