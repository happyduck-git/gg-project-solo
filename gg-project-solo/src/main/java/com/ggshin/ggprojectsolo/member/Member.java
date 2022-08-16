package com.ggshin.ggprojectsolo.member;

import com.ggshin.ggprojectsolo.company.CompanyLocation;
import com.ggshin.ggprojectsolo.company.CompanyType;
import lombok.AllArgsConstructor;
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

    public Member(String name, String password, String sex, String companyName, CompanyType companyType, CompanyLocation companyLocation) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.companyName = companyName;
        this.companyType = companyType;
        this.companyLocation = companyLocation;
    }
}
