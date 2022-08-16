package com.ggshin.ggprojectsolo.company;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompanyType {
    @Id
    private long id;
    private String companyType;
    private String companyCode;

    public String getCompanyCode() {
        return companyCode;
    }
}
