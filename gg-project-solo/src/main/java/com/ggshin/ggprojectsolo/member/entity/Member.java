package com.ggshin.ggprojectsolo.member.entity;

import com.ggshin.ggprojectsolo.company.location.entity.CompanyLocation;
import com.ggshin.ggprojectsolo.company.type.entity.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;
    private String name;
    private String password;
    private String sex;
    private String companyName;
    @ManyToOne
    @JoinColumn(name = "COMPANY_CODE")
    private CompanyType companyType;
    @ManyToOne
    @JoinColumn(name = "LOCATION_CODE")
    private CompanyLocation companyLocation;

    @Builder
    public Member(String name, String password, String sex, String companyName, CompanyType companyType, CompanyLocation companyLocation) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.companyName = companyName;
        this.companyType = companyType;
        this.companyLocation = companyLocation;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyType=" + companyType +
                ", companyLocation=" + companyLocation +
                '}';
    }
}
