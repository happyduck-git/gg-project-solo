package com.ggshin.ggprojectsolo.company;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompanyLocation {
    @Id
    private long id;
    private String location;
    private String locationCode;

    public String getLocationCode() {
        return locationCode;
    }
}
